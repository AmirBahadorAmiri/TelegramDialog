package com.github.amirbahadoramiri.telegramdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.github.amirbahadoramiri.telegramdialog.direction.DialogDirection;
import com.github.amirbahadoramiri.telegramdialog.listeners.OnMenuListener;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

/**
 * A Telegram-style action menu shown as a popup anchored to a view.
 * Use {@link #setOnClickListener(OnMenuListener)} for selections.
 */
public class TelegramPopupMenu {

    private static final String DEFAULT_TEXT_COLOR = "#757575";
    private static final String DEFAULT_ICON_TINT = "#5F6368";
    private static final String DIVIDER_LIGHT = "#ECECEC";
    private static final String DIVIDER_DARK = "#33424F";

    private record Item(int iconRes, String text, boolean divider, int position) {
    }

    private final Context context;
    private final View anchor;
    private final PopupWindow popupWindow;
    private final MaterialCardView cardView;
    private final LinearLayout container;

    private final List<Item> items = new ArrayList<>();
    private OnMenuListener listener;
    private int itemTextColor = TelegramColors.getColor(DEFAULT_TEXT_COLOR);
    private int itemIconTint = TelegramColors.getColor(DEFAULT_ICON_TINT);
    private int dividerColor;
    private int nextPosition;
    private int popupGravity = Gravity.LEFT;
    private boolean itemSelected;
    private Runnable pendingShow;

    @SuppressLint("InflateParams")
    public TelegramPopupMenu(Context context, View anchor) {
        this.context = context;
        this.anchor = anchor;
        View view = LayoutInflater.from(context).inflate(R.layout.telegram_popup_menu, null);
        cardView = view.findViewById(R.id.cardview);
        container = view.findViewById(R.id.menu_container);

        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // Window elevation stays at its 0 default; only the rounded card casts a shadow.
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(() -> {
            if (!itemSelected && listener != null) listener.onCanceled();
        });

        dividerColor = TelegramColors.getColor(TelegramColors.isNightMode(context) ? DIVIDER_DARK : DIVIDER_LIGHT);
        setCardRadius(16);
        setElevation(2);
        setWidth(220);
        setCardBackgroundColor(TelegramColors.getDialogBackground(context));
        setDirection(DialogDirection.LTR);
    }

    /** Adds a selectable row. Position passed to the listener follows insertion order (dividers don't count). */
    public TelegramPopupMenu addItem(int iconRes, String text) {
        items.add(new Item(iconRes, text, false, nextPosition++));
        return this;
    }

    /** Inserts the thick separator shown between groups of actions. */
    public TelegramPopupMenu addDivider() {
        items.add(new Item(0, null, true, -1));
        return this;
    }

    public TelegramPopupMenu setItemTextColor(int color) {
        itemTextColor = color;
        return this;
    }

    public TelegramPopupMenu setItemIconTint(int color) {
        itemIconTint = color;
        return this;
    }

    public TelegramPopupMenu setDividerColor(int color) {
        dividerColor = color;
        return this;
    }

    public TelegramPopupMenu setCardBackgroundColor(int color) {
        cardView.setCardBackgroundColor(color);
        container.setBackgroundColor(color);
        return this;
    }

    public TelegramPopupMenu setCardRadius(int cardRadius) {
        cardView.setRadius(dp(cardRadius));
        return this;
    }

    /** Shadow depth of the menu, in dp. */
    public TelegramPopupMenu setElevation(int elevationDp) {
        cardView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        cardView.setClipToOutline(true);
        cardView.setElevation(dp(elevationDp));
        return this;
    }

    /** Fixed width of the menu, in dp. */
    public TelegramPopupMenu setWidth(int widthDp) {
        popupWindow.setWidth(dp(widthDp));
        return this;
    }

    /** Controls whether touching outside or pressing back closes the menu. */
    public TelegramPopupMenu setCancelable(boolean cancelable) {
        popupWindow.setOutsideTouchable(cancelable);
        popupWindow.setFocusable(cancelable);
        return this;
    }

    public TelegramPopupMenu setDirection(DialogDirection dialogDirection) {
        boolean rtl = dialogDirection == DialogDirection.RTL;
        container.setLayoutDirection(rtl ? View.LAYOUT_DIRECTION_RTL : View.LAYOUT_DIRECTION_LTR);
        popupGravity = rtl ? Gravity.RIGHT : Gravity.LEFT;
        if (popupWindow.isShowing()) showAtAnchor();
        return this;
    }

    public TelegramPopupMenu setOnClickListener(OnMenuListener listener) {
        this.listener = listener;
        return this;
    }

    public void show() {
        // In onCreate() the anchor has no window token yet — wait until it's attached.
        if (!anchor.isAttachedToWindow() || anchor.getWindowToken() == null) {
            if (pendingShow == null) {
                pendingShow = () -> {
                    pendingShow = null;
                    show();
                };
                anchor.post(pendingShow);
            }
            return;
        }
        itemSelected = false;
        buildItems();
        showAtAnchor();
    }

    private void showAtAnchor() {
        popupWindow.showAsDropDown(anchor, 0, dp(4), popupGravity);
    }

    public void dismiss() {
        if (pendingShow != null) {
            anchor.removeCallbacks(pendingShow);
            pendingShow = null;
        }
        popupWindow.dismiss();
    }

    private void buildItems() {
        container.removeAllViews();
        for (Item item : items) {
            if (item.divider) {
                View divider = new View(context);
                divider.setBackgroundColor(dividerColor);
                divider.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, dp(8)));
                container.addView(divider);
            } else {
                container.addView(createItemView(item));
            }
        }
    }

    private AppCompatTextView createItemView(Item item) {
        AppCompatTextView row = new AppCompatTextView(context);
        row.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        row.setText(item.text);
        row.setTextColor(itemTextColor);
        row.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        row.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setMinimumHeight(dp(50));
        row.setPaddingRelative(dp(16), 0, dp(16), 0);
        row.setCompoundDrawablePadding(dp(16));
        row.setClickable(true);
        row.setFocusable(true);

        TypedValue out = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, out, true))
            row.setBackgroundResource(out.resourceId);

        Drawable icon = ContextCompat.getDrawable(context, item.iconRes);
        if (icon != null) {
            icon = icon.mutate();
            DrawableCompat.setTint(icon, itemIconTint);
            int size = dp(24);
            icon.setBounds(0, 0, size, size);
            row.setCompoundDrawablesRelative(icon, null, null, null);
        }

        int position = item.position;
        String text = item.text;
        row.setOnClickListener(v -> {
            itemSelected = true;
            dismiss();
            if (listener != null) listener.onItemSelected(position, text);
        });
        return row;
    }

    private int dp(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
                context.getResources().getDisplayMetrics());
    }
}

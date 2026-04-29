package com.github.amirbahadoramiri.telegramdialog.oneedit;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

import com.github.amirbahadoramiri.telegramdialog.R;
import com.github.amirbahadoramiri.telegramdialog.library.TeleDirection;
import com.github.amirbahadoramiri.telegramdialog.one.TeleDialogSingle;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TeleDialogSingleWithEditText {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private AppCompatTextView titleView, messageView;
    private AppCompatEditText edittextView;
    private MaterialButton buttonView;
    private LinearLayoutCompat buttonGroup;

    public TeleDialogSingleWithEditText(Context context) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.tele_dialog_single_with_edit_text, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        titleView = view.findViewById(R.id.title);
        messageView = view.findViewById(R.id.message);
        edittextView = view.findViewById(R.id.edittext);
        buttonView = view.findViewById(R.id.button);
        buttonGroup = view.findViewById(R.id.button_group);

        setTitle("Title");
        setMessage("Message");
        setEditTextColor(R.color.textcolor);
        setEditTextHintColor(R.color.main_blue_light);
        setEditTextBackgroundColor(R.color.main_blue_tint);
        setButtonText("OK");
        setButtonTextColor(R.color.main_blue);
        setButtonRippleColor(R.color.main_blue_tint);
        setButtonCornerRadius(16);
        setCardRadius(16);
        setCardBackgroundColor(R.color.dialog_page_background);
        setCancelable(true);
        setDirection(TeleDirection.LTR);

    }

    public TeleDialogSingleWithEditText setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TeleDialogSingleWithEditText setMessage(String message) {
        messageView.setText(message);
        return this;
    }

    public TeleDialogSingleWithEditText setJustificationMode(int mode) {
        messageView.setJustificationMode(mode);
        return this;
    }

    public TeleDialogSingleWithEditText setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TeleDialogSingleWithEditText setDirection(TeleDirection teleDirection) {
        if (teleDirection == TeleDirection.LTR)
            buttonGroup.setGravity(Gravity.RIGHT);
        else
            buttonGroup.setGravity(Gravity.LEFT);
        return this;
    }

    public TeleDialogSingleWithEditText setOnClickListener(TeleDialogSingleWithEditTextListener listener) {
        buttonView.setOnClickListener(v -> listener.onButtonClicked(Objects.requireNonNull(edittextView.getText()).toString()));
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TeleDialogSingleWithEditText setCardBackgroundColor(int cardBackgroundColor) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        return this;
    }

    public TeleDialogSingleWithEditText setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TeleDialogSingleWithEditText setButtonText(String buttonText) {
        buttonView.setText(buttonText);
        return this;
    }

    public TeleDialogSingleWithEditText setButtonTextColor(int buttonTextColor) {
        buttonView.setTextColor(ContextCompat.getColor(context, buttonTextColor));
        return this;
    }

    public TeleDialogSingleWithEditText setButtonRippleColor(int buttonRippleColor) {
        buttonView.setRippleColorResource(buttonRippleColor);
        return this;
    }

    public TeleDialogSingleWithEditText setButtonCornerRadius(int radius) {
        buttonView.setCornerRadius((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                radius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TeleDialogSingleWithEditText setEditTextValue(String text) {
        edittextView.setText(text);
        return this;
    }

    public TeleDialogSingleWithEditText setEditTextColor(int color) {
        edittextView.setTextColor(ContextCompat.getColor(context, color));
        return this;
    }

    public TeleDialogSingleWithEditText setEditTextHint(String hint) {
        edittextView.setHint(hint);
        return this;
    }

    public TeleDialogSingleWithEditText setEditTextHintColor(int color) {
        edittextView.setHintTextColor(ContextCompat.getColor(context, color));
        return this;
    }

    public TeleDialogSingleWithEditText setEditTextBackgroundColor(int color) {
        ColorStateList colorStateList = ColorStateList.valueOf(
                ContextCompat.getColor(context, color)
        );
        ViewCompat.setBackgroundTintList(edittextView, colorStateList);
        return this;
    }

    public TeleDialogSingleWithEditText setEditTextDrawable(int drawableID, int tintColor) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableID);
        if (drawable != null) {
            drawable = drawable.mutate();
            DrawableCompat.setTint(drawable, ContextCompat.getColor(context, tintColor));
            edittextView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }
        return this;
    }

    public void show() {
        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

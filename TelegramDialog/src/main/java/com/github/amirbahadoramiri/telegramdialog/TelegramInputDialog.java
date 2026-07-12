package com.github.amirbahadoramiri.telegramdialog;

import android.annotation.SuppressLint;
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

import com.github.amirbahadoramiri.telegramdialog.direction.DialogDirection;
import com.github.amirbahadoramiri.telegramdialog.listeners.OnInputListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TelegramInputDialog {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private AppCompatTextView titleView, messageView;
    private AppCompatEditText edittextView;
    private MaterialButton buttonView;
    private LinearLayoutCompat buttonGroup;

    @SuppressLint("InflateParams")
    public TelegramInputDialog(Context context) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.telegram_input_dialog, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        titleView = view.findViewById(R.id.title);
        messageView = view.findViewById(R.id.message);
        edittextView = view.findViewById(R.id.edittext);
        buttonView = view.findViewById(R.id.button);
        buttonGroup = view.findViewById(R.id.button_group);

        setTitle("Title");
        setMessage("Message");
        setEditTextColor(TelegramColors.getTextColor(context));
        setEditTextHintColor(TelegramColors.getColor(TelegramColors.MAIN_BLUE_LIGHT));
        setEditTextBackgroundColor(TelegramColors.getMainBlueTint(context));
        setPositiveButtonText("OK");
        setPositiveButtonTextColor(TelegramColors.getMainBlue());
        setPositiveButtonRippleColor(TelegramColors.getMainBlueTint(context));
        setPositiveButtonCornerRadius(16);
        setPositiveButtonBackgroundColor(TelegramColors.getDialogBackground(context));
        setCardRadius(16);
        setCardBackgroundColor(TelegramColors.getDialogBackground(context));
        setCancelable(true);
        setDirection(DialogDirection.LTR);

    }

    public TelegramInputDialog setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TelegramInputDialog setTitleTextColor(int color) {
        titleView.setTextColor(color);
        return this;
    }

    public TelegramInputDialog setMessage(String message) {
        messageView.setText(message);
        return this;
    }

    public TelegramInputDialog setMessageTextColor(int color) {
        messageView.setTextColor(color);
        return this;
    }

    public TelegramInputDialog setJustificationMode(int mode) {
        messageView.setJustificationMode(mode);
        return this;
    }

    public TelegramInputDialog setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TelegramInputDialog setDirection(DialogDirection dialogDirection) {
        if (dialogDirection == DialogDirection.LTR)
            buttonGroup.setGravity(Gravity.RIGHT);
        else
            buttonGroup.setGravity(Gravity.LEFT);
        return this;
    }

    public TelegramInputDialog setOnClickListener(OnInputListener listener) {
        buttonView.setOnClickListener(v -> listener.onPositiveButtonClicked(Objects.requireNonNull(edittextView.getText()).toString()));
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TelegramInputDialog setCardBackgroundColor(int color) {
        cardView.setCardBackgroundColor(color);
        view.findViewById(R.id.constraint).setBackgroundColor(color);
        return this;
    }

    public TelegramInputDialog setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramInputDialog setPositiveButtonText(String buttonText) {
        buttonView.setText(buttonText);
        return this;
    }

    public TelegramInputDialog setPositiveButtonTextColor(int color) {
        buttonView.setTextColor(color);
        return this;
    }

    public TelegramInputDialog setPositiveButtonRippleColor(int color) {
        buttonView.setRippleColor(ColorStateList.valueOf(color));
        return this;
    }

    public TelegramInputDialog setPositiveButtonCornerRadius(int radius) {
        buttonView.setCornerRadius((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                radius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramInputDialog setPositiveButtonBackgroundColor(int color) {
        buttonView.setBackgroundTintList(ColorStateList.valueOf(color));
        return this;
    }

    public TelegramInputDialog setEditTextValue(String text) {
        edittextView.setText(text);
        return this;
    }

    public TelegramInputDialog setEditTextColor(int color) {
        edittextView.setTextColor(color);
        return this;
    }

    public TelegramInputDialog setEditTextHint(String hint) {
        edittextView.setHint(hint);
        return this;
    }

    public TelegramInputDialog setEditTextHintColor(int color) {
        edittextView.setHintTextColor(color);
        return this;
    }

    public TelegramInputDialog setEditTextBackgroundColor(int color) {
        ColorStateList colorStateList = ColorStateList.valueOf(color);
        ViewCompat.setBackgroundTintList(edittextView, colorStateList);
        return this;
    }

    public TelegramInputDialog setEditTextDrawable(int drawableID, int tintColor) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableID);
        if (drawable != null) {
            drawable = drawable.mutate();
            DrawableCompat.setTint(drawable, tintColor);
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

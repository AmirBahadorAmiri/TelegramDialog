package com.github.amirbahadoramiri.telegramdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.github.amirbahadoramiri.telegramdialog.direction.DialogDirection;
import com.github.amirbahadoramiri.telegramdialog.listeners.OnConfirmListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TelegramConfirmDialog {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private AppCompatTextView titleView, messageView;
    private MaterialButton btn1View, btn2View;
    private LinearLayoutCompat buttonGroup;

    @SuppressLint("InflateParams")
    public TelegramConfirmDialog(Context context) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.telegram_confirm_dialog, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        titleView = view.findViewById(R.id.title);
        messageView = view.findViewById(R.id.message);
        btn1View = view.findViewById(R.id.button1);
        btn2View = view.findViewById(R.id.button2);
        buttonGroup = view.findViewById(R.id.button_group);

        setTitle("Title");
        setMessage("Message");
        setNegativeButtonText("NO");
        setNegativeButtonTextColor(TelegramColors.getMainBlue());
        setNegativeButtonRippleColor(TelegramColors.getMainBlueTint(context));
        setNegativeButtonCornerRadius(16);
        setNegativeButtonBackgroundColor(TelegramColors.getDialogBackground(context));
        setPositiveButtonText("OK");
        setPositiveButtonTextColor(TelegramColors.getMainRed());
        setPositiveButtonRippleColor(TelegramColors.getMainRedTint(context));
        setPositiveButtonCornerRadius(16);
        setPositiveButtonBackgroundColor(TelegramColors.getDialogBackground(context));
        setCardRadius(16);
        setCardBackgroundColor(TelegramColors.getDialogBackground(context));
        setCancelable(true);
        setDirection(DialogDirection.LTR);

    }

    public TelegramConfirmDialog setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TelegramConfirmDialog setTitleTextColor(int color) {
        titleView.setTextColor(color);
        return this;
    }

    public TelegramConfirmDialog setMessage(String message) {
        messageView.setText(message);
        return this;
    }

    public TelegramConfirmDialog setMessageTextColor(int color) {
        messageView.setTextColor(color);
        return this;
    }

    public TelegramConfirmDialog setJustificationMode(int mode) {
        messageView.setJustificationMode(mode);
        return this;
    }

    public TelegramConfirmDialog setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TelegramConfirmDialog setDirection(DialogDirection dialogDirection) {
        if (dialogDirection == DialogDirection.LTR)
            buttonGroup.setGravity(Gravity.RIGHT);
        else
            buttonGroup.setGravity(Gravity.LEFT);
        return this;
    }

    public TelegramConfirmDialog setOnClickListener(OnConfirmListener listener) {
        btn1View.setOnClickListener(v -> listener.onNegativeButtonClicked());
        btn2View.setOnClickListener(v -> listener.onPositiveButtonClicked());
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TelegramConfirmDialog setCardBackgroundColor(int color) {
        cardView.setCardBackgroundColor(color);
        view.findViewById(R.id.constraint).setBackgroundColor(color);
        return this;
    }

    public TelegramConfirmDialog setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramConfirmDialog setNegativeButtonText(String buttonOneText) {
        btn1View.setText(buttonOneText);
        return this;
    }

    public TelegramConfirmDialog setNegativeButtonTextColor(int color) {
        btn1View.setTextColor(color);
        return this;
    }

    public TelegramConfirmDialog setNegativeButtonRippleColor(int color) {
        btn1View.setRippleColor(ColorStateList.valueOf(color));
        return this;
    }

    public TelegramConfirmDialog setNegativeButtonCornerRadius(int radius) {
        btn1View.setCornerRadius((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                radius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramConfirmDialog setPositiveButtonText(String buttonTwoText) {
        btn2View.setText(buttonTwoText);
        return this;
    }

    public TelegramConfirmDialog setPositiveButtonTextColor(int color) {
        btn2View.setTextColor(color);
        return this;
    }

    public TelegramConfirmDialog setPositiveButtonRippleColor(int color) {
        btn2View.setRippleColor(ColorStateList.valueOf(color));
        return this;
    }

    public TelegramConfirmDialog setPositiveButtonCornerRadius(int radius) {
        btn2View.setCornerRadius((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                radius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramConfirmDialog setNegativeButtonBackgroundColor(int color) {
        btn1View.setBackgroundTintList(ColorStateList.valueOf(color));
        return this;
    }

    public TelegramConfirmDialog setPositiveButtonBackgroundColor(int color) {
        btn2View.setBackgroundTintList(ColorStateList.valueOf(color));
        return this;
    }

    public void show() {
        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

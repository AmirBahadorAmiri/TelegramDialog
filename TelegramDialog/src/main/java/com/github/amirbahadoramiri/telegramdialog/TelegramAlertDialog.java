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
import com.github.amirbahadoramiri.telegramdialog.listeners.OnAlertListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TelegramAlertDialog {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private AppCompatTextView titleView, messageView;
    private MaterialButton buttonView;
    private LinearLayoutCompat buttonGroup;

    @SuppressLint("InflateParams")
    public TelegramAlertDialog(Context context) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.telegram_alert_dialog, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        titleView = view.findViewById(R.id.title);
        messageView = view.findViewById(R.id.message);
        buttonView = view.findViewById(R.id.button);
        buttonGroup = view.findViewById(R.id.button_group);

        setTitle("Title");
        setMessage("Message");
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

    public TelegramAlertDialog setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TelegramAlertDialog setTitleTextColor(int color) {
        titleView.setTextColor(color);
        return this;
    }

    public TelegramAlertDialog setMessage(String message) {
        messageView.setText(message);
        return this;
    }

    public TelegramAlertDialog setMessageTextColor(int color) {
        messageView.setTextColor(color);
        return this;
    }

    public TelegramAlertDialog setJustificationMode(int mode) {
        messageView.setJustificationMode(mode);
        return this;
    }

    public TelegramAlertDialog setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TelegramAlertDialog setDirection(DialogDirection dialogDirection) {
        if (dialogDirection == DialogDirection.LTR)
            buttonGroup.setGravity(Gravity.RIGHT);
        else
            buttonGroup.setGravity(Gravity.LEFT);
        return this;
    }

    public TelegramAlertDialog setOnClickListener(OnAlertListener listener) {
        buttonView.setOnClickListener(v -> listener.onPositiveButtonClicked());
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TelegramAlertDialog setCardBackgroundColor(int color) {
        cardView.setCardBackgroundColor(color);
        view.findViewById(R.id.constraint).setBackgroundColor(color);
        return this;
    }

    public TelegramAlertDialog setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramAlertDialog setPositiveButtonText(String buttonText) {
        buttonView.setText(buttonText);
        return this;
    }

    public TelegramAlertDialog setPositiveButtonTextColor(int color) {
        buttonView.setTextColor(color);
        return this;
    }

    public TelegramAlertDialog setPositiveButtonRippleColor(int color) {
        buttonView.setRippleColor(ColorStateList.valueOf(color));
        return this;
    }

    public TelegramAlertDialog setPositiveButtonCornerRadius(int radius) {
        buttonView.setCornerRadius((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                radius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramAlertDialog setPositiveButtonBackgroundColor(int color) {
        buttonView.setBackgroundTintList(ColorStateList.valueOf(color));
        return this;
    }

    public void show() {
        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

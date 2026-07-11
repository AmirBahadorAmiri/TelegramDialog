package com.github.amirbahadoramiri.telegramdialog;

import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;

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
        setButtonText("OK");
        setButtonTextColor(R.color.main_blue);
        setButtonRippleColor(R.color.main_blue_tint);
        setButtonCornerRadius(16);
        setCardRadius(16);
        setCardBackgroundColor(R.color.dialog_page_background);
        setCancelable(true);
        setDirection(DialogDirection.LTR);

    }

    public TelegramAlertDialog setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TelegramAlertDialog setMessage(String message) {
        messageView.setText(message);
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
        buttonView.setOnClickListener(v -> listener.onButtonClicked());
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TelegramAlertDialog setCardBackgroundColor(int cardBackgroundColor) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
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

    public TelegramAlertDialog setButtonText(String buttonText) {
        buttonView.setText(buttonText);
        return this;
    }

    public TelegramAlertDialog setButtonTextColor(int buttonTextColor) {
        buttonView.setTextColor(ContextCompat.getColor(context, buttonTextColor));
        return this;
    }

    public TelegramAlertDialog setButtonRippleColor(int buttonRippleColor) {
        buttonView.setRippleColorResource(buttonRippleColor);
        return this;
    }

    public TelegramAlertDialog setButtonCornerRadius(int radius) {
        buttonView.setCornerRadius((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                radius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public void show() {
        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

package com.github.amirbahadoramiri.telegramdialog.one;

import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;

import com.github.amirbahadoramiri.telegramdialog.R;
import com.github.amirbahadoramiri.telegramdialog.library.TeleDirection;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TeleDialogSingle {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private AppCompatTextView titleView, messageView;
    private MaterialButton buttonView;
    private LinearLayoutCompat buttonGroup;

    public TeleDialogSingle(Context context) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.tele_dialog_single, null);
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
        setDirection(TeleDirection.LTR);

    }

    public TeleDialogSingle setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TeleDialogSingle setMessage(String message) {
        messageView.setText(message);
        return this;
    }

    public TeleDialogSingle setJustificationMode(int mode) {
        messageView.setJustificationMode(mode);
        return this;
    }

    public TeleDialogSingle setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TeleDialogSingle setDirection(TeleDirection teleDirection) {
        if (teleDirection == TeleDirection.LTR)
            buttonGroup.setGravity(Gravity.RIGHT);
        else
            buttonGroup.setGravity(Gravity.LEFT);
        return this;
    }

    public TeleDialogSingle setOnClickListener(TeleDialogSingleListener listener) {
        buttonView.setOnClickListener(v -> listener.onButtonClicked());
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TeleDialogSingle setCardBackgroundColor(int cardBackgroundColor) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        return this;
    }

    public TeleDialogSingle setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TeleDialogSingle setButtonText(String buttonText) {
        buttonView.setText(buttonText);
        return this;
    }

    public TeleDialogSingle setButtonTextColor(int buttonTextColor) {
        buttonView.setTextColor(ContextCompat.getColor(context, buttonTextColor));
        return this;
    }

    public TeleDialogSingle setButtonRippleColor(int buttonRippleColor) {
        buttonView.setRippleColorResource(buttonRippleColor);
        return this;
    }

    public TeleDialogSingle setButtonCornerRadius(int radius) {
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

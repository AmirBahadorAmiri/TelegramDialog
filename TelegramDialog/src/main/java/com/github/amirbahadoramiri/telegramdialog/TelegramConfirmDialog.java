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
        setButtonOneText("NO");
        setButtonOneTextColor(R.color.main_blue);
        setButtonOneRippleColor(R.color.main_blue_tint);
        setButtonOneCornerRadius(16);
        setButtonTwoText("OK");
        setButtonTwoTextColor(R.color.main_red);
        setButtonTwoRippleColor(R.color.main_red_tint);
        setButtonTwoCornerRadius(16);
        setCardRadius(16);
        setCardBackgroundColor(R.color.dialog_page_background);
        setCancelable(true);
        setDirection(DialogDirection.LTR);

    }

    public TelegramConfirmDialog setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TelegramConfirmDialog setMessage(String message) {
        messageView.setText(message);
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
        btn1View.setOnClickListener(v -> listener.onFirstButtonClicked());
        btn2View.setOnClickListener(v -> listener.onSecondButtonClicked());
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TelegramConfirmDialog setCardBackgroundColor(int cardBackgroundColor) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
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

    public TelegramConfirmDialog setButtonOneText(String buttonOneText) {
        btn1View.setText(buttonOneText);
        return this;
    }

    public TelegramConfirmDialog setButtonOneTextColor(int buttonOneTextColor) {
        btn1View.setTextColor(ContextCompat.getColor(context, buttonOneTextColor));
        return this;
    }

    public TelegramConfirmDialog setButtonOneRippleColor(int buttonOneRippleColor) {
        btn1View.setRippleColorResource(buttonOneRippleColor);
        return this;
    }

    public TelegramConfirmDialog setButtonOneCornerRadius(int radius) {
        btn1View.setCornerRadius((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                radius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramConfirmDialog setButtonTwoText(String buttonTwoText) {
        btn2View.setText(buttonTwoText);
        return this;
    }

    public TelegramConfirmDialog setButtonTwoTextColor(int buttonTwoTextColor) {
        btn2View.setTextColor(ContextCompat.getColor(context, buttonTwoTextColor));
        return this;
    }

    public TelegramConfirmDialog setButtonTwoRippleColor(int buttonTwoRippleColor) {
        btn2View.setRippleColorResource(buttonTwoRippleColor);
        return this;
    }

    public TelegramConfirmDialog setButtonTwoCornerRadius(int radius) {
        btn2View.setCornerRadius((int) TypedValue.applyDimension(
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

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

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

import com.github.amirbahadoramiri.telegramdialog.DialogDirection;
import com.github.amirbahadoramiri.telegramdialog.R;

public class DialogOneButton {

    Context context;
    Dialog builder;
    OneButtonListener listener;

    String TITLE, MESSAGE, BUTTON_TEXT;
    boolean CANCELABLE = true;
    int CARD_BACKGROUND_COLOR = R.color.dialog_page_background;
    int CARD_RADIUS = 16;
    DialogDirection DIALOG_DIRECTION = DialogDirection.RIGHT;
    int BUTTON_TEXT_COLOR = R.color.main_blue;
    int BUTTON_RIPPLE_COLOR = R.color.main_blue_tint;

    public DialogOneButton(Context context) {
        this.context = context;
    }

    public DialogOneButton setTitle(String title) {
        this.TITLE = title;
        return this;
    }

    public DialogOneButton setMessage(String message) {
        this.MESSAGE = message;
        return this;
    }

    public DialogOneButton setCancelable(boolean cancelable) {
        this.CANCELABLE = cancelable;
        return this;
    }

    public DialogOneButton setDirection(DialogDirection dialogDirection) {
        this.DIALOG_DIRECTION = dialogDirection;
        return this;
    }

    public DialogOneButton setOnClickListener(OneButtonListener listener) {
        this.listener = listener;
        return this;
    }

    public DialogOneButton setCardBackgroundColor(int cardBackgroundColor) {
        this.CARD_BACKGROUND_COLOR = cardBackgroundColor;
        return this;
    }

    public DialogOneButton setCardRadius(int cardRadius) {
        this.CARD_RADIUS = cardRadius;
        return this;
    }

    public DialogOneButton setButtonText(String buttonText) {
        this.BUTTON_TEXT = buttonText;
        return this;
    }

    public DialogOneButton setButtonTextColor(int buttonTextColor) {
        this.BUTTON_TEXT_COLOR = buttonTextColor;
        return this;
    }

    public DialogOneButton setButtonRippleColor(int buttonRippleColor) {
        this.BUTTON_RIPPLE_COLOR = buttonRippleColor;
        return this;
    }

    public void show() {
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        builder.setCancelable(CANCELABLE);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_one_button, null);
        builder.setContentView(view);

        MaterialCardView cardView = view.findViewById(R.id.cardview);
        if (CARD_BACKGROUND_COLOR != 0) {
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, CARD_BACKGROUND_COLOR));
            view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, CARD_BACKGROUND_COLOR));
        }
        if (CARD_RADIUS != 0) {
            cardView.setRadius(TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    CARD_RADIUS,
                    context.getResources().getDisplayMetrics()
            ));
        }

        AppCompatTextView title = view.findViewById(R.id.title);
        if (this.TITLE != null) title.setText(this.TITLE);

        AppCompatTextView message = view.findViewById(R.id.message);
        if (this.MESSAGE != null) message.setText(this.MESSAGE);

        MaterialButton button = view.findViewById(R.id.button);
        if (this.BUTTON_TEXT != null) button.setText(this.BUTTON_TEXT);
        if (this.BUTTON_TEXT_COLOR != 0)
            button.setTextColor(ContextCompat.getColor(context, this.BUTTON_TEXT_COLOR));
        if (this.BUTTON_RIPPLE_COLOR != 0) button.setRippleColorResource(this.BUTTON_RIPPLE_COLOR);
        button.setOnClickListener(v -> {
            if (listener != null) listener.onButtonClicked();
        });

        LinearLayoutCompat buttonGroup = view.findViewById(R.id.button_group);
        if (DIALOG_DIRECTION == DialogDirection.RIGHT) buttonGroup.setGravity(Gravity.RIGHT);
        else buttonGroup.setGravity(Gravity.LEFT);

        builder.setOnCancelListener(dialogInterface -> {
            if (listener != null) listener.onCanceled();
        });

        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

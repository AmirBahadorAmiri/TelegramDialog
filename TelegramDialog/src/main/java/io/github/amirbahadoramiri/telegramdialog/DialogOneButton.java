package io.github.amirbahadoramiri.telegramdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class DialogOneButton {

    Context context;
    Dialog builder;
    OnClickListeners.OneButtonListener listener;

    String TITLE, MESSAGE, BUTTON_TEXT;
    boolean CANCELABLE = true;
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

    public DialogOneButton setOnClickListener(OnClickListeners.OneButtonListener listener) {
        this.listener = listener;
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
        builder = new Dialog(context, R.style.TeleDialog);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        builder.setCancelable(CANCELABLE);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_one_button, null);
        builder.setContentView(view);

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

        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

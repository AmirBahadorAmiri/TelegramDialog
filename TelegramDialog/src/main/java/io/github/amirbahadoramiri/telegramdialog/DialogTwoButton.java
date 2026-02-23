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

public class DialogTwoButton {

    Context context;
    Dialog builder;
    OnClickListeners.TwoButtonListener listener;

    String TITLE, MESSAGE, BUTTON_ONE_TEXT, BUTTON_TWO_TEXT;
    boolean CANCELABLE = true;
    DialogDirection DIALOG_DIRECTION = DialogDirection.RIGHT;
    int BUTTON_ONE_TEXT_COLOR = R.color.main_blue;
    int BUTTON_ONE_RIPPLE_COLOR = R.color.main_blue_tint;
    int BUTTON_TWO_TEXT_COLOR = R.color.main_red;
    int BUTTON_TWO_RIPPLE_COLOR = R.color.main_red_tint;

    public DialogTwoButton(Context context) {
        this.context = context;
    }

    public DialogTwoButton setTitle(String title) {
        this.TITLE = title;
        return this;
    }

    public DialogTwoButton setMessage(String message) {
        this.MESSAGE = message;
        return this;
    }

    public DialogTwoButton setCancelable(boolean cancelable) {
        this.CANCELABLE = cancelable;
        return this;
    }

    public DialogTwoButton setDirection(DialogDirection dialogDirection) {
        this.DIALOG_DIRECTION = dialogDirection;
        return this;
    }

    public DialogTwoButton setOnClickListener(OnClickListeners.TwoButtonListener listener) {
        this.listener = listener;
        return this;
    }

    public DialogTwoButton setButtonOneText(String buttonOneText) {
        this.BUTTON_ONE_TEXT = buttonOneText;
        return this;
    }

    public DialogTwoButton setButtonOneTextColor(int buttonOneTextColor) {
        this.BUTTON_ONE_TEXT_COLOR = buttonOneTextColor;
        return this;
    }

    public DialogTwoButton setButtonOneRippleColor(int buttonOneRippleColor) {
        this.BUTTON_ONE_RIPPLE_COLOR = buttonOneRippleColor;
        return this;
    }

    public DialogTwoButton setButtonTwoText(String buttonTwoText) {
        this.BUTTON_TWO_TEXT = buttonTwoText;
        return this;
    }

    public DialogTwoButton setButtonTwoTextColor(int buttonTwoTextColor) {
        this.BUTTON_TWO_TEXT_COLOR = buttonTwoTextColor;
        return this;
    }

    public DialogTwoButton setButtonTwoRippleColor(int buttonTwoRippleColor) {
        this.BUTTON_TWO_RIPPLE_COLOR = buttonTwoRippleColor;
        return this;
    }

    public void show() {
        builder = new Dialog(context, R.style.TeleDialog);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        builder.setCancelable(CANCELABLE);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_two_button, null);
        builder.setContentView(view);

        AppCompatTextView title = view.findViewById(R.id.title);
        if (this.TITLE != null) title.setText(this.TITLE);

        AppCompatTextView message = view.findViewById(R.id.message);
        if (this.MESSAGE != null) message.setText(this.MESSAGE);

        MaterialButton button1 = view.findViewById(R.id.button1);
        if (this.BUTTON_ONE_TEXT != null) button1.setText(this.BUTTON_ONE_TEXT);
        if (this.BUTTON_ONE_TEXT_COLOR != 0)
            button1.setTextColor(ContextCompat.getColor(context, this.BUTTON_ONE_TEXT_COLOR));
        if (this.BUTTON_ONE_RIPPLE_COLOR != 0)
            button1.setRippleColorResource(this.BUTTON_ONE_RIPPLE_COLOR);
        button1.setOnClickListener(v -> {
            if (listener != null) listener.onFirstButtonClicked();
        });

        MaterialButton button2 = view.findViewById(R.id.button2);
        if (this.BUTTON_TWO_TEXT != null) button2.setText(this.BUTTON_TWO_TEXT);
        if (this.BUTTON_TWO_TEXT_COLOR != 0)
            button2.setTextColor(ContextCompat.getColor(context, this.BUTTON_TWO_TEXT_COLOR));
        if (this.BUTTON_TWO_RIPPLE_COLOR != 0)
            button2.setRippleColorResource(this.BUTTON_TWO_RIPPLE_COLOR);
        button2.setOnClickListener(v -> {
            if (listener != null) listener.onSecondButtonClicked();
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

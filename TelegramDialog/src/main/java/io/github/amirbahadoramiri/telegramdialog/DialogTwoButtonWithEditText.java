package io.github.amirbahadoramiri.telegramdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class DialogTwoButtonWithEditText {

    Context context;
    Dialog builder;
    OnClickListeners.TwoButtonWithEditTextListener listener;

    String TITLE, MESSAGE, BUTTON_ONE_TEXT, BUTTON_TWO_TEXT, EDITTEXT_TEXT, EDITTEXT_HINT;
    boolean CANCELABLE = true;
    DialogDirection DIALOG_DIRECTION = DialogDirection.RIGHT;
    int BUTTON_ONE_TEXT_COLOR = R.color.main_blue;
    int BUTTON_ONE_RIPPLE_COLOR = R.color.main_blue_tint;
    int BUTTON_TWO_TEXT_COLOR = R.color.main_red;
    int BUTTON_TWO_RIPPLE_COLOR = R.color.main_red_tint;
    int EDITTEXT_TEXT_COLOR = R.color.textcolor;
    int EDITTEXT_HINT_COLOR = R.color.main_blue_light;
    int EDITTEXT_BACKGROUND_COLOR = R.color.main_blue_tint;
    int EDITTEXT_DRAWABLE = 0;
    int EDITTEXT_DRAWABLE_COLOR = R.color.main_blue;

    public DialogTwoButtonWithEditText(Context context) {
        this.context = context;
    }

    public DialogTwoButtonWithEditText setTitle(String title) {
        this.TITLE = title;
        return this;
    }

    public DialogTwoButtonWithEditText setMessage(String message) {
        this.MESSAGE = message;
        return this;
    }

    public DialogTwoButtonWithEditText setCancelable(boolean cancelable) {
        this.CANCELABLE = cancelable;
        return this;
    }

    public DialogTwoButtonWithEditText setDirection(DialogDirection dialogDirection) {
        this.DIALOG_DIRECTION = dialogDirection;
        return this;
    }

    public DialogTwoButtonWithEditText setOnClickListener(OnClickListeners.TwoButtonWithEditTextListener listener) {
        this.listener = listener;
        return this;
    }

    public DialogTwoButtonWithEditText setButtonOneText(String buttonOneText) {
        this.BUTTON_ONE_TEXT = buttonOneText;
        return this;
    }

    public DialogTwoButtonWithEditText setButtonOneTextColor(int buttonOneTextColor) {
        this.BUTTON_ONE_TEXT_COLOR = buttonOneTextColor;
        return this;
    }

    public DialogTwoButtonWithEditText setButtonOneRippleColor(int buttonOneRippleColor) {
        this.BUTTON_ONE_RIPPLE_COLOR = buttonOneRippleColor;
        return this;
    }

    public DialogTwoButtonWithEditText setButtonTwoText(String buttonTwoText) {
        this.BUTTON_TWO_TEXT = buttonTwoText;
        return this;
    }

    public DialogTwoButtonWithEditText setButtonTwoTextColor(int buttonTwoTextColor) {
        this.BUTTON_TWO_TEXT_COLOR = buttonTwoTextColor;
        return this;
    }

    public DialogTwoButtonWithEditText setButtonTwoRippleColor(int buttonTwoRippleColor) {
        this.BUTTON_TWO_RIPPLE_COLOR = buttonTwoRippleColor;
        return this;
    }

    public DialogTwoButtonWithEditText setEditTextValue(String text) {
        this.EDITTEXT_TEXT = text;
        return this;
    }

    public DialogTwoButtonWithEditText setEditTextColor(int color) {
        this.EDITTEXT_TEXT_COLOR = color;
        return this;
    }

    public DialogTwoButtonWithEditText setEditTextHint(String hint) {
        this.EDITTEXT_HINT = hint;
        return this;
    }

    public DialogTwoButtonWithEditText setEditTextHintColor(int color) {
        this.EDITTEXT_HINT_COLOR = color;
        return this;
    }

    public DialogTwoButtonWithEditText setEditTextBackgroundColor(int color) {
        this.EDITTEXT_BACKGROUND_COLOR = color;
        return this;
    }

    public DialogTwoButtonWithEditText setEditTextDrawable(int drawable) {
        this.EDITTEXT_DRAWABLE = drawable;
        return this;
    }

    public DialogTwoButtonWithEditText setEditTextDrawableColor(int color) {
        this.EDITTEXT_DRAWABLE_COLOR = color;
        return this;
    }

    public void show() {
        builder = new Dialog(context, R.style.TeleDialog);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        builder.setCancelable(CANCELABLE);

        View view = LayoutInflater.from(context).inflate(R.layout.two_button_with_edit_text, null);
        builder.setContentView(view);

        AppCompatTextView title = view.findViewById(R.id.title);
        if (this.TITLE != null) title.setText(this.TITLE);

        AppCompatTextView message = view.findViewById(R.id.message);
        if (this.MESSAGE != null) message.setText(this.MESSAGE);

        AppCompatEditText edittext = view.findViewById(R.id.edittext);
        if (this.EDITTEXT_TEXT != null) edittext.setText(this.EDITTEXT_TEXT);
        if (this.EDITTEXT_HINT != null) edittext.setHint(this.EDITTEXT_HINT);
        if (EDITTEXT_TEXT_COLOR != 0)
            edittext.setTextColor(ContextCompat.getColor(context, this.EDITTEXT_TEXT_COLOR));
        if (EDITTEXT_HINT_COLOR != 0)
            edittext.setHintTextColor(ContextCompat.getColor(context, this.EDITTEXT_HINT_COLOR));
        if (EDITTEXT_BACKGROUND_COLOR != 0) {
            ColorStateList colorStateList = ColorStateList.valueOf(
                    ContextCompat.getColor(context, this.EDITTEXT_BACKGROUND_COLOR)
            );
            ViewCompat.setBackgroundTintList(edittext, colorStateList);
        }
        if (EDITTEXT_DRAWABLE != 0) {
            Drawable drawable = ContextCompat.getDrawable(context, this.EDITTEXT_DRAWABLE);
            if (EDITTEXT_DRAWABLE_COLOR != 0) {
                if (drawable != null) {
                    drawable = drawable.mutate();
                    DrawableCompat.setTint(drawable, ContextCompat.getColor(context, this.EDITTEXT_DRAWABLE_COLOR));
                }
            }
            edittext.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }

        MaterialButton button1 = view.findViewById(R.id.button1);
        if (this.BUTTON_ONE_TEXT != null) button1.setText(this.BUTTON_ONE_TEXT);
        if (this.BUTTON_ONE_TEXT_COLOR != 0)
            button1.setTextColor(ContextCompat.getColor(context, this.BUTTON_ONE_TEXT_COLOR));
        if (this.BUTTON_ONE_RIPPLE_COLOR != 0)
            button1.setRippleColorResource(this.BUTTON_ONE_RIPPLE_COLOR);
        button1.setOnClickListener(v -> {
            if (listener != null)
                listener.onFirstButtonClicked(Objects.requireNonNull(edittext.getText()).toString());
        });

        MaterialButton button2 = view.findViewById(R.id.button2);
        if (this.BUTTON_TWO_TEXT != null) button2.setText(this.BUTTON_TWO_TEXT);
        if (this.BUTTON_TWO_TEXT_COLOR != 0)
            button2.setTextColor(ContextCompat.getColor(context, this.BUTTON_TWO_TEXT_COLOR));
        if (this.BUTTON_TWO_RIPPLE_COLOR != 0)
            button2.setRippleColorResource(this.BUTTON_TWO_RIPPLE_COLOR);
        button2.setOnClickListener(v -> {
            if (listener != null)
                listener.onSecondButtonClicked(Objects.requireNonNull(edittext.getText()).toString());
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

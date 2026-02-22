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

public class DialogOneButtonWithEditText {

    Context context;
    Dialog builder;
    OnClickListeners.OneButtonWithEditTextListener listener;

    String TITLE, MESSAGE, BUTTON_TEXT, EDITTEXT_TEXT, EDITTEXT_HINT;
    boolean CANCELABLE = true;
    DialogDirection DIALOG_DIRECTION = DialogDirection.RIGHT;
    int BUTTON_TEXT_COLOR = R.color.main_blue;
    int BUTTON_RIPPLE_COLOR = R.color.main_blue_tint;
    int EDITTEXT_TEXT_COLOR = R.color.main_blue;
    int EDITTEXT_HINT_COLOR = R.color.main_blue_light;
    int EDITTEXT_BACKGROUND_COLOR = R.color.main_blue_tint;
    int EDITTEXT_DRAWABLE = 0;
    int EDITTEXT_DRAWABLE_COLOR = R.color.main_blue;

    public DialogOneButtonWithEditText(Context context) {
        this.context = context;
    }

    public DialogOneButtonWithEditText setTitle(String title) {
        this.TITLE = title;
        return this;
    }

    public DialogOneButtonWithEditText setMessage(String message) {
        this.MESSAGE = message;
        return this;
    }

    public DialogOneButtonWithEditText setCancelable(boolean cancelable) {
        this.CANCELABLE = cancelable;
        return this;
    }

    public DialogOneButtonWithEditText setDirection(DialogDirection dialogDirection) {
        this.DIALOG_DIRECTION = dialogDirection;
        return this;
    }

    public DialogOneButtonWithEditText setOnClickListener(OnClickListeners.OneButtonWithEditTextListener listener) {
        this.listener = listener;
        return this;
    }

    public DialogOneButtonWithEditText setButtonText(String buttonText) {
        this.BUTTON_TEXT = buttonText;
        return this;
    }

    public DialogOneButtonWithEditText setButtonTextColor(int buttonTextColor) {
        this.BUTTON_TEXT_COLOR = buttonTextColor;
        return this;
    }

    public DialogOneButtonWithEditText setButtonRippleColor(int buttonRippleColor) {
        this.BUTTON_RIPPLE_COLOR = buttonRippleColor;
        return this;
    }

    public DialogOneButtonWithEditText setEditTextValue(String text) {
        this.EDITTEXT_TEXT = text;
        return this;
    }

    public DialogOneButtonWithEditText setEditTextColor(int color) {
        this.EDITTEXT_TEXT_COLOR = color;
        return this;
    }

    public DialogOneButtonWithEditText setEditTextHint(String hint) {
        this.EDITTEXT_HINT = hint;
        return this;
    }

    public DialogOneButtonWithEditText setEditTextHintColor(int color) {
        this.EDITTEXT_HINT_COLOR = color;
        return this;
    }

    public DialogOneButtonWithEditText setEditTextBackgroundColor(int color) {
        this.EDITTEXT_BACKGROUND_COLOR = color;
        return this;
    }

    public DialogOneButtonWithEditText setEditTextDrawable(int drawable) {
        this.EDITTEXT_DRAWABLE = drawable;
        return this;
    }

    public DialogOneButtonWithEditText setEditTextDrawableColor(int color) {
        this.EDITTEXT_DRAWABLE_COLOR = color;
        return this;
    }

    public void show() {
        builder = new Dialog(context, R.style.TeleDialog);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        builder.setCancelable(CANCELABLE);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_one_button_with_edit_text, null);
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

        MaterialButton button = view.findViewById(R.id.button);
        if (this.BUTTON_TEXT != null) button.setText(this.BUTTON_TEXT);
        if (this.BUTTON_TEXT_COLOR != 0)
            button.setTextColor(ContextCompat.getColor(context, this.BUTTON_TEXT_COLOR));
        if (this.BUTTON_RIPPLE_COLOR != 0) button.setRippleColorResource(this.BUTTON_RIPPLE_COLOR);
        button.setOnClickListener(v -> {
            if (listener != null)
                listener.onButtonClicked(Objects.requireNonNull(edittext.getText()).toString());
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

package com.github.amirbahadoramiri.telegramdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

import com.github.amirbahadoramiri.telegramdialog.direction.DialogDirection;
import com.github.amirbahadoramiri.telegramdialog.listeners.OnInputConfirmListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TelegramInputConfirmDialog {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private AppCompatTextView titleView, messageView;
    private AppCompatEditText edittextView;
    private MaterialButton btn1View, btn2View;
    private LinearLayoutCompat buttonGroup;
    private DialogDirection direction;

    @SuppressLint("InflateParams")
    public TelegramInputConfirmDialog(Context context, DialogDirection direction) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.telegram_input_confirm_dialog, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        titleView = view.findViewById(R.id.title);
        messageView = view.findViewById(R.id.message);
        edittextView = view.findViewById(R.id.edittext);
        btn1View = view.findViewById(R.id.button1);
        btn2View = view.findViewById(R.id.button2);
        buttonGroup = view.findViewById(R.id.button_group);

        setDirection(direction);

        setTitle("Title");
        setMessage("Message");
        setEditTextColor(TelegramColors.getTextColor(context));
        setEditTextHintColor(TelegramColors.getColor(TelegramColors.MAIN_BLUE_LIGHT));
        setEditTextBackgroundColor(TelegramColors.getMainBlueTint(context));
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

    }

    public TelegramInputConfirmDialog setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TelegramInputConfirmDialog setTitleTextColor(int color) {
        titleView.setTextColor(color);
        return this;
    }

    public TelegramInputConfirmDialog setMessage(String message) {
        messageView.setText(message);
        return this;
    }

    public TelegramInputConfirmDialog setMessageTextColor(int color) {
        messageView.setTextColor(color);
        return this;
    }

    public TelegramInputConfirmDialog setJustificationMode(int mode) {
        messageView.setJustificationMode(mode);
        return this;
    }

    public TelegramInputConfirmDialog setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    private TelegramInputConfirmDialog setDirection(DialogDirection dialogDirection) {
        this.direction = dialogDirection;
        if (dialogDirection == DialogDirection.LTR)
            buttonGroup.setGravity(Gravity.RIGHT);
        else
            buttonGroup.setGravity(Gravity.LEFT);
        return this;
    }

    public TelegramInputConfirmDialog setOnClickListener(OnInputConfirmListener listener) {
        if (direction == DialogDirection.LTR) {
            btn1View.setOnClickListener(v -> listener.onNegativeButtonClicked(Objects.requireNonNull(edittextView.getText()).toString()));
            btn2View.setOnClickListener(v -> listener.onPositiveButtonClicked(Objects.requireNonNull(edittextView.getText()).toString()));
        } else {
            btn2View.setOnClickListener(v -> listener.onNegativeButtonClicked(Objects.requireNonNull(edittextView.getText()).toString()));
            btn1View.setOnClickListener(v -> listener.onPositiveButtonClicked(Objects.requireNonNull(edittextView.getText()).toString()));
        }

        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TelegramInputConfirmDialog setCardBackgroundColor(int color) {
        cardView.setCardBackgroundColor(color);
        view.findViewById(R.id.constraint).setBackgroundColor(color);
        return this;
    }

    public TelegramInputConfirmDialog setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramInputConfirmDialog setNegativeButtonText(String buttonOneText) {
        if (direction == DialogDirection.LTR) {
            btn1View.setText(buttonOneText);
        } else {
            btn2View.setText(buttonOneText);
        }
        return this;
    }

    public TelegramInputConfirmDialog setNegativeButtonTextColor(int color) {
        if (direction == DialogDirection.LTR) {
            btn1View.setTextColor(color);
        } else {
            btn2View.setTextColor(color);
        }
        return this;
    }

    public TelegramInputConfirmDialog setNegativeButtonRippleColor(int color) {
        if (direction == DialogDirection.LTR) {
            btn1View.setRippleColor(ColorStateList.valueOf(color));
        } else {
            btn2View.setRippleColor(ColorStateList.valueOf(color));
        }
        return this;
    }

    public TelegramInputConfirmDialog setNegativeButtonCornerRadius(int radius) {
        if (direction == DialogDirection.LTR) {
            btn1View.setCornerRadius((int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    radius,
                    context.getResources().getDisplayMetrics()
            ));
        } else {
            btn2View.setCornerRadius((int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    radius,
                    context.getResources().getDisplayMetrics()
            ));
        }
        return this;
    }

    public TelegramInputConfirmDialog setNegativeButtonBackgroundColor(int color) {
        if (direction == DialogDirection.LTR) {
            btn1View.setBackgroundTintList(ColorStateList.valueOf(color));
        } else {
            btn2View.setBackgroundTintList(ColorStateList.valueOf(color));
        }
        return this;
    }

    public TelegramInputConfirmDialog setPositiveButtonText(String buttonTwoText) {
        if (direction == DialogDirection.LTR) {
            btn2View.setText(buttonTwoText);
        } else {
            btn1View.setText(buttonTwoText);
        }
        return this;
    }

    public TelegramInputConfirmDialog setPositiveButtonTextColor(int color) {
        if (direction == DialogDirection.LTR) {
            btn2View.setTextColor(color);
        } else {
            btn1View.setTextColor(color);
        }
        return this;
    }

    public TelegramInputConfirmDialog setPositiveButtonRippleColor(int color) {
        if (direction == DialogDirection.LTR) {
            btn2View.setRippleColor(ColorStateList.valueOf(color));
        } else {
            btn1View.setRippleColor(ColorStateList.valueOf(color));
        }
        return this;
    }

    public TelegramInputConfirmDialog setPositiveButtonCornerRadius(int radius) {
        if (direction == DialogDirection.LTR) {
            btn2View.setCornerRadius((int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    radius,
                    context.getResources().getDisplayMetrics()
            ));
        } else {
            btn1View.setCornerRadius((int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    radius,
                    context.getResources().getDisplayMetrics()
            ));
        }
        return this;
    }

    public TelegramInputConfirmDialog setPositiveButtonBackgroundColor(int color) {
        if (direction == DialogDirection.LTR) {
            btn2View.setBackgroundTintList(ColorStateList.valueOf(color));
        } else {
            btn1View.setBackgroundTintList(ColorStateList.valueOf(color));
        }
        return this;
    }

    public TelegramInputConfirmDialog setEditTextValue(String text) {
        edittextView.setText(text);
        return this;
    }

    public TelegramInputConfirmDialog setEditTextColor(int color) {
        edittextView.setTextColor(color);
        return this;
    }

    public TelegramInputConfirmDialog setEditTextHint(String hint) {
        edittextView.setHint(hint);
        return this;
    }

    public TelegramInputConfirmDialog setEditTextHintColor(int color) {
        edittextView.setHintTextColor(color);
        return this;
    }

    public TelegramInputConfirmDialog setEditTextBackgroundColor(int color) {
        ColorStateList colorStateList = ColorStateList.valueOf(color);
        ViewCompat.setBackgroundTintList(edittextView, colorStateList);
        return this;
    }

    public TelegramInputConfirmDialog setInputType(int inputType) {
        edittextView.setInputType(inputType);
        return this;
    }

    public TelegramInputConfirmDialog setEditTextDrawable(int drawableID, int tintColor) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableID);
        if (drawable != null) {
            drawable = drawable.mutate();
            DrawableCompat.setTint(drawable, tintColor);
            edittextView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }
        return this;
    }

    public void show() {
        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

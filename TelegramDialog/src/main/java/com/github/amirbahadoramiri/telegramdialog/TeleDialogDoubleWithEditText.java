package com.github.amirbahadoramiri.telegramdialog;

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

import com.github.amirbahadoramiri.telegramdialog.direction.TeleDirection;
import com.github.amirbahadoramiri.telegramdialog.listeners.TeleDialogDoubleWithEditTextListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TeleDialogDoubleWithEditText {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private AppCompatTextView titleView, messageView;
    private AppCompatEditText edittextView;
    private MaterialButton btn1View, btn2View;
    private LinearLayoutCompat buttonGroup;

    public TeleDialogDoubleWithEditText(Context context) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.tele_dialog_double_with_edit_text, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        titleView = view.findViewById(R.id.title);
        messageView = view.findViewById(R.id.message);
        edittextView = view.findViewById(R.id.edittext);
        btn1View = view.findViewById(R.id.button1);
        btn2View = view.findViewById(R.id.button2);
        buttonGroup = view.findViewById(R.id.button_group);

        setTitle("Title");
        setMessage("Message");
        setEditTextColor(R.color.textcolor);
        setEditTextHintColor(R.color.main_blue_light);
        setEditTextBackgroundColor(R.color.main_blue_tint);
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
        setDirection(TeleDirection.LTR);

    }

    public TeleDialogDoubleWithEditText setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TeleDialogDoubleWithEditText setMessage(String message) {
        messageView.setText(message);
        return this;
    }

    public TeleDialogDoubleWithEditText setJustificationMode(int mode) {
        messageView.setJustificationMode(mode);
        return this;
    }

    public TeleDialogDoubleWithEditText setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TeleDialogDoubleWithEditText setDirection(TeleDirection teleDirection) {
        if (teleDirection == TeleDirection.LTR)
            buttonGroup.setGravity(Gravity.RIGHT);
        else
            buttonGroup.setGravity(Gravity.LEFT);
        return this;
    }

    public TeleDialogDoubleWithEditText setOnClickListener(TeleDialogDoubleWithEditTextListener listener) {
        btn1View.setOnClickListener(v -> listener.onFirstButtonClicked(Objects.requireNonNull(edittextView.getText()).toString()));
        btn2View.setOnClickListener(v -> listener.onSecondButtonClicked(Objects.requireNonNull(edittextView.getText()).toString()));
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TeleDialogDoubleWithEditText setCardBackgroundColor(int cardBackgroundColor) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        return this;
    }

    public TeleDialogDoubleWithEditText setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TeleDialogDoubleWithEditText setButtonOneText(String buttonOneText) {
        btn1View.setText(buttonOneText);
        return this;
    }

    public TeleDialogDoubleWithEditText setButtonOneTextColor(int buttonOneTextColor) {
        btn1View.setTextColor(ContextCompat.getColor(context, buttonOneTextColor));
        return this;
    }

    public TeleDialogDoubleWithEditText setButtonOneRippleColor(int buttonOneRippleColor) {
        btn1View.setRippleColorResource(buttonOneRippleColor);
        return this;
    }

    public TeleDialogDoubleWithEditText setButtonOneCornerRadius(int radius) {
        btn1View.setCornerRadius((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                radius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TeleDialogDoubleWithEditText setButtonTwoText(String buttonTwoText) {
        btn2View.setText(buttonTwoText);
        return this;
    }

    public TeleDialogDoubleWithEditText setButtonTwoTextColor(int buttonTwoTextColor) {
        btn2View.setTextColor(ContextCompat.getColor(context, buttonTwoTextColor));
        return this;
    }

    public TeleDialogDoubleWithEditText setButtonTwoRippleColor(int buttonTwoRippleColor) {
        btn2View.setRippleColorResource(buttonTwoRippleColor);
        return this;
    }

    public TeleDialogDoubleWithEditText setButtonTwoCornerRadius(int radius) {
        btn2View.setCornerRadius((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                radius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TeleDialogDoubleWithEditText setEditTextValue(String text) {
        edittextView.setText(text);
        return this;
    }

    public TeleDialogDoubleWithEditText setEditTextColor(int color) {
        edittextView.setTextColor(ContextCompat.getColor(context, color));
        return this;
    }

    public TeleDialogDoubleWithEditText setEditTextHint(String hint) {
        edittextView.setHint(hint);
        return this;
    }

    public TeleDialogDoubleWithEditText setEditTextHintColor(int color) {
        edittextView.setHintTextColor(ContextCompat.getColor(context, color));
        return this;
    }

    public TeleDialogDoubleWithEditText setEditTextBackgroundColor(int color) {
        ColorStateList colorStateList = ColorStateList.valueOf(
                ContextCompat.getColor(context, color)
        );
        ViewCompat.setBackgroundTintList(edittextView, colorStateList);
        return this;
    }

    public TeleDialogDoubleWithEditText setEditTextDrawable(int drawableID, int tintColor) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableID);
        if (drawable != null) {
            drawable = drawable.mutate();
            DrawableCompat.setTint(drawable, ContextCompat.getColor(context, tintColor));
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

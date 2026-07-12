package com.github.amirbahadoramiri.telegramdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.github.amirbahadoramiri.telegramdialog.listeners.OnProgressListener;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TelegramProgressDialog {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private ProgressBar progressBarView;

    public TelegramProgressDialog(Context context) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.telegram_progress_dialog, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        progressBarView = view.findViewById(R.id.progress_bar);

        setMax(100);
        setValue(30);
        setProgressbarTint(TelegramColors.getMainBlue());
        setProgressbarBackgroundTint(TelegramColors.getColor(TelegramColors.MAIN_BLUE_LIGHT));
        setCardRadius(16);
        setCardBackgroundColor(TelegramColors.getDialogBackground(context));
        setCancelable(true);

    }

    public TelegramProgressDialog setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TelegramProgressDialog setOnClickListener(OnProgressListener listener) {
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TelegramProgressDialog setCardBackgroundColor(int color) {
        cardView.setCardBackgroundColor(color);
        view.findViewById(R.id.constraint).setBackgroundColor(color);
        return this;
    }

    public TelegramProgressDialog setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramProgressDialog setProgressbarTint(int color) {
        progressBarView.setProgressTintList(ColorStateList.valueOf(color));
        return this;
    }

    public TelegramProgressDialog setProgressbarBackgroundTint(int color) {
        progressBarView.setProgressBackgroundTintList(ColorStateList.valueOf(color));
        return this;
    }

    public TelegramProgressDialog setMax(int progressbarMax) {
        progressBarView.setMax(progressbarMax);
        return this;
    }

    public TelegramProgressDialog setValue(int progressbarValue) {
        progressBarView.setProgress(progressbarValue);
        return this;
    }

    public void show() {
        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

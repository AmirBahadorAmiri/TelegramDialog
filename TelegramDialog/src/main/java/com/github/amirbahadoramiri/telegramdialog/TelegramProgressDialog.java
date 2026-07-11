package com.github.amirbahadoramiri.telegramdialog;

import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.core.content.ContextCompat;

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
        setProgressbarTint(R.color.main_blue);
        setProgressbarBackgroundTint(R.color.main_blue_light);
        setCardRadius(16);
        setCardBackgroundColor(R.color.dialog_page_background);
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

    public TelegramProgressDialog setCardBackgroundColor(int cardBackgroundColor) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
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

    public TelegramProgressDialog setProgressbarTint(int progressbarTint) {
        progressBarView.setProgressTintList(ContextCompat.getColorStateList(context, progressbarTint));
        return this;
    }

    public TelegramProgressDialog setProgressbarBackgroundTint(int progressbarBackgroundTint) {
        progressBarView.setProgressBackgroundTintList(ContextCompat.getColorStateList(context, progressbarBackgroundTint));
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

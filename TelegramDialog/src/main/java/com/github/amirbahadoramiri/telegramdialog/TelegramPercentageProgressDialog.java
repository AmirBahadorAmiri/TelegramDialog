package com.github.amirbahadoramiri.telegramdialog;

import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.github.amirbahadoramiri.telegramdialog.listeners.OnPercentageProgressListener;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TelegramPercentageProgressDialog {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private AppCompatTextView titleView, statusView;
    private ProgressBar progressBarView;

    public TelegramPercentageProgressDialog(Context context) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.telegram_percentage_progress_dialog, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        titleView = view.findViewById(R.id.title);
        progressBarView = view.findViewById(R.id.progress_bar);
        statusView = view.findViewById(R.id.status);

        setTitle("Title");
        setStatus("30%");
        setMax(100);
        setValue(30);
        setProgressbarTint(R.color.main_blue);
        setProgressbarBackgroundTint(R.color.main_blue_light);
        setCardRadius(16);
        setCardBackgroundColor(R.color.dialog_page_background);
        setCancelable(true);

    }

    public TelegramPercentageProgressDialog setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TelegramPercentageProgressDialog setStatus(String status) {
        statusView.setText(status);
        return this;
    }

    public TelegramPercentageProgressDialog setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TelegramPercentageProgressDialog setOnClickListener(OnPercentageProgressListener listener) {
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TelegramPercentageProgressDialog setCardBackgroundColor(int cardBackgroundColor) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        return this;
    }

    public TelegramPercentageProgressDialog setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramPercentageProgressDialog setProgressbarTint(int progressbarTint) {
        progressBarView.setProgressTintList(ContextCompat.getColorStateList(context, progressbarTint));
        return this;
    }

    public TelegramPercentageProgressDialog setProgressbarBackgroundTint(int progressbarBackgroundTint) {
        progressBarView.setProgressBackgroundTintList(ContextCompat.getColorStateList(context, progressbarBackgroundTint));
        return this;
    }

    public TelegramPercentageProgressDialog setMax(int progressbarMax) {
        progressBarView.setMax(progressbarMax);
        return this;
    }

    public TelegramPercentageProgressDialog setValue(int progressbarValue) {
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

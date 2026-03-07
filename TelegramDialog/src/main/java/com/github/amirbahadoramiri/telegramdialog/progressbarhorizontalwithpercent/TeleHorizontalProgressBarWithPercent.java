package com.github.amirbahadoramiri.telegramdialog.progressbarhorizontalwithpercent;

import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.github.amirbahadoramiri.telegramdialog.R;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TeleHorizontalProgressBarWithPercent {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private AppCompatTextView titleView, statusView;
    private ProgressBar progressBarView;

    public TeleHorizontalProgressBarWithPercent(Context context) {
        this.context = context;
        builder = new Dialog(context, R.style.LargeDialogStyle);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.tele_horizontal_progressbar_with_percent, null);
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

    public TeleHorizontalProgressBarWithPercent setTitle(String title) {
        titleView.setText(title);
        return this;
    }

    public TeleHorizontalProgressBarWithPercent setStatus(String status) {
        statusView.setText(status);
        return this;
    }

    public TeleHorizontalProgressBarWithPercent setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TeleHorizontalProgressBarWithPercent setOnClickListener(TeleHorizontalProgressBarWithPercentListener listener) {
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TeleHorizontalProgressBarWithPercent setCardBackgroundColor(int cardBackgroundColor) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        return this;
    }

    public TeleHorizontalProgressBarWithPercent setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TeleHorizontalProgressBarWithPercent setProgressbarTint(int progressbarTint) {
        progressBarView.setProgressTintList(ContextCompat.getColorStateList(context, progressbarTint));
        return this;
    }

    public TeleHorizontalProgressBarWithPercent setProgressbarBackgroundTint(int progressbarBackgroundTint) {
        progressBarView.setProgressBackgroundTintList(ContextCompat.getColorStateList(context, progressbarBackgroundTint));
        return this;
    }

    public TeleHorizontalProgressBarWithPercent setMax(int progressbarMax) {
        progressBarView.setMax(progressbarMax);
        return this;
    }

    public TeleHorizontalProgressBarWithPercent setValue(int progressbarValue) {
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

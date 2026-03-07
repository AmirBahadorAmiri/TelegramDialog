package com.github.amirbahadoramiri.telegramdialog.progressbar;

import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.core.content.ContextCompat;

import com.github.amirbahadoramiri.telegramdialog.R;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TeleProgressBar {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private ProgressBar progressBarView;

    public TeleProgressBar(Context context) {
        this.context = context;
        builder = new Dialog(context);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.tele_progressbar, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        progressBarView = view.findViewById(R.id.progress_bar);

        setProgressbarIndeterminateTint(R.color.progressbar_indeterminate_tint);
        setCardRadius(16);
        setCardBackgroundColor(R.color.dialog_page_background);
        setCancelable(true);

    }

    public TeleProgressBar setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TeleProgressBar setOnClickListener(TeleProgressBarListener listener) {
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TeleProgressBar setCardBackgroundColor(int cardBackgroundColor) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor));
        return this;
    }

    public TeleProgressBar setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TeleProgressBar setProgressbarIndeterminateTint(int progressbarIndeterminateTint) {
        progressBarView.setIndeterminateTintList(ContextCompat.getColorStateList(context, progressbarIndeterminateTint));
        return this;
    }

    public void show() {
        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

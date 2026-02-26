package com.github.amirbahadoramiri.telegramdialog.mediumprogress;

import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.core.content.ContextCompat;

import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

import com.github.amirbahadoramiri.telegramdialog.R;

public class MediumProgressBar {

    Context context;
    Dialog builder;
    MediumProgressBarListener listener;

    boolean CANCELABLE = true;
    int CARD_BACKGROUND_COLOR = R.color.dialog_page_background;
    int CARD_RADIUS = 16;
    int PROGRESSBAR_INDETERMINATE_TINT = R.color.progressbar_indeterminate_tint;

    public MediumProgressBar(Context context) {
        this.context = context;
    }

    public MediumProgressBar setCancelable(boolean cancelable) {
        this.CANCELABLE = cancelable;
        return this;
    }

    public MediumProgressBar setOnClickListener(MediumProgressBarListener listener) {
        this.listener = listener;
        return this;
    }

    public MediumProgressBar setCardBackgroundColor(int cardBackgroundColor) {
        this.CARD_BACKGROUND_COLOR = cardBackgroundColor;
        return this;
    }

    public MediumProgressBar setCardRadius(int cardRadius) {
        this.CARD_RADIUS = cardRadius;
        return this;
    }

    public MediumProgressBar setProgressbarIndeterminateTint(int progressbarIndeterminateTint) {
        this.PROGRESSBAR_INDETERMINATE_TINT = progressbarIndeterminateTint;
        return this;
    }

    public void show() {
        builder = new Dialog(context);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        builder.setCancelable(CANCELABLE);

        View view = LayoutInflater.from(context).inflate(R.layout.medium_progress_view, null);
        builder.setContentView(view);

        MaterialCardView cardView = view.findViewById(R.id.cardview);
        if (CARD_BACKGROUND_COLOR != 0) {
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, CARD_BACKGROUND_COLOR));
            view.findViewById(R.id.constraint).setBackgroundColor(ContextCompat.getColor(context, CARD_BACKGROUND_COLOR));
        }
        if (CARD_RADIUS != 0) {
            cardView.setRadius(TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    CARD_RADIUS,
                    context.getResources().getDisplayMetrics()
            ));
        }

        ProgressBar progress_bar = view.findViewById(R.id.progress_bar);
        if (PROGRESSBAR_INDETERMINATE_TINT != 0) {
            progress_bar.setIndeterminateTintList(ContextCompat.getColorStateList(context, PROGRESSBAR_INDETERMINATE_TINT));
        }

        builder.setOnCancelListener(dialogInterface -> {
            if (listener != null) listener.onCanceled();
        });

        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

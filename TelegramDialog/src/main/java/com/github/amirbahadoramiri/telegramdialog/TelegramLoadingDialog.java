package com.github.amirbahadoramiri.telegramdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.github.amirbahadoramiri.telegramdialog.listeners.OnLoadingListener;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class TelegramLoadingDialog {

    private Context context;
    private Dialog builder;

    private View view;
    private MaterialCardView cardView;
    private ProgressBar progressBarView;

    public TelegramLoadingDialog(Context context) {
        this.context = context;
        builder = new Dialog(context);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        view = LayoutInflater.from(context).inflate(R.layout.telegram_loading_dialog, null);
        builder.setContentView(view);

        cardView = view.findViewById(R.id.cardview);
        progressBarView = view.findViewById(R.id.progress_bar);

        setProgressbarIndeterminateTint(TelegramColors.getProgressBarIndeterminateTint(context));
        setCardRadius(16);
        setCardBackgroundColor(TelegramColors.getDialogBackground(context));
        setCancelable(true);

    }

    public TelegramLoadingDialog setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public TelegramLoadingDialog setOnClickListener(OnLoadingListener listener) {
        builder.setOnCancelListener(dialogInterface -> listener.onCanceled());
        return this;
    }

    public TelegramLoadingDialog setCardBackgroundColor(int color) {
        cardView.setCardBackgroundColor(color);
        view.findViewById(R.id.constraint).setBackgroundColor(color);
        return this;
    }

    public TelegramLoadingDialog setCardRadius(int cardRadius) {
        cardView.setRadius(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                cardRadius,
                context.getResources().getDisplayMetrics()
        ));
        return this;
    }

    public TelegramLoadingDialog setProgressbarIndeterminateTint(int color) {
        progressBarView.setIndeterminateTintList(ColorStateList.valueOf(color));
        return this;
    }

    public void show() {
        builder.show();
    }

    public void dismiss() {
        builder.dismiss();
    }

}

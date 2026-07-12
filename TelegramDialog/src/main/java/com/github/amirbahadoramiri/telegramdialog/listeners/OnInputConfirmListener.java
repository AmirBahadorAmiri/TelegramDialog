package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface OnInputConfirmListener {
        void onNegativeButtonClicked(String text);
        void onPositiveButtonClicked(String text);
        default void onCanceled() {}
    }
package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface OnConfirmListener {
    void onNegativeButtonClicked();
    void onPositiveButtonClicked();
    default void onCanceled() {}
}
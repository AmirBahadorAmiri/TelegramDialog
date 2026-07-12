package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface OnAlertListener {
    void onPositiveButtonClicked();
    default void onCanceled() {}
}
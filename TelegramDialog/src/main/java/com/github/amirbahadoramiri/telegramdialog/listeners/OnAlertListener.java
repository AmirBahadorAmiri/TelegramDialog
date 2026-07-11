package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface OnAlertListener {
    void onButtonClicked();
    default void onCanceled() {}
}
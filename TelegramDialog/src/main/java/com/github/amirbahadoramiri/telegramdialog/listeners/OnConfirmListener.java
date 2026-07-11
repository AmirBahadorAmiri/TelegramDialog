package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface OnConfirmListener {
    void onFirstButtonClicked();
    void onSecondButtonClicked();
    default void onCanceled() {}
}
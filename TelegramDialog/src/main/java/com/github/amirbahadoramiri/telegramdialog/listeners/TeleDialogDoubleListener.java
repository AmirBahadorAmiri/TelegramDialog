package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface TeleDialogDoubleListener {
    void onFirstButtonClicked();
    void onSecondButtonClicked();
    default void onCanceled() {}
}
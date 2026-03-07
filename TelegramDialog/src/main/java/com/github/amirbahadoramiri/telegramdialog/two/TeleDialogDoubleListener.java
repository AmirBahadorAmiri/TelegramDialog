package com.github.amirbahadoramiri.telegramdialog.two;

public interface TeleDialogDoubleListener {
    void onFirstButtonClicked();
    void onSecondButtonClicked();
    default void onCanceled() {}
}
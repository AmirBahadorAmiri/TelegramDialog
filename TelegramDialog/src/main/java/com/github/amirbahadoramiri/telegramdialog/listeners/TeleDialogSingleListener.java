package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface TeleDialogSingleListener {
    void onButtonClicked();
    default void onCanceled() {}
}
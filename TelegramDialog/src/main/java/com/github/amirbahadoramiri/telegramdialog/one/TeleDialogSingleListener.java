package com.github.amirbahadoramiri.telegramdialog.one;

public interface TeleDialogSingleListener {
    void onButtonClicked();
    default void onCanceled() {}
}
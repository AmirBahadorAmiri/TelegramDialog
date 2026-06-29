package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface TeleDialogSingleWithEditTextListener {
    void onButtonClicked(String text);
    default void onCanceled() {}
}
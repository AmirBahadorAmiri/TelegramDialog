package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface OnInputConfirmListener {
        void onFirstButtonClicked(String text);
        void onSecondButtonClicked(String text);
        default void onCanceled() {}
    }
package com.github.amirbahadoramiri.telegramdialog.twoedit;

public interface TeleDialogDoubleWithEditTextListener {
        void onFirstButtonClicked(String text);
        void onSecondButtonClicked(String text);
        default void onCanceled() {}
    }
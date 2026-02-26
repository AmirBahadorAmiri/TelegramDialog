package com.github.amirbahadoramiri.telegramdialog.twoedit;

public interface TwoButtonWithEditTextListener {
        void onFirstButtonClicked(String text);
        void onSecondButtonClicked(String text);
        default void onCanceled() {};
    }
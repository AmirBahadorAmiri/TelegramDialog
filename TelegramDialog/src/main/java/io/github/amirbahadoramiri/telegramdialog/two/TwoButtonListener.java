package io.github.amirbahadoramiri.telegramdialog.two;

public interface TwoButtonListener {
        void onFirstButtonClicked();
        void onSecondButtonClicked();
        default void onCanceled() {};
    }
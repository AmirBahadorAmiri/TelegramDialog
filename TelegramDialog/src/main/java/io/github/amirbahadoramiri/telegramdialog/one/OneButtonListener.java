package io.github.amirbahadoramiri.telegramdialog.one;

public interface OneButtonListener {
        void onButtonClicked();
        default void onCanceled() {};
    }
package com.github.amirbahadoramiri.telegramdialog.oneedit;

public interface OneButtonWithEditTextListener {
        void onButtonClicked(String text);
        default void onCanceled() {};
    }
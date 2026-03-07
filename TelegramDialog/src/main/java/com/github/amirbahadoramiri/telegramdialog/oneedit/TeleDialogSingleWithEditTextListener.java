package com.github.amirbahadoramiri.telegramdialog.oneedit;

public interface TeleDialogSingleWithEditTextListener {
    void onButtonClicked(String text);
    default void onCanceled() {}
}
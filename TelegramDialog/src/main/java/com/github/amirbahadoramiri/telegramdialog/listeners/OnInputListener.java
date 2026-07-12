package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface OnInputListener {
    void onPositiveButtonClicked(String text);
    default void onCanceled() {}
}
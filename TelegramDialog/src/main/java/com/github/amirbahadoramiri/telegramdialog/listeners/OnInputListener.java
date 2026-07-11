package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface OnInputListener {
    void onButtonClicked(String text);
    default void onCanceled() {}
}
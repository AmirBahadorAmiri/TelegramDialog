package com.github.amirbahadoramiri.telegramdialog.listeners;

public interface OnMenuListener {
    void onItemSelected(int position, String text);
    default void onCanceled() {}
}

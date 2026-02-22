package io.github.amirbahadoramiri.telegramdialog;

public interface OnClickListeners {

    public interface OneButtonListener {
        void onButtonClicked();
    }

    public interface OneButtonWithEditTextListener {
        void onButtonClicked(String text);
    }

    public interface TwoButtonListener {
        void onFirstButtonClicked();
        void onSecondButtonClicked();
    }

    public interface TwoButtonWithEditTextListener {
        void onFirstButtonClicked(String text);
        void onSecondButtonClicked(String text);
    }

}

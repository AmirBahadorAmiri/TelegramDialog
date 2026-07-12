package com.github.amirbahadoramiri.telegramdialog;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;

public class TelegramColors {

    public static final String MAIN_BLUE = "#4A90CA";
    public static final String MAIN_BLUE_TINT_LIGHT = "#EDF4FA";
    public static final String MAIN_BLUE_TINT_DARK = "#253A4D";
    public static final String MAIN_BLUE_LIGHT = "#73B0E3";

    public static final String MAIN_RED = "#CC4748";
    public static final String MAIN_RED_TINT_LIGHT = "#F9EDED";
    public static final String MAIN_RED_TINT_DARK = "#4D2525";
    public static final String MAIN_RED_LIGHT = "#F06768";

    public static final String MAIN_GREEN = "#3EB489";
    public static final String MAIN_GREEN_TINT = "#E2FFE2";
    public static final String MAIN_GREEN_LIGHT = "#ACE1AF";

    public static final String DIALOG_BACKGROUND_LIGHT = "#FFFFFF";
    public static final String DIALOG_BACKGROUND_DARK = "#1E2C38";

    public static final String TEXT_COLOR_LIGHT = "#000000";
    public static final String TEXT_COLOR_DARK = "#FFFFFF";

    public static final String PROGRESSBAR_TINT_LIGHT = "#8C8D8F";
    public static final String PROGRESSBAR_TINT_DARK = "#82909D";

    public static int getColor(String color) {
        return Color.parseColor(color);
    }

    public static boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;
    }

    public static int getDialogBackground(Context context) {
        return Color.parseColor(isNightMode(context) ? DIALOG_BACKGROUND_DARK : DIALOG_BACKGROUND_LIGHT);
    }

    public static int getTextColor(Context context) {
        return Color.parseColor(isNightMode(context) ? TEXT_COLOR_DARK : TEXT_COLOR_LIGHT);
    }

    public static int getMainBlue() {
        return Color.parseColor(MAIN_BLUE);
    }
    
    public static int getMainBlueTint(Context context) {
        return Color.parseColor(isNightMode(context) ? MAIN_BLUE_TINT_DARK : MAIN_BLUE_TINT_LIGHT);
    }

    public static int getMainRed() {
        return Color.parseColor(MAIN_RED);
    }

    public static int getMainRedTint(Context context) {
        return Color.parseColor(isNightMode(context) ? MAIN_RED_TINT_DARK : MAIN_RED_TINT_LIGHT);
    }
    
    public static int getProgressBarIndeterminateTint(Context context) {
        return Color.parseColor(isNightMode(context) ? PROGRESSBAR_TINT_DARK : PROGRESSBAR_TINT_LIGHT);
    }
}

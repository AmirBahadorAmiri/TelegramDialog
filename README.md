<p align="center">
  📄 Read in Persian: <a href="README.fa.md"><b>فارسی</b></a>
</p>

<p align="center">
  <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp" width="400" title="TelegramDialog Logo">
</p>

# TelegramDialog (دیالوگ تلگرام) 💬
### A customizable Android dialog library with a Telegram look

**TelegramDialog** is an Android library with Telegram-style dialogs and an anchored popup action menu. It is written in Java and works from both Java and Kotlin.

---

## 📥 Get the Library

The latest release is published on JitPack. Add JitPack to `settings.gradle.kts`, then add the dependency:

```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```

```kotlin
dependencies {
    implementation("com.github.AmirBahadorAmiri:TelegramDialog:2.3.3")
}
```

---

## 🆕 What's New in v2.3.3 — Scrollable popup menu

This release makes the popup menu usable with long action lists:

*   **Scrollable menu:** when items take more space than is available, the menu stops growing at 60% of the screen height and scrolls instead of cutting items off.
*   **Anchored popup:** `TelegramPopupMenu` opens below any view, with icons, dividers, RTL support and configurable width and elevation.
*   **compileSdk 37:** the library module now builds against API 37.

---

## 🌟 Key Features

### 💬 Dialogs
*   `TelegramAlertDialog` — single-button alert with title, message and justification mode.
*   `TelegramConfirmDialog` — two-button confirm with `OnConfirmListener`.
*   `TelegramInputDialog` and `TelegramInputConfirmDialog` — text input with hints, input types and drawables.
*   `TelegramLoadingDialog`, `TelegramProgressDialog` and `TelegramPercentageProgressDialog` — loading and progress variants with live updates.

### 🎯 Popup Menu
*   `TelegramPopupMenu` — an action menu shown as a popup anchored to a view, not as a dialog.
*   Rows support icons, a divider between groups, and a click listener with the item position and text.
*   **Scrollable by default:** long menus are capped at 60% of the screen and scroll; every open starts at the top.

### 🎨 Customization
*   Card radius, background color and shadow depth (`setElevation()`), plus a fixed menu width (`setWidth()`).
*   Button text, ripple and corner colors, input colors and hints, drawables and shake animations.
*   Menu text color, icon tint and divider color can be set separately.

### 🌍 RTL and Dark Mode
*   `DialogDirection.RTL` / `DialogDirection.LTR` and `setDirection()` flip dialogs and the popup menu.
*   `TelegramColors` reads the system night mode and returns the right background, text and tint colors — no extra resource files needed.

### ⚙️ Listeners
*   `OnAlertListener`, `OnConfirmListener`, `OnInputListener`, `OnInputConfirmListener`, `OnLoadingListener`, `OnProgressListener`, `OnPercentageProgressListener` and `OnMenuListener`.
*   Every listener has an optional `onCanceled()` callback for outside touch or back.

---

## 🛠 Technologies Used

TelegramDialog is built with the current Android toolchain:

*   **Language:** Java for the library, Kotlin for the sample app.
*   **UI:** Android Views, Material Components and ConstraintLayout.
*   **Core:** AndroidX AppCompat, Core-KTX and Activity.
*   **Build:** Gradle Kotlin DSL, AGP 9.3.2 and Java 17 (minSdk 26, targetSdk 37, compileSdk 37).
*   **Publishing:** JitPack and maven-publish.

---

## 🚀 Installation & Run Guide

1. First, clone the project from GitHub:
```bash
git clone https://github.com/AmirBahadorAmiri/TelegramDialog.git
```
2. Open the project in **Android Studio** (Ladybug or newer, JDK 17).
3. Let Gradle sync — JitPack, Google and MavenCentral are needed for the first sync.
4. Run the **app** configuration on an emulator or device to try every dialog and the popup menu.

---

## 📸 Screenshots

The sample app shows the dialog theme and its start animation:

| 💬 Dialog preview | 🎬 Start animation |
|:---:|:---:|
| <img width="184" height="408" alt="Telegram-style alert dialog" src="https://github.com/user-attachments/assets/57c8e94b-24e9-4265-863a-1cafc3d2794f" /> | <img width="184" height="408" alt="Dialog start animation" src="https://github.com/user-attachments/assets/4e1eb892-fc7d-4458-b9bd-0624bf9c2a81" /> |

---

## 👨‍💻 Developer

Developed by **Amir Bahador Amiri**. See [CONTRIBUTORS.md](./CONTRIBUTORS.md).

> [!TIP]
> Call `menu.show()` from a click listener. If you call it in `onCreate()`, the menu waits for the anchor view to attach before opening.

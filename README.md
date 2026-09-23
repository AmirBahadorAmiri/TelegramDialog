# TelegramDialog

> 📖 [نسخه فارسی](./README.fa.md)

A customizable Android dialog library inspired by the Telegram UI — built with Java, with Alert, Confirm, Input and Progress dialogs.

[![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)](https://developer.android.com)
[![Language](https://img.shields.io/badge/Language-Java_%2B_Kotlin-ED8B00?logo=java&logoColor=white)](https://github.com/AmirBahadorAmiri/TelegramDialog)
[![minSdk](https://img.shields.io/badge/minSdk-26-blue)](./TelegramDialog/build.gradle.kts)
[![Version](https://img.shields.io/badge/Version-2.2.0-orange)](./TelegramDialog/build.gradle.kts)
[![JitPack](https://jitpack.io/v/AmirBahadorAmiri/TelegramDialog.svg)](https://jitpack.io/#AmirBahadorAmiri/TelegramDialog)

## 👀 Preview

| `Preview` | `Start Animation` |
|:---------:|:-----------------:|
| <img width="184" height="408" src="https://github.com/user-attachments/assets/57c8e94b-24e9-4265-863a-1cafc3d2794f" /> | <img width="184" height="408" src="https://github.com/user-attachments/assets/4e1eb892-fc7d-4458-b9bd-0624bf9c2a81" /> |

## 📥 Installation

**Get it on JitPack** — [![Get it on JitPack](https://img.shields.io/badge/Get_it_on-JitPack-909090?logo=jitpack&logoColor=white)](https://jitpack.io/#AmirBahadorAmiri/TelegramDialog)

1. Add JitPack to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```

2. Add the dependency:

```kotlin
implementation("com.github.AmirBahadorAmiri:TelegramDialog:2.2.0")
```

## ✨ Features

### 💬 Dialogs
- `TelegramAlertDialog` — single-button alert with title, message, justification mode.
- `TelegramConfirmDialog` — two-button confirm with `OnConfirmListener`.
- `TelegramInputDialog` — text input with `OnInputListener`, hint, input-type and drawable support.
- `TelegramInputConfirmDialog` — input + confirm buttons with `OnInputConfirmListener`.
- `TelegramLoadingDialog` — indeterminate loading spinner.
- `TelegramProgressDialog` — determinate progress bar with `setMax` / `setValue`.
- `TelegramPercentageProgressDialog` — progress with title + status text (e.g. `30%`), live updatable.

### 🌍 RTL & Dark Mode
- Full RTL/LTR support via `DialogDirection.RTL` / `DialogDirection.LTR` and `setDirection()`.
- Native Dark Mode via `TelegramColors` — `getDialogBackground()`, `getTextColor()`, `getMainBlueTint()`, `getMainRedTint()`, no extra resource files needed.

### 🎨 Customization
- Compatible with Java and Kotlin.
- Card radius, background color, button text/ripple/corner-radius, `EditText` colors, hint and drawable (`setEditTextDrawable()`).
- Custom animations — e.g. shake validation via `startEditTextAnimation()`.

### ⚙️ Listeners
- `OnAlertListener`, `OnConfirmListener`, `OnInputListener`, `OnInputConfirmListener`, `OnLoadingListener`, `OnProgressListener`, `OnPercentageProgressListener` with optional `onCanceled()`.

## 📚 Usage

### Alert Dialog

```kotlin
val dialog = TelegramAlertDialog(this)
    .setTitle("Delete message")
    .setMessage("Are you sure you want to delete this\nmessage?")
    .setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD)
    .setCancelable(true)
    .setCardRadius(16)
    .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
    .setPositiveButtonText("Delete")
    .setPositiveButtonTextColor(TelegramColors.getMainBlue())
    .setPositiveButtonRippleColor(TelegramColors.getMainBlueTint(this))

dialog.setOnClickListener(object : OnAlertListener {
    override fun onPositiveButtonClicked() {
        dialog.dismiss()
    }
})

dialog.show()
```

RTL example:

```kotlin
val dialog = TelegramAlertDialog(this)
    .setTitle("حذف پیام")
    .setMessage("آیا از حذف این پیام اطمینان دارید؟")
    .setCancelable(true)
    .setCardRadius(16)
    .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
    .setPositiveButtonText("حذف")
    .setDirection(DialogDirection.RTL)
    .setPositiveButtonTextColor(TelegramColors.getMainBlue())
    .setPositiveButtonRippleColor(TelegramColors.getMainBlueTint(this))

dialog.show()
```

### Confirm Dialog

```kotlin
val dialog = TelegramConfirmDialog(this, DialogDirection.LTR)
    .setTitle("Delete message")
    .setMessage("Are you sure?")
    .setNegativeButtonText("Cancel")
    .setPositiveButtonText("Delete")
    .setPositiveButtonTextColor(TelegramColors.getMainRed())

dialog.setOnClickListener(object : OnConfirmListener {
    override fun onNegativeButtonClicked() { dialog.dismiss() }
    override fun onPositiveButtonClicked() { dialog.dismiss() }
})

dialog.show()
```

### Input Dialog

```kotlin
val dialog = TelegramInputDialog(this)
    .setTitle("Input")
    .setEditTextHint("Type something...")
    .setPositiveButtonText("Submit")
    .setInputType(InputType.TYPE_CLASS_TEXT)
    .setEditTextBackgroundColor(TelegramColors.getMainBlueTint(this))

dialog.setOnClickListener(object : OnInputListener {
    override fun onPositiveButtonClicked(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }
})

dialog.show()
```

### Input Confirm Dialog

```kotlin
val dialog = TelegramInputConfirmDialog(this, DialogDirection.LTR)
    .setTitle("Delete message")
    .setMessage("Are you sure you want to delete this\nmessage?")
    .setNegativeButtonText("Cancel")
    .setPositiveButtonText("Delete")
    .setPositiveButtonTextColor(TelegramColors.getMainRed())
    .setPositiveButtonRippleColor(TelegramColors.getMainRedTint(this))
    .setEditTextHint("Typing...")
    .setEditTextBackgroundColor(TelegramColors.getMainBlueTint(this))
    .setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
    .setEditTextDrawable(R.drawable.ic_person, TelegramColors.getMainBlue())

dialog.setOnClickListener(object : OnInputConfirmListener {
    override fun onNegativeButtonClicked(text: String) { dialog.dismiss() }
    override fun onPositiveButtonClicked(text: String) { dialog.dismiss() }
})

dialog.show()
```

### Progress Dialogs

```kotlin
// Loading
val loading = TelegramLoadingDialog(this)
    .setProgressbarIndeterminateTint(TelegramColors.getMainBlue())
    .show()

// Progress
val progress = TelegramProgressDialog(this)
    .setValue(30)
    .show()

// Percentage Progress
val percentage = TelegramPercentageProgressDialog(this)
    .setTitle("Downloading...")
    .setStatus("30%")
    .setValue(30)
    .show()
```

### Color Management

```kotlin
.setPositiveButtonBackgroundColor(TelegramColors.getMainBlue())
.setCardBackgroundColor(TelegramColors.getDialogBackground(this))
```

Or with your own resources:

```kotlin
.setPositiveButtonBackgroundColor(getColor(R.color.btn_background))
.setCardBackgroundColor(getColor(R.color.background))
```

### RTL Support

```kotlin
.setDirection(DialogDirection.RTL)
```

### Animations

```kotlin
val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
dialog.startEditTextAnimation(shake)
```

## 🛠 Tech Stack

| Layer | Library / Tool |
|-------|----------------|
| Language | Java (library), Kotlin (sample app) |
| UI | Android Views, Material Components |
| Core | AndroidX AppCompat, Core-KTX, Activity, ConstraintLayout |
| Build | Gradle (Kotlin DSL), AGP 9.3.2, Java 17 |
| Publish | JitPack, maven-publish |
| Min / Target | minSdk 26, targetSdk 37, compileSdk 36/37 |

## 📁 Project Structure

```text
TelegramDialog/
├── app/                  # sample app
│   └── src/main/java/.../MainActivity.kt
├── TelegramDialog/       # library module
│   └── src/main/java/.../telegramdialog/
├── gradle/libs.versions.toml
├── settings.gradle.kts
└── README.md / README.fa.md
```

- `TelegramDialog/src/main/java/.../TelegramAlertDialog.java` — single-button alert dialog.
- `TelegramDialog/src/main/java/.../TelegramConfirmDialog.java` — two-button confirm dialog.
- `TelegramDialog/src/main/java/.../TelegramInputDialog.java` — input dialog.
- `TelegramDialog/src/main/java/.../TelegramInputConfirmDialog.java` — input + confirm dialog.
- `TelegramDialog/src/main/java/.../TelegramLoadingDialog.java`, `TelegramProgressDialog.java`, `TelegramPercentageProgressDialog.java` — progress variants.
- `TelegramDialog/src/main/java/.../TelegramColors.java` — dark-mode aware color utility.
- `TelegramDialog/src/main/java/.../direction/DialogDirection.java` — RTL/LTR enum.
- `app/src/main/java/.../MainActivity.kt` — full usage demo of all dialogs.

## 🚀 Build & Run

1. Clone the repo:

```bash
git clone https://github.com/AmirBahadorAmiri/TelegramDialog.git
```

2. Open in Android Studio (Ladybug or newer, JDK 17).
3. Let Gradle sync (JitPack + Google + MavenCentral).
4. Run the `app` configuration on an emulator or device.

> Note: first sync needs Internet for Gradle dependencies; after that the project builds offline unless dependencies change.

## 📋 Requirements

- Android 8.0 (API 26) or higher
- Android Studio with JDK 17
- Internet for first Gradle sync (JitPack, Google, MavenCentral)

## 🤝 Contributing

Contributions are welcome via pull requests. For bug reports or feature suggestions, please open an issue with reproduction steps, device / Android version and screenshots if possible.

---

Made with ❤️ for Telegram-style Android UIs

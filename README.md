## 📌 TelegramDialog

TelegramDialog is a customizable Android dialog library inspired by Telegram style dialogs.
It provides modern, clean, and flexible dialogs with positive/negative buttons, edit text support, and various progress dialogs.

✨ Built with Java & Kotlin support

✨ Fully customizable (Colors, Radius, Ripple)

✨ Native Dark Mode support via `TelegramColors`

✨ RTL & LTR support

✨ Lightweight & easy to use<br>

### 📦 Installation (JitPack)

Add JitPack to your settings.gradle:
```gradle
dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Then add the dependency:
```gradle
implementation("com.github.AmirBahadorAmiri:TelegramDialog:2.1.0")
```
🎯 Features

✅ ***TelegramAlertDialog***

✅ ***TelegramConfirmDialog***

✅ ***TelegramInputDialog***

✅ ***TelegramInputConfirmDialog***

✅ ***TelegramLoadingDialog***

✅ ***TelegramProgressDialog***

✅ ***TelegramPercentageProgressDialog***

✅ ***RTL & LTR Direction Support***
<br>

<h2>🖼 Preview & Usage</h2>

https://github.com/user-attachments/assets/5d76692d-769e-4e0f-bcfe-98a4d424968c

<br><br><br><br>

### 🔹 Alert Dialog
```kotlin
val dialog = TelegramAlertDialog(this)
    .setTitle("Delete message")
    .setMessage("Are you sure you want to delete this\n" + "message?")
    .setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD)
    .setCancelable(true)
    .setCardRadius(16)
    .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
    .setPositiveButtonText("Delete")
    .setPositiveButtonTextColor(TelegramColors.getMainBlue())
    .setPositiveButtonRippleColor(TelegramColors.getMainBlueTint(this))

dialog.setOnClickListener(object : OnAlertListener {
    override fun onPositiveButtonClicked() {
        /* Do something */
        dialog.dismiss()
    }
})

dialog.show()
```

or

```kotlin
val dialog = TelegramAlertDialog(this)
            .setTitle("حذف پیام")
            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
            .setCancelable(true)
            .setCardRadius(16)
            .setPositiveButtonCornerRadius(32)
            .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
            .setPositiveButtonText("حذف")
            .setDirection(DialogDirection.RTL)
            .setPositiveButtonTextColor(TelegramColors.getMainBlue())
            .setPositiveButtonRippleColor(TelegramColors.getMainBlueTint(this))

dialog.setOnClickListener(object : OnAlertListener {
            override fun onPositiveButtonClicked() {
                /* Do something */
                dialog.dismiss()
            }
            /* Optional Function */
            override fun onCanceled() {
                /* Do something */
            }
        })

dialog.show()
```


<br>

### 🔹 Confirm Dialog
```kotlin
val dialog = TelegramConfirmDialog(this,DialogDirection.LTR)
    .setTitle("Delete message")
    .setMessage("Are you sure?")
    .setNegativeButtonText("Cancel")
    .setPositiveButtonText("Delete")
    .setPositiveButtonTextColor(TelegramColors.getMainRed())

dialog.setOnClickListener(object : OnConfirmListener {
    override fun onNegativeButtonClicked() { dialog.dismiss() }
    override fun onPositiveButtonClicked() { 
        // Do something
        dialog.dismiss() 
    }
})

dialog.show()
```

<br>

### 🔹 Input Dialog
```kotlin
val dialog = TelegramInputDialog(this)
    .setTitle("Input")
    .setEditTextHint("Type something...")
    .setPositiveButtonText("Submit")
    .setEditTextBackgroundColor(TelegramColors.getMainBlueTint(this))

dialog.setOnClickListener(object : OnInputListener {
    override fun onPositiveButtonClicked(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }
})

dialog.show()
```

<br>

### 🔹 Input Confirm Dialog
```kotlin
val dialog = TelegramInputConfirmDialog(this, DialogDirection.LTR)
    .setTitle("Delete message")
    .setMessage("Are you sure you want to delete this\n" + "message?")
    .setCancelable(true)
    .setCardRadius(16)
    .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
    .setNegativeButtonText("Cancel")
    .setNegativeButtonTextColor(TelegramColors.getMainBlue())
    .setNegativeButtonRippleColor(TelegramColors.getMainBlueTint(this))
    .setNegativeButtonCornerRadius(16)
    .setPositiveButtonText("Delete")
    .setPositiveButtonTextColor(TelegramColors.getMainRed())
    .setPositiveButtonRippleColor(TelegramColors.getMainRedTint(this))
    .setPositiveButtonCornerRadius(32)
    .setEditTextHint("Typing...")
    .setEditTextHintColor(TelegramColors.getColor(TelegramColors.MAIN_BLUE_LIGHT))
    .setEditTextColor(TelegramColors.getTextColor(this))
    .setEditTextBackgroundColor(TelegramColors.getMainBlueTint(this))
//            ic_person size   **  JUST 20dpx20dp  **
    .setEditTextDrawable(R.drawable.ic_person,TelegramColors.getMainBlue())

dialog.setOnClickListener(object : OnInputConfirmListener {
    override fun onNegativeButtonClicked(text: String) {
        Toast.makeText(this@MainActivity, "onNegativeButtonClicked: ${text}", Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }
    override fun onPositiveButtonClicked(text: String) {
        Toast.makeText(this@MainActivity, "onPositiveButtonClicked: ${text}", Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }
    /* Optional Function */
    override fun onCanceled() {
        Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show();
    }
})
dialog.show()
```

<br>

### 🔹 Progress Dialogs
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
val progress = TelegramPercentageProgressDialog(this)
    .setTitle("Downloading...")
    .setStatus("30%")
    .setValue(30)
    .show()
```

<br><br>
🎨 Color Management

The library now uses `TelegramColors` for smart color management and Dark Mode support without needing a `colors.xml` file in your project.

```kotlin
.setPositiveButtonBackgroundColor(TelegramColors.getMainBlue())
.setCardBackgroundColor(TelegramColors.getDialogBackground(this))
```

or

```kotlin
.setPositiveButtonBackgroundColor(getColor(R.color.btn_background))
.setCardBackgroundColor(getColor(R.color.background))
```

<br><br>
🌍 RTL Support

Supports both LTR and RTL (Persian, Arabic) layout directions.
```kotlin
.setDirection(DialogDirection.RTL)
```

<br><br>
🤝 Contributing

Pull requests are welcome. If you find a bug or have suggestions, feel free to open an issue.

⭐ Support

If you like this project, please consider giving it a star on GitHub ⭐

## TelegramDialog

TelegramDialog is a customizable Android dialog library inspired by the Telegram user interface. It provides modern and flexible dialog components, including support for positive/negative buttons, input fields, and various progress indicators.

**Features**
- Compatible with Java and Kotlin.
- Fully customizable properties including colors, corner radius, and ripple effects.
- Native Dark Mode support via the TelegramColors utility.
- Comprehensive support for RTL and LTR layouts.
- Lightweight implementation with an intuitive API.

### Installation (JitPack)

Add JitPack to your settings.gradle:
```gradle
dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency to your project:
```gradle
implementation("com.github.AmirBahadorAmiri:TelegramDialog:2.2.0")
```
<br>

### Preview and Usage

|                        `Preview`                         |                        `Start Animation`                         |
|:---------------------------------------------------------:|:-----------------------------------------------------------:|
| <img width="184" height="408" src="https://github.com/user-attachments/assets/57c8e94b-24e9-4265-863a-1cafc3d2794f" /> | <img width="184" height="408" src="https://github.com/user-attachments/assets/4e1eb892-fc7d-4458-b9bd-0624bf9c2a81" /> |

<br><br>

### Alert Dialog
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

### Confirm Dialog
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

### Input Dialog
```kotlin
val dialog = TelegramInputDialog(this)
    .setTitle("Input")
    .setEditTextHint("Type something...")
    .setPositiveButtonText("Submit")
    .setInputType(InputType.TYPE_CLASS_TEXT) // Set input type (Numeric, Password, etc.)
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

### Input Confirm Dialog
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
    .setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD) // Password support
    .setEditTextDrawable(R.drawable.ic_person, TelegramColors.getMainBlue()) // Support for drawables

dialog.setOnClickListener(object : OnInputConfirmListener {
    override fun onNegativeButtonClicked(text: String) {
        Toast.makeText(this@MainActivity, "onNegativeButtonClicked: $text", Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }
    override fun onPositiveButtonClicked(text: String) {
        Toast.makeText(this@MainActivity, "onPositiveButtonClicked: $text", Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }
    /* Optional Function */
    override fun onCanceled() {
        Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show()
    }
})
dialog.show()
```

<br>

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
val progress = TelegramPercentageProgressDialog(this)
    .setTitle("Downloading...")
    .setStatus("30%")
    .setValue(30)
    .show()
```

<br><br>
### Color Management

The library utilizes the TelegramColors class for intelligent color management and Dark Mode integration, eliminating the need for external resource files.

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
### RTL Support

The library supports both LTR and RTL directions, ensuring compatibility with languages such as Persian and Arabic.
```kotlin
.setDirection(DialogDirection.RTL)
```

<br><br>
### Animations

Developers can apply custom animations to dialog components, such as shake effects for input validation.
```kotlin
val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
dialog.startEditTextAnimation(shake)
```

<br><br>
### Contributing

Contributions are welcome through pull requests. For bug reports or feature suggestions, please open an issue.

### Support

You may support the project by starring the repository on GitHub.

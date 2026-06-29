<h2>📌 TelegramDialog</h2>

TelegramDialog is a customizable Android dialog library inspired by Telegram style dialogs.
It provides modern, clean, and flexible dialogs with one button, two buttons, edit text support, and a custom progress dialog.

✨ Built with Kotlin<br>
✨ Fully customizable<br>
✨ RTL & LTR support<br>
✨ Lightweight & easy to use<br><br>

📦 Installation (JitPack)

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
implementation("com.github.AmirBahadorAmiri:TelegramDialog:1.3.2")
```
🎯 Features

✅ One Button Dialog

✅ Two Button Dialog

✅ Dialog with EditText

✅ RTL & LTR Direction Support

✅ Customizable Colors & Radius

✅ Medium Progress Dialog

✅ Ripple & Tint Support
<br><br><br>
<h2>🖼 Preview</h2>
🔹 One Button Dialog
<br><br>
<img width="120" src="https://github.com/user-attachments/assets/af807cf0-6fb7-41cb-ab72-b6b8a0e7dd90" />
<img width="120" src="https://github.com/user-attachments/assets/e0dac78b-6f32-40a5-80d9-ba68cd7999ec" />
<br><br>

```kotlin
val dialog = TeleDialogSingle(this)
    .setTitle("Delete message")
    .setMessage("Are you sure you want to delete this message?")
    .setButtonText("Delete")
    .setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD)
    .setCancelable(true)

dialog.setOnClickListener(object : OneButtonListener {
    override fun onButtonClicked() {
        dialog.dismiss()
    }
})

dialog.show()

```
<br><br><br>
🔹 Two Button Dialog<br><br>
<img width="120" src="https://github.com/user-attachments/assets/a2c99a8f-a2be-411b-9888-092ce42089b4" />
<img width="120" src="https://github.com/user-attachments/assets/a9753b0e-b38a-4190-b37e-06bd448ae9c8" />
<br><br>
```kotlin

val dialog = TeleDialogDouble(this)
    .setTitle("Delete message")
    .setMessage("Are you sure?")
    .setButtonOneText("Cancel")
    .setButtonTwoText("Delete")

dialog.setOnClickListener(object : TwoButtonListener {
    override fun onFirstButtonClicked() { dialog.dismiss() }
    override fun onSecondButtonClicked() { dialog.dismiss() }
})

dialog.show()

```
<br><br><br>
🔹 Dialog With EditText<br><br>
<img width="120" src="https://github.com/user-attachments/assets/310e7bb2-24f1-41f2-bc52-c7ba125ba15c" />
<img width="120" src="https://github.com/user-attachments/assets/6782e750-781f-40fe-8bba-8a70804c7921" />
<br><br>
```kotlin

val dialog = TeleDialogSingleWithEditText(this)
    .setTitle("Input")
    .setEditTextHint("Type something...")
    .setButtonText("Submit")

dialog.setOnClickListener(object : OneButtonWithEditTextListener {
    override fun onButtonClicked(text: String) {
        dialog.dismiss()
    }
})

dialog.show()

```
<br><br><br>
🔹 Progress Dialog<br><br>
<img width="120" src="https://github.com/user-attachments/assets/231c5428-f134-4eff-afa8-0fd0db0a50e8" />
<img width="120" src="https://github.com/user-attachments/assets/4b647f3b-5f04-48ff-9bbc-64f124683aa1" />
<img width="120" src="https://github.com/user-attachments/assets/1549520b-c62b-42a4-b8bc-778ccb1478ba" />

<br><br><br>
```kotlin

val dialog = TeleProgressBar(this)
    .setCancelable(true)
    .setProgressbarIndeterminateTint(R.color.main_blue)

dialog.show()

```
<br><br><br>

**All Classes Can Use**
* TeleDialogSingle
* TeleDialogDouble
* TeleDialogSingleWithEditText
* TeleDialogDoubleWithEditText
* TeleProgressBar
* TeleHorizontalProgressBar
* TeleHorizontalProgressBarWithPercent

<br><br><br>
🌍 RTL Support

Supports both LTR (English) and RTL (Persian, Arabic) layout directions.
```kotlin
.setDirection(DialogDirection.LEFT)
```
<br><br>
* Text Justification
```kotlin
.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD)
```
<br><br>

🤝 Contributing

Pull requests are welcome.
If you find a bug or have suggestions, feel free to open an issue.
<br><br>
⭐ Support

If you like this project, please consider giving it a star on GitHub ⭐

<h2>Add Dependencies</h2>

```gradle
implementation("com.github.AmirBahadorAmiri:TelegramDialog:1.0.4")

maven {
  url = uri("https://jitpack.io")
}
```

<br><br><br>

<h2> Dialog One Button</h2>
<img width="90" height="200" alt="single fa" src="https://github.com/user-attachments/assets/af807cf0-6fb7-41cb-ab72-b6b8a0e7dd90" />
<img width="90" height="200" alt="single en" src="https://github.com/user-attachments/assets/e0dac78b-6f32-40a5-80d9-ba68cd7999ec" />
<br><br><br>

```kotlin

        val dialog = DialogOneButton(this)
            .setTitle("Delete message")
            .setMessage(
                "Are you sure you want to delete this\n" +
                        "message?"
            )
            .setCancelable(false)
            .setButtonText("Delete")
            .setButtonTextColor(R.color.main_red)
            .setButtonRippleColor(R.color.main_red_tint)


        val dialog = DialogOneButton(this)
            .setTitle("حذف پیام")
            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
            .setCancelable(false)
            .setButtonText("حذف")
            .setDirection(DialogDirection.LEFT)
            .setButtonTextColor(R.color.main_red)
            .setButtonRippleColor(R.color.main_red_tint)


        dialog.setOnClickListener { dialog.dismiss() }
```
<br><br><br>

<h2> Dialog Two Button</h2>
<img width="90" height="200" alt="double fa" src="https://github.com/user-attachments/assets/a2c99a8f-a2be-411b-9888-092ce42089b4" />
<img width="90" height="200" alt="double en" src="https://github.com/user-attachments/assets/a9753b0e-b38a-4190-b37e-06bd448ae9c8" />
<br><br><br>

```kotlin

          val dialog = DialogTwoButton(this)
            .setTitle("Delete message")
            .setMessage(
                "Are you sure you want to delete this\n" +
                        "message?"
            )
            .setCancelable(false)
            .setButtonOneText("Cancel")
            .setButtonOneTextColor(R.color.main_blue)
            .setButtonOneRippleColor(R.color.main_blue_tint)
            .setButtonTwoText("Delete")
            .setButtonTwoTextColor(R.color.main_red)
            .setButtonTwoRippleColor(R.color.main_red_tint)


        val dialog = DialogTwoButton(this)
            .setTitle("حذف پیام")
            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
            .setCancelable(false)
            .setButtonOneText("حذف")
            .setButtonTwoText("لغو")
            .setDirection(DialogDirection.LEFT)


        dialog.setOnClickListener(object : OnClickListeners.TwoButtonListener {
            override fun onFirstButtonClicked() {
                dialog.dismiss();
            }

            override fun onSecondButtonClicked() {
                dialog.dismiss()
            }
        })

```

<br><br><br>

<h2> Dialog With EditText</h2>
<img width="90" height="200" alt="single edit" src="https://github.com/user-attachments/assets/310e7bb2-24f1-41f2-bc52-c7ba125ba15c" />
<img width="90" height="200" alt="double edit" src="https://github.com/user-attachments/assets/6782e750-781f-40fe-8bba-8a70804c7921" />
<br><br><br>

```kotlin

        val dialog = DialogOneButtonWithEditText(this)
            .setTitle("Delete message")
            .setMessage(
                "Are you sure you want to delete this\n" +
                        "message?"
            )
            .setCancelable(false)
            .setButtonText("Delete")
            .setButtonTextColor(R.color.main_red)
            .setButtonRippleColor(R.color.main_red_tint)
            .setEditTextHint("Typing...")
            .setEditTextHintColor(R.color.main_red_light)
            .setEditTextColor(R.color.main_red)
            .setEditTextBackgroundColor(R.color.main_red_tint)
//        --------------> ic_person size 20dpx20dp <--------------
            .setEditTextDrawable(R.drawable.ic_person)
            .setEditTextDrawableColor(R.color.main_red)

        dialog.setOnClickListener { text ->
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }




        val dialog = DialogTwoButtonWithEditText(this)
            .setTitle("Delete message")
            .setMessage(
                "Are you sure you want to delete this\n" +
                        "message?"
            )
            .setCancelable(false)
            .setButtonOneText("Cancel")
            .setButtonOneTextColor(R.color.main_blue)
            .setButtonOneRippleColor(R.color.main_blue_tint)
            .setButtonTwoText("Delete")
            .setButtonTwoTextColor(R.color.main_red)
            .setButtonTwoRippleColor(R.color.main_red_tint)
            .setEditTextHint("Typing...")
            .setEditTextHintColor(R.color.main_blue_light)
            .setEditTextColor(R.color.main_blue)
            .setEditTextBackgroundColor(R.color.main_blue_tint)
//        --------------> ic_person size 20dpx20dp <--------------
            .setEditTextDrawable(R.drawable.ic_person)
            .setEditTextDrawableColor(R.color.main_blue)

        dialog.setOnClickListener(object : OnClickListeners.TwoButtonWithEditTextListener {
            override fun onFirstButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            override fun onSecondButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        })

```
<br><br><br>

<h2>Show Dialog Function</h2>
```kotlin
dialog.show()
```

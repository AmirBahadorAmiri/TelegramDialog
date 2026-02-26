# Add Dependencies

```gradle
implementation("com.github.AmirBahadorAmiri:TelegramDialog:1.2.1")

maven {
  url = uri("https://jitpack.io")
}
```

# Documents
<h3>Dialog One Button</h3>
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
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(R.color.dialog_page_background)
            .setButtonText("Delete")
            .setButtonTextColor(R.color.main_blue)
            .setButtonRippleColor(R.color.main_blue_tint)


        val dialog = DialogOneButton(this)
            .setTitle("حذف پیام")
            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(R.color.dialog_page_background)
            .setButtonText("حذف")
            .setDirection(DialogDirection.LEFT)
            .setButtonTextColor(R.color.main_blue)
            .setButtonRippleColor(R.color.main_blue_tint)

        dialog.setOnClickListener(object : OneButtonListener {
            override fun onButtonClicked() {
                Toast.makeText(this@MainActivity, "onButtonClicked", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            // Optional Function
            override fun onCanceled() {
                super.onCanceled()
                Toast.makeText(this@MainActivity, "canceled", Toast.LENGTH_SHORT).show()
            }

        })

```
<br><br>

<h3>Dialog Two Button</h3>
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
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(R.color.dialog_page_background)
            .setButtonOneText("Cancel")
            .setButtonOneTextColor(R.color.main_blue)
            .setButtonOneRippleColor(R.color.main_blue_tint)
            .setButtonTwoText("Delete")
            .setButtonTwoTextColor(R.color.main_red)
            .setButtonTwoRippleColor(R.color.main_red_tint)


        val dialog = DialogTwoButton(this)
            .setTitle("حذف پیام")
            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(R.color.dialog_page_background)
            .setButtonOneText("حذف")
            .setButtonTwoText("لغو")
            .setDirection(DialogDirection.LEFT)


        dialog.setOnClickListener(object : TwoButtonListener {
            override fun onFirstButtonClicked() {
                Toast.makeText(this@MainActivity, "onFirstButtonClicked", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            override fun onSecondButtonClicked() {
                Toast.makeText(this@MainActivity, "onSecondButtonClicked", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            // Optional Function
            override fun onCanceled() {
                super.onCanceled()
                Toast.makeText(this@MainActivity, "canceled", Toast.LENGTH_SHORT).show()
            }

        })

```

<br><br>

<h3>Dialog With EditText</h3>
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
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(R.color.dialog_page_background)
            .setButtonText("Delete")
            .setButtonTextColor(R.color.main_blue)
            .setButtonRippleColor(R.color.main_blue_tint)
            .setEditTextHint("Typing...")
            .setEditTextHintColor(R.color.main_blue_light)
            .setEditTextColor(R.color.textcolor)
            .setEditTextBackgroundColor(R.color.main_blue_tint)
//            ic_person size 20dpx20dp
            .setEditTextDrawable(R.drawable.ic_person)
            .setEditTextDrawableColor(R.color.main_blue)

        dialog.setOnClickListener(object : OneButtonWithEditTextListener {
            override fun onButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            // Optional Function
            override fun onCanceled() {
                super.onCanceled()
                Toast.makeText(this@MainActivity, "canceled", Toast.LENGTH_SHORT).show();
            }

        })


        val dialog = DialogTwoButtonWithEditText(this)
            .setTitle("Delete message")
            .setMessage(
                "Are you sure you want to delete this\n" +
                        "message?"
            )
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(R.color.dialog_page_background)
            .setButtonOneText("Cancel")
            .setButtonOneTextColor(R.color.main_blue)
            .setButtonOneRippleColor(R.color.main_blue_tint)
            .setButtonTwoText("Delete")
            .setButtonTwoTextColor(R.color.main_red)
            .setButtonTwoRippleColor(R.color.main_red_tint)
            .setEditTextHint("Typing...")
            .setEditTextHintColor(R.color.main_blue_light)
            .setEditTextColor(R.color.textcolor)
            .setEditTextBackgroundColor(R.color.main_blue_tint)
//            ic_person size   **  JUST 20dpx20dp  **
            .setEditTextDrawable(R.drawable.ic_person)
            .setEditTextDrawableColor(R.color.main_blue)

        dialog.setOnClickListener(object : TwoButtonWithEditTextListener {
            override fun onFirstButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            override fun onSecondButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            // Optional Function
            override fun onCanceled() {
                super.onCanceled()
                Toast.makeText(this@MainActivity, "canceled", Toast.LENGTH_SHORT).show();
            }

        })

```

<br><br>

<h3>ProgressBar</h3>
<img width="90" height="200" alt="light" src="https://github.com/user-attachments/assets/231c5428-f134-4eff-afa8-0fd0db0a50e8" />
<img width="90" height="200" alt="dark" src="https://github.com/user-attachments/assets/4b647f3b-5f04-48ff-9bbc-64f124683aa1" />


```kotlin

        val dialog = MediumProgressBar(this)
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(R.color.dialog_page_background)
            .setProgressbarIndeterminateTint(R.color.main_blue)
            .setOnClickListener { Toast.makeText(this, "canceled", Toast.LENGTH_SHORT).show() }

```

<br><br>

<h3>Show Dialog Function</h3>

```kotlin

dialog.show()

```

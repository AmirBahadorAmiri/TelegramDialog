package com.amirbahadoramiri.telegramdialog

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        --------------> Single Button LTR <--------------
//        val dialog = DialogOneButton(this)
//            .setTitle("Delete message")
//            .setMessage(
//                "Are you sure you want to delete this\n" +
//                        "message?"
//            )
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setButtonText("Delete")
//            .setButtonTextColor(R.color.main_blue)
//            .setButtonRippleColor(R.color.main_blue_tint)


//        --------------> Single Button RTL <--------------
//        val dialog = DialogOneButton(this)
//            .setTitle("حذف پیام")
//            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setButtonText("حذف")
//            .setDirection(DialogDirection.LEFT)
//            .setButtonTextColor(R.color.main_blue)
//            .setButtonRippleColor(R.color.main_blue_tint)
//
//        dialog.setOnClickListener(object : OneButtonListener {
//            override fun onButtonClicked() {
//                Toast.makeText(this@MainActivity, "onButtonClicked", Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//            }
//
//            // Optional Function
//            override fun onCanceled() {
//                super.onCanceled()
//                Toast.makeText(this@MainActivity, "canceled", Toast.LENGTH_SHORT).show()
//            }
//
//        })


//        --------------> Double Button LTR <--------------
//        val dialog = DialogTwoButton(this)
//            .setTitle("Delete message")
//            .setMessage(
//                "Are you sure you want to delete this\n" +
//                        "message?"
//            )
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setButtonOneText("Cancel")
//            .setButtonOneTextColor(R.color.main_blue)
//            .setButtonOneRippleColor(R.color.main_blue_tint)
//            .setButtonTwoText("Delete")
//            .setButtonTwoTextColor(R.color.main_red)
//            .setButtonTwoRippleColor(R.color.main_red_tint)


//        --------------> Double Button RTL <--------------
//        val dialog = DialogTwoButton(this)
//            .setTitle("حذف پیام")
//            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setButtonOneText("حذف")
//            .setButtonTwoText("لغو")
//            .setDirection(DialogDirection.LEFT)
//
//
//        dialog.setOnClickListener(object : TwoButtonListener {
//            override fun onFirstButtonClicked() {
//                Toast.makeText(this@MainActivity, "onFirstButtonClicked", Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//            }
//
//            override fun onSecondButtonClicked() {
//                Toast.makeText(this@MainActivity, "onSecondButtonClicked", Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//            }
//
//            // Optional Function
//            override fun onCanceled() {
//                super.onCanceled()
//                Toast.makeText(this@MainActivity, "canceled", Toast.LENGTH_SHORT).show()
//            }
//
//        })


//        --------------> Single Button LTR With EditText <--------------
//        val dialog = DialogOneButtonWithEditText(this)
//            .setTitle("Delete message")
//            .setMessage(
//                "Are you sure you want to delete this\n" +
//                        "message?"
//            )
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setButtonText("Delete")
//            .setButtonTextColor(R.color.main_blue)
//            .setButtonRippleColor(R.color.main_blue_tint)
//            .setEditTextHint("Typing...")
//            .setEditTextHintColor(R.color.main_blue_light)
//            .setEditTextColor(R.color.textcolor)
//            .setEditTextBackgroundColor(R.color.main_blue_tint)
////            ic_person size 20dpx20dp
//            .setEditTextDrawable(R.drawable.ic_person)
//            .setEditTextDrawableColor(R.color.main_blue)
//
//        dialog.setOnClickListener(object : OneButtonWithEditTextListener {
//            override fun onButtonClicked(text: String) {
//                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//            }
//
//            // Optional Function
//            override fun onCanceled() {
//                super.onCanceled()
//                Toast.makeText(this@MainActivity, "canceled", Toast.LENGTH_SHORT).show();
//            }
//
//        })


//        --------------> Double Button LTR With EditText <--------------
//        val dialog = DialogTwoButtonWithEditText(this)
//            .setTitle("Delete message")
//            .setMessage(
//                "Are you sure you want to delete this\n" +
//                        "message?"
//            )
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setButtonOneText("Cancel")
//            .setButtonOneTextColor(R.color.main_blue)
//            .setButtonOneRippleColor(R.color.main_blue_tint)
//            .setButtonTwoText("Delete")
//            .setButtonTwoTextColor(R.color.main_red)
//            .setButtonTwoRippleColor(R.color.main_red_tint)
//            .setEditTextHint("Typing...")
//            .setEditTextHintColor(R.color.main_blue_light)
//            .setEditTextColor(R.color.textcolor)
//            .setEditTextBackgroundColor(R.color.main_blue_tint)
////            ic_person size   **  JUST 20dpx20dp  **
//            .setEditTextDrawable(R.drawable.ic_person)
//            .setEditTextDrawableColor(R.color.main_blue)
//
//        dialog.setOnClickListener(object : TwoButtonWithEditTextListener {
//            override fun onFirstButtonClicked(text: String) {
//                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//            }
//
//            override fun onSecondButtonClicked(text: String) {
//                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//            }
//
//            // Optional Function
//            override fun onCanceled() {
//                super.onCanceled()
//                Toast.makeText(this@MainActivity, "canceled", Toast.LENGTH_SHORT).show();
//            }
//
//        })


//        --------------> ProgressBar <--------------
//        val dialog = MediumProgressBar(this)
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setProgressbarIndeterminateTint(R.color.main_blue)
//            .setOnClickListener { Toast.makeText(this, "canceled", Toast.LENGTH_SHORT).show() }
//
//        dialog.show()

    }
}
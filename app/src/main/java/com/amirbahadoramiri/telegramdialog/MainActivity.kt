package com.amirbahadoramiri.telegramdialog

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.amirbahadoramiri.telegramdialog.DialogTwoButtonWithEditText
import io.github.amirbahadoramiri.telegramdialog.OnClickListeners

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
//            .setCancelable(false)
//            .setButtonText("Delete")
//            .setButtonTextColor(R.color.main_red)
//            .setButtonRippleColor(R.color.main_red_tint)


//        --------------> Single Button RTL <--------------
//        val dialog = DialogOneButton(this)
//            .setTitle("حذف پیام")
//            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
//            .setCancelable(false)
//            .setButtonText("حذف")
//            .setDirection(DialogDirection.LEFT)
//            .setButtonTextColor(R.color.main_red)
//            .setButtonRippleColor(R.color.main_red_tint)

//        dialog.setOnClickListener(object : OnClickListeners.OneButtonListener {
//            override fun onButtonClicked() {
//                dialog.dismiss()
//            }
//        })


//        --------------> Double Button LTR <--------------
//        val dialog = DialogTwoButton(this)
//            .setTitle("Delete message")
//            .setMessage(
//                "Are you sure you want to delete this\n" +
//                        "message?"
//            )
//            .setCancelable(false)
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
//            .setCancelable(false)
//            .setButtonOneText("حذف")
//            .setButtonTwoText("لغو")
//            .setDirection(DialogDirection.LEFT)


//        dialog.setOnClickListener(object : OnClickListeners.TwoButtonListener {
//            override fun onFirstButtonClicked() {
//                dialog.dismiss();
//            }
//
//            override fun onSecondButtonClicked() {
//                dialog.dismiss()
//            }
//        })


//        --------------> Single Button LTR With EditText <--------------
//        val dialog = DialogOneButtonWithEditText(this)
//            .setTitle("Delete message")
//            .setMessage(
//                "Are you sure you want to delete this\n" +
//                        "message?"
//            )
//            .setCancelable(false)
//            .setButtonText("Delete")
//            .setButtonTextColor(R.color.main_red)
//            .setButtonRippleColor(R.color.main_red_tint)
//            .setEditTextHint("Typing...")
//            .setEditTextHintColor(R.color.main_red_light)
//            .setEditTextColor(R.color.main_red)
//            .setEditTextBackgroundColor(R.color.main_red_tint)
////            ic_person size 20dpx20dp
//            .setEditTextDrawable(R.drawable.ic_person)
//            .setEditTextDrawableColor(R.color.main_red)
//
//        dialog.setOnClickListener { text ->
//            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
//            dialog.dismiss()
//        }


//        --------------> Double Button LTR With EditText <--------------
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
//            ic_person size   **  JUST 20dpx20dp  **
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

        dialog.show()

    }
}
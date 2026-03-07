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
//        val dialog = TeleDialogSingle(this)
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
//        val dialog = TeleDialogSingle(this)
//            .setTitle("حذف پیام")
//            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setButtonCornerRadius(32)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setButtonText("حذف")
//            .setDirection(TeleDirection.RTL)
//            .setButtonTextColor(R.color.main_blue)
//            .setButtonRippleColor(R.color.main_blue_tint)
//
//        dialog.setOnClickListener(object : TeleDialogSingleListener {
//            override fun onButtonClicked() {
//                Toast.makeText(this@MainActivity, "onButtonClicked", Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//            }
//
//            // Optional Function
//            override fun onCanceled() {
//                super.onCanceled()
//                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show()
//            }
//
//        })


//        --------------> Double Button LTR <--------------
//        val dialog = TeleDialogDouble(this)
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
//            .setButtonOneCornerRadius(16)
//            .setButtonTwoText("Delete")
//            .setButtonTwoTextColor(R.color.main_red)
//            .setButtonTwoRippleColor(R.color.main_red_tint)
//            .setButtonTwoCornerRadius(32)

//        --------------> Double Button RTL <--------------
//        val dialog = TeleDialogDouble(this)
//            .setTitle("حذف پیام")
//            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setButtonOneText("حذف")
//            .setButtonOneCornerRadius(32)
//            .setButtonTwoText("لغو")
//            .setButtonTwoCornerRadius(32)
//            .setDirection(TeleDirection.RTL)


//        dialog.setOnClickListener(object : TeleDialogDoubleListener {
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
//                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show()
//            }
//
//        })


//        --------------> Single Button LTR With EditText <--------------
//        val dialog = TeleDialogSingleWithEditText(this)
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
//            .setButtonCornerRadius(32)
//            .setEditTextHint("Typing...")
//            .setEditTextHintColor(R.color.main_blue_light)
//            .setEditTextColor(R.color.textcolor)
//            .setEditTextBackgroundColor(R.color.main_blue_tint)
////            ic_person size 20dpx20dp
//            .setEditTextDrawable(R.drawable.ic_person,R.color.main_blue)
//
//        dialog.setOnClickListener(object : TeleDialogSingleWithEditTextListener {
//            override fun onButtonClicked(text: String) {
//                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//            }
//
//            // Optional Function
//            override fun onCanceled() {
//                super.onCanceled()
//                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show();
//            }
//
//        })


//        --------------> Double Button LTR With EditText <--------------
//        val dialog = TeleDialogDoubleWithEditText(this)
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
//            .setButtonOneCornerRadius(16)
//            .setButtonTwoText("Delete")
//            .setButtonTwoTextColor(R.color.main_red)
//            .setButtonTwoRippleColor(R.color.main_red_tint)
//            .setButtonTwoCornerRadius(32)
//            .setEditTextHint("Typing...")
//            .setEditTextHintColor(R.color.main_blue_light)
//            .setEditTextColor(R.color.textcolor)
//            .setEditTextBackgroundColor(R.color.main_blue_tint)
////            ic_person size   **  JUST 20dpx20dp  **
//            .setEditTextDrawable(R.drawable.ic_person,R.color.main_blue)
//
//        dialog.setOnClickListener(object : TeleDialogDoubleWithEditTextListener {
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
//                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show();
//            }
//
//        })


//        --------------> TeleProgressBar <--------------
//        val dialog = TeleProgressBar(this)
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setProgressbarIndeterminateTint(R.color.main_blue)
//            .setOnClickListener { Toast.makeText(this, "onCanceled", Toast.LENGTH_SHORT).show() }


        //        --------------> TeleHorizontalProgressBar <--------------
//        val dialog = TeleHorizontalProgressBar(this)
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setProgressbarTint(R.color.main_blue)
//            .setProgressbarBackgroundTint(R.color.main_blue_light)
//            .setMax(100)
//            .setValue(30)
//            .setOnClickListener { Toast.makeText(this, "onCanceled", Toast.LENGTH_SHORT).show() }


        //        --------------> TeleHorizontalProgressBarWithPercent <--------------
//        val dialog = TeleHorizontalProgressBarWithPercent(this)
//            .setTitle("Loading...")
//            .setStatus("30%")
//            .setCancelable(true)
//            .setCardRadius(16)
//            .setCardBackgroundColor(R.color.dialog_page_background)
//            .setProgressbarTint(R.color.main_red)
//            .setProgressbarBackgroundTint(R.color.main_red_light)
//            .setMax(100)
//            .setValue(30)
//            .setOnClickListener { Toast.makeText(this, "onCanceled", Toast.LENGTH_SHORT).show() }
////
//        val timer = Timer()
//        timer.schedule(object : TimerTask() {
//            override fun run() {
//                dialog.setValue(50)
//                    .setStatus("50%")
//                    .setProgressbarTint(R.color.progressbar_indeterminate_tint)
//                    .setProgressbarBackgroundTint(R.color.main_blue_light)
//            }
//        }, 2000L)
//        timer.schedule(object : TimerTask() {
//            override fun run() {
//                dialog.setValue(70)
//                    .setStatus("70%")
//                    .setProgressbarTint(R.color.main_blue)
//                    .setProgressbarBackgroundTint(R.color.main_blue_light)
//            }
//        }, 4000L)
//        timer.schedule(object : TimerTask() {
//            override fun run() {
//                dialog.setValue(100)
//                    .setStatus("100%")
//                    .setProgressbarTint(R.color.main_green)
//                    .setProgressbarBackgroundTint(R.color.main_green_light)
//            }
//        }, 6000L)

//        dialog.show()

    }
}
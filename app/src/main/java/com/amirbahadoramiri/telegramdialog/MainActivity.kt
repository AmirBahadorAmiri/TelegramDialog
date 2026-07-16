package com.amirbahadoramiri.telegramdialog

import android.os.Bundle
import android.text.InputType
import android.text.Layout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.github.amirbahadoramiri.telegramdialog.TelegramAlertDialog
import com.github.amirbahadoramiri.telegramdialog.TelegramColors
import com.github.amirbahadoramiri.telegramdialog.TelegramConfirmDialog
import com.github.amirbahadoramiri.telegramdialog.TelegramInputConfirmDialog
import com.github.amirbahadoramiri.telegramdialog.TelegramInputDialog
import com.github.amirbahadoramiri.telegramdialog.TelegramLoadingDialog
import com.github.amirbahadoramiri.telegramdialog.TelegramPercentageProgressDialog
import com.github.amirbahadoramiri.telegramdialog.TelegramProgressDialog
import com.github.amirbahadoramiri.telegramdialog.direction.DialogDirection
import com.github.amirbahadoramiri.telegramdialog.listeners.OnAlertListener
import com.github.amirbahadoramiri.telegramdialog.listeners.OnConfirmListener
import com.github.amirbahadoramiri.telegramdialog.listeners.OnInputConfirmListener
import com.github.amirbahadoramiri.telegramdialog.listeners.OnInputListener
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

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



        val telegramAlertDialog = TelegramAlertDialog(this)
            .setTitle("Delete message")
            .setMessage("Are you sure you want to delete this\n" + "message?")
            .setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD)
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
            .setPositiveButtonText("Delete")
            .setPositiveButtonTextColor(TelegramColors.getMainBlue())
            .setPositiveButtonRippleColor(TelegramColors.getMainBlueTint(this))
        telegramAlertDialog.show()



        val telegramAlertDialog2 = TelegramAlertDialog(this)
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

        telegramAlertDialog2.setOnClickListener(object : OnAlertListener {
            override fun onPositiveButtonClicked() {
                Toast.makeText(this@MainActivity, "onPositiveButtonClicked", Toast.LENGTH_SHORT).show()
                telegramAlertDialog2.dismiss()
            }
            /* Optional Function */
            override fun onCanceled() {
                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show()
            }
        })

        telegramAlertDialog2.show()




        val telegramConfirmDialog = TelegramConfirmDialog(this,DialogDirection.LTR)
            .setTitle("Delete message")
            .setMessage(
                "Are you sure you want to delete this\n" +
                        "message?"
            )
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

        telegramConfirmDialog.setOnClickListener(object : OnConfirmListener {
            override fun onNegativeButtonClicked() {
                Toast.makeText(this@MainActivity, "onNegativeButtonClicked", Toast.LENGTH_SHORT).show()
                telegramConfirmDialog.dismiss()
            }
            override fun onPositiveButtonClicked() {
                Toast.makeText(this@MainActivity, "onPositiveButtonClicked", Toast.LENGTH_SHORT).show()
                telegramConfirmDialog.dismiss()
            }
            /* Optional Function */
            override fun onCanceled() {
                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show()
            }
        })
        telegramConfirmDialog.show()



        val telegramConfirmDialog2 = TelegramConfirmDialog(this,DialogDirection.RTL)
            .setTitle("حذف پیام")
            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
            .setPositiveButtonText("حذف")
            .setPositiveButtonCornerRadius(32)
            .setNegativeButtonText("لغو")
            .setNegativeButtonCornerRadius(32)

        telegramConfirmDialog2.setOnClickListener(object : OnConfirmListener {
            override fun onNegativeButtonClicked() {
                Toast.makeText(this@MainActivity, "onNegativeButtonClicked", Toast.LENGTH_SHORT).show()
                telegramConfirmDialog2.dismiss()
            }
            override fun onPositiveButtonClicked() {
                Toast.makeText(this@MainActivity, "onPositiveButtonClicked", Toast.LENGTH_SHORT).show()
                telegramConfirmDialog2.dismiss()
            }
            /* Optional Function */
            override fun onCanceled() {
                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show()
            }
        })
        telegramConfirmDialog2.show()



        val telegramInputDialog = TelegramInputDialog(this)
            .setTitle("Delete message")
            .setMessage(
                "Are you sure you want to delete this\n" +
                        "message?"
            )
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
            .setPositiveButtonText("Delete")
            .setPositiveButtonTextColor(TelegramColors.getMainBlue())
            .setPositiveButtonRippleColor(TelegramColors.getMainBlueTint(this))
            .setPositiveButtonCornerRadius(32)
            .setEditTextHint("Typing...")
            .setEditTextHintColor(TelegramColors.getColor(TelegramColors.MAIN_BLUE_LIGHT))
            .setEditTextColor(TelegramColors.getTextColor(this))
            .setEditTextBackgroundColor(TelegramColors.getMainBlueTint(this))
//            ic_person size 20dpx20dp
            .setEditTextDrawable(R.drawable.ic_person,TelegramColors.getMainBlue())

        telegramInputDialog.setOnClickListener(object : OnInputListener {
            override fun onPositiveButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
                telegramInputDialog.dismiss()
            }
            /* Optional Function */
            override fun onCanceled() {
                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show();
            }
        })
        telegramInputDialog.show()



        val telegramInputConfirmDialog = TelegramInputConfirmDialog(this, DialogDirection.RTL)
            .setTitle("حذف پیام")
            .setMessage("آیا از حذف این پیام اطمینان دارید؟")
            .setNegativeButtonText("لغو")
            .setPositiveButtonText("حذف")
            .setEditTextHint("بنویسید...")
//            ic_person size   **  JUST 20dpx20dp  **
            .setEditTextDrawable(R.drawable.ic_person,TelegramColors.getMainBlue())

        telegramInputConfirmDialog.setOnClickListener(object : OnInputConfirmListener {
            override fun onNegativeButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, "onNegativeButtonClicked: ${text}", Toast.LENGTH_SHORT).show()
                telegramInputConfirmDialog.dismiss()
            }
            override fun onPositiveButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, "onPositiveButtonClicked: ${text}", Toast.LENGTH_SHORT).show()
                telegramInputConfirmDialog.dismiss()
            }
            /* Optional Function */
            override fun onCanceled() {
                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show();
            }
        })
        telegramInputConfirmDialog.show()



        val telegramInputConfirmDialog2 = TelegramInputConfirmDialog(this, DialogDirection.LTR)
            .setTitle("Delete message")
            .setMessage("Are you sure you want to delete this\n" + "message?")
            .setCancelable(true)
            .setCardRadius(16)
            .setInputType(InputType.TYPE_CLASS_NUMBER)
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

        telegramInputConfirmDialog2.setOnClickListener(object : OnInputConfirmListener {
            override fun onNegativeButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, "onNegativeButtonClicked: ${text}", Toast.LENGTH_SHORT).show()
                telegramInputConfirmDialog2.dismiss()
            }
            override fun onPositiveButtonClicked(text: String) {
                Toast.makeText(this@MainActivity, "onPositiveButtonClicked: ${text}", Toast.LENGTH_SHORT).show()
                telegramInputConfirmDialog2.dismiss()
            }
            /* Optional Function */
            override fun onCanceled() {
                Toast.makeText(this@MainActivity, "onCanceled", Toast.LENGTH_SHORT).show();
            }
        })
        telegramInputConfirmDialog2.show()



        val telegramLoadingDialog = TelegramLoadingDialog(this)
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
            .setProgressbarIndeterminateTint(TelegramColors.getProgressBarIndeterminateTint(this))
            .setOnClickListener { Toast.makeText(this, "onCanceled", Toast.LENGTH_SHORT).show() }
        telegramLoadingDialog.show()



        val telegramProgressDialog = TelegramProgressDialog(this)
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
            .setProgressbarTint(TelegramColors.getMainBlue())
            .setProgressbarBackgroundTint(TelegramColors.getMainBlueTint(this))
            .setMax(100)
            .setValue(30)
            .setOnClickListener { Toast.makeText(this, "onCanceled", Toast.LENGTH_SHORT).show() }
        telegramProgressDialog.show()



        val telegramPercentageProgressDialog = TelegramPercentageProgressDialog(this)
            .setTitle("Loading...")
            .setStatus("30%")
            .setCancelable(true)
            .setCardRadius(16)
            .setCardBackgroundColor(TelegramColors.getDialogBackground(this))
            .setProgressbarTint(TelegramColors.getMainRed())
            .setProgressbarBackgroundTint(TelegramColors.getMainRedTint(this))
            .setMax(100)
            .setValue(30)
            .setOnClickListener { Toast.makeText(this, "onCanceled", Toast.LENGTH_SHORT).show() }
        telegramPercentageProgressDialog.show()

        lifecycleScope.launch {
            delay(2.seconds)
            telegramPercentageProgressDialog.setValue(50)
                .setStatus("50%")
                .setProgressbarTint(TelegramColors.getProgressBarIndeterminateTint(this@MainActivity))
                .setProgressbarBackgroundTint(TelegramColors.getMainBlueTint(this@MainActivity))
        }
        lifecycleScope.launch {
            delay(4.seconds)
            telegramPercentageProgressDialog.setValue(70)
                .setStatus("70%")
                .setProgressbarTint(TelegramColors.getMainBlue())
                .setProgressbarBackgroundTint(TelegramColors.getMainBlueTint(this@MainActivity))
        }
        lifecycleScope.launch {
            delay(6.seconds)
            telegramPercentageProgressDialog.setValue(100)
                .setStatus("100%")
                .setProgressbarTint(TelegramColors.getColor(TelegramColors.MAIN_GREEN))
                .setProgressbarBackgroundTint(TelegramColors.getColor(TelegramColors.MAIN_GREEN_LIGHT))
        }

    }
}
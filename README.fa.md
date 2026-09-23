# TelegramDialog

> 🌍 [English version](./README.md)

دیالوگ‌اندرویدی قابل‌شخصی‌سازی با الهام از رابط تلگرام — ساخته‌شده با جاوا، با دیالوگ‌های Alert ،Confirm ،Input و Progress.

[![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)](https://developer.android.com)
[![Language](https://img.shields.io/badge/Language-Java_%2B_Kotlin-ED8B00?logo=java&logoColor=white)](https://github.com/AmirBahadorAmiri/TelegramDialog)
[![minSdk](https://img.shields.io/badge/minSdk-26-blue)](./TelegramDialog/build.gradle.kts)
[![Version](https://img.shields.io/badge/Version-2.2.0-orange)](./TelegramDialog/build.gradle.kts)
[![JitPack](https://jitpack.io/v/AmirBahadorAmiri/TelegramDialog.svg)](https://jitpack.io/#AmirBahadorAmiri/TelegramDialog)

## 👀 پیش‌نمایش

| `پیش‌نمایش` | `شروع انیمیشن` |
|:-----------:|:---------------:|
| <img width="184" height="408" src="https://github.com/user-attachments/assets/57c8e94b-24e9-4265-863a-1cafc3d2794f" /> | <img width="184" height="408" src="https://github.com/user-attachments/assets/4e1eb892-fc7d-4458-b9bd-0624bf9c2a81" /> |

## 📥 نصب

**دریافت از JitPack** — [![دریافت از JitPack](https://img.shields.io/badge/Get_it_on-JitPack-909090?logo=jitpack&logoColor=white)](https://jitpack.io/#AmirBahadorAmiri/TelegramDialog)

۱. جیت‌پک را به `settings.gradle.kts` اضافه کن:

```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```

۲. وابستگی را اضافه کن:

```kotlin
implementation("com.github.AmirBahadorAmiri:TelegramDialog:2.2.0")
```

## ✨ امکانات

### 💬 دیالوگ‌ها
- `TelegramAlertDialog` — دیالوگ هشدار تک‌دکمه‌ای با عنوان، پیام و حالت تراز متن.
- `TelegramConfirmDialog` — دیالوگ تأیید دودکمه‌ای با `OnConfirmListener`.
- `TelegramInputDialog` — دیالوگ ورودی متن با `OnInputListener`، هینت، نوع ورودی و آیکون.
- `TelegramInputConfirmDialog` — ترکیب ورودی + تأیید با `OnInputConfirmListener`.
- `TelegramLoadingDialog` — دیالوگ لودینگ چرخان.
- `TelegramProgressDialog` — نوار پیشرفت با `setMax` و `setValue`.
- `TelegramPercentageProgressDialog` — پیشرفت همراه عنوان و وضعیت (مثل `30%`) با قابلیت به‌روزرسانی زنده.

### 🌍 راست‌چین و حالت شب
- پشتیبانی کامل از RTL و LTR با `DialogDirection.RTL` / `DialogDirection.LTR` و متد `setDirection()`.
- حالت شب خودکار با `TelegramColors` — متدهای `getDialogBackground()` ،`getTextColor()` ،`getMainBlueTint()` و `getMainRedTint()` بدون نیاز به فایل ریسورس اضافه.

### 🎨 شخصی‌سازی
- سازگار با جاوا و کاتلین.
- تنظیم شعاع کارت، رنگ پس‌زمینه، رنگ/ریپل/گوشه دکمه‌ها، رنگ متن و هینت ورودی و آیکون با `setEditTextDrawable()`.
- انیمیشن دلخواه — مثل افکت لرزش برای اعتبارسنجی با `startEditTextAnimation()`.

### ⚙️ لیسنرها
- `OnAlertListener` ،`OnConfirmListener` ،`OnInputListener` ،`OnInputConfirmListener` ،`OnLoadingListener` ،`OnProgressListener` و `OnPercentageProgressListener` با تابع اختیاری `onCanceled()`.

## 📚 نحوه استفاده

### دیالوگ هشدار

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

مثال راست‌چین:

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

### دیالوگ تأیید

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

### دیالوگ ورودی

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

### دیالوگ ورودی + تأیید

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

### دیالوگ‌های پیشرفت

```kotlin
// لودینگ
val loading = TelegramLoadingDialog(this)
    .setProgressbarIndeterminateTint(TelegramColors.getMainBlue())
    .show()

// پیشرفت
val progress = TelegramProgressDialog(this)
    .setValue(30)
    .show()

// پیشرفت درصدی
val percentage = TelegramPercentageProgressDialog(this)
    .setTitle("Downloading...")
    .setStatus("30%")
    .setValue(30)
    .show()
```

### مدیریت رنگ

```kotlin
.setPositiveButtonBackgroundColor(TelegramColors.getMainBlue())
.setCardBackgroundColor(TelegramColors.getDialogBackground(this))
```

یا با ریسورس خودت:

```kotlin
.setPositiveButtonBackgroundColor(getColor(R.color.btn_background))
.setCardBackgroundColor(getColor(R.color.background))
```

### پشتیبانی از راست‌چین

```kotlin
.setDirection(DialogDirection.RTL)
```

### انیمیشن‌ها

```kotlin
val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
dialog.startEditTextAnimation(shake)
```

## 🛠 تکنولوژی‌ها

| بخش | ابزار |
|-----|-------|
| زبان | جاوا (کتابخانه)، کاتلین (اپ نمونه) |
| رابط کاربری | اندروید ویو، متریال کامپوننت |
| هسته | AndroidX AppCompat ،Core-KTX ،Activity ،ConstraintLayout |
| بیلد | گردل (کاتلین DSL)، AGP 9.3.2، جاوا ۱۷ |
| انتشار | JitPack و maven-publish |
| نسخه‌ها | minSdk 26 ،targetSdk 37 ،compileSdk 36/37 |

## 📁 ساختار پروژه

```text
TelegramDialog/
├── app/                  # اپ نمونه
│   └── src/main/java/.../MainActivity.kt
├── TelegramDialog/       # ماژول کتابخانه
│   └── src/main/java/.../telegramdialog/
├── gradle/libs.versions.toml
├── settings.gradle.kts
└── README.md / README.fa.md
```

- `TelegramDialog/src/main/java/.../TelegramAlertDialog.java` — دیالوگ هشدار تک‌دکمه‌ای.
- `TelegramDialog/src/main/java/.../TelegramConfirmDialog.java` — دیالوگ تأیید دودکمه‌ای.
- `TelegramDialog/src/main/java/.../TelegramInputDialog.java` — دیالوگ ورودی.
- `TelegramDialog/src/main/java/.../TelegramInputConfirmDialog.java` — دیالوگ ورودی + تأیید.
- `TelegramDialog/src/main/java/.../TelegramLoadingDialog.java` ،`TelegramProgressDialog.java` ،`TelegramPercentageProgressDialog.java` — مدل‌های پیشرفت.
- `TelegramDialog/src/main/java/.../TelegramColors.java` — ابزار رنگ سازگار با حالت شب.
- `TelegramDialog/src/main/java/.../direction/DialogDirection.java` — اینام راست‌چین/چپ‌چین.
- `app/src/main/java/.../MainActivity.kt` — دموی کامل همه دیالوگ‌ها.

## 🚀 اجرا و بیلد

۱. ریپو را کلون کن:

```bash
git clone https://github.com/AmirBahadorAmiri/TelegramDialog.git
```

۲. در اندروید استودیو باز کن (Ladybug یا جدیدتر، JDK 17).
۳. بگذار گردل سینک شود (JitPack + Google + MavenCentral).
۴. کانفیگ `app` را روی امولاتور یا گوشی اجرا کن.

> نکته: اولین سینک به اینترنت نیاز دارد؛ بعدش آفلاین هم بیلد می‌شود مگر وابستگی‌ها عوض شوند.

## 📋 پیش‌نیازها

- اندروید ۸ (API 26) یا بالاتر
- اندروید استودیو با JDK 17
- اینترنت برای اولین سینک گردل (JitPack ،Google ،MavenCentral)

## 🤝 مشارکت

مشارکت با پول‌ریکوئست آزاد است. برای باگ یا پیشنهاد، ایشو باز کن و مراحل تکرار، مدل گوشی / نسخه اندروید و اسکرین‌شات را بنویس.

---

ساخته‌شده با ❤️ برای رابط‌های تلگرام‌استایل اندروید

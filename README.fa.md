<p align="center">
  🌍 Read in English: <a href="README.md"><b>English</b></a>
</p>

<p align="center">
  <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp" width="400" title="لوگوی TelegramDialog">
</p>

# دیالوگ تلگرام (TelegramDialog) 💬
### کتابخانهٔ اندرویدی دیالوگها با ظاهر تلگرام

**دیالوگ تلگرام** کتابخانهای اندرویدی است با دیالوگهایی به سبک تلگرام و یک منوی popup متصل به view. این کتابخانه به زبان Java نوشته شده و هم از Java و هم از Kotlin قابل استفاده است.

---

## 📥 دریافت کتابخانه

آخرین نسخه روی JitPack منتشر شده است. ابتدا JitPack را به `settings.gradle.kts` اضافه کنید، سپس وابستگی را بگیرید:

```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```

```kotlin
dependencies {
    implementation("com.github.AmirBahadorAmiri:TelegramDialog:2.3.3")
}
```

---

## 🆕 تغییرات نسخهٔ ۲.۳.۳ — منوی popup با اسکرول

این نسخه منوی popup را برای فهرستهای بلند عملی میکند:

*   **اسکرول هنگام نیاز:** وقتی آیتمها بیشتر از فضای موجود باشند، ارتفاع منو در ۶۰ درصد ارتفاع صفحه متوقف میشود و بجای بریده شدن، اسکرول میکند.
*   **منوی متصل به view:** کلاس `TelegramPopupMenu` پایین هر view باز میشود، با آیکون، جداگر، پشتیبانی RTL و قابلیت تنظیم عرض و elevation.
*   **compileSdk 37:** ماژول کتابخانه اکنون با API شماره ۳۷ بیلد میشود.

---

## 🌟 ویژگیهای کلیدی

### 💬 دیالوگها
*   `TelegramAlertDialog` — دیالوگ هشدار تکدکمهای با عنوان، پیام و حالت تراز متن.
*   `TelegramConfirmDialog` — دیالوگ تأیید دودکمهای با `OnConfirmListener`.
*   `TelegramInputDialog` و `TelegramInputConfirmDialog` — ورودی متن با هینت، نوع ورودی و آیکون.
*   `TelegramLoadingDialog`، `TelegramProgressDialog` و `TelegramPercentageProgressDialog` — مدلهای لودینگ و پیشرفت با بهروزرسانی زنده.

### 🎯 منوی popup
*   `TelegramPopupMenu` — منوی اکشنی که به صورت popup متصل به یک view نمایش داده میشود، نه بعنوان دیالوگ.
*   ردیفها از آیکون، جداگر میان گروهها و لیسنری با شماره و متن آیتم پشتیبانی میکنند.
*   **اسکرول بهصورت پیشفرض:** منوهای بلند در ۶۰ درصد صفحه محدود میشوند و اسکرول میخورند؛ هر بار باز شدن از بالا شروع میشود.

### 🎨 شخصیسازی
*   شعاع کارت، رنگ پسزمینه، میزان سایه (`setElevation()`) و عرض ثابت منو (`setWidth()`).
*   رنگ متن و ripple دکمهها، رنگ گوشهها، رنگ ورودی و هینت، آیکون و انیمیشن لرزش.
*   رنگ متن منو، رنگ آیکونها و رنگ جداگر هر کدام جداگانه قابل تنظیماند.

### 🌍 RTL و حالت شب
*   `DialogDirection.RTL` / `DialogDirection.LTR` و متد `setDirection()` دیالوگها و منوی popup را برمیگردانند.
*   `TelegramColors` حالت شب سیستم را تشخیص میدهد و رنگ پسزمینه، متن و tint مناسب را میدهد — بدون فایل ریسورس اضافه.

### ⚙️ لیسنرها
*   `OnAlertListener`، `OnConfirmListener`، `OnInputListener`، `OnInputConfirmListener`، `OnLoadingListener`، `OnProgressListener`، `OnPercentageProgressListener` و `OnMenuListener`.
*   هر لیسنر یک تابع اختیاری `onCanceled()` برای لمس بیرون یا دکمه back دارد.

---

## 🛠 تکنولوژیهای استفاده شده

در توسعهٔ دیالوگ تلگرام از ابزارهای روز اندروید استفاده شده است:

*   **زبان:** Java برای کتابخانه، Kotlin برای اپ نمونه.
*   **رابط کاربری:** Android Views، Material Components و ConstraintLayout.
*   **هسته:** AndroidX AppCompat، Core-KTX و Activity.
*   **بیلد:** Gradle Kotlin DSL، AGP 9.3.2 و Java 17 (minSdk 26، targetSdk 37، compileSdk 37).
*   **انتشار:** JitPack و maven-publish.

---

## 🚀 راهنمای نصب و اجرا

۱. ابتدا پروژه را از GitHub کلون کنید:
```bash
git clone https://github.com/AmirBahadorAmiri/TelegramDialog.git
```
۲. پروژه را در **Android Studio** باز کنید (Ladybug یا جدیدتر، JDK 17).
۳. بگذارید Gradle سینک شود — برای سینک اول به JitPack، Google و MavenCentral نیاز است.
۴. کانفیگ **app** را روی امولاتور یا گوشی اجرا کنید تا همه دیالوگها و منوی popup را امتحان کنید.

---

## 📸 اسکرینشاتها

اپ نمونه تم دیالوگ و انیمیشن شروع آن را نشان میدهد:

| 💬 نمای دیالوگ | 🎬 انیمیشن شروع |
|:---:|:---:|
| <img width="184" height="408" alt="دیالوگ هشدار به سبک تلگرام" src="https://github.com/user-attachments/assets/57c8e94b-24e9-4265-863a-1cafc3d2794f" /> | <img width="184" height="408" alt="انیمیشن شروع دیالوگ" src="https://github.com/user-attachments/assets/4e1eb892-fc7d-4458-b9bd-0624bf9c2a81" /> |

---

## 👨‍💻 توسعهدهنده

توسعه داده شده توسط **امیربهادر امیری**. فهرست مشارکتکنندگان را در [CONTRIBUTORS.md](./CONTRIBUTORS.md) ببینید.

> [!TIP]
> متد `menu.show()` را از داخل یک کلیک لیسنر صدا بزنید. اگر آن را در `onCreate()` صدا بزنید، منو تا متصل شدن view موردنظر صبر میکند و سپس باز میشود.

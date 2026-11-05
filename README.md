# 🚀 Opengram for Android

<p align="center">
  <img src="https://raw.githubusercontent.com/rahilanw4r/opengram/main/TMessagesProj/src/main/res-cherrygram/mipmap-xxhdpi/icon_launcher_cherry.webp" alt="Opengram Logo" width="128" height="128" />
</p>

<p align="center">
  <b>A modern, high-performance, and privacy-respecting Telegram client for Android.</b>
</p>

<p align="center">
  <a href="https://github.com/rahilanw4r/opengram/blob/main/LICENSE"><img src="https://img.shields.io/badge/License-GPL%20v2%2B-blue.svg?style=for-the-badge" alt="License: GPL v2+" /></a>
  <a href="https://developer.android.com"><img src="https://img.shields.io/badge/Platform-Android%207.0%2B%20(API%2024%2B)-green.svg?style=for-the-badge&logo=android" alt="Android 7.0+" /></a>
  <a href="https://kotlinlang.org"><img src="https://img.shields.io/badge/Kotlin-2.2-purple.svg?style=for-the-badge&logo=kotlin" alt="Kotlin" /></a>
  <a href="https://github.com/rahilanw4r/opengram/stargazers"><img src="https://img.shields.io/github/stars/rahilanw4r/opengram?style=for-the-badge" alt="Stars" /></a>
  <a href="https://github.com/rahilanw4r/opengram/network/members"><img src="https://img.shields.io/github/forks/rahilanw4r/opengram?style=for-the-badge" alt="Forks" /></a>
</p>

---

## 📖 Overview

**Opengram** is a refined, open-source Android client for the Telegram messaging platform. Built on the solid foundation of official Telegram sources and community improvements, Opengram focuses on user sovereignty, advanced customization, clean UI design, and maximum speed without compromising privacy.

> [!NOTE]  
> Opengram is an unofficial client developed independently and is not affiliated with Telegram FZ-LLC.

---

## ✨ Key Highlights

- **🎨 Advanced Appearance & Theming**
  - Full Material You / Dynamic Colors (Monet) support across the entire app.
  - Solar and OneUI icon sets, custom chat bubbles, and configurable status bars.
  - Granular drawer navigation personalization and customized folder tabs.

- **🔒 Privacy & Autonomy**
  - Completely disarmed remote locks, anti-rebrand checks, and tracking routines.
  - Native biometric authentication (`CGBiometricPrompt`) for sensitive conversations.
  - Configurable Ghost Mode preferences and granular control over read receipts.

- **⚡ Media & Camera Enhancements**
  - Modern Jetpack CameraX integration (`CameraXView`) supporting high-framerate capture, lens switching, and stabilization.
  - Integrated ExoPlayer / Media3 engine with native FFmpeg audio/video decoders.
  - Markdown and LaTeX (`jlatexmath`) rendering directly inside message bubbles.

- **🤖 Built-in AI Capabilities**
  - Integrated Google Gemini AI chat assistant for rapid queries, summarization, and translation.

- **🛠 Developer & Power-User Tools**
  - In-app JSON payload inspector for message packets.
  - Fast account switching with multi-account support.
  - Independent direct updates and standalone distribution capabilities.

---

## 🏗 Repository Architecture

```text
opengram/
├── TMessagesProj/               # Core Telegram Android library (UI, controllers, MTProto network engine)
│   ├── jni/                     # C/C++ native source code (BoringSSL, WebRTC, FFmpeg, tlottie, TDLib)
│   └── src/main/java/
│       ├── org/telegram/        # Telegram core UI, activities, controllers, and services
│       └── uz/unnarsx/cherrygram/ # Custom Opengram features, camera, preferences, and hooks
├── TMessagesProj_App/           # Google Play Store application flavor
├── TMessagesProj_AppStandalone/ # Direct-download standalone APK (with self-updater)
├── TMessagesProj_AppHuawei/     # Huawei AppGallery distribution flavor
├── TMessagesProj_Modules/media/ # AndroidX Media3 / ExoPlayer multimedia subsystem
├── buildSrc/                    # Custom Gradle plugins and TL-schema code generation tools
└── Dockerfile                   # Specification for reproducible builds
```

---

## 🛠 Prerequisites

To compile Opengram from source, your development environment must include:

- **JDK**: Java Development Kit 17 (recommended: OpenJDK 17 or Eclipse Temurin)
- **Android SDK**: API 36 (`compileSdkVersion 36`, `targetSdkVersion 36`, `minSdkVersion 24`)
- **Android Build Tools**: `36.0.0`
- **Android NDK**: `27.2.12479018`
- **CMake**: `3.22.1`
- **Gradle**: `8.13` (managed via included Gradle Wrapper)

---

## 🚀 Building from Source

### 1. Clone the Repository

Clone Opengram together with its submodules:

```bash
git clone --recursive https://github.com/rahilanw4r/opengram.git
cd opengram
```

If you previously cloned without `--recursive`, initialize submodules manually:

```bash
git submodule update --init --recursive --depth=1
```

### 2. Configure Telegram API Credentials

Telegram requires every third-party application to use its own API credentials:

1. Obtain your `api_id` and `api_hash` by registering an application at [my.telegram.org](https://my.telegram.org).
2. Open `TMessagesProj/src/main/java/uz/unnarsx/cherrygram/Extra.kt` and insert your credentials:

```kotlin
object Extra {
    fun getAppID(): Int = YOUR_APP_ID
    fun getAppHash(): String = "YOUR_APP_HASH"
    // ...
}
```

### 3. Setup Firebase Push Notifications (Optional for Local Builds)

1. Create a project in the [Firebase Console](https://console.firebase.google.com/).
2. Add an Android app with package ID `org.gram.messenger` (and `org.gram.messenger.beta` for beta builds).
3. Download `google-services.json` and place it in the `TMessagesProj/` folder.

### 4. Build the Project

You can compile using Android Studio or directly via the command line:

#### Debug Build (Fast Compilation)
```bash
./gradlew :TMessagesProj_App:assembleDebug
```

#### Standalone Release APK
```bash
./gradlew :TMessagesProj_AppStandalone:assembleAfatStandalone
```

The resulting APKs will be located in `TMessagesProj_App/build/outputs/apk/` and `TMessagesProj_AppStandalone/build/outputs/apk/`.

---

## 📄 License & Attribution

Opengram is licensed under the **GNU General Public License v2.0 or later** ([GPL-2.0-or-later](LICENSE)).

### Acknowledgments & Upstream Credits
Opengram builds upon the work of several fantastic open-source projects:
- [Telegram for Android](https://github.com/DrKLO/Telegram) by Nikolai Kudashov and Telegram LLC
- [Cherrygram](https://github.com/arsLan4k1390/Cherrygram) by arsLan4k1390
- [Nekogram](https://gitlab.com/Nekogram/Nekogram) & [Catogram](https://github.com/Catogram/Catogram)
- [exteraGram](https://github.com/exteraSquad/exteraGram) & [OwlGram](https://github.com/OwlGramDev/OwlGram)
- [Telegram Monet](https://github.com/c3r5b8/Telegram-Monet) & [Telegraher](https://github.com/nikitasius/Telegraher)

---

<p align="center">
  Made with ❤️ by <a href="https://github.com/rahilanw4r">Rahil Anwar</a> and the Open Source Community.
</p>

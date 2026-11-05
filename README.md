# Opengram for Android

<p align="center">
  <img src="assets/opengram-logo.svg" alt="Opengram logo" width="140" />
</p>

<p align="center">
  <strong>An open-source Android client for Telegram, built around customization, usability, and control.</strong>
</p>

<p align="center">
  <a href="LICENSE">GPL-2.0-or-later</a> · Android · Kotlin
</p>

---

## Overview

Opengram is an independently developed Android client based on Telegram for Android and community-developed enhancements. It adds customization and extra tools while retaining Telegram's messaging platform.

Opengram is an unofficial third-party client. It is not affiliated with, endorsed by, or sponsored by Telegram FZ-LLC.

## Features

- **Interface customization:** Material You / Dynamic Color support, icon themes, chat bubble options, status-bar settings, drawer customization, and folder-tab controls.
- **Privacy controls:** Biometric protection for supported sensitive areas, Ghost Mode preferences, and configurable read-receipt behavior.
- **Media and camera:** CameraX integration, Media3 / ExoPlayer playback, FFmpeg-based media support, and message rendering for Markdown and LaTeX.
- **Built-in assistant:** Google Gemini integration for supported AI chat, summarization, and translation workflows.
- **Power-user tools:** JSON message-payload inspection, multi-account support, and standalone distribution with direct-update functionality.

Feature availability can vary by build flavor and configuration.

## Download

Check the [Releases](https://github.com/rahilanw4r/opengram/releases) page for available builds.

## Build from source

### Requirements

| Component | Version |
|---|---|
| JDK | 17 |
| Android SDK | API 36 |
| Android Build Tools | 36.0.0 |
| Android NDK | 27.2.12479018 |
| CMake | 3.22.1 |
| Gradle | 8.13 (Gradle Wrapper) |

### 1. Clone the repository

Clone the repository and its submodules:

```bash
git clone --recursive https://github.com/rahilanw4r/opengram.git
cd opengram
```

If the repository was cloned without submodules:

```bash
git submodule update --init --recursive --depth=1
```

### 2. Configure Telegram API credentials

Register an application at [my.telegram.org](https://my.telegram.org) to obtain your own Telegram API ID and API hash.

Configure the credentials in:

`TMessagesProj/src/main/java/uz/unnarsx/cherrygram/Extra.kt`

Example:

```kotlin
object Extra {
    fun getAppID(): Int = YOUR_APP_ID
    fun getAppHash(): String = "YOUR_APP_HASH"
}
```

Do not commit personal credentials or secrets to a public repository.

### 3. Configure Firebase (optional)

Firebase is optional for local builds that do not require push notifications.

1. Create a project in the [Firebase Console](https://console.firebase.google.com/).
2. Register the Android application package used by your build.
3. Place the corresponding `google-services.json` file in `TMessagesProj/`.

Keep Firebase configuration and any associated credentials out of public commits when they are private to your project.

### 4. Build

Debug APK:

```bash
./gradlew :TMessagesProj_App:assembleDebug
```

Standalone APK:

```bash
./gradlew :TMessagesProj_AppStandalone:assembleAfatStandalone
```

Build outputs are generated under the relevant module's `build/outputs/apk/` directory.

## Repository structure

```text
opengram/
├── TMessagesProj/                # Telegram Android core and custom features
├── TMessagesProj_App/            # Main application flavor
├── TMessagesProj_AppStandalone/  # Standalone distribution flavor
├── TMessagesProj_AppHuawei/      # Huawei distribution flavor
├── TMessagesProj_Modules/media/  # Media3 / ExoPlayer components
├── buildSrc/                     # Custom Gradle build logic
└── Dockerfile                    # Build environment specification
```

## License

Opengram is licensed under the [GNU General Public License v2.0 or later](LICENSE).

## Acknowledgments

Opengram builds on Telegram for Android and incorporates ideas or work from open-source projects including:

- [Telegram for Android](https://github.com/DrKLO/Telegram)
- [Nekogram](https://gitlab.com/Nekogram/Nekogram)
- [Catogram](https://github.com/Catogram/Catogram)
- [exteraGram](https://github.com/exteraSquad/exteraGram)
- [OwlGram](https://github.com/OwlGramDev/OwlGram)
- [Telegram Monet](https://github.com/c3r5b8/Telegram-Monet)
- [Telegraher](https://github.com/nikitasius/Telegraher)

Please refer to the upstream projects and their licenses for applicable attribution and licensing details.

---

<p align="center">
  Maintained by <a href="https://github.com/rahilanw4r">Rahil Anwar</a> and contributors.
</p>

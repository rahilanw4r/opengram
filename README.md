# 🚀 Opengram

Opengram is an enhanced, privacy-focused open-source Telegram client for Android.

This is an unofficial fork of Telegram App for Android based on Cherrygram.

## Compilation Guide

You will require Android Studio, Android NDK 27.2.12479018 and Android SDK 36.

1. Submodules: ensure submodules in `TMessagesProj/jni/` and `TMessagesProj_Modules/media/` are checked out.
2. Sign your app: Fill out storeFile, storePassword, keyAlias, keyPassword in `TMessagesProj_App`, `TMessagesProj_AppHuawei`, or `TMessagesProj_AppStandalone`.
3. Firebase: Go to https://console.firebase.google.com/, create Android apps with application ID `org.gram.messenger` and `org.gram.messenger.beta`, enable Firebase Messaging, and copy `google-services.json` into `TMessagesProj`.
4. API credentials: Set your Telegram `api_id` and `api_hash` in `TMessagesProj/src/main/java/uz/unnarsx/cherrygram/Extra.kt`.
5. You are ready to build Opengram!


## Thanks to:
- [Catogram](https://github.com/Catogram/Catogram) and [Nekogram](https://gitlab.com/Nekogram/Nekogram)
- [exteraGram](https://github.com/exteraSquad/exteraGram) and [OwlGram](https://github.com/OwlGramDev/OwlGram)
- [Telegraher](https://github.com/nikitasius/Telegraher) and [Telegram Monet](https://github.com/c3r5b8/Telegram-Monet)

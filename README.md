# musicfy_android
Musicfy - GPL v3 Licensed

# Musicfy

Save and view WhatsApp statuses on your Android device.

## License

This project is licensed under the **GNU General Public License v3.0** - see the [LICENSE](LICENSE) file for details.

**Important:** This app complies with GPL-3.0 open source licensing requirements. You are free to use, modify, and distribute this software under the terms of the GPL v3 license.

## Download

- **Google Play Store:** [Musicfy]
- ([https://play.google.com/store/apps/details?id=com.appsease.status.saver](https://play.google.com/store/apps/details?id=com.play_pause.musicplayer&hl=en_IN))
- **Source Code:** [GitHub Repository](https://github.com/publicappsrepo/musicfy_android)

## Features

- Offline Music App Feature
- Customize Theme

## Building from Source

### Prerequisites

- Android Studio Arctic Fox or newer
- JDK 11 or newer
- Android SDK API 21+ (Android 5.0+)
- Gradle 7.0+

### Build Instructions

1. Clone this repository:
```bash
git clone https://github.com/publicappsrepo/musicfy_android.git
cd musicfy_android
```

2. Open the project in Android Studio

3. Sync Gradle files (Android Studio will prompt you)

4. Build the project:
   - Click **Build** → **Build Bundle(s) / APK(s)** → **Build APK(s)**
   
   Or use command line:
```bash
./gradlew assembleDebug
```

5. The APK will be in `app/build/outputs/apk/debug/`

### Installation
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```
## Contributing

Contributions are welcome! By contributing to this project, you agree to license your contributions under GPL v3.

## Privacy

This app does not collect or transmit any personal data. All operations are performed locally on your device.

## Disclaimer

This app is not affiliated with, endorsed by, or connected to WhatsApp Inc. or Meta Platforms, Inc.

## Contact

For questions or issues: [appsease2001@gmail.com]

### STEP 5: Create Additional Required Files

**Create `.gitignore`:**
```
# Built application files
*.apk
*.ap_
*.aab

# Files for the ART/Dalvik VM
*.dex

# Java class files
*.class

# Generated files
bin/
gen/
out/
build/

# Gradle files
.gradle/
gradle/

# Local configuration file (sdk path, etc)
local.properties

# Android Studio
.idea/
*.iml
.DS_Store
captures/
.externalNativeBuild
.cxx

# Keystore files
*.jks
*.keystore

# Signing files
signing.propertiesp

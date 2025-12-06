# Building Musicfy

## Requirements

- **Operating System:** Windows 10+, macOS 10.14+, or Linux
- **Android Studio:** Arctic Fox (2020.3.1) or newer
- **JDK:** Version 11 or 17
- **Android SDK:**
  - Build Tools: 30.0.3 or newer
  - Platform: Android API 21 (5.0) minimum
  - Platform: Android API 33 (13.0) target

## Step-by-Step Build Process

### 1. Install Android Studio

Download from: https://developer.android.com/studio

### 2. Install JDK
```bash
# Ubuntu/Debian
sudo apt install openjdk-11-jdk

# macOS
brew install openjdk@11

# Windows - download from Oracle or use Android Studio's bundled JDK
```

### 3. Clone Repository
```bash
git clone https://github.com/publicappsrepo/musicfy_android.git
cd musicfy_android
```

### 4. Configure SDK Path

Create `local.properties`:
```
sdk.dir=/path/to/your/Android/Sdk
```

### 5. Build Debug APK
```bash
chmod +x gradlew  # Linux/Mac only
./gradlew clean assembleDebug
```

Output: `app/build/outputs/apk/debug/app-debug.apk`

### 6. Build Release APK

For your own use (you'll need to sign it):
```bash
./gradlew assembleRelease
```

## Troubleshooting

### Error: SDK location not found
**Solution:** Create `local.properties` with your SDK path

### Error: Gradle sync failed
**Solution:** Check your internet connection and proxy settings

### Error: Build failed - missing dependencies
**Solution:** Run `./gradlew clean build --refresh-dependencies`

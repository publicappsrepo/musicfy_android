# Musicfy

**A Material You Music Player for Android**

Musicfy is an offline music player that allows you to listen to your local music collection with a beautiful, customizable interface built on open-source foundations.

---

## 📜 Attribution & License

### This project is a fork of [RetroMusicPlayer](https://github.com/RetroMusicPlayer/RetroMusicPlayer)

**Original Project Information:**
- **Original Repository:** https://github.com/RetroMusicPlayer/RetroMusicPlayer
- **Original Authors:** RetroMusicPlayer Team and Contributors
- **Original License:** GNU General Public License v3.0

We are grateful to the RetroMusicPlayer team for creating an excellent foundation for this project.

---

### Our Modifications

This fork includes the following customizations and changes from the original RetroMusicPlayer:

#### UI/UX Changes
- Rebranded interface with "Musicfy" branding
- Modified color schemes and theme options
- Updated app icon and splash screen
- Customized navigation layouts
- Adjusted typography and font selections

#### Feature Modifications
- Streamlined settings interface
- Reorganized menu structures
- Modified home screen layout
- Customized player controls design
- Adjusted theme switcher behavior

#### Localization
- Added/modified language support for regional preferences
- Updated text strings and translations

#### Technical Changes
- Updated package name to `com.play_pause.musicplayer`
- Modified build configuration
- Updated dependencies to latest versions
- Adjusted minimum SDK requirements

#### Removed Features
- [List any features removed from original, if applicable]

#### Added Features
- [List any genuinely new features you've added, if applicable]

**Note:** The core music playback engine, library management, and most features remain from the original RetroMusicPlayer project. Our fork focuses on UI customization and user experience refinements.

---

### License

This project is licensed under the **GNU General Public License v3.0** - see the [LICENSE](LICENSE) file for complete terms.

#### What This Means:
- ✅ You are **free to use** this software for any purpose
- ✅ You can **study** how the app works by examining the source code
- ✅ You can **modify** the source code to suit your needs
- ✅ You can **share** copies with others
- ✅ You can **distribute** your modifications under the same GPL-3.0 license

#### Your Obligations:
- 📋 You **must** keep the GPL-3.0 license when redistributing
- 📋 You **must** provide access to the source code
- 📋 You **must** clearly state any changes you made
- 📋 You **must** preserve all copyright notices

**All original copyright notices and license headers from RetroMusicPlayer have been preserved in the source code.**

---

## 📥 Download

- **Google Play Store:** [Download Musicfy](https://play.google.com/store/apps/details?id=com.play_pause.musicplayer)
- **Source Code:** [GitHub Repository](https://github.com/publicappsrepo/musicfy_android)
- **Original Project:** [RetroMusicPlayer on GitHub](https://github.com/RetroMusicPlayer/RetroMusicPlayer)

---

## ✨ Features

### Core Music Features
- 🎵 **Offline Music Playback** - Play local MP3, FLAC, and other audio formats
- 📁 **Library Organization** - Browse by Songs, Albums, Artists, Playlists, Genres, Folders
- 🎨 **Album Artwork** - Beautiful album art display with metadata
- 📜 **Lyrics Support** - View synchronized and static lyrics
- 🔀 **Smart Playback** - Shuffle, repeat, gapless playback, crossfade
- 📋 **Queue Management** - Full control over your playback queue

### Customization
- 🎨 **Material You Design** - Dynamic color theming (Android 12+)
- 🌓 **Multiple Themes** - Light, Dark, Pure Black (AMOLED) modes
- 🎭 **Customizable Interface** - Adjust layouts, headers, and fonts
- 🖼️ **Now Playing Styles** - Multiple player screen designs

### Organization
- ⭐ **Smart Categories** - Recently played, top tracks, favorites
- 📚 **Playlist Management** - Create, edit, and organize playlists
- 🔍 **Search** - Fast search across your entire library
- 📊 **Statistics** - View your listening history and patterns

### Audio
- 🎚️ **Equalizer** - Built-in equalizer with presets
- 🔊 **Audio Effects** - Bass boost, virtualizer, and more
- ⏱️ **Sleep Timer** - Auto-stop playback after set duration
- 🎧 **Headset Controls** - Full media button support

---

## 🛠️ Building from Source

### Prerequisites

Before building, ensure you have:

- **Android Studio** - Arctic Fox (2020.3.1) or newer recommended
- **JDK** - Java Development Kit 11 or newer
- **Android SDK** - API Level 21 (Android 5.0 Lollipop) or higher
- **Gradle** - Version 7.0 or newer (usually bundled with Android Studio)
- **Git** - For cloning the repository

### Step-by-Step Build Instructions

#### 1. Clone the Repository
```bash
git clone https://github.com/publicappsrepo/musicfy_android.git
cd musicfy_android
```

#### 2. Open in Android Studio

- Launch Android Studio
- Select **File** → **Open**
- Navigate to the cloned `musicfy_android` folder
- Click **OK**

#### 3. Sync Gradle

Android Studio should automatically prompt you to sync Gradle files. If not:
- Click **File** → **Sync Project with Gradle Files**
- Wait for the sync to complete

#### 4. Build the Project

**Option A: Using Android Studio GUI**
- Click **Build** → **Build Bundle(s) / APK(s)** → **Build APK(s)**
- Wait for the build to complete
- Click **locate** in the notification to find your APK

**Option B: Using Command Line**

For Debug build:
```bash
./gradlew assembleDebug
```

For Release build (requires signing):
```bash
./gradlew assembleRelease
```

#### 5. Locate Your APK

Built APKs will be in:
```
app/build/outputs/apk/debug/app-debug.apk
```

Or for release builds:
```
app/build/outputs/apk/release/app-release.apk
```

### Installing the APK

#### Via ADB (Android Debug Bridge)
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

#### Via File Transfer
- Copy the APK to your Android device
- Open the APK file on your device
- Grant permission to install from unknown sources if prompted
- Follow the installation prompts

---

## 🔧 Development Setup

### Project Structure
```
musicfy_android/
├── app/                    # Main application module
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/      # Java/Kotlin source files
│   │   │   ├── res/       # Resources (layouts, drawables, etc.)
│   │   │   └── AndroidManifest.xml
│   └── build.gradle       # App-level build configuration
├── gradle/                # Gradle wrapper files
├── build.gradle          # Project-level build configuration
├── settings.gradle       # Project settings
├── LICENSE               # GPL-3.0 license text
└── README.md            # This file
```

### Code Style

This project follows standard Android/Kotlin coding conventions. Please maintain consistency when contributing.

---

## 🤝 Contributing

We welcome contributions! By contributing to this project, you agree to license your contributions under GPL v3.

### How to Contribute

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### Contribution Guidelines

- Follow existing code style and conventions
- Test your changes thoroughly
- Update documentation as needed
- Ensure your code builds without errors
- Respect the GPL-3.0 license terms

### Reporting Issues

Found a bug? Have a suggestion? Please open an issue on GitHub with:
- Clear description of the problem
- Steps to reproduce (for bugs)
- Expected vs actual behavior
- Device and Android version information

---

## 🔒 Privacy & Permissions

### Privacy Commitment

**Musicfy respects your privacy:**
- ❌ No data collection or analytics
- ❌ No internet connection required
- ❌ No account creation or sign-in
- ❌ No advertisements or tracking
- ✅ All operations performed locally on your device
- ✅ Your music library never leaves your device

### Required Permissions

The app requires the following Android permissions:

- **READ_EXTERNAL_STORAGE** / **READ_MEDIA_AUDIO** - To access and play your music files
- **WAKE_LOCK** - To keep playing music when screen is off
- **FOREGROUND_SERVICE** - To show playback notification and controls

**All permissions are used solely for core music playback functionality.**

---

## 📱 System Requirements

- **Minimum Android Version:** Android 5.0 (Lollipop, API 21)
- **Recommended:** Android 8.0 (Oreo, API 26) or higher
- **Storage:** ~20-30 MB for app installation
- **RAM:** 2GB+ recommended for smooth performance
- **Display:** Any screen size supported (optimized for phones and tablets)

---

## 🙏 Acknowledgments

### Special Thanks To:

- **[RetroMusicPlayer Team](https://github.com/RetroMusicPlayer/RetroMusicPlayer)** - For creating the excellent foundation this project is built upon. Musicfy would not exist without their incredible work.
- **All RetroMusicPlayer Contributors** - For their ongoing development and improvements
- **The Open Source Community** - For supporting free and open software
- **Material Design Team at Google** - For the beautiful design system
- **Our Users** - For choosing Musicfy and providing valuable feedback

---

## 📧 Contact & Support

### Get in Touch

- **Email:** appsease2001@gmail.com
- **GitHub Issues:** [Report bugs or request features](https://github.com/publicappsrepo/musicfy_android/issues)
- **Source Code:** [View on GitHub](https://github.com/publicappsrepo/musicfy_android)

### Support the Original Project

If you enjoy this app, please consider:
- ⭐ Starring the [original RetroMusicPlayer repository](https://github.com/RetroMusicPlayer/RetroMusicPlayer)
- 💬 Contributing to RetroMusicPlayer development
- 📢 Spreading the word about open-source music players

---

## ⚠️ Disclaimer

- This is an **independent fork** of RetroMusicPlayer
- **Not affiliated with, endorsed by, or officially connected to** the RetroMusicPlayer project or its maintainers
- All modifications are provided "as-is" under GPL-3.0
- The original RetroMusicPlayer team is not responsible for issues in this fork

---

## 📜 Legal Notices

### Copyright
```
Musicfy - A fork of RetroMusicPlayer
Copyright (C) 2024-2025 Musicfy Project

Based on RetroMusicPlayer
Copyright (C) [Year] RetroMusicPlayer Team

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <https://www.gnu.org/licenses/>.
```

### Third-Party Libraries

This project uses several open-source libraries. Full attribution for all dependencies can be found in the app's "About" section and in the source code.

---

## 🔗 Links

- **Musicfy GitHub:** https://github.com/publicappsrepo/musicfy_android
- **Original RetroMusicPlayer:** https://github.com/RetroMusicPlayer/RetroMusicPlayer
- **GPL-3.0 License:** https://www.gnu.org/licenses/gpl-3.0.html
- **Google Play Store:** https://play.google.com/store/apps/details?id=com.play_pause.musicplayer

---

**Made with ❤️ by the open-source community**

**Built on the foundation of RetroMusicPlayer**

---

*Last Updated: December 2025*

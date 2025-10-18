<div align="center">

# 🏛️ Aristotle AI

### *Ancient Wisdom Meets Modern Intelligence*

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://android.com)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin-purple.svg)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-blue.svg)](https://developer.android.com/jetpack/compose)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

[Download on Google Play](https://play.google.com/store/apps/details?id=com.kreggscode.aristotlequotes) • [View Documentation](https://kreggscode.github.io/Aristotle-Ai/) • [Report Bug](https://github.com/kreggscode/Aristotle-Ai/issues)

<img src="https://img.shields.io/badge/Min%20SDK-26-brightgreen" alt="Min SDK"/>
<img src="https://img.shields.io/badge/Target%20SDK-36-blue" alt="Target SDK"/>

</div>

---

## 📖 About

**Aristotle AI** is a premium Android application that brings the timeless wisdom of Aristotle to your fingertips. Explore thousands of quotes, major philosophical works, essays, and letters, all enhanced with AI-powered insights and explanations.

Whether you're a philosophy student, a wisdom seeker, or simply curious about one of history's greatest minds, Aristotle AI provides an immersive, beautiful experience combining ancient teachings with modern technology.

## ✨ Features

### 💭 **Extensive Quote Library**
- Browse thousands of carefully curated quotes from Aristotle
- Organized by categories: Ethics, Politics, Metaphysics, Science, and more
- Search and filter functionality
- Beautiful card-based UI with Ancient Greek themed colors

### 📚 **Complete Works Collection**
- **Major Works**: Nicomachean Ethics, Politics, Metaphysics, Poetics, Rhetoric
- **Essays**: In-depth philosophical essays
- **Letters**: Historical correspondence
- **Papers**: Academic writings and treatises
- Detailed summaries and key insights for each work

### 🤖 **AI-Powered Insights**
- Get modern explanations of ancient wisdom
- Ask questions about Aristotle's philosophy
- Context and interpretation for complex concepts
- Interactive chat interface

### 🌅 **Daily Inspiration**
- Quote of the Day feature
- Daily affirmations based on Aristotelian virtues
- Customizable notification times (default: 9 AM)
- Toggle notifications on/off in settings

### ⭐ **Personal Collection**
- Save favorite quotes
- Build your personal wisdom library
- Quick access to bookmarked content
- Sync across app sessions

### 🎨 **Premium Design**
- Stunning glassmorphic UI inspired by Ancient Greece
- Animated gradients and smooth transitions
- Material 3 Design components
- Dark mode optimized for OLED displays
- Edge-to-edge immersive experience

### 🔊 **Text-to-Speech**
- Listen to quotes in English and French
- Stop/Start controls
- Perfect for meditation or study

### 🌐 **Multilingual Support**
- English quotes and translations
- French translations available
- More languages coming soon

## 🛠️ Tech Stack

### Core
- **Language**: Kotlin 2.2.10
- **Min SDK**: 26 (Android 8.0 Oreo)
- **Target SDK**: 36 (Android 15)
- **Gradle**: 8.14.3

### Architecture & Libraries
- **UI**: Jetpack Compose + Material 3
- **Architecture**: MVVM (Model-View-ViewModel)
- **Database**: Room for local persistence
- **Async**: Kotlin Coroutines + Flow
- **Notifications**: WorkManager for daily quotes
- **Preferences**: DataStore for settings
- **Navigation**: Jetpack Navigation Compose
- **Dependency Injection**: Manual DI (lightweight)

### Key Dependencies
```gradle
// Compose
implementation("androidx.compose.ui:ui:1.7.6")
implementation("androidx.compose.material3:material3:1.3.1")

// Room Database
implementation("androidx.room:room-runtime:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")

// WorkManager
implementation("androidx.work:work-runtime-ktx:2.10.0")

// DataStore
implementation("androidx.datastore:datastore-preferences:1.1.1")
```

## 📋 Prerequisites

- **Android Studio**: Ladybug (2024.2.1) or later
- **JDK**: 17 or higher
- **Android SDK**: API 26-36
- **Git**: For version control
- **Device/Emulator**: Android 8.0+ for testing

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/kreggscode/Aristotle-Ai.git
cd Aristotle-Ai
```

### 2. Open in Android Studio

1. Launch Android Studio
2. Select "Open an Existing Project"
3. Navigate to the cloned directory
4. Click "OK"

### 3. Configure SDK (if needed)

Android Studio will auto-detect your SDK. If not, create/update `local.properties`:

```properties
sdk.dir=/path/to/your/Android/sdk
```

### 4. Sync Dependencies

Android Studio will automatically sync Gradle. If not:
- **File** → **Sync Project with Gradle Files**

Or run:
```bash
./gradlew build
```

### 5. Run the App

**Option A: Android Studio**
1. Select a device/emulator
2. Click the green "Run" button ▶️

**Option B: Command Line**
```bash
./gradlew installDebug
```

### 6. Build Release APK

```bash
./gradlew assembleRelease
```

Find the APK in: `app/build/outputs/apk/release/`

## 📦 Project Structure

```
Aristotle Ai/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/kreggscode/aristotlequotes/
│   │   │   │   ├── data/              # Data layer (Repository, DAO, API)
│   │   │   │   ├── model/             # Data models
│   │   │   │   ├── navigation/        # Navigation graph
│   │   │   │   ├── notifications/     # Notification handling
│   │   │   │   ├── ui/
│   │   │   │   │   ├── components/    # Reusable UI components
│   │   │   │   │   ├── screens/       # App screens
│   │   │   │   │   └── theme/         # Theme & styling
│   │   │   │   ├── viewmodel/         # ViewModels
│   │   │   │   └── MainActivity.kt
│   │   │   ├── assets/                # JSON data files
│   │   │   └── res/                   # Resources (layouts, strings, etc.)
│   │   └── build.gradle.kts
│   └── build.gradle.kts
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── README.md
```

## 🎨 Design

The app features a modern, premium design with:
- **Glassmorphic UI**: Frosted glass effect cards
- **Animated Gradients**: Dynamic background animations
- **Material 3**: Latest Material Design components
- **Edge-to-Edge**: Full-screen immersive experience
- **Dark Theme**: Optimized for OLED displays

## 📊 Data Files

The app uses JSON files in `assets/` folder:
- `aristotle_affirmations.json` - Daily affirmations
- `aristotle_biography.json` - Biographical information
- `aristotle_essays.json` - Essays and writings
- `aristotle_letters.json` - Historical letters
- `aristotle_major_works.json` - Major philosophical works
- `aristotle_papers.json` - Academic papers
- `dataset1.json` - Quote database
- `dataset2.json` - Additional quotes

**Note**: Currently, the JSON files contain placeholder data. Replace with actual Aristotle content.

## 🔧 Configuration

### Package Name
```
com.kreggscode.aristotlequotes
```

### Version
- Version Code: 4
- Version Name: 1.0

### Permissions
- `INTERNET` - For API calls
- `POST_NOTIFICATIONS` - For daily quote notifications
- `SCHEDULE_EXACT_ALARM` - For precise notification timing

## 🏗️ Build Variants

- **Debug**: Development build with debugging enabled
- **Release**: Production build with ProGuard/R8 optimization

## 🗺️ Roadmap

### Version 1.1 (Upcoming)
- [ ] Enhanced search with filters
- [ ] Quote sharing with beautiful cards
- [ ] More language translations
- [ ] Widget support
- [ ] Backup & restore favorites

### Version 1.2 (Future)
- [ ] Tablet optimization
- [ ] Wear OS companion app
- [ ] Audio narration for works
- [ ] Study mode with notes
- [ ] Community features

### Long-term
- [ ] Expand to other philosophers (Plato, Socrates)
- [ ] Interactive philosophy courses
- [ ] AR experiences for ancient Greece
- [ ] Cross-platform (iOS, Web)

## 🤝 Contributing

We welcome contributions! Here's how you can help:

### Ways to Contribute
- 🐛 Report bugs via [Issues](https://github.com/kreggscode/Aristotle-Ai/issues)
- 💡 Suggest features or improvements
- 📝 Improve documentation
- 🌐 Add translations
- 🎨 Design improvements
- 💻 Code contributions

### Development Workflow

1. **Fork** the repository
2. **Clone** your fork:
   ```bash
   git clone https://github.com/YOUR_USERNAME/Aristotle-Ai.git
   ```
3. **Create** a feature branch:
   ```bash
   git checkout -b feature/amazing-feature
   ```
4. **Make** your changes
5. **Test** thoroughly
6. **Commit** with clear messages:
   ```bash
   git commit -m "Add amazing feature"
   ```
7. **Push** to your fork:
   ```bash
   git push origin feature/amazing-feature
   ```
8. **Open** a Pull Request

### Code Style
- Follow Kotlin coding conventions
- Use meaningful variable/function names
- Comment complex logic
- Keep functions small and focused
- Write clean, readable code

### Commit Messages
- Use present tense ("Add feature" not "Added feature")
- Be descriptive but concise
- Reference issues when applicable (#123)

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2025 Kreggscode

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction...
```

## 📧 Contact & Support

- **Developer**: Kreggscode
- **Email**: [kreg9da@gmail.com](mailto:kreg9da@gmail.com)
- **GitHub**: [@kreggscode](https://github.com/kreggscode)
- **Website**: [kreggscode.github.io/Aristotle-Ai](https://kreggscode.github.io/Aristotle-Ai/)

### Support the Project

If you find this app useful:
- ⭐ Star the repository
- 🐛 Report bugs
- 💡 Suggest features
- 📢 Share with others
- ☕ [Buy me a coffee](https://www.buymeacoffee.com/kreggscode) (coming soon)

## 🙏 Acknowledgments

- **Aristotle** - For the timeless wisdom that inspired this app
- **Android Jetpack** - For the excellent libraries
- **Material Design** - For the beautiful design system
- **Kotlin Community** - For the amazing language and ecosystem
- **Open Source Community** - For inspiration and support

## 📱 Screenshots

<div align="center">

| Home Screen | Quote Detail | Works Library | AI Chat |
|-------------|--------------|---------------|----------|
| 🏠 | 💭 | 📚 | 🤖 |

*Screenshots coming soon*

</div>

## 🌟 Star History

[![Star History Chart](https://api.star-history.com/svg?repos=kreggscode/Aristotle-Ai&type=Date)](https://star-history.com/#kreggscode/Aristotle-Ai&Date)

---

<div align="center">

### Made with ❤️ by [Kreggscode](https://github.com/kreggscode)

**"Knowing yourself is the beginning of all wisdom." - Aristotle**

[⬆ Back to Top](#-aristotle-ai)

</div>

# QuestTugasLayout_0253

Single-screen Android layout assignment for Teknologi Informasi at Universitas
Muhammadiyah Yogyakarta (UMY).

## Technology

- Kotlin
- Jetpack Compose and Material 3
- Android Gradle Plugin with the repository's existing version catalog

## UI

The screen contains a resource-driven header, four responsive student cards, and
a bottom copyright label. Each card reuses `StudentCard` and displays the same
locally bundled UMY emblem on both sides. The first student's name uses the
platform cursive fallback; the other names use bold sans-serif text.

Static records are represented by `StudentUiModel` and assembled in
`StudentData.kt`. `strings.xml`, `colors.xml`, and `dimens.xml` contain the
visible copy, palette, and reusable sizing values.

## Build and run

Open the project in Android Studio, or run:

```text
gradlew.bat assembleDebug
```

Install the generated `app/build/outputs/apk/debug/app-debug.apk` on an
Android device or emulator.

## Assets and licensing

`app/src/main/res/drawable/umy_seal.png` was downloaded from the Wikimedia
Commons file [Universitas Muhammadiyah Yogyakarta Logo.png](https://commons.wikimedia.org/wiki/File:Universitas_Muhammadiyah_Yogyakarta_Logo.png),
which identifies the UMY emblem and provides its licensing information. The
image is bundled locally so the application has no runtime image dependency.
No external font is bundled; the Android `FontFamily.Cursive` fallback is used.

## Limitations

Visual verification depends on the available emulator or device. The project
does not require network access after installation.

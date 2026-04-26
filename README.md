# Euclid

A cross-platform interactive geometry diagram tool built with Java and JavaFX.


## Overview

Euclid is an open-source geometry diagram tool that lets users construct and visualize geometric shapes interactively. Click to place points, connect them with lines, draw circles, and more — with auto-calculated labels for lengths and angles.

Currently in early development. Desktop (Linux/Windows/Mac) is the primary target, with Android and iOS support planned via Gluon Mobile.

---

## Features (v1 Roadmap)

- [x] Interactive canvas with grid
- [x] Point tool — click to place points
- [ ] Line tool — connect two points
- [ ] Circle tool
- [ ] Triangle tool
- [ ] Polygon tool
- [ ] Angle arc tool
- [ ] Input panel — manually enter lengths, angles, coordinates
- [ ] Auto-calculated labels — side lengths and angles shown on diagram
- [ ] Export — PNG and SVG with all labels intact

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 26 | Core language |
| JavaFX 23 | Desktop UI |
| Gradle 9.4.1 | Build system |
| Gluon Mobile *(planned)* | Android & iOS support |

---

## Project Structure

```
euclid/
├── core/                        # Pure Java — math, models, no UI
│   └── src/main/java/
│       └── dev/euclid/core/
│           └── Point.java       # 2D point model (x, y)
├── desktop/                     # JavaFX UI — depends on core
│   └── src/main/java/
│       └── dev/euclid/desktop/
│           ├── App.java         # Entry point, launches JavaFX window
│           ├── MainLayout.java  # Root BorderPane layout
│           ├── Toolbar.java     # Tool selection panel (left)
│           ├── MainCanvas.java  # Drawing canvas (center)
│           └── ToolState.java   # Shared state between toolbar and canvas
├── settings.gradle
└── build.gradle
```

The `core` module is intentionally kept free of any UI dependencies. This ensures it can be reused across desktop, Android, and iOS targets without modification.

---

## Getting Started

### Prerequisites

- Java JDK 26 — [download](https://jdk.java.net/26/)
- Gradle 9.4.1 — [download](https://gradle.org/releases/) or install via [SDKMAN](https://sdkman.io/)

Verify your setup:

```bash
java -version
gradle -version
```

### Clone the repository

```bash
git clone https://github.com/your-username/euclid.git
cd euclid
```

### Generate Gradle wrapper

```bash
gradle wrapper
```

### Build

```bash
./gradlew build
```

### Run

```bash
./gradlew :desktop:run
```

---

## Architecture

Euclid follows a clean separation between data and UI:

- **`core`** — contains all geometry models and math logic. No JavaFX, no UI code. Will be shared across all platform targets.
- **`desktop`** — contains the JavaFX application. Depends on `core` but `core` has no knowledge of `desktop`.
- **`ToolState`** — acts as a bridge between `Toolbar` and `MainCanvas`. They never communicate directly; both read from and write to `ToolState`.

---

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

---

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.

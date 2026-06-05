<h1 align="center">Sokoban</h1>
A Java implementation of the classic Sokoban puzzle game, built for the POO (Object-Oriented Programming) course at IUL/ISTA. The player controls a forklift (`Empilhadora`) and must push crates (`Caixotes`) onto target tiles (`Alvos`) across multiple levels.

<img src="https://github.com/RuiSlayer/demo_videos/blob/main/sokoban_demo.gif" width="1080" alt="Demo">

---

## Dependencies
### Runtime
- **Java 17+** (OpenJDK recommended)
### Build Tool
- **Gradle** (via wrapper — no installation required)
### Internal Library
- `pt.iul.ista.poo` — School-provided GUI and utility library (located in `lib/src/`)
  - `pt.iul.ista.poo.gui` — `ImageMatrixGUI`, `ImageTile` (tile-based graphical interface)
  - `pt.iul.ista.poo.utils` — `Point2D`, `Vector2D`, `Direction`
  - `pt.iul.ista.poo.observer` — `Observer`, `Observed` (event system)
  
---

## Project Structure
```
.
├── build.gradle      # Gradle build configuration
├── settings.gradle   # Gradle project settings
├── gradlew           # Gradle wrapper (Linux/macOS)
├── gradlew.bat       # Gradle wrapper (Windows)
├── gradle/           # Gradle wrapper binaries
├── images/           # Game sprite assets (.png)
├── levels/           # Level definition files (level0.txt, level1.txt, ...)
├── scores/           # Leaderboard save files
├── lib/
│   └── src/          # POO library source files (pt.iul.ista.poo.*)
├── src/
│   ├── AbstractObjs/ # Base abstract classes (AbstractObjs, Chao, Parede)
│   ├── Active_Objs/  # Interactive game objects (Alvo, Bateria, Buraco, Gelo, ...)
│   ├── Movabel_Objs/ # Movable objects (Empilhadora, Caixote, BigStone, ...)
│   └── sokoban/
│       └── starter/  # Game engine (Main, SokobanGame, Map, LoadLevel, ...)
└── README.md
```
---
## Installation

### 1. Install Java (Windows)
```powershell
winget install Microsoft.OpenJDK.17
```
### 2. Install Java (macOS)
```bash
brew install --cask temurin@17
```

### 3. Install Java (Arch Linux)
```bash
sudo pacman -S jdk17-openjdk
sudo archlinux-java set java-17-openjdk
```

### 4. Install Java (Debian/Ubuntu)
```bash
sudo apt install openjdk-17-jdk
```

### 5. Install Java (Fedora)
```bash
sudo dnf install java-17-openjdk-devel
```

Verify your installation:
```bash
java -version
javac --version
```

> No Gradle installation is needed — the project includes a Gradle wrapper (`gradlew`) that downloads and manages Gradle automatically.
---
## Building & Running
### Linux / macOS
```bash
# Build and run
./gradlew run
# Build only
./gradlew build
```
### Windows
```bash
# Build and run
gradlew.bat run
# Build only
gradlew.bat build
```
> ⚠️ Always run from the **project root directory** so the game can find the `images/`, `levels/`, and `scores/` folders.
---
## Cleaning
To remove all compiled files and build artifacts:
```bash
# Linux/macOS
./gradlew clean
# Windows
gradlew.bat clean
```
---
## Gradle Task Reference
| Command | Description |
|---|---|
| `./gradlew run` | Build (if needed) and run the game |
| `./gradlew build` | Compile and package the project |
| `./gradlew clean` | Remove all generated build files |
| `./gradlew tasks` | List all available Gradle tasks |
---
## Adding Levels
Level files are plain text files placed in the `levels/` folder and named `level0.txt`, `level1.txt`, etc.
Each character in the file maps to a game object:
| Character | Object |
|---|---|
| `#` | Parede (Wall) |
| ` ` | Chao (Floor) |
| `E` | Empilhadora (Player/Forklift) |
| `C` | Caixote (Crate) |
| `A` | Alvo (Target) |
| `B` | Buraco (Hole) |
| `G` | Gelo (Ice) |
| `M` | Martelo (Hammer) |
| `T` | Bateria (Battery) |
| `P` | Portal_Azul (Blue Portal) |
To add a new level, create `levels/levelN.txt` (where N follows the last existing level number). The game will load it automatically via `getNivelNr()`.
---
## Gameplay
- **Arrow keys** — Move the forklift
- **R** — Restart the current level
- Push all crates onto the target tiles to complete a level
- Collect batteries to gain extra moves
- Avoid holes — crates and the player can fall in
- Ice tiles cause sliding movement
- Hammers can break cracked walls
- Portals teleport crates to a new position
---
## Architecture Overview
| Class | Role |
|---|---|
| `Main` | Entry point — initialises `ImageMatrixGUI` and starts the game |
| `SokobanGame` | Core game loop, implements `Observer` to handle key input |
| `Map` | Holds all game objects for the current level |
| `LoadLevel` | Parses level `.txt` files and builds the `Map` |
| `AbstractObjs` | Base class for all tile objects, implements `ImageTile` |
| `Movabel` | Base class for movable objects, handles movement logic |
| `ActiveObjs` | Base class for interactive/reactive objects |
| `Jogador_Score` | Tracks the player's score and move count |
| `LeaderBoard` | Stores and displays high scores |
| `LevelMesages` | Handles level start/end messages |

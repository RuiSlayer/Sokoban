# Sokoban - RuiCosta_93529

A Java implementation of the classic Sokoban puzzle game, built for the POO (Object-Oriented Programming) course at IUL/ISTA. The player controls a forklift (`Empilhadora`) and must push crates (`Caixotes`) onto target tiles (`Alvos`) across multiple levels.

---

## Dependencies

### Runtime
- **Java 17+** (OpenJDK recommended)

### Internal Library
- `pt.iul.ista.poo` — School-provided GUI and utility library (located in `lib/src/`)
  - `pt.iul.ista.poo.gui` — `ImageMatrixGUI`, `ImageTile` (tile-based graphical interface)
  - `pt.iul.ista.poo.utils` — `Point2D`, `Vector2D`, `Direction`
  - `pt.iul.ista.poo.observer` — `Observer`, `Observed` (event system)

---

## Project Structure

```
.
├── images/           # Game sprite assets (.png)
├── levels/           # Level definition files (level0.txt, level1.txt, ...)
├── lib/
│   └── src/          # POO library source files (pt.iul.ista.poo.*)
├── src/
│   ├── AbstractObjs/ # Base abstract classes (AbstractObjs, Chao, Parede)
│   ├── Active_Objs/  # Interactive game objects (Alvo, Bateria, Buraco, Gelo, ...)
│   ├── Movabel_Objs/ # Movable objects (Empilhadora, Caixote, BigStone, ...)
│   └── sokoban/
│       └── starter/  # Game engine (Main, SokobanGame, Map, LoadLevel, ...)
├── build.sh          # Build script
└── README.md
```

---

## Installation

### 1. Install Java (Arch Linux)

```bash
sudo pacman -S jdk17-openjdk
sudo archlinux-java set java-17-openjdk
```

Verify:
```bash
javac --version
java --version
```

### 2. Install Java (Debian/Ubuntu)

```bash
sudo apt install openjdk-17-jdk
```

### 3. Install Java (Fedora)

```bash
sudo dnf install java-17-openjdk-devel
```

---

## Building

Make the build script executable (first time only):

```bash
chmod +x build.sh
```

Then build the project:

```bash
bash build.sh
```

This will:
1. Compile the `pt.iul.ista.poo` library from `lib/src/`
2. Compile all project source files in `src/`
3. Package everything into `sokoban.jar`

---

## Running

```bash
bash build.sh run
```

Or directly:

```bash
java -jar sokoban.jar
```

> ⚠️ Always run from the **project root directory** so the game can find the `images/` and `levels/` folders.

---

## Cleaning

To remove all compiled files and generated artifacts:

```bash
bash build.sh clean
```

Files removed: `build/`, `lib/bin/`, `lib/poo-lib.jar`, `sources.txt`, `lib_sources.txt`, `manifest.txt`, `sokoban.jar`.

---

## Build Script Reference

| Command | Description |
|---|---|
| `bash build.sh` | Build the project (default) |
| `bash build.sh build` | Same as above |
| `bash build.sh run` | Run the game |
| `bash build.sh clean` | Remove all generated files |

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


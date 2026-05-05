#!/bin/bash
set -e

build() {
    echo ">> Compiling library..."
    find lib/src -name "*.java" > lib_sources.txt
    mkdir -p lib/bin
    javac -d lib/bin @lib_sources.txt
    jar -cvf lib/poo-lib.jar -C lib/bin/ .

    echo ">> Compiling project..."
    mkdir -p build
    find src -name "*.java" > sources.txt
    javac -encoding ISO-8859-1 -cp lib/poo-lib.jar -d build @sources.txt

    echo ">> Packaging JAR..."
    cd build && jar -xf ../lib/poo-lib.jar && cd ..
    echo "Main-Class: sokoban.starter.Main" > manifest.txt
    jar -cvfm sokoban.jar manifest.txt -C build/ .

    echo ">> Done!"
}

is_up_to_date() {
    # Returns 0 (true) if sokoban.jar exists and is newer than all source files
    if [ ! -f sokoban.jar ]; then
        return 1
    fi
    # Find any source file newer than sokoban.jar
    newer=$(find src lib/src -name "*.java" -newer sokoban.jar 2>/dev/null)
    [ -z "$newer" ]
}

case "$1" in
  run)
    if is_up_to_date; then
        echo ">> Build is up to date, skipping build..."
    else
        echo ">> JAR not found or sources changed, building first..."
        build
    fi
    echo ">> Running..."
    java -jar sokoban.jar
    ;;

  clean)
    echo ">> Cleaning..."
    rm -rf build/ lib/bin/ lib/poo-lib.jar lib_sources.txt sources.txt manifest.txt sokoban.jar
    echo ">> Clean done!"
    ;;

  build|"")
    if is_up_to_date; then
        echo ">> Nothing to do, build is already up to date."
        echo ">> Use 'bash build.sh clean' first to force a rebuild."
    else
        build
        echo ">> Run with: bash build.sh run"
    fi
    ;;

  *)
    echo "Usage: bash build.sh [build|run|clean]"
    ;;
esac

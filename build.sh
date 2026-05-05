#!/bin/bash
set -e

case "$1" in
  run)
    echo ">> Running..."
    java -jar sokoban.jar
    ;;

  clean)
    echo ">> Cleaning..."
    rm -rf build/ lib/bin/ lib/poo-lib.jar lib_sources.txt sources.txt manifest.txt sokoban.jar
    echo ">> Clean done!"
    ;;

  build|"")
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

    echo ">> Done! Run with: bash build.sh run"
    ;;

  *)
    echo "Usage: bash build.sh [build|run|clean]"
    ;;
esac

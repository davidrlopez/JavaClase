#!/bin/bash
# Compile all Java files with proper classpath
cd src
javac -cp . -d ../bin arrays/*.java operations/*.java
echo "Compilation completed"
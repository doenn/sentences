#!/bin/bash

javac src/main/java/sentences/*.java
javac -cp junit-platform-console-standalone-1.1.0.jar:src/main/java/sentences:src/test/java/sentences src/test/java/sentences/*.java src/main/java/sentences/*.java
rm -rf doc/javadoc
javadoc -html5 -cp junit-platform-console-standalone-1.1.0.jar:src/main/java/sentences:src/test/java/sentences -d doc/javadoc -sourcepath src/main/java:src/test/java -subpackages sentences

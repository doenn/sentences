#!/bin/bash
cd src/test/java
java -jar ../../../junit-platform-console-standalone-1.1.0.jar --cp sentences:../../main/java:../resources:. --select-class sentences.SentencesTest
cd ../../../

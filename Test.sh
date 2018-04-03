#!/bin/bash
rm -rf report/junit
cd src/test/java
java -jar ../../../junit-platform-console-standalone-1.1.0.jar --reports-dir ../../../reports/junit --cp sentences:../../main/java:../resources:. --select-class sentences.SentencesTest
cd ../../../

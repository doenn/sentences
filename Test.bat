cd src/test/java
rmdir /S /Q ..\..\..\report\junit
rmdir /S /Q ..\..\..\report\allure
java -jar ../../../junit-platform-console-standalone-1.1.0.jar --reports-dir ../../../report/junit --cp sentences;../../main/java;../resources;. --select-class sentences.SentencesTest
cd ../../../
mkdir report\allure
allure-2.6.0\bin\allure.bat generate report\junit --output report\allure
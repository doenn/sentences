cd dist
rmdir /S /Q sentences
mkdir sentences
copy /Y ..\src\test\java\sentences\*.class .\sentences
copy /Y ..\src\main\java\sentences\*.class .\sentences
copy /Y ..\junit-platform-console-standalone-1.1.0.jar .\sentences
xcopy /S /Y ..\src\test\resources sentences
jar -cfm SentenceTests.jar MANIFEST.TXT sentences
cd ..
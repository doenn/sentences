# Sentences #

**Sentences**  is a sentence parser which returns the number of words in a sentence, along with the longest word. Accompanying tests are present in the form of unit tests.

The **Sentences** parser was written in Java 10 and unit tests were written with JUnit 5.

## Assumptions ##

Detailed assumptions are listed per-test, however in general, the following was assumed:

* The sentence parser function could return any datatype.
* The "Length" and longest words of a sentence were originally thought to mean "sentence length" and "words with the most letters." Based on the example provided: "The cow jumped over the moon." returning 6 and jumped, 6 is both the largest word letter count, and total word count. It seems the largest word letter count could have been the intended requirement here, so some refactoring could be needed.
* More than one word could be returned if they each had the most letters.
	* An addendum to this is that the same word would only be returned once.
* The largest words returned could be returned in any order.
* The function could throw exceptions.

## Platforms ##

**Sentences** should compile and execute on most Java 10-compliant systems, but build and test scripts have currently been written on:

* Windows
* Linux (Tested on OpenSUSE)
* Mac (Untested)

## Requirements ##

The Java JDK is required. Java 10 was used, but Java 9 should run the **Sentences**. Prior versions of Java may not run.

## Running on Windows ##

**Sentences** will work on both Windows and Linux, but Linux scripts are less-maintained and therefore less stable.

* Build via **Build.bat**
	* Builds the source.
* Run via **Run.bat**
	* Runs the **Sentences** parser app only. You can tweak the parser input by editing the main method in the Main class. Alternatively, you can use JShell for interactive REPL-style input. 
* Test via **Test.bat**
	* Runs the Unit tests without filtering.
* View reports in **report/allure.**

## Optional Features ##

There are also some optional features provided:

* You can build the **SentenceTests.jar** executor. This is experimental.
	* The jar is buildable via **Build_SentenceTests.bat**
	* The jar is runnable via **SentenceTests.bat**
* You can also start a report server with the latest results by running **StartWinReportServer.bat**. This server was provided by the Allure project, but will display the latest test results in your browser.

## Documentation ##

The **doc** folder includes:

* The source and test **javadoc**. These were combined since the main application requiring documentation could be either the SUT or test harness.
* Test Checklist: long-term test coverage checkllist with pass/fail results. Also includes some notes on particular coverage areas.
* Test Suite spreadsheet. This includes every test in a Microsoft Excel Workbook.

## Directory Structure Notes ##

Some comments on the repository layout:

* Source and test files are included in the **src** directory.
	* Input data is provided in the form of **.csv**s, which are also in the **src** directory.
* The JUnit5 standalone console and classes were provided for convenience (Maven/Gradle/Docker setup not necessary, though these would be provided next). Jenkins was also setup, though Jenkins config files were not yet provided.
* The allure-2.6.0 Windows distributable was provided for script purposes and for convenience.
* The experimental **SentenceTests.jar** executor is in the **dist** dir, but runnable from the top-level **.bat** file.
* A Windows-linefeed replacement script was provided in case quick mixed Windows & Linux script editing is performed (for convenience).
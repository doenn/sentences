package sentences;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;


import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;


import java.io.*;


import java.lang.Number;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import sentences.*;

import sentences.SentencesTest;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
* Experimental Unit Test Runner for the Sentences App.
* Kicks off Unit test execution. Contains main method when run from a JAR.
*/
public class SentenceTests {


	/**
	* No-arg constructor.
	*
	*/
	public SentenceTests(){

	}


	public static void main(String[] args){


		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()	// Discover tests
			.selectors(
      				selectPackage("sentences"),
       				selectClass(sentences.SentencesTest.class))
    			//.filters(								// TO-DO: Support filtering by unit/smoke test and sub-suites. Filtering would be parameterized.
     			//	includeClassNamePatterns(".*Tests"))
    			.build();

		Launcher launcher = LauncherFactory.create();

		TestPlan testPlan = launcher.discover(request);					

		TestExecutionListener listener = new SummaryGeneratingListener();
		launcher.registerTestExecutionListeners(listener);

		launcher.execute(request);							// Launch test
		
		PrintWriter defaultWriter = new PrintWriter(System.out);

		TestExecutionSummary testExecutionSummary = ((SummaryGeneratingListener)listener).getSummary();
		testExecutionSummary.printTo(defaultWriter);




	}



}
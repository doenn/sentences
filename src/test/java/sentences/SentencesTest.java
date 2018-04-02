package sentences;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.Number;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class SentencesTest{


	@Nested
	public class wordTests{

		@ParameterizedTest
		@CsvFileSource(resources = "/Word/Case-Sentitivity/Verify words are matched regardless of case.csv") 
		@DisplayName ("Verify words are matched regardless of case.")
		@Tag ("Unit")
		public void matchAnyCaseTest(String sentence, int expectedLength, String longestWord){

			Map<String, Object> results;


			Pattern expectedWordPattern = Pattern.compile("([^\\s]+)(\\s)?");		// Tokenize by spaces
			Matcher expectedWordMatcher = expectedWordPattern.matcher(longestWord);


			List expectedLongestWords = new ArrayList<String>();

			while (expectedWordMatcher.find()){		// Parse expectedLongestWords arguments into ArrayList
				String expectedWordMatch = expectedWordMatcher.group(1);			
				expectedLongestWords.add(expectedWordMatch);
			}
	

			Sentences sentences = new Sentences();
			results = sentences.parseSentence(sentence);


			Integer sentenceLength = (Integer)results.get("Length");
			List longestWords = (ArrayList<?>)results.get("Longest Words");

			assertEquals(longestWords.size(), expectedLongestWords.size());

			for (String expectedWord :  (ArrayList<String>)expectedLongestWords){

				long sameWordCount = ((ArrayList<String>)longestWords).stream()
							.filter((String returnedWord)->{
								return expectedWord.equals(returnedWord);
							})
							.count();
				assertEquals(sameWordCount, 1);					// Only one match, no more.
			}
		

			assertEquals(sentenceLength, Integer.valueOf(expectedLength));
		}

		@ParameterizedTest
		@CsvFileSource(resources = "/Word/Case-Sentitivity/Verify words in capital letters only are matched.csv") 
		@DisplayName ("Verify words in capital letters only are matched")
		@Tag ("Unit")
		public void matchOnlyCapsTest(String sentence, int expectedLength, String longestWord){

			Map<String, Object> results;


			Pattern expectedWordPattern = Pattern.compile("([^\\s]+)(\\s)?");		// Tokenize by spaces
			Matcher expectedWordMatcher = expectedWordPattern.matcher(longestWord);


			List expectedLongestWords = new ArrayList<String>();

			while (expectedWordMatcher.find()){		// Parse expectedLongestWords arguments into ArrayList
				String expectedWordMatch = expectedWordMatcher.group(1);
				expectedLongestWords.add(expectedWordMatch);
			}
	

			Sentences sentences = new Sentences();
			results = sentences.parseSentence(sentence);


			Integer sentenceLength = (Integer)results.get("Length");
			List longestWords = (ArrayList<?>)results.get("Longest Words");

			for (String actualWord : (ArrayList<String>)longestWords){
				System.out.println("Actual: " + actualWord);
			}

			assertEquals(longestWords.size(), expectedLongestWords.size());

			for (String expectedWord :  (ArrayList<String>)expectedLongestWords){

				long sameWordCount = ((ArrayList<String>)longestWords).stream()
							.filter((String returnedWord)->{
								return expectedWord.equals(returnedWord);
							})
							.count();
				assertEquals(sameWordCount, 1);					// Only one match, no more.
			}
		

			assertEquals(sentenceLength, Integer.valueOf(expectedLength));
		}

	}

	@Nested
	public class spacesTests{

		@ParameterizedTest
		@CsvFileSource(resources = "/Spaces/Spaces/Verify any number of spaces between words will not affect matching.csv") 
		@DisplayName ("Verify any number of spaces between words will not affect matching")
		@Tag ("Unit")
		public void variableSpaceCountTest(String sentence, int expectedLength, String longestWord){		

			Map<String, Object> results;


			Pattern expectedWordPattern = Pattern.compile("([^\\s]+)(\\s)?");		// Tokenize by spaces
			Matcher expectedWordMatcher = expectedWordPattern.matcher(longestWord);


			List expectedLongestWords = new ArrayList<String>();

			while (expectedWordMatcher.find()){		// Parse expectedLongestWords arguments into ArrayList
				String expectedWordMatch = expectedWordMatcher.group(1);
				expectedLongestWords.add(expectedWordMatch);
			}
	

			Sentences sentences = new Sentences();
			results = sentences.parseSentence(sentence);


			Integer sentenceLength = (Integer)results.get("Length");
			List longestWords = (ArrayList<?>)results.get("Longest Words");


			assertEquals(longestWords.size(), expectedLongestWords.size());

			for (String expectedWord :  (ArrayList<String>)expectedLongestWords){

				long sameWordCount = ((ArrayList<String>)longestWords).stream()
							.filter((String returnedWord)->{
								return expectedWord.equals(returnedWord);
							})
							.count();
				assertEquals(sameWordCount, 1);					// Only one match, no more.
			}
		

			assertEquals(sentenceLength, Integer.valueOf(expectedLength));
		}

	}



}
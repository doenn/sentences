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

	@ParameterizedTest
	@CsvFileSource(resources = "/InputData.csv") 
	@DisplayName ("Verify words are matched regardless of case.")
	@Tag ("System")
	public void parseSentence(String sentence, int expectedLength, String longestWord){

		Map<String, Object> results;


		Pattern expectedWordPattern = Pattern.compile("(\\s)?+(.+)(\\s)?+");		// Tokenize by spaces
		Matcher expectedWordMatcher = expectedWordPattern.matcher(longestWord);


		List expectedLongestWords = new ArrayList<String>();

		while (expectedWordMatcher.find()){		// Parse expectedLongestWords arguments into ArrayList
			String expectedWordMatch = expectedWordMatcher.group(2);			
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

	@Nested
	public class SentencesNestedTest{

		@Test
		@DisplayName ("Verify 2+1 = 3")
		@Tag ("System")
		public void parseSentenceNested(){
			assertEquals(3, 2+1);
			System.out.println("Sentence parser nested test.");
		}
	}

}
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


public class SentencesTest{

	@ParameterizedTest
	@CsvFileSource(resources = "/InputData.csv") 
	@DisplayName ("Verify words are matched regardless of case.")
	@Tag ("System")
	public void parseSentence(String sentence, int expectedLength, String longestWord){

		Map<String, Object> results;


		Sentences sentences = new Sentences();
		results = sentences.parseSentence(sentence);

		Integer sentenceLength = (Integer)results.get("Length");
		List longestWords = (ArrayList<?>)results.get("Longest Words");
		boolean sameWords = ((ArrayList<String>)longestWords).stream().filter((String returnedWord)->{
			return longestWord.equals(returnedWord);
		}).allMatch((String sameReturnedWord)->{
			return longestWord.equals(sameReturnedWord);
		});

		assertEquals(sentenceLength, Integer.valueOf(expectedLength));
		assertEquals(sameWords, true);
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
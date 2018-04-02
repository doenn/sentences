package sentences;

import java.lang.Number;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Sentences {

	private Map<String, Object> results;						// Parsed results returned in Map containing sentence Length and Longest Words

	/**
	* No-arg constructor. Initializes the private result member.
	*
	*/
	public Sentences(){
		results = new HashMap<String, Object>();
		results.put("Length", Integer.valueOf(0));				// Initialize sentence length as 0
		results.put("Longest Words", new ArrayList<String>());			// Longest Words ArrayList begins with size of 0
	}

	/**
	* Parses a sentence and returns both the word count and longest word.
	* 
	* @param sentence a sentence String.
	* @return the word count and longest word.
	*/
	public Map parseSentence(String sentence){
			

		Pattern wordPattern = Pattern.compile("\\w+");
		Matcher wordMatcher = wordPattern.matcher(sentence);

		List longestWords = (ArrayList<?>)results.get("Longest Words");
		Integer wordCount = 0;							// Initialize as 0

		while (wordMatcher.find()){
			final String wordMatch = wordMatcher.group();
			wordCount++;


			boolean sameLengthExists = ((ArrayList<String>)longestWords).stream().filter((String priorMatch)->{
				return wordMatch.length() == priorMatch.length();
			}).anyMatch((String sameLengthPriorMatch)->{
				return !wordMatch.equalsIgnoreCase(sameLengthPriorMatch);	// Do not include new match when it already exists
			});

			if (sameLengthExists){
				longestWords.add(wordMatch);		// Append match to end of list
			}

			((ArrayList<String>)longestWords).removeIf((String priorMatch)->{		
				return wordMatch.length() > priorMatch.length();		// Remove shorter-length words that were previously matched.
			});


			if (longestWords.size() == 0){
				longestWords.add(wordMatch);
			}
			
		}
		Integer sentenceLength = (Integer)results.get("Length");
		sentenceLength = Integer.valueOf(wordCount);
		results.put("Length", sentenceLength);	

		for (String longestWord : (ArrayList<String>)longestWords){
			System.out.println("Longest word: " + longestWord);
		}
		System.out.println("Word count: " + wordCount);

		

		return results;
	}

}
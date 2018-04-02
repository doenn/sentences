package sentences;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Sentences {

	private int result;

	/**
	* No-arg constructor. Initializes the private result member.
	*
	*/
	public Sentences(){
		result = 0;

	}

	/**
	* Parses a sentence and returns both the word count and longest word.
	* 
	* @param sentence a sentence String.
	* @return the word count and longest word.
	*/
	public int parseSentence(String sentence){
			
		String wordMatch = null;

		Pattern wordPattern = Pattern.compile("\\w+");
		Matcher wordMatcher = wordPattern.matcher(sentence);
	
		while (wordMatcher.find()){
			wordMatch = wordMatcher.group();
			System.out.println("Word: " + wordMatch);
		}

		return result;
	}

}
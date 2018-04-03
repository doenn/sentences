package sentences;

import sentences.*;
import sentences.Sentences.NotSingleSentenceException;

/**
 * Executes the Sentences application.
*/

public class Main {

	public static void main(String[] args){
		
		Sentences sentences = new Sentences();
		try {
			sentences.parseSentence("I just returned from Iceland.");
		}
		catch(NotSingleSentenceException notSingleSentenceException){
			notSingleSentenceException.printStackTrace();
		}
	

	}

}
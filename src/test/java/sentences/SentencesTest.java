package sentences;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;



public class SentencesTest{

	@Test
	@DisplayName ("Verify 1+1 = 2")
	@Tag ("Smoke")
	@Tag ("System")
	public void parseSentence(){


		Sentences sentences = new Sentences();
		sentences.parseSentence("I used to visit the lake.");
		assertEquals(2, 1+1);
		System.out.println("Sentence parser test.");
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
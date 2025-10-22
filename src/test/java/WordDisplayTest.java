import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordDisplayTest {

	@Test
	void creates_word_display_with_secret_word() {
		WordDisplay display = new WordDisplay("foobar");
		assertNotNull(display);
	}

	@Test
	void shows_all_underscores_initially() {
		WordDisplay display = new WordDisplay("foobar");
		assertEquals("______", display.getCurrentDisplay());
	}

	@Test
	void reveals_guessed_letter_that_appears_once() {
		WordDisplay display = new WordDisplay("foobar");
		display.guessLetter('b');
		assertEquals("___b__", display.getCurrentDisplay());
	}

	@Test
	void reveals_all_occurrences_of_guessed_letter() {
		WordDisplay display = new WordDisplay("foobar");
		display.guessLetter('o');
		assertEquals("_oo___", display.getCurrentDisplay());
	}

	@Test
	void multiple_guesses_accumulate() {
		WordDisplay display = new WordDisplay("foobar");
		display.guessLetter('f');
		display.guessLetter('o');
		display.guessLetter('a');
		assertEquals("foo_a_", display.getCurrentDisplay());
	}

	@Test
	void word_not_complete_initially() {
		WordDisplay display = new WordDisplay("foobar");
		assertFalse(display.isWordComplete());
	}

	@Test
	void word_complete_when_all_letters_guessed() {
		WordDisplay display = new WordDisplay("foobar");
		display.guessLetter('f');
		display.guessLetter('o');
		display.guessLetter('b');
		display.guessLetter('a');
		display.guessLetter('r');
		assertTrue(display.isWordComplete());
	}
}

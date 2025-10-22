import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class HangmanGameTest {

	@Mock
	ScannerWrapper scannerWrapper;

	@Mock
	SystemWrapper systemWrapper;

	@InjectMocks
	HangmanGame game;

	@BeforeEach
	void setUp() {
		scannerWrapper = mock(ScannerWrapper.class);
		systemWrapper = mock(SystemWrapper.class);
		game = new HangmanGame(scannerWrapper, systemWrapper);
	}

	@Test
	void game_asks_user_to_enter_word() {
		when(scannerWrapper.readLine()).thenReturn("test");
		game.setupGame();
		verify(systemWrapper).printLine("Enter a word:");
	}

	@Test
	void game_clears_console_after_word_entered() {
		when(scannerWrapper.readLine()).thenReturn("test");
		game.setupGame();
		verify(systemWrapper, times(1000)).printLine();
	}

	@Test
	void game_displays_initial_masked_word() {
		when(scannerWrapper.readLine()).thenReturn("test");
		game.setupGame();
		verify(systemWrapper).printLine("____");
	}

	@Test
	void game_asks_for_guess_and_displays_update() {
		when(scannerWrapper.readLine()).thenReturn("test");
		when(scannerWrapper.readChar()).thenReturn('t');
		game.setupGame();
		game.playOneRound();
		verify(systemWrapper).printLine("Enter a guess:");
		verify(systemWrapper, atLeastOnce()).printLine("t__t");
	}

	@Test
	void game_congratulates_when_completed() {
		when(scannerWrapper.readLine()).thenReturn("hi");
		when(scannerWrapper.readChar()).thenReturn('h', 'i');
		game.play();
		verify(systemWrapper).printLine("Congratulations! You won!");
	}

	@Test
	void game_flow_correct_order_guessing() {
		when(scannerWrapper.readLine()).thenReturn("ab");
		when(scannerWrapper.readChar()).thenReturn('a', 'b');
		game.play();
		verify(systemWrapper).printLine("Enter a word:");
		verify(systemWrapper, times(1000)).printLine();
		verify(systemWrapper).printLine("__");
		verify(systemWrapper, atLeast(2)).printLine("Enter a guess:");
		verify(systemWrapper, atLeastOnce()).printLine("a_");
		verify(systemWrapper, atLeastOnce()).printLine("ab");
		verify(systemWrapper).printLine("Congratulations! You won!");
	}

	@Test
	void game_flow_correct_order_guess_b_first() {
		when(scannerWrapper.readLine()).thenReturn("ab");
		when(scannerWrapper.readChar()).thenReturn('b', 'a');
		game.play();
		verify(systemWrapper).printLine("Enter a word:");
		verify(systemWrapper, times(1000)).printLine();
		verify(systemWrapper).printLine("__");
		verify(systemWrapper, atLeast(2)).printLine("Enter a guess:");
		verify(systemWrapper, atLeastOnce()).printLine("_b");
		verify(systemWrapper, atLeastOnce()).printLine("ab");
		verify(systemWrapper).printLine("Congratulations! You won!");
	}

	@Test
	void game_skips_to_win_if_word_empty() {
		when(scannerWrapper.readLine()).thenReturn("");
		game.play();
		verify(systemWrapper).printLine("Congratulations! You won!");
	}

	@Test
	void game_displays_updated_word_after_wrong_guess() {
		when(scannerWrapper.readLine()).thenReturn("dog");
		when(scannerWrapper.readChar()).thenReturn('x', 'd', 'o', 'g');
		game.play();
		verify(systemWrapper, atLeastOnce()).printLine("___");
		verify(systemWrapper, atLeastOnce()).printLine("d__");
		verify(systemWrapper, atLeastOnce()).printLine("do_");
		verify(systemWrapper, atLeastOnce()).printLine("dog");
		verify(systemWrapper).printLine("Congratulations! You won!");
	}

	@Test
	void game_displays_same_state_on_repeated_guess() {
		when(scannerWrapper.readLine()).thenReturn("apple");
		when(scannerWrapper.readChar()).thenReturn('a', 'p', 'p', 'l', 'e');
		game.play();
		verify(systemWrapper, atLeastOnce()).printLine("apple");
		verify(systemWrapper).printLine("Congratulations! You won!");
	}

	@Test
	void game_handles_single_letter_word() {
		when(scannerWrapper.readLine()).thenReturn("x");
		when(scannerWrapper.readChar()).thenReturn('x');
		game.play();
		verify(systemWrapper).printLine("_");
		verify(systemWrapper).printLine("x");
		verify(systemWrapper).printLine("Congratulations! You won!");
	}

	@Test
	void game_displays_multiple_same_letters_correctly() {
		when(scannerWrapper.readLine()).thenReturn("banana");
		when(scannerWrapper.readChar()).thenReturn('a', 'b', 'n');
		game.play();
		verify(systemWrapper, atLeastOnce()).printLine("______");
		verify(systemWrapper, atLeastOnce()).printLine("_a_a_a");
		verify(systemWrapper, atLeastOnce()).printLine("banana");
		verify(systemWrapper).printLine("Congratulations! You won!");
	}

	@Test
	void game_handles_uppercase_word_and_lowercase_guesses() {
		when(scannerWrapper.readLine()).thenReturn("HELLO");
		when(scannerWrapper.readChar()).thenReturn('h', 'e', 'l', 'o');
		game.play();
		verify(systemWrapper, atLeastOnce()).printLine("hello");
		verify(systemWrapper).printLine("Congratulations! You won!");
	}

}

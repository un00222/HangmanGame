import java.util.HashSet;
import java.util.Set;

public class WordDisplay {
	private final String secretWord;
	private final Set<Character> guessedLetters = new HashSet<>();

	public WordDisplay(String secretWord) {
		this.secretWord = secretWord.toLowerCase();
	}

	public void guessLetter(char letter) {
		guessedLetters.add(Character.toLowerCase(letter));
	}

	public String getCurrentDisplay() {
		StringBuilder display = new StringBuilder();
		for (char c : secretWord.toCharArray()) {
			if (guessedLetters.contains(c)) {
				display.append(c);
			} else {
				display.append('_');
			}
		}
		return display.toString();
	}

	public boolean isWordComplete() {
		for (char c : secretWord.toCharArray()) {
			if (!guessedLetters.contains(c)) {
				return false;
			}
		}
		return true;
	}
}

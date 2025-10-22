public class HangmanGame {
	private static final String PROMPT_WORD = "Enter a word:";
	private static final String PROMPT_GUESS = "Enter a guess:";
	private static final String WIN_MESSAGE = "Congratulations! You won!";
	private static final int CLEAR_LINES = 1000;

	private final ScannerWrapper scanner;
	private final SystemWrapper system;
	private WordDisplay wordDisplay;

	public HangmanGame(ScannerWrapper scanner, SystemWrapper system) {
		this.scanner = scanner;
		this.system = system;
	}

	public void setupGame() {
		system.printLine(PROMPT_WORD);
		String word = scanner.readLine();
		clearConsole();
		wordDisplay = new WordDisplay(word);
		system.printLine(wordDisplay.getCurrentDisplay());
	}

	private void clearConsole() {
		for (int i = 0; i < CLEAR_LINES; i++) {
			system.printLine();
		}
	}

	public void playOneRound() {
		system.printLine(PROMPT_GUESS);
		char guess = scanner.readChar();
		wordDisplay.guessLetter(guess);
		system.printLine(wordDisplay.getCurrentDisplay());
	}

	public void play() {
		setupGame();
		while (!wordDisplay.isWordComplete()) {
			playOneRound();
		}
		system.printLine(WIN_MESSAGE);
	}
}

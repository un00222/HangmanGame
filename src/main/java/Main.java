public class Main {
	public static void main(String[] args) {
		ScannerWrapper scanner = new ScannerWrapper();
		SystemWrapper system = new SystemWrapper();
		HangmanGame game = new HangmanGame(scanner, system);
		game.play();
	}
}

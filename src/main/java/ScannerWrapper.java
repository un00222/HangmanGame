import java.util.Scanner;

public class ScannerWrapper {
	private final Scanner scanner = new Scanner(System.in);

	public String readLine() {
		return scanner.nextLine();
	}

	public char readChar() {
		return scanner.next().charAt(0);
	}
}

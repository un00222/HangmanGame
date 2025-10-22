# Hangman Game (Java - Test Driven Development)

This project is a **console-based Hangman Game** implemented in **Java** using **Test-Driven Development (TDD)** principles.  
It demonstrates modular design, clean coding practices, and automated testing with **JUnit**.  
All user input and console output are abstracted through wrapper classes to make the game fully testable.

---

## 1. Overview
The Hangman Game allows one player to enter a secret word, clears the console to hide it, and lets another player guess letters until they either:
- correctly guess the entire word, or  
- run out of allowed attempts.

The project was developed following **TDD**, meaning all logic was written after defining test cases that initially failed.  
This ensures robust, maintainable, and bug-resistant code.

---

## 2. Features
- Prompts one player to enter a secret word.
- Simulates console clearing by printing multiple blank lines.
- Allows a second player to guess letters one at a time.
- Displays the current word progress with underscores for unguessed letters.
- Tracks all guessed letters and remaining attempts.
- Detects win or loss conditions.
- Fully unit tested (no manual input during testing).
- Demonstrates clean architecture and separation of concerns.

---

## 3. Design Objectives
- Apply **Single Responsibility Principle (SRP)**: each class handles one responsibility.
- Keep **game logic separate from input/output**, improving testability.
- Follow **Test-Driven Development (TDD)** from start to finish.
- Enable **unit testing** through wrapper classes (mockable I/O).
- Ensure **readability and maintainability** through consistent naming and modular structure.

---

## 4. Project Structure

| File | Description |
|------|--------------|
| `Main.java` | Entry point; coordinates the game loop and connects components. |
| `HangmanGame.java` | Core logic: tracks guesses, determines win/loss, and validates letters. |
| `WordDisplay.java` | Handles formatting and rendering of the current guessed word. |
| `ScannerWrapper.java` | Encapsulates `Scanner` for controlled user input; allows test mocking. |
| `SystemWrapper.java` | Encapsulates `System.out` printing for predictable test output. |
| `HangmanGameTest.java` | JUnit test suite for verifying main game logic (guessing, win/loss). |
| `WordDisplayTest.java` | JUnit test suite for validating word display updates and formatting. |

---

## 5. Class Responsibilities

### **Main.java**
- Starts the game.
- Asks Player 1 for a secret word.
- 
- Clears the console output.
- Runs the guessing loop until the game ends.

### **HangmanGame.java**
- Stores the secret word and guessed letters.
- Checks letter matches and updates the display.
- Determines win/loss state based on current guesses.
- Provides accessors for remaining attempts and display state.

### **WordDisplay.java**
- Returns the display string for the secret word.
- Replaces unguessed letters with underscores.
- Updates dynamically after each guess.

### **ScannerWrapper.java**
- Wrapper around Java’s `Scanner` for input operations.
- Facilitates test mocking of user input.

### **SystemWrapper.java**
- Wrapper around `System.out` for output operations.
- Allows test verification of printed output.

---

## 6. Example Gameplay

Enter the secret word: foobar

Guess a letter: o
Current word: oo__
Guessed letters: o
Remaining attempts: 5

Guess a letter: f
Current word: foo___
Guessed letters: o, f
Remaining attempts: 4
...
Congratulations! You guessed the word: foobar


---

## 7. Testing Strategy

### Approach
All core logic is tested using **JUnit 4**.  
The project follows TDD: write failing test → write code → make test pass → refactor.

### Test Coverage
| Test Class | What It Tests |
|-------------|---------------|
| `HangmanGameTest.java` | Verifies guessing logic, win/loss detection, and attempt tracking. |
| `WordDisplayTest.java` | Verifies correct display of letters and underscores. |

### Mocking & Abstraction
- Input (`ScannerWrapper`) and output (`SystemWrapper`) are abstracted to allow deterministic testing.
- No real console input/output occurs during automated tests.

---

## 8. Technologies Used
- **Language:** Java (JDK 17+ recommended)  
- **Testing Framework:** JUnit 4.13.2  
- **Build Tool:** Maven or Gradle (optional)  
- **IDE:** IntelliJ IDEA or Eclipse  

-

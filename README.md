# Hangman Game (Test-Driven Development)

A fully test-driven implementation of the classic Hangman word guessing game in Java, built using JUnit and Mockito for automated testing.  
This project demonstrates clean code design, Single Responsibility Principle (SRP), and test-driven development (TDD) practices.

---

## Overview
This program allows one player to enter a secret word, then another player guesses letters until they win or run out of attempts.  
All user input and console output are abstracted through wrapper classes to allow mocking during testing.

---

## Features
- Accepts a hidden word input from the first player.
- Clears the console output (simulated by printing blank lines).
- Accepts letter guesses from the second player.
- Tracks guessed letters and remaining attempts.
- Displays current progress (letters or underscores).
- Determines and reports win/loss outcomes.
- Follows TDD and clean code principles throughout.

---

## Design Principles
- **Single Responsibility:** Each class performs one clear function
- **Separation of Concerns:** Game logic is separated from user interface operations.
- **Encapsulation:** Internal state is private and accessed only through methods.
- **Testability:** Input and output are mockable to ensure deterministic tests.

---

## Class Overview
| Class | Responsibility |
|--------|----------------|
| `HangmanGame` | Core logic for handling guesses and checking game state. |
| `ConsoleInput` | Wrapper around Scanner for controlled input (mockable). |
| `ConsoleOutput` | Handles all console printing. |
| `GameRunner` | Entry point that coordinates game flow. |
| `HangmanTest` | JUnit test suite verifying logic and input/output handling. |

---

## Technologies Used
- Language: Java  
- Testing Frameworks: JUnit, Mockito  
- Build Tool: Gradle or Maven  
- IDE: IntelliJ IDEA or Eclipse

---

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/un00222/HangmanGame.git
   cd HangmanGame

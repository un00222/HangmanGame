
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

---

## 9. How to Run the Game

### Step 1: Clone the repository
```bash
git clone https://github.com/un00222/HangmanGame.git
cd HangmanGame

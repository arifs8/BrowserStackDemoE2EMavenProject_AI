# BrowserStack Demo E2E Maven Project

This project contains a professional Selenium with Java automation framework for testing the **BrowserStack Demo Application** (bstackdemo.com). It is built using the **Page Object Model (POM)** and **TestNG**.

## 🚀 The AI Prompt (How this was generated)

This framework was generated using a high-precision AI prompt designed for enterprise-grade automation. Here is the exact prompt used:

> "Generate an enterprise-level Selenium with Java automation script for the BrowserStack demo application. The script should follow the Page Object Model with PageFactory, TestNG annotations, and robust exception handling. Cover login functionality and adding the 'iPhone 12 mini' to the cart. **Constraint:** Use ONLY XPath selectors (no CSS, IDs, or names). Do NOT use `Thread.sleep()`. Maintain high readability and modularity. Output one Page Object file and TestNG test scripts as runnable code."

---

## 🎓 The RICE POT Framework (Prompt Engineering for Students)

To get the best results from AI when generating test cases or automation scripts, we use the **RICE POT** framework. This helps students structure their prompts effectively.

| Letter | Definition | Description |
| :--- | :--- | :--- |
| **R** | **Role** | Assign a specific identity to the AI (e.g., "Act as a Senior SDET"). |
| **I** | **Instruction** | Clearly state the primary command (e.g., "Create a Selenium script"). |
| **C** | **Context** | Provide background info (e.g., "The application is a demo e-commerce site"). |
| **E** | **Example** | Show the desired pattern (e.g., "Use Page Object Model with PageFactory"). |
| **P** | **Parameters / Persona** | Define constraints and style (e.g., "Use enterprise standards, no sleep triggers"). |
| **O** | **Output Format** | Specify the final result (e.g., "Java files, JUnit/TestNG format"). |
| **T** | **Target / Constraints** | Set strict rules (e.g., "Use XPath selectors only, avoid CSS"). |

---

## 🛠️ Project Structure

- **src/main/java**: Contains Page Objects (`LoginPage.java`).
- **src/test/java**: Contains TestNG test scripts (`ValidLoginTest.java`, `InvalidLoginTest.java`).
- **pom.xml**: Maven configuration with dependencies for Selenium, TestNG, and WebDriverManager.

## 🏃 How to Run the Tests

1. Ensure you have **Java 11+** and **Maven** installed.
2. Clone this repository.
3. Open the terminal in the project root folder.
4. Run the following command:
   ```bash
   mvn test
   ```

## 📝 Key Features
- **Strict XPath usage**: All elements are located using customized XPaths.
- **Dynamic Waits**: Uses `WebDriverWait` instead of hardcoded sleeps.
- **Robustness**: Implements try-catch blocks and explicit waits for stability.

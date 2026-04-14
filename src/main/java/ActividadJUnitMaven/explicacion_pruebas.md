# Activity 02 - Test Design and Implementation

## Test Cases Analysis

To test the `isMayorDeEdad()` method from the `Persona` class, which returns `true` if the age is between 18 and 120 (inclusive) and `false` otherwise, the following test cases have been designed using the **Equivalence Partitioning** and **Boundary Value Analysis** techniques.

### 1. Equivalence Partitioning Method
Three ranges or "classes" of possible inputs are identified:

| Equivalence Class | Age Range | Expected Result | Selected Test Value |
| :--- | :--- | :--- | :--- |
| EC1 (Invalid - Minor) | < 18 | `false` | 10 |
| EC2 (Valid) | 18 to 120 | `true` | 50 |
| EC3 (Invalid - Elder) | > 120 | `false` | 130 |

### 2. Boundary Value Analysis Method
The boundaries of the valid ranges are evaluated by testing the exact boundary value, one value below, and one value above:

**Lower Boundary (18):**
*   Boundary - 1 = **17** -> Expected: `false`
*   Boundary = **18** -> Expected: `true`
*   Boundary + 1 = **19** -> Expected: `true`

**Upper Boundary (120):**
*   Boundary - 1 = **119** -> Expected: `true`
*   Boundary = **120** -> Expected: `true`
*   Boundary + 1 = **121** -> Expected: `false`

---

## Code Implementation

### Section 1: Individual Tests
An independent `@Test` method has been created for each of the 9 cases designed above (3 for equivalence and 6 for boundaries) within the `PersonaTest` class. 

*[INSTRUCTION FOR STUDENT: Add here a screenshot of your code showing the individual test methods]*

### Section 2: Parameterized Tests
Instead of having 9 separate methods, a `@DataProvider` named `edadesProvider` has been created, returning a two-dimensional array with all the test ages and their expected results. Subsequently, a single `@Test(dataProvider = "edadesProvider")` method was created, which executes 9 consecutive times, injecting the parameters automatically. 

*[INSTRUCTION FOR STUDENT: Add here a screenshot of your code showing the DataProvider and the Parameterized Test, along with a screenshot of the test results panel showing all tests passed (green)]*

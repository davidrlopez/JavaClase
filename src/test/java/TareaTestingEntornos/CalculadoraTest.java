package TareaTestingEntornos;

public class CalculadoraTest {
  int num1;
  int num2;

  public CalculadoraTest(int a, int b) {
    num1 = a;
    num2 = b;
  }

  public int suma() {
    int result = num1 + num2;
    return result;
  }

  public int resta() {
    int result = num1 - num2;
    return result;
  }

  public int multiplica() {
    int result = num1 * num2;
    return result;
  }

  public int divide() {
    int result = num1 / num2;
    return result;
  }
}

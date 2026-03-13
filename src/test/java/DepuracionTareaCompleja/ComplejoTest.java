package DepuracionTareaCompleja;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Add tests for all methods, with meaningful test cases for each one,
 * and in such a way that no errors are generated.
 * Document/comment on the decisions made.
 */
public class ComplejoTest {
  @Test
  public void testConstructorsAndGetters() {
    Complejo defaultComplejo = new Complejo();
    assertEquals(defaultComplejo.getR(), 1);
    assertEquals(defaultComplejo.getI(), 0);

    Complejo paramComplejo = new Complejo(4, 2);
    assertEquals(paramComplejo.getR(), 4);
    assertEquals(paramComplejo.getI(), 2);

    Complejo copyComplejo = new Complejo(paramComplejo);
    assertEquals(copyComplejo.getR(), 4);
    assertEquals(copyComplejo.getI(), 2);
  }

  @Test
  public void testSetters() {
    Complejo c = new Complejo();
    c.setR(10);
    c.setI(5);
    assertEquals(c.getR(), 10);
    assertEquals(c.getI(), 5);

    c.setComplejo(7, 7);
    assertEquals(c.getR(), 7);
    assertEquals(c.getI(), 7);

    c.setComplejo(new Complejo(3, 3));
    assertEquals(c.getR(), 3);
    assertEquals(c.getI(), 3);
  }

  @Test
  public void testToString() {
    Complejo c = new Complejo(3, 4);
    assertEquals(c.toString(), "{3+4i}");
  }

  @Test
  public void testEquals() {
    Complejo c1 = new Complejo(3, 4);
    Complejo c2 = new Complejo(3, 4);
    Complejo c3 = new Complejo(5, 5);

    assertTrue(c1.equals(3, 4));
    assertFalse(c1.equals(5, 5));
    assertTrue(c1.equals(c2));
    assertFalse(c1.equals(c3));
  }

  @Test
  public void testSuma() {
    Complejo c = new Complejo(3, 4);
    Complejo result1 = c.sumaComplejo(1, 2);
    assertEquals(result1.getR(), 4);
    assertEquals(result1.getI(), 6);

    Complejo result2 = c.sumaComplejo(new Complejo(1, 2));
    assertEquals(result2.getR(), 4);
    assertEquals(result2.getI(), 6);
  }

  @Test
  public void testResta() {
    Complejo c = new Complejo(5, 9);
    Complejo result1 = c.complejoResta(1, 4);
    assertEquals(result1.getR(), 4);
    assertEquals(result1.getI(), 5);

    Complejo result2 = c.complejoResta(new Complejo(1, 4));
    assertEquals(result2.getR(), 4);
    assertEquals(result2.getI(), 5);
  }

  @Test
  public void testProducto() {
    Complejo c = new Complejo(2, 3);
    // (2+3i) * (4+5i) = (2*4 - 3*5) + (2*5 + 3*4)i = (8-15) + (10+12)i = -7 + 22i
    Complejo result1 = c.complejoProducto(4, 5);
    assertEquals(result1.getR(), -7);
    assertEquals(result1.getI(), 22);

    Complejo result2 = c.complejoProducto(new Complejo(4, 5));
    assertEquals(result2.getR(), -7);
    assertEquals(result2.getI(), 22);
  }

  // DECISION (CRITICAL): Ensure that we do not trigger an ArithmeticException (/
  // by zero).
  // Test cases for cociente use divisors where (r*r + i*i) != 0.
  @Test
  public void testCociente() {
    Complejo c = new Complejo(10, 5);
    Complejo result1 = c.complejoCociente(2, 1);
    assertEquals(result1.getR(), 5);
    assertEquals(result1.getI(), 0);

    Complejo result2 = c.complejoCociente(new Complejo(2, 1));
    assertEquals(result2.getR(), 5);
    assertEquals(result2.getI(), 0);
  }
}

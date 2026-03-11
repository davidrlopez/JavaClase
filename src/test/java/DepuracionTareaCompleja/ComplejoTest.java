package DepuracionTareaCompleja;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Add tests for all methods, with meaningful test cases for each one, 
 * and in such a way that no errors are generated. 
 * Document/comment on the decisions made.
 */
public class ComplejoTest {

    // DECISION: Test both default and parameterized constructors to ensure
    // default values are correct (r=1, i=0) and assigned values match.
    @Test
    public void testConstructorsAndGetters() {
        Complejo defaultComplejo = new Complejo();
        assertEquals(1, defaultComplejo.getR());
        assertEquals(0, defaultComplejo.getI());

        Complejo paramComplejo = new Complejo(4, 2);
        assertEquals(4, paramComplejo.getR());
        assertEquals(2, paramComplejo.getI());

        Complejo copyComplejo = new Complejo(paramComplejo);
        assertEquals(4, copyComplejo.getR());
        assertEquals(2, copyComplejo.getI());
    }

    // DECISION: Verify setters mutate the internal state without throwing errors.
    @Test
    public void testSetters() {
        Complejo c = new Complejo();
        c.setR(10);
        c.setI(5);
        assertEquals(10, c.getR());
        assertEquals(5, c.getI());

        c.setComplejo(7, 7);
        assertEquals(7, c.getR());
        assertEquals(7, c.getI());

        c.setComplejo(new Complejo(3, 3));
        assertEquals(3, c.getR());
        assertEquals(3, c.getI());
    }

    // DECISION: Verify output string matches expected formatting.
    @Test
    public void testToString() {
        Complejo c = new Complejo(3, 4);
        assertEquals("{3+4i}", c.toString());
    }

    // DECISION: Test equality against primitives and object instances.
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

    // DECISION: Arithmetic operations should return a new object with the correct results.
    @Test
    public void testSuma() {
        Complejo c = new Complejo(3, 4);
        Complejo result1 = c.sumaComplejo(1, 2);
        assertEquals(4, result1.getR());
        assertEquals(6, result1.getI());

        Complejo result2 = c.sumaComplejo(new Complejo(1, 2));
        assertEquals(4, result2.getR());
        assertEquals(6, result2.getI());
    }

    @Test
    public void testResta() {
        Complejo c = new Complejo(5, 9);
        Complejo result1 = c.complejoResta(1, 4);
        assertEquals(4, result1.getR());
        assertEquals(5, result1.getI());

        Complejo result2 = c.complejoResta(new Complejo(1, 4));
        assertEquals(4, result2.getR());
        assertEquals(5, result2.getI());
    }

    @Test
    public void testProducto() {
        Complejo c = new Complejo(2, 3);
        // (2+3i) * (4+5i) = (2*4 - 3*5) + (2*5 + 3*4)i = (8-15) + (10+12)i = -7 + 22i
        Complejo result1 = c.complejoProducto(4, 5);
        assertEquals(-7, result1.getR());
        assertEquals(22, result1.getI());

        Complejo result2 = c.complejoProducto(new Complejo(4, 5));
        assertEquals(-7, result2.getR());
        assertEquals(22, result2.getI());
    }

    // DECISION (CRITICAL): Ensure that we do not trigger an ArithmeticException (/ by zero).
    // Test cases for cociente use divisors where (r*r + i*i) != 0.
    @Test
    public void testCociente() {
        Complejo c = new Complejo(10, 5);
        // Divisor: 2+1i => r*r + i*i = 5
        // real: (10*2 + 5*1)/5 = 25/5 = 5
        // imag: (5*2 - 10*1)/5 = (10-10)/5 = 0
        Complejo result1 = c.complejoCociente(2, 1);
        assertEquals(5, result1.getR());
        assertEquals(0, result1.getI());

        Complejo result2 = c.complejoCociente(new Complejo(2, 1));
        assertEquals(5, result2.getR());
        assertEquals(0, result2.getI());
    }
}

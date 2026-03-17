package DepuracionTareaCompleja;

import org.testng.annotations.Test;
import java.util.Arrays;
import static org.testng.Assert.*;

public class ArraysTest {

    MisArrays utiles = new MisArrays();

    @Test
    public void testOrdenarInsercionEmpty() {
        int[] emptyArray = new int[]{};
        int[] result = utiles.ordenarInsercion(emptyArray);
        assertTrue(Arrays.equals(result, new int[]{}));
    }

    @Test
    public void testOrdenarInsercionNormal() {
        int[] input = new int[]{9, 5, 2, 8, 1};
        int[] expected = new int[]{9, 2, 5, 8, 1};
        int[] result = utiles.ordenarInsercion(input);
        assertTrue(Arrays.equals(result, expected));
    }

    @Test
    public void testAcumulaArrayEmpty() {
        int[] emptyArray = new int[]{};
        String result = utiles.acumulaArrayParaPintar(emptyArray);
        assertEquals(result, "");
    }

    @Test
    public void testAcumulaArrayNormal() {
        int[] input = new int[]{10, 20, 30, 40};
        String expected = "20 30 40 ";
        String result = utiles.acumulaArrayParaPintar(input);
        assertEquals(result, expected);
    }
}

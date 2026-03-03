package TareaTestingEntornos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LlenarNumerosTest {
  @Test
  public void pruebaMetodoLlenar() {
    int n = 5;

    int[] resultado = LlenarNumeros.llenar(n);

    Assert.assertEquals(resultado.length, n, "El array debería tener tamaño 5");

    Assert.assertEquals(resultado[0], 0, "El primer elemento debería ser 0");
    Assert.assertEquals(resultado[2], 20, "El tercer elemento (índice 2) debería ser 20");
    Assert.assertEquals(resultado[4], 40, "El último elemento (índice 4) debería ser 40");
  }

  @Test
  public void pruebaMetodoSumar() {
    int[] arraySimulado = { 10, 20, 30 };
    int resultadoSuma = LlenarNumeros.sumar(arraySimulado);

    Assert.assertEquals(resultadoSuma, 60, "La suma del array [10, 20, 30] debe ser 60");
  }

  @Test
  public void pruebaMetodoLlenar0() {
    int n = 0;

    int[] resultado = LlenarNumeros.llenar(0);

    Assert.assertEquals(resultado.length, n, "El array debería tener tamaño 0");
  }

  @Test
  public void pruebaMetodoSumar0() {
    int[] arrayVacio = new int[0];
    int resultadoSuma = LlenarNumeros.sumar(arrayVacio);

    Assert.assertEquals(resultadoSuma, 0, "La suma del array 0");
  }

}

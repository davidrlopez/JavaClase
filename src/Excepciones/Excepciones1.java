package Excepciones;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Excepciones1 {

  /**
   * Clase interna para probar NullPointerException
   */
  static class Ejemplo {
    public int at1;

    public Ejemplo() {
      this.at1 = 0;
    }

    public Ejemplo(int n) {
      this.at1 = n;
    }

    @Override
    public String toString() {
      return "Ejemplo{" + "at1=" + at1 + '}';
    }
  }

  /**
   * Clase de excepción personalizada (creada abajo anteriormente)
   */
  static class DivisionPorCeroException extends Exception {
    String mensaje;

    public DivisionPorCeroException(String mensaje) {
      // Pasamos el mensaje al padre (Exception) también, es buena práctica
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "DivisionPorCeroException: " + mensaje;
    }
  }

  public static void main(String[] args) {

    // ---------------------------------------------------------
    // 1. Prueba de Aritmética (ArithmeticException)
    // ---------------------------------------------------------
    System.out.println("--- 1. Prueba Aritmética ---");
    int a, b = 1, c = 0;
    try {
      // Esto lanzará ArithmeticException inmediatamente
      a = b / c;
      System.out.println("a = " + a);
    } catch (ArithmeticException e) {
      System.out.println("Error capturado: División por cero.");
    } catch (Exception e) {
      System.out.println("Error general aritmética: " + e.toString());
    }

    // ---------------------------------------------------------
    // 2. Prueba de Array (ArrayIndexOutOfBoundsException)
    // ---------------------------------------------------------
    System.out.println("\n--- 2. Prueba Array ---");
    try {
      int[] array = { 3, 4, 5, 7, 8, 2 };
      // Intentamos acceder a una posición que no existe
      array[20] = 99;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Error capturado: Índice fuera de los límites del array.");
    } catch (Exception e) {
      System.out.println("Error general array: " + e.toString());
    }

    // ---------------------------------------------------------
    // 3. Prueba de Objeto Nulo (NullPointerException)
    // ---------------------------------------------------------
    System.out.println("\n--- 3. Prueba Objeto Nulo ---");
    Ejemplo ej1 = null;
    try {
      // Intentamos acceder a un atributo de un objeto no inicializado
      System.out.println(ej1.at1);
    } catch (NullPointerException e) {
      System.out.println("Error capturado: Intento de acceso a objeto nulo.");
    } catch (Exception e) {
      System.out.println("Error general objeto: " + e.toString());
    }

    // ---------------------------------------------------------
    // 4. Prueba de Scanner (InputMismatchException)
    // ---------------------------------------------------------
    System.out.println("\n--- 4. Prueba Scanner (InputMismatch) ---");
    Scanner teclado = new Scanner(System.in);
    int edad;

    while (true) {
      try {
        System.out.print("Introduce tu edad (número entero): ");
        edad = teclado.nextInt();
        System.out.println("Edad correcta: " + edad);
        break; // Rompe el bucle si la entrada es correcta
      } catch (InputMismatchException e) {
        System.out.println("Error: El valor introducido no es un número entero. Inténtalo de nuevo.");
        teclado.next(); // Limpia el buffer del scanner para evitar bucle infinito
      }
    }

    // ---------------------------------------------------------
    // 5. Prueba de Lanzar nuestras propias excepciones (Throw)
    // ---------------------------------------------------------
    System.out.println("\n--- 5. Prueba Throw ---");
    try {
      if (c == 0) {
        // Lanzamos la excepción manualmente con un mensaje personalizado
        throw new ArithmeticException("Lanzada manualmente porque c es 0");
      } else {
        a = b / c;
        System.out.println("A=" + a);
      }
    } catch (ArithmeticException e) {
      System.out.println("Excepción manual capturada: " + e.getMessage());
    }

    // ---------------------------------------------------------
    // 6. Crear nueva excepción personalizada (DivisionPorCeroException)
    // ---------------------------------------------------------
    System.out.println("\n--- 6. Nueva Excepción Personalizada ---");
    try {
      if (c == 0) {
        throw new DivisionPorCeroException("Error crítico: Intento de división por cero detectado.");
      }
    } catch (DivisionPorCeroException e) {
      System.out.println("¡Excepción Personalizada Capturada! -> " + e.toString());
    } catch (Exception e) {
      System.out.println("Error general: " + e.toString());
    }

    teclado.close();
    System.out.println("\nFin del programa.");
  }
}

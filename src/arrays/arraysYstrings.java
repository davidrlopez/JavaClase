package arrays;

import java.util.Arrays;
import java.util.Scanner;
import operations.TestRapido;

public class arraysYstrings {
  public static void main(String[] args) {
    System.out.println("=== TESTING ARRAYS Y STRINGS ===");

    // Test abecedario method
    System.out.println("\n1. Testing abecedario method:");
    abecedario();

    // Test devolverMayus method
    System.out.println("\n2. Testing devolverMayus method:");
    String testText = "hola mundo ñ";
    System.out.println("Original: " + testText);
    System.out.print("Uppercase: ");
    devolverMayus(testText);

    // Test ejercicio3 method (count vowels and A's)
    System.out.println("\n3. Testing ejercicio3 method:");
    String testFrase = "Esta es una frase de ejemplo para analizar";
    System.out.println("Analyzing: \"" + testFrase + "\"");
    ejercicio3(testFrase);

    // Test with more methods
    System.out.println("\n4. Additional string and array tests:");
    testStringMethods();
    System.out.println("\n5. Test ejercicio4");
    String frase = "Wow que maravilla";
    System.out.println("Searching for 'w'/'W' in: \"" + frase + "\"");
    ejercicio4(frase);

    System.out.println("\n6. Test ejercicio5");
    String frase2 = "Testing the letter T in this text";
    System.out.println("Searching for 't'/'T' in: \"" + frase2 + "\"");
    ejercicio5(frase2);

    // Test with string that doesn't contain the letters
    System.out.println("\n7. Test with no matches:");
    String frase3 = "Hello beautiful day";
    System.out.println("Searching for 't'/'T' in: \"" + frase3 + "\"");
    ejercicio5(frase3);

    System.out.println("\n=== ALL TESTS COMPLETED ===");
  }

  public static void abecedario() {
    for (int i = 'A'; i <= 'Z'; i++) {
      System.out.println(i);
      if (i == 'N') {
        System.out.println('Ñ');
      }
    }
  }

  public static void devolverMayus(String texto) {
    System.out.println(texto.toUpperCase());
  }

  public static void ejercicio3(String frase) {
    int contA = 0;
    int contVoc = 0;
    for (int i = 0; i < frase.length(); i++) {
      if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i' || frase.charAt(i) == 'o'
          || frase.charAt(i) == 'u'
          || frase.charAt(i) == 'A' || frase.charAt(i) == 'E' || frase.charAt(i) == 'I' || frase.charAt(i) == 'O'
          || frase.charAt(i) == 'U') {
        contVoc++;
      }
      if (frase.charAt(i) == 'a' || frase.charAt(i) == 'A') {
        contA++;
      }
    }
    System.out.println("Numero de As: " + contA);
    System.out.println("Numero de vocales: " + contVoc);
  }

  public static void ejercicio4(String frase) {
    boolean encontrado = false;
    for (int i = 0; i < frase.length(); i++) {
      if (frase.charAt(i) == 'w') {
        System.out.println("w minúscula, posición: " + i);
        encontrado = true;
        break;
      }
      if (frase.charAt(i) == 'W') {
        System.out.println("W mayúscula, posición: " + i);
        encontrado = true;
        break;
      }
    }
    if (!encontrado) {
      System.out.println("No se encontró la letra 'w' o 'W' en la frase");
    }
  }

  public static void ejercicio5(String frase) {
    boolean encontrado = false;
    for (int i = 0; i < frase.length(); i++) {
      if (frase.charAt(i) == 't') {
        System.out.println("t minúscula, posición: " + i);
        encontrado = true;
      }
      if (frase.charAt(i) == 'T') {
        System.out.println("T mayúscula, posición: " + i);
        encontrado = true;
      }
    }
    if (!encontrado) {
      System.out.println("No se encontró la letra 't' o 'T' en la frase");
    }
  }

  // Additional utility methods for string manipulation
  public static void testStringMethods() {
    String[] palabras = { "programacion", "java", "arrays", "strings", "metodos" };
    System.out.println("Array of words: " + Arrays.toString(palabras));

    // Find longest word
    String palabraMasLarga = encontrarPalabraMasLarga(palabras);
    System.out.println("Longest word: " + palabraMasLarga);

    // Count total characters
    int totalCaracteres = contarCaracteresTotales(palabras);
    System.out.println("Total characters in all words: " + totalCaracteres);

    // Reverse a string
    String original = "Java";
    String reversed = invertirString(original);
    System.out.println("Original: " + original + " -> Reversed: " + reversed);
  }

  public static String encontrarPalabraMasLarga(String[] palabras) {
    String masLarga = "";
    for (String palabra : palabras) {
      if (palabra.length() > masLarga.length()) {
        masLarga = palabra;
      }
    }
    return masLarga;
  }

  public static int contarCaracteresTotales(String[] palabras) {
    int total = 0;
    for (String palabra : palabras) {
      total += palabra.length();
    }
    return total;
  }

  public static String invertirString(String texto) {
    StringBuilder resultado = new StringBuilder();
    for (int i = texto.length() - 1; i >= 0; i--) {
      resultado.append(texto.charAt(i));
    }
    return resultado.toString();
  }
}

package arrays;

import java.util.Arrays;
import java.util.Scanner;

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

    // Test esPrimo method
    System.out.println("\n8. Test esPrimo method:");
    int[] testNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 17, 19, 20, 25, 29, 97 };
    for (int num : testNumbers) {
      System.out.println(num + " is prime: " + esPrimo(num));
    }

    // Test primo_mayor method
    System.out.println("\n9. Test primo_mayor method:");
    int[] testArray = { 4, 7, 12, 17, 3, 19, 8, 23, 6 };
    System.out.println("Array: " + Arrays.toString(testArray));
    int positionOfLargestPrime = primo_mayor(testArray);
    if (positionOfLargestPrime >= 0 && positionOfLargestPrime < testArray.length) {
      System.out.println("Position of largest prime: " + positionOfLargestPrime);
      System.out.println("Largest prime value: " + testArray[positionOfLargestPrime]);
    } else {
      System.out.println("No prime numbers found in array");
    }

    // Interactive Caesar cipher tests with user input
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n=== CAESAR CIPHER INTERACTIVE TESTS ===");

    System.out.println("\n10. Test Caesar encryption:");
    System.out.print("Enter a message to encrypt: ");
    String original = scanner.nextLine();
    System.out.print("Enter encryption key (1-25): ");
    int encryptKey = scanner.nextInt();
    scanner.nextLine(); // consume newline

    String encrypted = encriptacionCesar(original, encryptKey);
    System.out.println("Original: " + original);
    System.out.println("Encrypted (key=" + encryptKey + "): " + encrypted);

    System.out.println("\n11. Test Caesar decryption with known key:");
    String decrypted = DesencriptacionCesar(encrypted, encryptKey);
    System.out.println("Decrypted back: " + decrypted);
    System.out.println("Match original? " + original.toUpperCase().equals(decrypted));

    System.out.println("\n12. Test brute force decryption (all keys):");
    System.out.print("Enter an encrypted message to decrypt (or press Enter to use previous): ");
    String bruteForceMessage = scanner.nextLine();
    if (bruteForceMessage.trim().isEmpty()) {
      bruteForceMessage = encrypted;
    }
    DesencriptacionCesarsinClave(bruteForceMessage);

    System.out.println("\n13. Test smart dictionary decryption:");
    System.out.print("Enter an encrypted Spanish message (or press Enter to use previous): ");
    String dictionaryMessage = scanner.nextLine();
    if (dictionaryMessage.trim().isEmpty()) {
      dictionaryMessage = encrypted;
    }
    mensajeDescifrado(dictionaryMessage);

    scanner.close();

    // Test factorial functionality (ejercicio6) with 10 numbers
    System.out.println("\n14. Test factorial functionality (ejercicio6):");
    int[] testNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    System.out.println("Original array: " + Arrays.toString(testNumbers));

    int[] factorialResults = ejercicio6(testNumbers);
    System.out.println("Factorial results: " + Arrays.toString(factorialResults));

    // Show individual calculations for clarity
    System.out.println("Individual factorial calculations:");
    for (int i = 0; i < testNumbers.length; i++) {
      System.out.println(testNumbers[i] + "! = " + factorialResults[i]);
    }

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

  // Nueva versión de ejercicio3 usando string con todas las vocales
  public static void ejercicio3Nueva(String frase) {
    // String con todas las vocales: minúsculas, mayúsculas y con tildes
    String vocales = "aeiouAEIOUáéíóúÁÉÍÓÚàèìòùÀÈÌÒÙäëïöüÄËÏÖÜ";
    String asVocales = "aAáÁàÀäÄ";

    int contA = 0;
    int contVoc = 0;

    for (int i = 0; i < frase.length(); i++) {
      char caracter = frase.charAt(i);

      // Verificar si es vocal usando indexOf (retorna -1 si no encuentra)
      if (vocales.indexOf(caracter) != -1) {
        contVoc++;
      }

      // Verificar si es una 'A' en cualquier forma usando indexOf
      if (asVocales.indexOf(caracter) != -1) {
        contA++;
      }
    }

    System.out.println("Numero de As (nueva version): " + contA);
    System.out.println("Numero de vocales (nueva version): " + contVoc);
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

  // Nueva versión de ejercicio4 usando indexOf y devolviendo la posición
  public static int ejercicio4Nueva(String frase, char letra) {
    return frase.indexOf(letra);
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

  public static int[] ejercicio5(String cadena, char letra) {

    int array[] = new int[cadena.length()];
    int cont = 0;

    Arrays.fill(array, -1);

    int pos = cadena.indexOf(letra);

    while (pos != -1) {

      array[cont++] = pos;

      pos = cadena.indexOf(letra, pos + 1);

    }

    return array;
  }

  public static int ejercicio6(String texto, char letra) {
    return texto.lastIndexOf(letra);
  }

  public static void mostrarArray(char array[]) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      if (i < array.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println();
    System.out.println("****************************");
  }

  public static char[] buscarChar(String cadena) {
    char array[] = new char[cadena.length()];
    for (int i = 0; i < cadena.length(); i++) {
      array[i] = cadena.charAt(i);
    }
    return array;
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

  public static String invertirStringClase(String texto) { // version de clase
    String invertida = "";
    for (int i = texto.length() - 1; i >= 0; i--) {
      invertida += texto.charAt(i);
    }
    return invertida;
  }

  public static boolean esNumero(String cadena) {
    char array[] = cadena.toCharArray();
    for (int i = 0; i < cadena.length(); i++) {
      if (array[i] < '0' || array[i] > '9') {
        return false;
      }
    }
    return true;
  }

  public static boolean esTodoletra(String cadena) {
    char caracter;
    for (int i = 0; i < cadena.length(); i++) {
      caracter = cadena.charAt(i);
      if (!(caracter >= 'A' || caracter <= 'Z') || (caracter >= 'a' || caracter <= 'z') || caracter == 'n'
          || caracter == 'Ñ') {
        return false;
      }
    }
    return true;
  }

  public static int sumaDigitos(String cadena) {
    int suma = 0;
    char array[] = cadena.toCharArray();
    for (int i = 0; i < cadena.length(); i++) {
      if (array[i] >= '0' && array[i] <= '9') {
        suma += (array[i] - '0');
      }
    }
    return suma;
  }

  public static String quitarEspacios(String cadena) {
    String sinEspacios = "";

    for (int i = 0; i < cadena.length(); i++) {
      if (cadena.charAt(i) != ' ') {
        sinEspacios += cadena.charAt(i);
      }
    }
    return sinEspacios;
  }

  public static boolean palindromo(String cadena) {
    boolean es_pal = false;
    cadena = quitarEspacios(cadena);
    cadena = cadena.toLowerCase();
    if (cadena.equals(invertirString(cadena))) {
      es_pal = true;

    }
    return es_pal;
  }

  public static boolean palindromo2(String cadena) { // version optimizada
    cadena = quitarEspacios(cadena);
    cadena = cadena.toLowerCase();
    for (int i = 0; i < cadena.length() / 2; i++) {

      if (cadena.charAt(i) != cadena.charAt(cadena.length() - i - 1)) {
        return false;

      }
    }
    return true;
  }

  public static String encriptacionCesar(String cadena, int clave) {
    cadena = cadena.toUpperCase();
    String cifrado = "";
    for (int i = 0; i < cadena.length(); i++) {
      char caracter = cadena.charAt(i);
      if (caracter >= 'A' && caracter <= 'Z') {
        char cifradoChar = (char) (((caracter - 'A' + clave) % 26) + 'A');
        cifrado += cifradoChar;
        if (caracter == 'Ñ' || caracter == 'ñ') {
          caracter = '$';
        }
      } else {
        cifrado += caracter;
      }
    }
    return cifrado;
  }

  public static String DesencriptacionCesar(String cadena, int clave) {
    cadena = cadena.toUpperCase();
    String cifrado = "";
    for (int i = 0; i < cadena.length(); i++) {
      char caracter = cadena.charAt(i);
      if (caracter >= 'A' && caracter <= 'Z') {
        char cifradoChar = (char) (((caracter - 'A' - clave + 26) % 26) + 'A');
        cifrado += cifradoChar;
        if (caracter == '$') {
          caracter = 'Ñ';
        }
      } else {
        cifrado += caracter;
      }
    }
    return cifrado;
  }

  public static void DesencriptacionCesarsinClave(String cadena) {
    System.out.println("Mensaje cifrado=" + cadena);
    for (int i = 1; i <= 26; i++) {
      System.out.println("****************************");
      System.out.println("Clave=" + i);
      System.out.println(DesencriptacionCesar(cadena, i));
    }
  }

  public static void mensajeDescifrado(String cadena) {
    String[] diccionario = { "EN", "HOLA", "ES", "ESTA", "YO", "HAS", "MUNDO", "CASA", "AGUA", "AMOR", "VIDA", "SOY",
        "TU", "EL", "LA", "DE", "QUE", "SE", "NO", "UN", "UNA", "CON", "PARA", "POR", "TODO", "BIEN", "MAS", "COMO",
        "PERO", "SIN" };

    System.out.println("Analyzing: \"" + cadena + "\" using dictionary...");

    int maxMatches = 0, bestKey = 0;
    String bestDecryption = "";

    for (int key = 1; key <= 26; key++) {
      String decrypted = DesencriptacionCesar(cadena, key);
      int matches = countDictionaryMatches(quitarEspacios(decrypted).toUpperCase(), diccionario);

      System.out.printf("Key %2d: %s (%d coincidencias)\n", key, decrypted, matches);

      if (matches > maxMatches) {
        maxMatches = matches;
        bestKey = key;
        bestDecryption = decrypted;
      }
    }

    System.out
        .println("\n Mas coincidencias; " + bestKey + " -> " + bestDecryption + " (" + maxMatches + " coincidencias)");
  }

  // Simplified helper using existing methods
  private static int countDictionaryMatches(String cleanMessage, String[] dictionary) {
    int matches = 0;
    for (String word : dictionary) {
      if (cleanMessage.indexOf(word) != -1)
        matches++; // Reuse indexOf logic from ejercicio4Nueva
    }
    return matches;
  }

  public static String encriptar(String cadena, int clave) {
    cadena = cadena.toUpperCase();
    // cadena=sinEspacios(cadena);

    String encriptada = "";
    int pos_letra;

    for (int i = 0; i < cadena.length(); i++) {
      if (cadena.charAt(i) == 'Ñ') {
        encriptada += '$';
        continue;
      }
      if (cadena.charAt(i) != ' ') {

        pos_letra = (int) cadena.charAt(i);
        pos_letra += clave;

        if (pos_letra > 90) {
          pos_letra -= 26;
        }

        encriptada += (char) pos_letra;
      } else
        encriptada += ' ';
    }

    return encriptada;
  }

  public static String desencriptar(String cadena, int clave) {

    String encriptada = "";
    int pos_letra;

    for (int i = 0; i < cadena.length(); i++) {
      if (cadena.charAt(i) == '$') {
        encriptada += 'Ñ';
        continue;
      }
      if (cadena.charAt(i) != ' ') {

        pos_letra = (int) cadena.charAt(i);
        pos_letra -= clave;

        if (pos_letra < 65) {
          pos_letra += 26;
        }

        encriptada += (char) pos_letra;
      } else
        encriptada += ' ';
    }

    return encriptada;
  }

  public static void descrifrado_cesar(String mensaje) {

    System.out.println("Mensaje cifrado: " + mensaje);
    for (int i = 0; i <= 26; i++) {
      System.out.println("  ");
      System.out.println("Clave: " + i);
      System.out.println(desencriptar(mensaje, i));

    }

  }

  public static boolean mensaje_con_sentido(String mensaje) {

    String diccionario[] = { " HOLA ", " ADIOS ", " EN ", " HAS ", " PLATA " };

    for (int i = 0; i < diccionario.length; i++) {
      if (mensaje.contains(diccionario[i])) {
        return true;
      }
    }

    return false;
  }

  public static void clave_descifrado_cesar(String mensaje) {

    String descifrado;

    System.out.println("Mensaje cifrado: " + mensaje);

    for (int i = 0; i <= 26; i++) {
      System.out.println("_______________");
      System.out.println("Clave: " + i);

      descifrado = desencriptar(mensaje, i);
      System.out.println(descifrado);

      if (mensaje_con_sentido(descifrado)) {
        System.out.println("********Esta es la clave*******");
      }

    }

  }

  public static String numero_telefono(String telefono) {

    String formateado = "";
    String pais, codigo1, codigo2, codigo3, codigo4;

    if (telefono.length() != 11) {
      System.out.println("Error formato");
      return telefono;
    }
    pais = telefono.substring(0, 2);
    codigo1 = telefono.substring(2, 5);
    codigo2 = telefono.substring(5, 7);
    codigo3 = telefono.substring(7, 9);
    codigo4 = telefono.substring(9, 11);

    formateado = "(" + pais + ")_" + codigo1 + "_" + codigo2 + "_" + codigo3 + "_" + codigo4;

    return formateado;
  }

  public static int numero_de_palabras(String frase) {

    frase = frase.trim();

    // Con un while de que haya " " puedes remplazarlos con " " y luego cuentas los
    // espacios

    if (frase.length() == 0) {
      return 0;
    }

    int suma = 1;

    for (int i = 0; i < frase.length(); i++)
      if (frase.charAt(i) == ' ' && frase.charAt(i - 1) != ' ')
        suma++;

    return suma;

  }

  // ejercicios refuerzo tema 4
  public static boolean esPrimo(int n) {
    if (n <= 1) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  // ejercicio 1
  public static int primo_mayor(int array[]) {
    int pos_primo_mayor = 0;
    int primo_mayor = 0;
    for (int i = 0; i < array.length; i++) {
      if (esPrimo(array[i]) && array[i] > primo_mayor) {
        primo_mayor = array[i];
        pos_primo_mayor = i;
      }
    }
    return pos_primo_mayor;
  }

  // ejercicio2
  public static int[] primos2(int n) { // version del pdf para entre 100 y 300
    int[] respuesta = new int[n];
    int primos = 0;
    for (int i = 100; i <= 300; i++) {
      if (esPrimo(respuesta[i]) && primos < n) {
        respuesta[primos++] = i;
      }
    }
    return respuesta;
  }

  public static int[] primos2limites(int n, int li, int ls) { // version con limites
    int[] respuesta = new int[n];
    int primos = 0;
    for (int i = li; i <= ls; i++) {
      if (primos == n) {
        break;
      }
      if (esPrimo(respuesta[i]) && primos < n) {
        respuesta[primos++] = i;
      }
    }
    return respuesta;
  }

  // ejercicio3
  public static int[] ejercicio3(int array[]) {
    int solucion[] = new int[array.length];
    int posicion = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] % 10 == 4) {
        solucion[posicion++] = i;
      }
    }
    return solucion;
  }

  public static int[] ejercicio3String(int array[]) { // mi version convirtiendo a string
    int solucion[] = new int[array.length];
    int posicion = 0;
    String cadena;
    for (int i = 0; i < array.length; i++) {
      cadena = String.valueOf(array[i]);
      if (cadena.charAt(cadena.length() - 1) == '4') {
        solucion[posicion++] = i;
      }
    }
    return solucion;
  }

  // ejercicio4 POSIBLE EXAMEN
  public static int ejercicio4(int array[]) {
    int posicionMaxima = 0;
    int sumaMaxima = 0;

    for (int i = 0; i < array.length; i++) {
      String cadena = String.valueOf(Math.abs(array[i])); // Math.abs por si hay negativos
      int sumaActual = 0;

      // Sumar los dígitos del número actual
      for (int j = 0; j < cadena.length(); j++) {

        sumaActual += (cadena.charAt(j) - '0');
      }

      // Comparar después de haber sumado todos los dígitos
      if (sumaActual > sumaMaxima) {
        sumaMaxima = sumaActual;
        posicionMaxima = i;
      }
    }

    return posicionMaxima;
  }

  public static int ejercicio4sinString(int array[]) { // version de clase numerica
    int posicionMaxima = 0;
    int sumaMaxima = 0;

    for (int i = 0; i < array.length; i++) {
      int sumaActual = 0;
      int valor = array[i];
      while (valor > 0) {
        sumaActual += valor % 10;
        valor /= 10;
      }

      // Comparar después de haber sumado todos los dígitos
      if (sumaActual > sumaMaxima) {
        sumaMaxima = sumaActual;
        posicionMaxima = i;
      }
    }

    return posicionMaxima;
  }

  public static int ejercicio4sinStringClaude(int array[]) { // version claude
    int posicionMaxima = 0;
    int sumaMaxima = 0;

    for (int i = 0; i < array.length; i++) {
      int sumaActual = 0;
      int valor = array[i];

      // Caso especial: si el número es 0
      if (valor == 0) {
        sumaActual = 0;
      } else {
        while (valor > 0) {
          sumaActual += valor % 10; // Obtiene el último dígito
          valor /= 10; // Elimina el último dígito
        }
      }

      if (sumaActual > sumaMaxima) {
        sumaMaxima = sumaActual;
        posicionMaxima = i;
      }
    }

    return posicionMaxima;
  }

  // ejercicio 5
  public static int ejercicio5(int array[]) {
    int posicionMaxima = 0;
    int maxDigitos = 0;

    for (int i = 0; i < array.length; i++) {
      String cadena = String.valueOf(array[i]);
      int cantidadDigitos = cadena.length();

      if (cantidadDigitos > maxDigitos) {
        maxDigitos = cantidadDigitos;
        posicionMaxima = i;
      }
    }

    return posicionMaxima;
  }

  public static int ejercicio5sinString(int array[]) {
    int posicionMaxima = 0;
    int maxDigitos = 0;

    for (int i = 0; i < array.length; i++) {
      int cantidadDigitos = 0;
      int valor = array[i];

      // Caso especial: 0 tiene 1 dígito
      if (valor == 0) {
        cantidadDigitos = 1;
      } else {
        while (valor > 0) {
          cantidadDigitos++;
          valor /= 10;
        }
      }

      if (cantidadDigitos > maxDigitos) {
        maxDigitos = cantidadDigitos;
        posicionMaxima = i;
      }
    }

    return posicionMaxima;
  }

  public static int Factorial(int a) {
    int Factorial = 1;
    for (int i = 1; i <= a; i++) {
      Factorial *= i;
    }
    return Factorial;
  }

  public static int[] ejercicio6(int array[]) {
    int solucion[] = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      solucion[i] = Factorial(array[i]);
    }
    return solucion;
  }

  public static int ejercicio7(int array[]) {
    int contador = 0;
    String cadena;
    for (int i = 0; i < array.length; i++) {
      cadena = String.valueOf(array[i]);
      if (cadena.endsWith("15")) {
        contador++;
      }
    }
    return contador;
  }

  public static int ejercicio7sinString(int array[]) {
    int contador = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] % 100 == 15) {
        contador++;
      }
    }
    return contador;
  }

  // ejercicio8: University survey analysis
  public static void ejercicio8() {
    Scanner input = new Scanner(System.in);

    System.out.print("Introduzca el numero de estudiantes (max 50): ");
    int estudiantes = input.nextInt();

    // Validation
    if (estudiantes <= 0 || estudiantes > 50) {
      System.out.println("Error: Numero de estudiantes debe estar entre 1 y 50");
      return;
    }

    // ✅ CORRECT array declaration: [students][4 fields]
    // Fields: [0]=cedula, [1]=sexo, [2]=trabaja, [3]=sueldo
    int[][] datos = new int[estudiantes][4];

    // Input data for each student
    for (int i = 0; i < estudiantes; i++) {
      System.out.println("\n--- Estudiante " + (i + 1) + " ---");

      System.out.print("Cedula: ");
      datos[i][0] = input.nextInt();

      System.out.print("Sexo (1-Masculino, 2-Femenino): ");
      datos[i][1] = input.nextInt();

      System.out.print("Trabaja (1-Si, 2-No): ");
      datos[i][2] = input.nextInt();

      System.out.print("Sueldo: ");
      datos[i][3] = input.nextInt();
    }

    // Initialize counters and sums
    int cantHombres = 0, cantMujeres = 0;
    int hombresTrabajan = 0, mujeresTrabajan = 0;
    int sumaSueldoHombres = 0, sumaSueldoMujeres = 0;

    // Process data
    for (int i = 0; i < estudiantes; i++) {
      int sexo = datos[i][1];
      int trabaja = datos[i][2];
      int sueldo = datos[i][3];

      if (sexo == 1) { // Male
        cantHombres++;
        if (trabaja == 1) {
          hombresTrabajan++;
          sumaSueldoHombres += sueldo;
        }
      } else if (sexo == 2) { // Female
        cantMujeres++;
        if (trabaja == 1) {
          mujeresTrabajan++;
          sumaSueldoMujeres += sueldo;
        }
      }
    }

    // Calculate percentages and averages
    double porcentajeHombres = (cantHombres * 100.0) / estudiantes;
    double porcentajeMujeres = (cantMujeres * 100.0) / estudiantes;

    double porcentajeHombresTrabajan = cantHombres > 0 ? (hombresTrabajan * 100.0) / cantHombres : 0;
    double porcentajeMujeresTrabajan = cantMujeres > 0 ? (mujeresTrabajan * 100.0) / cantMujeres : 0;

    double promedioSueldoHombres = hombresTrabajan > 0 ? (double) sumaSueldoHombres / hombresTrabajan : 0;
    double promedioSueldoMujeres = mujeresTrabajan > 0 ? (double) sumaSueldoMujeres / mujeresTrabajan : 0;

    // Display results
    System.out.println("\n=== RESULTADOS DE LA ENCUESTA ===");
    System.out.printf("1. Porcentaje de hombres: %.2f%%\n", porcentajeHombres);
    System.out.printf("2. Porcentaje de mujeres: %.2f%%\n", porcentajeMujeres);
    System.out.printf("3. Porcentaje de hombres que trabajan: %.2f%% (Sueldo promedio: %.2f)\n",
        porcentajeHombresTrabajan, promedioSueldoHombres);
    System.out.printf("4. Porcentaje de mujeres que trabajan: %.2f%% (Sueldo promedio: %.2f)\n",
        porcentajeMujeresTrabajan, promedioSueldoMujeres);

    input.close();
  }
}

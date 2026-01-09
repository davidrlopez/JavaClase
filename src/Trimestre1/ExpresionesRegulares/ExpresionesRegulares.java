package ExpresionesRegulares;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {
  // Validaciones por expresiones regulares
  private static final String REGEX_VACIA = "^$";
  private static final String REGEX_PALABRA_SOLO_LETRAS = "^\\p{L}+$"; // Solo letras Unicode, una sola palabra
  private static final String REGEX_SOLO_CIFRAS = "^\\d+$"; // Solo dígitos 0-9
  private static final String REGEX_TELEFONO_ES = "^[69]\\d{8}$"; // 9 cifras, empieza por 6 o 9
  private static final String REGEX_DNI_BASICO = "^(\\d{1,8})([A-Za-z])?$"; // 1-8 números y letra opcional
  private static final String DIGITO_CONTROL_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

  private static final Pattern P_DNI_BASICO = Pattern.compile(REGEX_DNI_BASICO);

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String opcion = "";
    do {
      mostrarMenu();
      System.out.print("\nSeleccione una opción: ");
      opcion = scanner.nextLine().toLowerCase().trim();

      switch (opcion) {
        case "a":
          validarVacia();
          break;
        case "b":
          validarPalabra();
          break;
        case "c":
          validarNumero();
          break;
        case "d":
          validarTelefono();
          break;
        case "e":
          validarDNI();
          break;
        case "0":
          System.out.println("\n¡Gracias por usar el programa!");
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("\n✗ Opción '" + opcion + "' no válida. Por favor, seleccione a, b, c, d, e o 0");
      }

      if (!opcion.equals("0")) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
      }

    } while (!opcion.equals("0"));

    scanner.close();
  }

  /**
   * Muestra el menú principal
   */
  private static void mostrarMenu() {
    System.out.println("\n" + "=".repeat(60));
    System.out.println("         MENÚ DE VALIDACIONES - SWITCH");
    System.out.println("=".repeat(60));
    System.out.println("a. Verificar si una cadena está vacía");
    System.out.println("b. Verificar una única palabra con solo letras");
    System.out.println("c. Verificar un único número (solo cifras, sin decimales)");
    System.out.println("d. Verificar número de teléfono (9 cifras, empieza por 6 o 9)");
    System.out.println("e. Verificar DNI (1-8 números, con o sin letra)");
    System.out.println("0. Salir");
    System.out.println("=".repeat(60));
  }

  /**
   * Apartado a: Verifica si una cadena está vacía
   */
  private static void validarVacia() {
    System.out.println("\n--- VERIFICAR CADENA VACÍA ---");
    System.out.print("Ingrese una cadena (o presione Enter para vacío): ");
    String cadena = scanner.nextLine();

    if (cadena.matches(REGEX_VACIA)) {
      System.out.println("✓ La cadena está VACÍA");
    } else {
      System.out.println("✗ La cadena NO está vacía. Contiene: '" + cadena + "'");
      System.out.println("  Longitud: " + cadena.length() + " caracteres");
    }
  }

  /**
   * Apartado b: Verifica una única palabra que contenga solamente letras
   */
  private static void validarPalabra() {
    System.out.println("\n--- VERIFICAR PALABRA (SOLO LETRAS) ---");
    System.out.print("Ingrese una palabra: ");
    String cadena = scanner.nextLine();

    if (cadena.matches(REGEX_PALABRA_SOLO_LETRAS)) {
      System.out.println("✓ '" + cadena + "' es una palabra válida (solo letras)");
      System.out.println("  Longitud: " + cadena.length() + " letras");
    } else {
      System.out.println("✗ '" + cadena + "' NO es válida. Debe ser una única palabra compuesta solo por letras");
    }
  }

  /**
   * Apartado c: Verifica un único número que contenga solamente cifras
   */
  private static void validarNumero() {
    System.out.println("\n--- VERIFICAR NÚMERO (SOLO CIFRAS) ---");
    System.out.print("Ingrese un número: ");
    String cadena = scanner.nextLine();

    if (cadena.matches(REGEX_SOLO_CIFRAS)) {
      System.out.println("✓ '" + cadena + "' es un número válido (solo cifras)");
      System.out.println("  Valor numérico: " + cadena);
      System.out.println("  Cantidad de cifras: " + cadena.length());
    } else {
      System.out.println("✗ '" + cadena + "' NO es válido. Debe contener solo cifras (0-9), sin signos ni decimales");
    }
  }

  /**
   * Apartado d: Verifica número de teléfono (9 cifras, empezando por 6 o 9)
   */
  private static void validarTelefono() {
    System.out.println("\n--- VERIFICAR NÚMERO DE TELÉFONO ---");
    System.out.print("Ingrese un número de teléfono: ");
    String cadena = scanner.nextLine();

    if (cadena.matches(REGEX_TELEFONO_ES)) {
      System.out.println("✓ '" + cadena + "' es un número de teléfono válido");
    } else {
      System.out.println("✗ '" + cadena + "' NO es válido. Debe tener 9 cifras y empezar por 6 o 9");
    }
  }

  /**
   * Apartado e: Verifica DNI (de 1 a 8 números, con letra o sin ella)
   */
  private static void validarDNI() {
    System.out.println("\n--- VERIFICAR DNI ---");
    System.out.print("Ingrese un DNI: ");
    String input = scanner.nextLine().replace(" ", "").toUpperCase();

    Matcher m = P_DNI_BASICO.matcher(input);
    if (!m.matches()) {
      System.out.println("✗ '" + input + "' NO es válido. Formato esperado: 1-8 números, con o sin letra final");
      return;
    }

    String parteNumerica = m.group(1);
    String letra = m.group(2); // puede ser null

    System.out.println("✓ Formato correcto");
    System.out.println("  Número: " + parteNumerica);

    if (letra != null) {
      int numero = Integer.parseInt(parteNumerica);
      char letraCorrecta = DIGITO_CONTROL_DNI.charAt(numero % 23);
      if (Character.toUpperCase(letra.charAt(0)) == letraCorrecta) {
        System.out.println("  ✓ Letra '" + letra + "' CORRECTA");
      } else {
        System.out.println("  ✗ Letra '" + letra + "' INCORRECTA. Debería ser '" + letraCorrecta + "'");
      }
    } else {
      System.out.println("  Sin letra");
    }
  }

  // Métodos auxiliares con regex
  private static boolean soloLetras(String cadena) {
    return cadena.matches(REGEX_PALABRA_SOLO_LETRAS);
  }

  private static boolean soloDigitos(String cadena) {
    return cadena.matches(REGEX_SOLO_CIFRAS);
  }

  // Utilidades extra: validadores directos estilo ejercicios finales
  public static boolean validar_dni(String dni) {
    if (dni == null)
      return false;
    String input = dni.replace(" ", "").toUpperCase();
    Matcher m = P_DNI_BASICO.matcher(input);
    if (!m.matches() || m.group(2) == null)
      return false; // requiere letra

    String numeros = m.group(1);
    char letra = m.group(2).toUpperCase().charAt(0);

    int numeroDni = Integer.parseInt(numeros);
    int indice = numeroDni % 23;
    return letra == DIGITO_CONTROL_DNI.charAt(indice);
  }

  public static boolean validar_nie(String nie) {
    if (nie == null)
      return false;
    String input = nie.replace(" ", "").toUpperCase();
    if (!input.matches("^[XYZ]\\d{7}[A-Z]$"))
      return false;

    char pref = input.charAt(0);
    String numeros = input.substring(1, 8);
    char letra = input.charAt(8);

    String prefNum = (pref == 'X') ? "0" : (pref == 'Y') ? "1" : "2";
    int numeroNie = Integer.parseInt(prefNum + numeros);
    int indice = numeroNie % 23;
    return letra == DIGITO_CONTROL_DNI.charAt(indice);
  }
}

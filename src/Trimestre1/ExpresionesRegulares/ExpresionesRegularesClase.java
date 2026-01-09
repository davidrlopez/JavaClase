package ExpresionesRegulares;

class ExpresionesRegularesClase {

  public static void main(String[] args) {

  }

  public static String validar_String(char opcion, String cadena) {

    String inputLimpio = cadena.trim();
    String resultado = "No coincide con el patron";

    switch (opcion) {

      // a. vacía
      case 'a':
        if (inputLimpio.isEmpty()) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // b. una única palabra que contenga solamente letras (incluye Ñ y tildes)
      case 'b':
        if (inputLimpio.matches("^[A-Za-zñÑáéíóúÁÉÍÓÚ]+$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // c. un único número que contenga solamente cifras (sin decimales ni signo)
      case 'c':
        if (inputLimpio.matches("^\\d+$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // d. número de teléfono (9 cifras, empezando por 6 o 9)
      case 'd':
        if (inputLimpio.matches("^[69]\\d{8}$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // e. DNI (de 1 a 8 números, con letra o sin ella)
      case 'e':
        // La regex admite de 1 a 8 dígitos, seguidos opcionalmente (?) de una letra
        if (inputLimpio.matches("^\\d{1,8}[A-Za-z]?$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // f. código postal (cinco cifras, empezando por 0, 1, 2, 3 o 4)
      case 'f':
        if (inputLimpio.matches("^[0-4]\\d{4}$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // g. dos palabras (sólo letras, separadas por uno o varios espacios)
      case 'g':
        // Nota: \s+ coincide con uno o más espacios en blanco
        if (inputLimpio.matches("^[A-Za-zñÑáéíóúÁÉÍÓÚ]+\\s+[A-Za-zñÑáéíóúÁÉÍÓÚ]+$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // h. varias palabras (sólo letras, separadas por uno o varios espacios)
      case 'h':
        // Coincide con dos o más palabras separadas por uno o más espacios
        if (inputLimpio.matches("^[A-Za-zñÑáéíóúÁÉÍÓÚ]+(\\s+[A-Za-zñÑáéíóúÁÉÍÓÚ]+){1,}$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // i. fecha de nacimiento: dd/mm/aaaa
      case 'i':
        if (inputLimpio.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // j. un único número sin signo y con como mucho dos decimales (punto o coma)
      case 'j':
        // La parte decimal es opcional (?); si existe, debe tener 1 o 2 dígitos
        if (inputLimpio.matches("^\\d+([.,]\\d{1,2})?$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // k. un único número con signo y con decimales (punto o coma, solo si hay
      // decimales)
      case 'k':
        // Debe empezar con signo [+-] y debe tener parte decimal obligatoriamente
        if (inputLimpio.matches("^[+-]\\d+[.,]\\d+$")) {
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // l. contraseña (al menos 6 caracteres, letras, números y símbolo, sin
      // espacios)
      case 'l':
        // Requiere Lookaheads: (?=.*[A-Za-z]) - Mira hacia adelante para letras, etc.
        // [^\s]{6,} - No espacios y al menos 6 de longitud
        if (inputLimpio.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[^A-Za-z\\d\\s])[^\\s]{6,}$")) {
          // version facil de clase if (cadena.matches("\\S{6,}")) no exige al menos 6
          // dígitos
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      // m. dirección de correo electrónico
      case 'm':
        // Patrón estándar simple para email
        if (inp utLimpio.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
          // version clase murciaeduca
          // profesor y alumno separado por OR|
          // "^[A-z]+[A-z]+\\d*@murciaeduca.es|\\d{7}@alu.murciaeduca.es$"
          resultado = "Si";
        } else {
          resultado = "No";
        }
        break;

      default:
        resultado = "Opción de validación no reconocida.";
        break;
    }

    return resultado;
  }

  public static boolean validar_dni(String dni) {
    if (dni.matches("\\d{8}-?[A-Za-z]")) {
      String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";

      // Extraer los números y la letra del DNI
      String numeros = dni.replaceAll("[^0-9]", "");
      String letra = dni.replaceAll("[^A-Za-z]", "").toUpperCase();

      // Calcular el índice del dígito de control
      int numeroDni = Integer.parseInt(numeros);
      int indice = numeroDni % 23;

      // Verificar si la letra coincide
      return letra.equals(String.valueOf(DIGITO_CONTROL.charAt(indice)));
    }
    return false;
  }

  public static boolean validar_nie(String nie) {
    if (nie.matches("^[XYZ]\\d{7}-?[A-Z]$")) {
      String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";

      // Extraer los números y la letra del DNI
      String numeros = nie.replaceAll("[^0-9]", "");
      String letra = nie.replaceAll("[^A-Za-z]", "").toUpperCase();

      // Calcular el índice del dígito de control
      int numeroNie = Integer.parseInt(numeros);
      int indice = numeroNie % 23;

      // Verificar si la letra coincide
      return letra.equals(String.valueOf(DIGITO_CONTROL.charAt(indice)));
    }
    return false;
  }
}

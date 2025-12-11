package ExpresionesRegulares;

public class ExpresionesRegulares {

  public static void main(String[] args) {

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
    if (nie.matches("[XYZ]-?\\d{7}-?[A-Za-z]")) {
      String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";

      // Extraer la letra inicial, números y letra final
      String letraInicial = nie.substring(0, 1).toUpperCase();
      String numeros = nie.replaceAll("[^0-9]", "");
      String letraFinal = nie.substring(nie.length() - 1).toUpperCase();

      // Reemplazar letra inicial por su valor numérico
      String numeroCompleto = numeros;
      if (letraInicial.equals("X"))
        numeroCompleto = "0" + numeros;
      else if (letraInicial.equals("Y"))
        numeroCompleto = "1" + numeros;
      else if (letraInicial.equals("Z"))
        numeroCompleto = "2" + numeros;

      // Calcular el índice del dígito de control
      int numeroNie = Integer.parseInt(numeroCompleto);
      int indice = numeroNie % 23;

      // Verificar si la letra coincide
      return letraFinal.equals(String.valueOf(DIGITO_CONTROL.charAt(indice)));
    }
    return false;
  }
}

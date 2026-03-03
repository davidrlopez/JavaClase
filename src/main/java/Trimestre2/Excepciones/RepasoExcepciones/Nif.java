package Trimestre2.Excepciones.RepasoExcepciones;

public class Nif {
  private String s;
  private final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

  // --- CONSTRUCTORES ---

  public Nif() {
  }

  public Nif(int n) {
    setNif(n);
  }

  public Nif(String nifCompleto) {
    nifCompleto = nifCompleto.trim().toUpperCase();
    // Extraemos solo los números para el constructor
    String soloNumeros = nifCompleto.replaceAll("[^0-9]", "");
    if (soloNumeros.isEmpty())
      throw new IllegalArgumentException("No hay números");
    setNif(Integer.parseInt(soloNumeros));
  }

  public Nif(Nif otro) {
    if (otro == null)
      throw new IllegalArgumentException("Nif nulo");
    this.s = otro.getNif();
  }

  // --- SETTERS ---

  public void setNif(int n) throws IllegalArgumentException {
    if (n <= 0)
      throw new IllegalArgumentException("El número debe ser positivo");
    char letra = calcularLetra(n);
    this.s = n + "-" + letra;
  }

  public void setNif(String se) throws IllegalArgumentException {
    setNif(Integer.parseInt(se));
  }

  public void setNif(Nif otro) throws IllegalArgumentException {
    if (otro == null)
      throw new IllegalArgumentException("Error, dni introducido nulo");
    this.s = otro.getNif();
  }

  public String getNif() {
    return this.s;
  }

  // --- LÓGICA DE VALIDACIÓN ---

  private char calcularLetra(int n) {
    return LETRAS.charAt(n % 23);
  }

  /**
   * Método isNif según requerimientos del examen
   */
  public boolean isNif(String nif) {
    // a. Uso de length() para validación inicial
    if (nif == null || nif.length() < 9 || nif.length() > 10) {
      return false;
    }

    nif = nif.toUpperCase();
    String parteNumerica;
    char letraCandidata;

    // d. Uso de substring para separar números de letra
    // Manejamos formato 12345678X (9) o 12345678-X (10)
    if (nif.length() == 10 && nif.charAt(8) == '-') {
      parteNumerica = nif.substring(0, 8);
      letraCandidata = nif.charAt(9); // La letra es el último char
    } else {
      parteNumerica = nif.substring(0, 8);
      letraCandidata = nif.charAt(8);
    }

    // c. Uso de Character.isDigit para comprobar los números
    for (int i = 0; i < parteNumerica.length(); i++) {
      if (!Character.isDigit(parteNumerica.charAt(i))) {
        return false;
      }
    }

    // b. Uso de Character.isLetter para la letra
    if (!Character.isLetter(letraCandidata)) {
      return false;
    }

    // Validación matemática final
    int num = Integer.parseInt(parteNumerica);
    return letraCandidata == calcularLetra(num);
  }

  @Override
  public String toString() {
    return s;
  }

  public boolean equals(Nif otro) throws IllegalArgumentException {
    if (otro == null) {
      throw new IllegalArgumentException();
    }
    return this.s.equals(otro.s);
  }
}

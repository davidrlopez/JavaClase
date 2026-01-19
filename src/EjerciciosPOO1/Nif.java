package EjerciciosPOO1;

public class Nif {
  private String dni;
  private static final String letra = "TRWAGMYFPDXBNJZSQVHLCKE";

  // Default constructor
  public Nif() {
    this.dni = "00000000A"; // Default NIF
  }

  // Constructor that takes a DNI string
  public Nif(String numeroDni) {
    if (isNIF(numeroDni)) {
      this.dni = numeroDni;
    } else {
      System.out.println("NIF inválido. Estableciendo NIF por defecto: 00000000A");
      this.dni = "00000000A"; // Default NIF for invalid input
    }
  }

  // Static helper method to validate a DNI string
  public static boolean isNIF(String dato) {
    if (dato == null || !dato.matches("[0-9]{8}[A-Z]")) {
      return false;
    }
    String numero = dato.substring(0, 8);
    char letraDni = dato.charAt(8);
    int intNumero = Integer.parseInt(numero);
    char letraCalculada = Nif.letra.charAt(intNumero % 23);
    return letraDni == letraCalculada;
  }

  // Getter for dni
  public String getDni() {
    return dni;
  }

  // Setter for dni with validation
  public void setDni(String newDni) {
    if (isNIF(newDni)) {
      this.dni = newDni;
    } else {
      this.dni = "00000000A";
      System.out.println("NIF inválido. No se ha cambiado el NIF.");
    }
  }

  public void setDni(Nif n) {
    this.dni = n.dni;
  }

  public boolean equals(Nif n) {
    return this.getDni() == n.getDni();
  }

  public static void main(String[] args) {
    System.out.println("--- Probando Nif ---");
    Nif nif1 = new Nif("12345678A"); // Assuming this is a valid DNI for testing
    System.out.println("Nif 1: " + nif1.getDni() + " es válido: " + Nif.isNIF("12345678A"));

    Nif nif2 = new Nif("00000000B"); // This is an invalid NIF for testing the default
    System.out.println("Nif 2: " + nif2.getDni() + " es válido: " + Nif.isNIF("00000000B"));
    nif2.setDni("11111111H"); // Valid DNI
    System.out.println("Nif 2 actualizado: " + nif2.getDni());
  }
}

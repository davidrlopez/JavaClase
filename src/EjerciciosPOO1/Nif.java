package EjerciciosPOO1;

import java.util.Objects;

public class Nif {
  private static final String DEFAULT_NIF = "00000000A";
  private String dni;
  private static final String letra = "TRWAGMYFPDXBNJZSQVHLCKE";

  // Default constructor
  public Nif() {
    this.dni = DEFAULT_NIF;
  }

  // Constructor that takes a DNI string
  public Nif(String numeroDni) {
    if (isNIF(numeroDni)) {
      this.dni = numeroDni;
    } else {
      System.out.println("NIF inválido. Estableciendo NIF por defecto: " + DEFAULT_NIF);
      this.dni = DEFAULT_NIF; // Default NIF for invalid input
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
      this.dni = DEFAULT_NIF;
      System.out.println("NIF inválido. No se ha cambiado el NIF.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Nif nif = (Nif) o;
    return dni.equals(nif.dni);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dni);
  }

  public void displayDetails() {
    System.out.println("Nif:" + this.dni);
  }

  @Override
  public String toString() {
    return "Nif [dni=" + dni + "]";
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

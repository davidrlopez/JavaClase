package Trimestre2;

import java.util.Scanner;

class Persona {
  public String dni;
  public String nombre;
  public String apellido1;
  public String apellido2;
  public boolean sexo;
  public double sueldo;

  public void ver_datos() {

    String sexo;

    System.out.println("DNI: " + this.dni);
    System.out.println("Nombre: " + this.nombre);
    System.out.println("Primer Apellido: " + this.apellido1);
    System.out.println("Segundo Apellido: " + this.apellido2);

    if (this.sexo) {
      sexo = "Macho";
    } else if (this.dni != null) {
      sexo = "Hembra";
    } else
      sexo = null;

    System.out.println("Sexo (true=masculino, false=femenino): " + sexo);
    System.out.println("Sueldo: " + this.sueldo);

  }

  public Persona() { // Constructor para sustituir el por defecto

    Scanner teclado;
    teclado = new Scanner(System.in);
    System.out.println("Introduzca DNI");
    this.dni = teclado.next();
    System.out.println("Introduzca nombre");
    this.nombre = teclado.next();
    System.out.println("Introduzca apellido1");
    this.apellido1 = teclado.next();
    System.out.println("Introduzca apellido2");
    this.apellido2 = teclado.next();
    System.out.println("Introduzca sexo");
    this.sexo = teclado.nextBoolean();
    System.out.println("introduzca sexo");
    this.sueldo = teclado.nextDouble();

  }

  public void guardar_datos(String dni, String nombre, String apellido1, String apellido2, boolean sexo,
      double sueldo) {

    this.dni = dni;
    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
    this.sexo = sexo;
    this.sueldo = sueldo;

  }

  public String obtener_DNI(String d) {
    return this.dni = d;
  }

  public String obtener_nombre(String n) {
    return this.nombre = n;
  }

  public String obtener_apellido1(String a1) {
    return this.apellido1 = a1;
  }

  public String obtener_apellido2(String a2) {
    return this.apellido2 = a2;
  }

  public Boolean obtener_sexo(Boolean s) {
    return this.sexo = s;
  }

  public Double obtener_sueldo(Double sd) {
    return this.sueldo = sd;
  }

  public class PloyectoPOO1 {

    public static void main(String[] args) {
      // System.out.println("Hello World!");
      Persona Alberto; // Declaracion de objetos Alberto
      Alberto = new Persona(); // Instaciación del objeto

      String sexo = "";

      Alberto.ver_datos();

      System.out.println("     -----      ");
      Alberto.dni = "92384334D";
      Alberto.nombre = "Juan";
      Alberto.apellido1 = "Garcia";
      Alberto.apellido2 = "Torreznos";
      Alberto.sexo = true;
      Alberto.sueldo = 1050.4;

      if (Alberto.sexo) {
        sexo = "Macho";
      } else
        sexo = "Hembra";

      Alberto.ver_datos();

    }
  }
}

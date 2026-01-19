package EjerciciosPOO1;

import java.util.Scanner;

class Persona {
  private Nif nif;
  private String nombre;
  private String apellido1;
  private String apellido2;
  private boolean sexo;
  private double sueldo;
  private Fecha fecha_nacimiento;

  public void ver_datos() {
    System.out.println("Nombre: " + this.nombre);
    System.out.println("Primer Apellido: " + this.apellido1);
    System.out.println("Segundo Apellido: " + this.apellido2);

  }

  public Persona() {

    this.nif = new Nif();
    this.nombre = "****";
    this.apellido1 = "*****";
    this.apellido2 = "******";
    this.sexo = true;
    this.fecha_nacimiento = new Fecha();
  }

  public Nif getNif() {
    return nif;
  }

  public void setNif(Nif nif) {
    this.nif = nif;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido1() {
    return apellido1;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  public String getApellido2() {
    return apellido2;
  }

  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }

  public boolean isSexo() {
    return sexo;
  }

  public void setSexo(boolean sexo) {
    this.sexo = sexo;
  }

  public double getSueldo() {
    return sueldo;
  }

  public void setSueldo(double sueldo) {
    this.sueldo = sueldo;
  }

  public Fecha getFecha_nacimiento() {
    return fecha_nacimiento;
  }

  public void setFecha_nacimiento(Fecha fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
  }

  public void guardar_datos(String nombre, String apellido1, String apellido2, boolean sexo,
      double sueldo) {

    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
    this.sexo = sexo;
    this.sueldo = sueldo;

  }

  // to string

  public static void main(String[] args) {
    Persona Alberto;
    Alberto = new Persona();

    String sexo = "";

    Alberto.ver_datos();

    System.out.println("     -----      ");
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

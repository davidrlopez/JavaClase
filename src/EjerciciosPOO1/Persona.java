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
  private boolean estado;

  public void ver_datos() {
    this.nif.ver_datos();
    System.out.println("Nombre: " + this.nombre);
    System.out.println("Primer Apellido: " + this.apellido1);
    System.out.println("Segundo Apellido: " + this.apellido2);
    System.out.println("Sexo:" + this.sexo);
    System.out.println("Estado:" + this.estado);
    this.getFecha_nacimiento().verFecha();

  }

  public Persona(String nif, String no, String ap1, String ap2, boolean se, boolean es, double su, int d, int m,
      int a) {
    this.setPersona(nif, no, ap1, ap2, se, es, su, d, m, a);
  }

  public Persona(Nif ni, String no, String ap1, String ap2, boolean se, boolean es, double su, Fecha fe) {
    this.setPersona(ni, no, ap1, ap2, se, es, su, fe);
  }

  public Persona() {

    this.nif = new Nif();
    this.nombre = "****";
    this.apellido1 = "*****";
    this.apellido2 = "******";
    this.sexo = true;
    this.estado = true;
    this.fecha_nacimiento = new Fecha();
  }

  public void setPersona(Nif ni, String no, String ap1, String ap2, boolean se, boolean es, double su, Fecha fe) {
    this.nif = new Nif();
    this.nombre = "****";
    this.apellido1 = "*****";
    this.apellido2 = "******";
    this.sexo = true;
    this.estado = true;
    this.fecha_nacimiento = new Fecha();

  }

  public void setPersona(String ni, String no, String ap1, String ap2, boolean se, boolean es, double su, int d, int m,
      int a) {
    this.nif = new Nif();
    this.nombre = "****";
    this.apellido1 = "*****";
    this.apellido2 = "******";
    this.sexo = true;
    this.estado = true;
    this.fecha_nacimiento = new Fecha(d, m, a);

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

  @Override
  public String toString() {
    return "Persona [nif=" + nif + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
        + ", sexo=" + sexo + ", sueldo=" + sueldo + ", fecha_nacimiento=" + fecha_nacimiento + ", estado=" + estado
        + ", getNif()=" + getNif() + ", getNombre()=" + getNombre() + ", getApellido1()=" + getApellido1()
        + ", getApellido2()=" + getApellido2() + ", isSexo()=" + isSexo() + ", getClass()=" + getClass()
        + ", getSueldo()=" + getSueldo() + ", getFecha_nacimiento()=" + getFecha_nacimiento() + ", hashCode()="
        + hashCode() + ", toString()=" + super.toString() + "]";
  }

  public static void main(String[] args) {
    Persona Alberto;
    Alberto = new Persona();
    System.out.println(Alberto.toString());
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
    Persona ana = new Persona("123455", "Ana", "Robles", "Montilla", false, true, 1200, 5, 1, 1980);
    System.out.println(ana.toString());
    ana.ver_datos();

    Fecha fe = new Fecha(01, 01, 1980);
    Nif ni = new Nif("888888881A");
    Persona elena = new Persona(ni, "Elena", "Lopez", "Lopez", false, true, 1500, fe);
  }
}

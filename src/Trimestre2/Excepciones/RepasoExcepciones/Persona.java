package Trimestre2.Excepciones.RepasoExcepciones;

import static Trimestre2.Excepciones.RepasoExcepciones.ExceptionsPersona.*;
import static Trimestre2.Excepciones.RepasoExcepciones.FechasException.*;

public class Persona {

  private String nombre = "";
  private String apellido1 = "";
  private String apellido2 = "";
  private String sexo = "";
  private String estado = "";
  private Fecha fechaNac = new Fecha(1, 1, 2000);
  private Nif nif = new Nif(10000);

  // Constructor vacío (buena práctica)
  public Persona() {
  }

  // --- SETTERS CON VALIDACIÓN ---

  public void setNombre(String no) throws NombreException {
    // CORRECCIÓN: Usar == para nulos
    if (no == null || no.trim().isEmpty()) {
      throw new NombreException("El nombre no puede estar vacío");
    }
    this.nombre = no;
  }

  // ... (Getters y Setters de apellidos, sexo, estado igual pero con validación
  // null) ...

  public void setPersona(String no, String ap1, String ap2, String sexo, String estado, String fStr, String nifStr)
      throws NombreException, YearException, MesException, DiaException {
    setNombre(no);
    this.apellido1 = ap1;
    this.apellido2 = ap2;
    this.sexo = sexo;
    this.estado = estado;
    // ASIGNACIÓN CORRECTA: Guardamos en el atributo de la clase
    this.fechaNac = new Fecha(fStr);
    this.nif = new Nif(nifStr);
  }

  public void setPersona(Persona otra) throws NombreException, YearException, MesException, DiaException {
    if (otra == null)
      return;

    setNombre(otra.nombre);
    this.apellido1 = otra.apellido1;
    this.apellido2 = otra.apellido2;
    this.sexo = otra.sexo;
    this.estado = otra.estado;
    // Copiamos los objetos (usando constructor de copia si existe)
    this.fechaNac = new Fecha(otra.fechaNac);
    this.nif = new Nif(otra.nif);
  }

  // --- MÉTODOS ESPECIALES ---

  // toString sobrecargado con opciones
  public String toString(int opcion) {
    switch (opcion) {
      case 1: // Formato corto: Inicial Nombre + Apellidos
        return nombre.substring(0, 1) + ". " + apellido1 + " " + apellido2;
      case 2: // Nombre completo con iniciales apellidos
        return nombre + " " + apellido1.substring(0, 1) + ". " + apellido2.substring(0, 1) + ".";
      default:
        return toString(); // Llama al toString normal por defecto
    }
  }

  @Override
  public String toString() {
    return String.format("%s %s, %s [%s] Nacido el: %s",
        nombre, apellido1, apellido2, nif, fechaNac);
  }

  public boolean equals(Persona otra) {
    if (otra == null) {
      return false;
    }
    return this.nombre.equals(otra.nombre) && this.apellido1.equals(otra.apellido1);
  }
}

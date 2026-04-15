package Trimestre3.Colecciones.Instituto;

import Trimestre2.Excepciones.RepasoExcepciones.Persona;
import static Trimestre2.Excepciones.RepasoExcepciones.FechasException.*;
import static Trimestre2.Excepciones.RepasoExcepciones.ExceptionsPersona.*;

public class Profesor extends Persona {
  private int years_trabajados = 0;
  private String especialidad = "";
  private double sueldo = 0;

  public int getYears_trabajados() {
    return years_trabajados;
  }

  public void setYears_trabajados(int years_trabajados) throws IllegalArgumentException {
    if (years_trabajados < 0) {
      throw new IllegalArgumentException("La experiencia no puede ser negativa");
    }
    this.years_trabajados = years_trabajados;
  }

  public Profesor(int years_trabajados, String especialidad, double sueldo) {
    super();
    setYears_trabajados(years_trabajados);
    setEspecialidad(especialidad);
    setSueldo(sueldo);
  }

  public Profesor(int years_trabajados, String especialidad, double sueldo, String no, String ap1, String ap2,
      String sexo, String estado, String fStr,
      String nifStr)
      throws IllegalArgumentException, DiaException, MesException, YearException, NombreException {
    super();
    setPersona(no, ap1, ap2, sexo, estado, fStr, nifStr);
    setYears_trabajados(years_trabajados);
    setEspecialidad(especialidad);
    setSueldo(sueldo);
  }

  public Profesor() {
    super();
    setEspecialidad(especialidad);
    setSueldo(sueldo);
    setYears_trabajados(years_trabajados);
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public double getSueldo() {
    return sueldo;
  }

  public void setSueldo(double sueldo) throws IllegalArgumentException {
    if (sueldo < 0) {
      throw new IllegalArgumentException("El sueldo no puede ser negativo");
    }
    this.sueldo = sueldo;
  }

  @Override
  public String toString() {
    return super.toString() + " | Especialidad: " + especialidad + ", Sueldo: " + sueldo + "€";
  }

}

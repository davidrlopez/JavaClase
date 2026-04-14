package Trimestre3.Colecciones;

import Trimestre2.Excepciones.RepasoExcepciones.Persona;
import static Trimestre2.Excepciones.RepasoExcepciones.FechasException.*;
import static Trimestre2.Excepciones.RepasoExcepciones.ExceptionsPersona.*;

public class Alumno extends Persona {
  private int curso = 1;
  private String nvIngles = "A1";

  public Alumno(int curso, String nvIngles, String no, String ap1, String ap2, String sexo, String estado, String fStr,
      String nifStr)
      throws NombreException, YearException, MesException, DiaException, IllegalArgumentException {

    super();
    setPersona(no, ap1, ap2, sexo, estado, fStr, nifStr);
    setCurso(curso);
    setNvIngles(nvIngles);
  }

  public Alumno() throws IllegalArgumentException {
    super();
    setCurso(curso);
    setNvIngles(nvIngles);
  }

  public Alumno(int curso, String nvIngles) throws IllegalArgumentException {
    super();
    setCurso(curso);
    setNvIngles(nvIngles);
  }

  public int getCurso() {
    return curso;
  }

  public void setCurso(int curso) throws IllegalArgumentException {
    if (curso <= 0) {
      throw new IllegalArgumentException("Curso incorrecto");
    }
    this.curso = curso;
  }

  public String getNvIngles() {
    return nvIngles;
  }

  public void setNvIngles(String nvIngles) throws IllegalArgumentException {
    if (!nvIngles.matches("[A-C][12]")) {
      throw new IllegalArgumentException("Nivel no valido");
    }
    this.nvIngles = nvIngles;
  }

}

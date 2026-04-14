package Trimestre2.Excepciones.RepasoExcepciones;

import Trimestre2.Excepciones.RepasoExcepciones.Persona;

public class ExceptionsPersona {
  public static class NombreException extends Exception {
    public NombreException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class ApellidoException extends Exception {
    public ApellidoException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class SexoException extends Exception {
    public SexoException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class EstadoException extends Exception {
    public EstadoException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

}

package Trimestre2.Excepciones.RepasoExcepciones;

import Trimestre2.Excepciones.RepasoExcepciones.Persona;

public class ExceptionsPersona {
  public static class nombreException extends Exception {
    public nombreException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class apellidoException extends Exception {
    public apellidoException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class sexoException extends Exception {
    public sexoException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class estadoException extends Exception {
    public estadoException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

}

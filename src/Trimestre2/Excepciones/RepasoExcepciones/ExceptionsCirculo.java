package Trimestre2.Excepciones.RepasoExcepciones;

public class ExceptionsCirculo {

  public static class RadioException extends Exception {
    String mensaje;

    public RadioException(String mensaje) {
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "RadioException:" + mensaje;
    }
  }

  public static class CentroException extends Exception {
    String mensaje;

    public CentroException(String mensaje) {
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "CentroException:" + mensaje;
    }
  }
}

package Trimestre2.Excepciones.RepasoExcepciones;

public class FechasException {

  public static class DiaException extends Exception {
    String mensaje;

    public DiaException(String mensaje) {
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "DiaException:" + mensaje;
    }
  }

  public static class MesException extends Exception {
    String mensaje;

    public MesException(String mensaje) {
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "MesException:" + mensaje;
    }
  }

  public static class YearException extends Exception {
    String mensaje;

    public YearException(String mensaje) {
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "YearException:" + mensaje;
    }
  }

}

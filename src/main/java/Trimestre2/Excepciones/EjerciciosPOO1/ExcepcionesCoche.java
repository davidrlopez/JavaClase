package Trimestre2.Excepciones.EjerciciosPOO1;

public class ExcepcionesCoche {
  public static class PuertasException extends Exception {
    String mensaje;

    public PuertasException(String mensaje) {
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "PuertasException: " + mensaje;
    }
  }

  public static class PrecioException extends Exception {
    String mensaje;

    public PrecioException(String mensaje) {
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "PreciosException: " + mensaje;
    }
  }

  public static class CombustibleException extends Exception {
    String mensaje;

    public CombustibleException(String mensaje) {
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "CombustibleException: " + mensaje;
    }
  }

  public static class CambioException extends Exception {
    String mensaje;

    public CambioException(String mensaje) {
      super(mensaje);
      this.mensaje = mensaje;
    }

    @Override
    public String toString() {
      return "CambioException: " + mensaje;
    }
  }
}

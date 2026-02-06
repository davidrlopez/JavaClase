package Trimestre2.Excepciones.RepasoExcepciones;

public class ExceptionsCoche {

  public static class PuertasException extends Exception {
    public PuertasException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class PrecioException extends Exception {
    public PrecioException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class CombustibleException extends Exception {
    public CombustibleException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class CambioException extends Exception {
    public CambioException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class MarcaException extends Exception {
    public MarcaException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }
}

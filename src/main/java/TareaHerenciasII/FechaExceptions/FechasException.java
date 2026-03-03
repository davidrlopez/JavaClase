package TareaHerenciasII.FechaExceptions;

public class FechasException {

  public static class DiaException extends Exception {
    public DiaException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return "DiaException:" + getMessage();
    }
  }

  public static class MesException extends Exception {
    public MesException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return "MesException:" + getMessage();
    }
  }

  public static class YearException extends Exception {
    public YearException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return "YearException:" + getMessage();
    }
  }
}

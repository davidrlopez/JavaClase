package Trimestre2.Excepciones.RepasoExcepciones;

public class ExceptionsCirculo {

  // Clase base para tus excepciones (Opcional, pero recomendado para agrupar)
  public static class CirculoException extends Exception {
    public CirculoException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      // getMessage() recupera el String que pasaste al super()
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class RadioException extends CirculoException {
    public RadioException(String mensaje) {
      super(mensaje);
    }
  }

  public static class CentroException extends CirculoException {
    public CentroException(String mensaje) {
      super(mensaje);
    }
  }
}

package Trimestre2.Herencias.Vehiculo;

public class VehiculoExceptions {

  public static class PrecioIncorrecto extends IllegalArgumentException {
    public PrecioIncorrecto(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class PotenciaIncorrecta extends IllegalArgumentException {
    public PotenciaIncorrecta(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

  public static class RevisionesIncorrectas extends IllegalArgumentException {
    public RevisionesIncorrectas(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return getClass().getSimpleName() + ":" + getMessage();
    }
  }
}

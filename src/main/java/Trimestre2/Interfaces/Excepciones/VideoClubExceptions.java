package Trimestre2.Interfaces.Excepciones;

public class VideoClubExceptions {
  public static class VideoClubException extends Exception {
    public VideoClubException() {
      super();
    }

    public VideoClubException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class ProductosException extends Exception {
    public ProductosException() {
      super();
    }

    public ProductosException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class DuracionProductosException extends Exception {
    public DuracionProductosException() {
      super();
    }

    public DuracionProductosException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class DuracionPeliculaException extends Exception {
    public DuracionPeliculaException() {
      super("Error, la duración de una Pelicula no puede ser negativa o 0");
    }

    public DuracionPeliculaException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class DuracionCDException extends Exception {
    public DuracionCDException() {
      super("Error, la duración de un CD no puede ser negativa o 0");
    }

    public DuracionCDException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class IdiomaPeliculaException extends Exception {
    public IdiomaPeliculaException() {
      super("Error, el idioma de una Película no está definido");
    }

    public IdiomaPeliculaException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class CapacidadArrayException extends Exception {
    public CapacidadArrayException() {
      super();
    }

    public CapacidadArrayException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class NoMas5ProductosAlquiladosPorClienteException extends Exception {
    public NoMas5ProductosAlquiladosPorClienteException() {
      super("Error, un cliente nunca puede alquilar más de 5 productos");
    }

    public NoMas5ProductosAlquiladosPorClienteException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class NoMas50ProductosVideoClubException extends Exception {
    public NoMas50ProductosVideoClubException() {
      super("Error, el Video Club no puede tener más de 50 productos");
    }

    public NoMas50ProductosVideoClubException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class NoMas20ClientesVideoClubException extends Exception {
    public NoMas20ClientesVideoClubException() {
      super("Error, el Video Club no puede tener más de 20 clientes");
    }

    public NoMas20ClientesVideoClubException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }

  public static class AlquilarException extends Exception {
    public AlquilarException() {
      super("Error al intentar alquilar un producto");
    }

    public AlquilarException(String mensaje) {
      super(mensaje);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + ": " + getMessage();
    }
  }
}

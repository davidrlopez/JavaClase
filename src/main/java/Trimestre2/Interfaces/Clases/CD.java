package Trimestre2.Interfaces.Clases;

public class CD {

  private static int duracion = 0;
  private static int genero = 0;
  private static int contCD = 0;

  public static int getDuracion() {
    return duracion;
  }

  public static void setDuracion(int duracion) {
    CD.duracion = duracion;
  }

  public static int getGenero() {
    return genero;
  }

  public static void setGenero(int genero) {
    CD.genero = genero;
  }

  public static int getContCD() {
    return contCD;
  }

  public static void setContCD(int contCD) {
    CD.contCD = contCD;
  }

  public CD() {
    setGenero(genero);
    setContCD(contCD);
    setDuracion(duracion);
  }

public CD()
}

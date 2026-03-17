package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.*;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.DuracionCDException;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.AlquilarException;

public class CD extends ProductoVideoClub implements Alquilable {

  private int duracion = 0;
  private int genero = 0;
  private static int contCD = 0;

  public int getDuracion() {
    return this.duracion;
  }

  public void setDuracion(int duracion) throws DuracionCDException {
    if (duracion <= 0) {
      throw new DuracionCDException("La duracion tiene que ser mayor a 0");
    }
    this.duracion = duracion;
  }

  public int getGenero() {
    return this.genero;
  }

  public void setGenero(int genero) {
    this.genero = genero;
  }

  public static int getContCD() {
    return contCD;
  }

  public static void setContCD(int contCD) {
    CD.contCD = contCD;
  }

  public CD(String nombre, int genero, int duracion) throws DuracionCDException {
    super(nombre);
    setGenero(genero);
    setDuracion(duracion);
    contCD++;
  }

  public CD(CD otro) throws DuracionCDException {
    super(otro.getNombre());
    setDuracion(otro.getDuracion());
    setGenero(otro.getGenero());
    contCD++;
  }

  @Override
  public double getPrecio() {
    return 1.0;
  }

  @Override
  public void devolver() throws AlquilarException {
    super.devolver();
  }

  @Override
  public void retirar() throws AlquilarException {
    super.retirar();
  }
}

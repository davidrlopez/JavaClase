package Trimestre2.Interfaces.Interfaces;

import static Trimestre2.Interfaces.Excepciones.VideoClubExceptions.*;

public interface Alquilable {

  public void alquilar() throws AlquilarException;

  public void devolver();

  public boolean isAlquilado();
}

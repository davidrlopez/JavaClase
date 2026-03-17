package Trimestre2.Interfaces.Interfaces;

import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.AlquilarException;

public interface Retirable {

  public void retirar() throws AlquilarException;

  public boolean isRetirado();
}

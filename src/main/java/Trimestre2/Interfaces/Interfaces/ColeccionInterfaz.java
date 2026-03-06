package Trimestre2.Interfaces.Interfaces;

import java.util.NoSuchElementException;

public interface ColeccionInterfaz {

  public boolean estaVacia();

  public Object extraer() throws NoSuchElementException;

  public Object primero() throws NoSuchElementException;

  public boolean añadir(Object o);
}

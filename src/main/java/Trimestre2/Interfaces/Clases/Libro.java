package Trimestre2.Interfaces.Clases;

import java.awt.IllegalComponentStateException;

import Trimestre2.Interfaces.Interfaces.Prestable;

public class Libro extends Publicacion implements Prestable {
  private boolean prestado = false;

  public boolean prestado() {
    return prestado;
  }

  public void setPrestado(boolean prestado) throws IllegalComponentStateException {
    if (prestado() == true) {
      throw new IllegalComponentStateException("El libro ya estaba prestado");
    }
    this.prestado = prestado;
  }

  public Libro(int id, String titulo, int year, boolean prestado) {
    super(id, titulo, year);
    setPrestado(prestado);
  }

  public boolean prestar() throws IllegalArgumentException {
    setPrestado(prestado);
    return prestado;
  }

  public boolean devolver() throws IllegalArgumentException {
    boolean devuelto = false;
    if (prestado() == false) {
      throw new IllegalArgumentException("No esta prestado para poder devolverlo");
    } else {
      setPrestado(true);
      devuelto = true;
    }
    return devuelto;
  }
}

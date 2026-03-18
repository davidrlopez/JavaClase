package Trimestre2.ExamenNetflix.Clases;

import Trimestre2.ExamenNetflix.ExceptionsNetflix.GeneroException;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.PrecioException;

public class Videojuego extends Producto {
  private int numVideojuego = 0;
  private String genero = "DRAMA";
  private static double tipoIVA = 0.04;

  public int getNumVideojuego() {
    return this.numVideojuego;
  }

  public void setNumVideojuego(int numVideojuego) {
    this.numVideojuego = numVideojuego;
  }

  public String getGenero() {
    return this.genero;
  }

  public void setGenero(String genero) throws GeneroException {
    if (!genero.toUpperCase().equals("DRAMA") || !genero.toUpperCase().equals("COMEDIA")
        || !genero.toUpperCase().equals("TERROR") || !genero.toUpperCase().equals("BELICA")
        || !genero.toUpperCase().equals("ANIMACION")) {
      throw new GeneroException("Genero desconocido");
    }
    this.genero = genero;
  }

  public double getTipoIVA() {
    return Videojuego.tipoIVA;
  }

  public void setTipoIVA(double tipoIVA) {
    Videojuego.tipoIVA = tipoIVA;
  }

  public Videojuego(Producto otro) throws PrecioException {
    super(otro);
    numVideojuego++;
  }

  public Videojuego(String nombreProd, int idProd, boolean alquilado, double precioAqluiler, int numVideojuegoTry,
      String genero, double tipoIVA) throws PrecioException, GeneroException {
    super(nombreProd, idProd, alquilado, precioAqluiler);
    numVideojuegoTry = numVideojuego++;
    setGenero(genero);
    setTipoIVA(tipoIVA);
  }

  public boolean alquilar() throws IllegalArgumentException {
    if (this.isAlquilado() == true) {
      throw new IllegalArgumentException("Ya estaba alquilado");
    }
    setAlquilado(true);
    return this.isAlquilado();
  }

  public boolean devolver() throws IllegalArgumentException {
    if (this.isAlquilado() == false) {
      throw new IllegalArgumentException("No estaba alquilado");
    }
    setAlquilado(false);
    return this.isAlquilado();
  }

  public double PrecioAlquilerIVA() {
    return this.getPrecioSinIVA() + (this.getPrecioSinIVA() * tipoIVA);
  }

  public boolean estaAlquilado() {
    return this.isAlquilado();
  }

  @Override
  public String toString() {
    return "Nombre del producto:" + this.getNombreProd() + " ID:" + this.getIdProd() + " estado alquiler:"
        + this.isAlquilado() + " precio sin iva:" + this.getPrecioSinIVA() + " numVideojuego:" + this.getNumVideojuego()
        + " genero:" + this.getGenero() + " tipoIVA:" + this.getTipoIVA() + " precio total con IVA:"
        + PrecioAlquilerIVA();

  }
}

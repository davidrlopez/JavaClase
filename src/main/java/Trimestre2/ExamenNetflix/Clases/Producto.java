package Trimestre2.ExamenNetflix.Clases;

import Trimestre2.ExamenNetflix.Interfaces.Alquilable;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.PrecioException;

public abstract class Producto implements Alquilable {

  private String nombreProd = "";
  private int idProd = 0;
  private boolean alquilado = false;
  private double precioAqluiler = 0;

  public String getNombreProd() {
    return this.nombreProd;
  }

  public void setNombreProd(String nombreProd) {
    this.nombreProd = nombreProd;
  }

  public int getIdProd() {
    return this.idProd;
  }

  public void setIdProd(int idProd) {
    this.idProd = idProd;
  }

  public boolean isAlquilado() {
    return this.alquilado;
  }

  public void setAlquilado(boolean alquilado) {
    this.alquilado = alquilado;
  }

  public double getPrecioSinIVA() {
    return this.precioAqluiler;
  }

  public void setPrecioSinIVA(double precioAqluiler) throws PrecioException {
    if (precioAqluiler < 0) {
      throw new PrecioException("Precio no puede ser negativo");
    }
    this.precioAqluiler = precioAqluiler;
  }

  public Producto(String nombreProd, int idProd, boolean alquilado, double precioAqluiler) throws PrecioException {
    setNombreProd(nombreProd);
    setIdProd(idProd);
    setAlquilado(alquilado);
    setPrecioSinIVA(precioAqluiler);
  }

  public Producto(Producto otro) throws PrecioException {
    setNombreProd(otro.nombreProd);
    setIdProd(otro.idProd);
    setAlquilado(otro.alquilado);
    setPrecioSinIVA(otro.precioAqluiler);
  }

  public Producto() {

  }

  @Override
  public String toString() {
    return "Nombre del producto:" + this.getNombreProd() + " ID:" + this.getIdProd() + " estado alquiler:"
        + this.isAlquilado() + " precio sin iva:" + this.getPrecioSinIVA();
  }

}

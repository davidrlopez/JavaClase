package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.Vendible;

public abstract class Viaje implements Vendible {

  protected String origen = "";
  protected String destino = "";
  protected int nDias = 0;
  protected double precio = 0;
  private static double iva = 0.21;

  public String getOrigen() {
    return origen;
  }

  public void setOrigen(String origen) {
    this.origen = origen;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public int getnDias() {
    return nDias;
  }

  public void setnDias(int nDias) {
    this.nDias = nDias;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public Viaje(String origen, String destino, int nDias, double precio) {
    this.origen = origen;
    this.destino = destino;
    this.nDias = nDias;
    this.precio = precio;
  }

  public double precioIva() {
    return getPrecio() * (1 + iva);
  }

  @Override
  public String toString() {
    return "Viaje{" +
        "origen='" + getOrigen() + '\'' +
        ", destino=" + getDestino() +
        ", dias=" + getnDias() +
        ", iva=" + iva +
        ", precio con IVA=" + precioIva() +
        '}';
  }

}

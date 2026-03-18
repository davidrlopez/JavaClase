package Trimestre2.ExamenNetflix.SubClases;

import Trimestre2.ExamenNetflix.ExceptionsNetflix.DateFaultException;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.GeneroException;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.PrecioException;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.DuracionException;
import Trimestre2.ExamenNetflix.Clases.Producto;
import Trimestre2.ExamenNetflix.Interfaces.*;

public class Pelicula extends Producto implements Vendible {
  private int numPelicula = 0;
  private String fechaPelicula = "01/01/1700";
  private String generoPelicula = "DRAMA";
  private int duracion = 0;
  private static double tipoIVA = 0.21;
  private boolean vendida = false;
  private double precioVenta = 0;

  public int getNumPelicula() {
    return this.numPelicula;
  }

  public void setNumPelicula(int numPelicula) {
    this.numPelicula = numPelicula;
  }

  public String getFechaPelicula() {
    return fechaPelicula;
  }

  public static boolean fechaValida(String fechaPelicula) throws DateFaultException {
    boolean isValida = false;
    if (fechaPelicula.length() == 10 && fechaPelicula.charAt(2) == '/' && fechaPelicula.charAt(5) == '/') {
      isValida = true;
    } else {
      throw new DateFaultException("El formato de fecha debe ser XX/XX/XXXX y de valores positivos");
    }
    return isValida;
  }

  public void setFechaPelicula(String fechaPelicula) throws DateFaultException {
    if (!fechaValida(fechaPelicula)) {
      throw new DateFaultException("Fecha con formato incorrecto");
    }
    this.fechaPelicula = fechaPelicula;
  }

  public String getGeneroPelicula() {
    return generoPelicula;
  }

  public void setGeneroPelicula(String generoPelicula) throws GeneroException {
    if (!generoPelicula.toUpperCase().equals("DRAMA") && !generoPelicula.toUpperCase().equals("COMEDIA")
        && !generoPelicula.toUpperCase().equals("TERROR") && !generoPelicula.toUpperCase().equals("BELICA")
        && !generoPelicula.toUpperCase().equals("ANIMACION")) {
      throw new GeneroException("Genero desconocido");
    }
    this.generoPelicula = generoPelicula;

  }

  public int getDuracion() {
    return duracion;
  }

  public void setDuracion(int duracion) throws DuracionException {
    if (duracion <= 0) {
      throw new DuracionException("La duracion no puede ser negativa");
    }
    this.duracion = duracion;
  }

  public static double getTipoIVA() {
    return tipoIVA;
  }

  public static void setTipoIVA(double tipoIVA) {
    Pelicula.tipoIVA = tipoIVA;
  }

  @Override
  public boolean estaVendido() {
    return vendida;
  }

  public void setVendida(boolean vendida) throws IllegalArgumentException {
    if (this.isAlquilado() == true) {
      throw new IllegalArgumentException("El producto esta actualmente alquilado");
    }
    this.vendida = vendida;
  }

  public double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public Pelicula(Producto otro) throws PrecioException, DateFaultException, GeneroException, DuracionException {
    super(otro);
    numPelicula++;
    setFechaPelicula(fechaPelicula);
    setGeneroPelicula(generoPelicula);
    setDuracion(duracion);
    setTipoIVA(tipoIVA);
    setVendida(vendida);
    setPrecioVenta(precioVenta);
  }

  public Pelicula(String nombreProd, int idProd, boolean alquilado, double precioAqluiler, int numPeliculaTry,
      String fechaPelicula, String generoPelicula, int duracion, boolean vendida, double precioVenta)
      throws PrecioException, DateFaultException, GeneroException, DuracionException {
    super(nombreProd, idProd, alquilado, precioAqluiler);
    numPelicula++;
    setFechaPelicula(fechaPelicula);
    setGeneroPelicula(generoPelicula);
    setDuracion(duracion);
    setVendida(vendida);
    setPrecioVenta(precioVenta);
  }

  @Override
  public boolean alquilar() throws IllegalArgumentException {
    if (this.isAlquilado() == true) {
      throw new IllegalArgumentException("Ya estaba alquilado");
    }
    setAlquilado(true);
    return this.isAlquilado();
  }

  @Override
  public boolean devolver() throws IllegalArgumentException {
    if (this.isAlquilado() == false) {
      throw new IllegalArgumentException("No estaba alquilado");
    }
    setAlquilado(false);
    return this.isAlquilado();
  }

  @Override
  public double PrecioAlquilerIVA() {
    return super.getPrecioSinIVA() + (super.getPrecioSinIVA() * tipoIVA);
  }

  @Override
  public boolean estaAlquilado() {
    return this.isAlquilado();
  }

  @Override
  public boolean vender() {
    if (this.vendida == true) {
      return false;
    }
    try {
      setVendida(true);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return estaVendido();
  }

  @Override
  public double precioVentaIVA() {
    return this.precioVenta + (this.precioVenta * tipoIVA);
  }

  @Override
  public String toString() {
    return "Nombre del producto:" + this.getNombreProd() + " ID:" + this.getIdProd() + " estado alquiler:"
        + this.isAlquilado() + " precio alquiler sin iva:" + super.getPrecioSinIVA() + " numPelicula:"
        + this.getNumPelicula()
        + " genero:" + this.getGeneroPelicula() + " tipoIVA:" + Pelicula.getTipoIVA()
        + " precio alquiler total con IVA:"
        + PrecioAlquilerIVA() + " precio total venta con IVA:" + this.precioVentaIVA();

  }

}

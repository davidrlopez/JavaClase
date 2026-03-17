package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.Alquilable;
import Trimestre2.Interfaces.Interfaces.Retirable;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.AlquilarException;

public abstract class ProductoVideoClub implements Alquilable, Retirable {
  public String nombre;
  protected double precio = 0;
  public int id;
  private static int contProductos = 0;
  private boolean alquilado = false;
  private boolean retirado = false;

  public ProductoVideoClub(String nombre) {
    this.nombre = nombre;
    contProductos++;
    this.id = contProductos;
    this.alquilado = false;
    this.retirado = false;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public abstract double getPrecio();

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
    if (id > contProductos) {
      contProductos = id;
    }
  }

  @Override
  public String toString() {
    return "ProductoVideoClub [nombre=" + nombre + ", precio=" + precio + ", id=" + id + ", contProductos="
        + contProductos + ", alquilado=" + alquilado + ", retirado=" + retirado + ", getNombre()=" + getNombre()
        + ", getPrecio()=" + getPrecio() + ", getId()=" + getId() + ", getContProductos()=" + getContProductos()
        + ", isAlquilado()=" + isAlquilado() + ", isRetirado()=" + isRetirado() + ", getClass()=" + getClass() + "]";
  }

  public static int getContProductos() {
    return contProductos;
  }

  public void setContProductos(int contProductos) {
    ProductoVideoClub.contProductos = contProductos;
  }

  public boolean isAlquilado() {
    return alquilado;
  }

  public void setAlquilado(boolean alquilado) throws AlquilarException {
    if (this.isAlquilado() == true && alquilado == true) {
      throw new AlquilarException("El producto ya esta alquilado");
    } else {
      this.alquilado = alquilado;
    }
  }

  public void alquilar() throws AlquilarException {
    if (this.isAlquilado() == true) {
      throw new AlquilarException("El producto ya esta alquilado");
    } else {
      setAlquilado(true);
    }
  }

  public boolean isRetirado() {
    return retirado;
  }

  public void setRetirado(boolean retirado) {
    this.retirado = retirado;
  }

  public void devolver() throws AlquilarException {
    if (this.isAlquilado() == false) {
      throw new AlquilarException("El producto no se puede devolver porque no estaba alquilado");
    } else {
      setAlquilado(false);
    }
  }

  public void retirar() throws AlquilarException {
    if (this.isRetirado() == true) {
      throw new AlquilarException("El producto ya estaba retirado");
    } else {
      setRetirado(true);
    }
  }
}

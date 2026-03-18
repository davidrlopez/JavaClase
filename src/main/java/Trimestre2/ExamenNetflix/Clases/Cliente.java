package Trimestre2.ExamenNetflix.Clases;

import java.util.ArrayList;

import Trimestre2.ExamenNetflix.SubClases.Pelicula;

public class Cliente {
  private String dni = "";
  private String nombre = "";
  private ArrayList<Producto> productosAlquilados;
  private ArrayList<Pelicula> productosVendidos;

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public ArrayList<Producto> getProductosAlquilados() {
    return productosAlquilados;
  }

  public void setProductosAlquilados(ArrayList<Producto> productosAlquilados) {
    this.productosAlquilados = productosAlquilados;
  }

  public ArrayList<Pelicula> getProductosVendidos() {
    return productosVendidos;
  }

  public void setProductosVendidos(ArrayList<Pelicula> productosVendidos) {
    this.productosVendidos = productosVendidos;
  }

  public Cliente(String dni, String nombre, ArrayList<Producto> productosAlquilados,
      ArrayList<Pelicula> productosVendidos) {
    setDni(dni);
    setNombre(nombre);
    setProductosAlquilados(productosAlquilados);
    setProductosVendidos(productosVendidos);
  }

  public Cliente() {
    this.productosAlquilados = new ArrayList<>();
    this.productosVendidos = new ArrayList<>();
  }

  public boolean alquilar(Producto otro) throws IllegalArgumentException {
    if (otro.isAlquilado() == true) {
      throw new IllegalArgumentException("El producto ya esta alquilado");
    }
    otro.setAlquilado(true);
    this.productosAlquilados.add(otro);
    return otro.isAlquilado();
  }

  public boolean devolver(Producto otro) throws IllegalArgumentException {
    if (otro.isAlquilado() == false) {
      throw new IllegalArgumentException("El producto no esta alquilado");
    }
    otro.setAlquilado(false);
    this.productosAlquilados.remove(otro);
    return otro.isAlquilado();
  }

  public boolean comprar(Pelicula otro) throws IllegalArgumentException {
    if (otro.estaVendido() == true) {
      throw new IllegalArgumentException("El producto ya esta vendido");
    }
    otro.vender();
    this.productosVendidos.add(otro);
    return otro.estaVendido();
  }

  public double precioTotalAlquiler() {
    double suma = 0;
    for (Producto producto : productosAlquilados) {
      suma += producto.PrecioAlquilerIVA();
    }
    return suma;
  }

  public double precioTotalVenta() {
    double suma = 0;
    for (Pelicula pelicula : productosVendidos) {
      suma += pelicula.precioVentaIVA();
    }
    return suma;
  }

  public void listadoAlquilerPeliculas() {
    for (Producto producto : productosAlquilados) {

      if (producto instanceof Trimestre2.ExamenNetflix.SubClases.Pelicula) {
        System.out.println(producto.toString());

      }
    }

  }

  public void listadoVenta() {
    for (Pelicula pelicula : productosVendidos) {
      System.out.println(pelicula.toString());

    }

  }
}

package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.Vendible;
import java.util.ArrayList;

public class Carrito {
  protected ArrayList<Vendible> listaCarrito;

  public Carrito() {
    this.listaCarrito = new ArrayList<>();
  }

  public void addCarrito(Vendible v) {
    this.listaCarrito.add(v);
  }

  public void muestraCarrito() {
    for (Vendible v : listaCarrito) {
      System.out.println(v.toString());
    }
  }

  public double precioTotalCarrito() {
    double total = 0;
    for (Vendible v : listaCarrito) {
      total += v.precioIva();
    }
    return total;
  }

  public void mostrarCarritoViajes() {
    for (Vendible v : listaCarrito) {
      if (v instanceof Viaje) {
        System.out.println(v.toString());
      }
    }
  }

  public void mostrarCarritoDestinoViajes() {
    for (Vendible v : listaCarrito) {
      if (v instanceof Viaje) {
        Viaje viaje = (Viaje) v;
        System.out.println(viaje.getDestino());
      }
    }
  }
}

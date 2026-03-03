package Trimestre2.Interfaces.Clases;

public class Ropa extends Producto {
  private static final double iva = 0.1;

  public Ropa(String nombre, double precio) {
    super(nombre, precio);
  }

  public static double getIva() {
    return iva;
  }

  @Override
  public double precioIva() {
    return getPrecio() * (1 + iva);
  }

  @Override
  public String toString() {
    return "Alimentacion{" +
        "nombre='" + getNombre() + '\'' +
        ", precio=" + getPrecio() +
        ", iva=" + iva +
        ", precio con IVA=" + precioIva() +
        '}';
  }
}

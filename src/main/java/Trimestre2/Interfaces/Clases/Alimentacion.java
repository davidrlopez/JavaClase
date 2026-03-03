package Trimestre2.Interfaces.Clases;

public class Alimentacion extends Producto {
  private static final double iva = 0.04;

  public Alimentacion(String nombre, double precio) {
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

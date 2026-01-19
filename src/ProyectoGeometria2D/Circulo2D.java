package ProyectoGeometria2D;

import java.util.Objects;

public class Circulo2D {

  private double radio;
  private Punto2D centro;

  public Circulo2D() {
    this.radio = 0;
    this.centro = new Punto2D(0, 0);
  }

  public Circulo2D(double radio, double x, double y) {
    this.radio = radio;
    this.centro = new Punto2D(x, y);
  }

  public void ver_datos() {
    System.out.println("radio:" + this.radio);
    System.out.println("Punto2D:" + this.centro);
  }

  public double getRadio() {
    return radio;
  }

  public void setRadio(double radio) {
    this.radio = radio;
  }

  public Punto2D getCentro() {
    return centro;
  }

  public void setCentro(Punto2D centro) {
    this.centro = centro;
  }

  // FIX: Removed parameter to use the object's own radio
  public double superficie() {
    return Math.PI * Math.pow(this.radio, 2);
  }

  // FIX: Removed parameter to use the object's own radio
  public double longitud() {
    return 2 * Math.PI * this.radio;
  }

  public boolean igualSuperficie(Circulo2D otro) {
    if (otro == null)
      return false;
    // Comparing radii is equivalent to comparing area, but safer with epsilon
    double epsilon = 0.00001;
    return Math.abs(this.radio - otro.getRadio()) < epsilon;
  }

  public double distanciaPunto(Punto2D punto2) {
    return centro.distanceTo(punto2);
  }

  // Renamed from distanciaPunto(Circulo2D) as requested
  public double distanciaCirculo(Circulo2D circulo2) {
    return centro.distanceTo(circulo2.centro);
  }

  @Override
  public String toString() {
    return "Circulo2D [radio=" + radio + ", centro=" + centro + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Circulo2D circulo2D = (Circulo2D) o;
    return Double.compare(circulo2D.radio, radio) == 0 &&
        Objects.equals(centro, circulo2D.centro);
  }

  @Override
  public int hashCode() {
    return Objects.hash(radio, centro);
  }

  public static void main(String[] args) {
    Circulo2D c1 = new Circulo2D(5, 0, 0);
    c1.ver_datos();
    System.out.println("Superficie: " + c1.superficie());

    Punto2D p = new Punto2D(2, 4);
    System.out.println("Distancia a punto: " + c1.distanciaPunto(p));
  }
}

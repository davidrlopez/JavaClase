package Trimestre2.Excepciones.ProyectoGeometria2D;

import java.util.Objects;

public class Punto2D {

  private double x;
  private double y;

  // Default constructor
  public Punto2D() {
    this(0, 0);
  }

  public Punto2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  // Consolidated "bulk setter" replacing setPunto2D and cambiarPunto2D
  public void setLocation(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceToOrigin() {
    return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
  }

  public double distanceTo(double otherX, double otherY) {
    return Math.sqrt(Math.pow(otherX - this.x, 2) + Math.pow(otherY - this.y, 2));
  }

  public double distanceTo(Punto2D other) {
    return distanceTo(other.x, other.y);
  }

  public Vector2D vectorPunto2D() {
    return new Vector2D(this.getX(), this.getY());
  }

  // Replaces ver_datos() with standard toString()
  @Override
  public String toString() {
    return "Punto2D [x=" + x + ", y=" + y + "]";
  }

  // Added for value equality
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Punto2D punto2D = (Punto2D) o;
    return Double.compare(punto2D.x, x) == 0 &&
        Double.compare(punto2D.y, y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  public static void main(String[] args) {
    Punto2D p1 = new Punto2D(3, 4);
    System.out.println("Point 1: " + p1);
    System.out.println("Distance to origin: " + p1.distanceToOrigin());

    Punto2D p2 = new Punto2D(0, 0);
    System.out.println("Distance to p2: " + p1.distanceTo(p2));

    p2.setLocation(3, 4);
    System.out.println("Point 2 after setLocation: " + p2);
    System.out.println("p1 equals p2: " + p1.equals(p2));
  }
}

package Trimestre2.ProyectoGeometria;

public class Geometria {
  public static void main(String[] args) {
    Circulo c1 = new Circulo(2, 3, 5);
    Circulo c2 = new Circulo(2, 3, 5);
    c1.verDatos();
    System.out.println("Circulo creado con radio: " + c1.toString());
    c2 = c1;
    if (c1.equals(c2)) {
      System.out.println("C1 y C2 son iguales");
    } else {
      System.out.println("C1 y C2 no son iguales");
    }
  }
}

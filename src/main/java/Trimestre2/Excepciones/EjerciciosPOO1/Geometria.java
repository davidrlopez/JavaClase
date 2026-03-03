package Trimestre2.Excepciones.EjerciciosPOO1;

public class Geometria {
  public static void main(String[] args) {
    Circulo c1 = new Circulo(2, 3, 5);
    Circulo c2 = new Circulo(4, -5, 5);
    c1.verDatos();
    System.out.println("Circulo creado con radio: " + c1.toString());
    if (c1.equals(c2)) {
      System.out.println("C1 y C2 son iguales");
    } else {
      System.out.println("C1 y C2 no son iguales");
    }
    System.out.println("Distancia c1 a c2=" + c1.distanciaCirculo(c2));
    System.out.println("Distancia c2 a c1=" + c2.distanciaCirculo(c1));
    System.out.println("Distancia c1 a punto=" + c1.distanciaCirculo(8, 9));
    Fecha f1 = new Fecha(30, 6, 2025);
    Fecha f2 = new Fecha(-30, 2, 2020);
    Fecha f3 = new Fecha();
    f1.verFecha();
    f2.verFecha();
    f3.verFecha();

  }
}

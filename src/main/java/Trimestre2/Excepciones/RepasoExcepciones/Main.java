package Trimestre2.Excepciones.RepasoExcepciones;

import Trimestre2.Excepciones.ProyectoGeometria2D.Punto2D;
import Trimestre2.Excepciones.RepasoExcepciones.ExceptionsCirculo.*;
import Trimestre2.Excepciones.RepasoExcepciones.ExceptionsCoche.*;
import Trimestre2.Excepciones.RepasoExcepciones.FechasException.DiaException;
import Trimestre2.Excepciones.RepasoExcepciones.FechasException.MesException;
import Trimestre2.Excepciones.RepasoExcepciones.FechasException.YearException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Punto2D P = new Punto2D();
    Punto2D Q = new Punto2D(5, 4);
    Punto2D Qr = new Punto2D(Q.getY(), Q.getX());
    Scanner input = new Scanner(System.in);
    try {
      Circulo c1 = new Circulo(0);
      Circulo c2 = new Circulo(Q, 4);
      Circulo c3 = new Circulo(7, 10, 12);
      Circulo c4 = new Circulo(7);
      Circulo c5 = new Circulo(P, "5");
      Circulo c6 = new Circulo("4", "6", "7");
      Circulo c7 = new Circulo(c3);
      Punto2D c3R = new Punto2D((int) (P.getX() + c7.getCentro().getX() / 2),
          (int) ((P.getY() + c7.getCentro().getY() / 2)));
      Circulo c8 = new Circulo(c6.getCentro(), c4.getRadio());
      Circulo c9 = new Circulo(Qr, 4);
      Circulo c10 = new Circulo(c3R, 24);
      System.out.println("Circulo 1:" + c1.toString());
      System.out.println("Circulo 2:" + c2.toString());
      System.out.println("Circulo 3:" + c3.toString());
      System.out.println("Circulo 4:" + c4.toString());
      System.out.println("Circulo 5:" + c5.toString());
      System.out.println("Circulo 6:" + c6.toString());
      System.out.println("Circulo 7:" + c7.toString());
      System.out.println("Circulo 8:" + c8.toString());
      System.out.println("Circulo 9:" + c9.toString());
      System.out.println("Circulo 10:" + c10.toString());
      System.out.println("Centro de c10:" + c10.getCentro());
      c5.setCentro(c7.getCentro());
      System.out.println("nuevo c5:" + c5);
      c2.setCentro(4, 5);
      System.out.println(c2);
      c10.setCentro((int) (c9.getCentro().getX() + Q.getX()), (int) (c9.getCentro().getY() + Q.getY()));
      Punto2D c4M = new Punto2D(c5.getCentro().getY(), 7);
      c4.setCentro((int) (c4M.getX()), (int) (c4M.getY()));
      c4.setRadio(7);
      c7.setCirculo(c4);
      System.out.println(c10.area());
      c7.ampliaCirculo(10);
      System.out.println(c7);
      System.out.println(c9.distancia(c5.getCentro()));
      System.out.println(c4.getCentro().distanceTo(Q));
      System.out.println(c3.getCentro().distanceTo(c1.getCentro()));
    } catch (RadioException e) {
      System.out.println("Error en el radio:" + e.getMessage());
    } catch (CentroException e) {
      System.out.println("Error en el centro:" + e.getMessage());
    }
    try {
      Fecha f1 = new Fecha();
      System.out.println(f1.toString());
      Fecha f2 = new Fecha(20, 1, 1);
      Fecha f3 = new Fecha();
      boolean fechaCorrecta = false; // Nuestra bandera
      do {
        try {
          System.out.println("Introduce día, mes y año:");
          int d1 = input.nextInt();
          int m1 = input.nextInt();
          int a1 = input.nextInt();

          // 1. Intentamos cambiar la fecha
          f3.setFecha(d1, m1, a1);

          // 2. Si llegamos aquí es que NO hubo excepción
          fechaCorrecta = true;

        } catch (DiaException | MesException | YearException e) {
          // 3. Si hubo error, informamos y el bucle sigue porque fechaCorrecta sigue
          // siendo false
          System.out.println("Fecha inválida: " + e.getMessage() + ". Inténtalo de nuevo.");
          input.nextLine(); // Limpieza básica del buffer por si acaso
        }
      } while (!fechaCorrecta);
      Fecha f4 = new Fecha();
      f4.setFecha(f2);
      Fecha f6 = new Fecha();
      f6.setFecha(f4.getDia(), f1.getMes(), 2000);
      fechaCorrecta = false;
      do {
        try {
          f6.setYear(f6.getYear() + 10);
          fechaCorrecta = true;
        } catch (YearException e) {
          System.out.println("Fecha invalida:" + e.getMessage());
          input.nextLine();
        }

      } while (!fechaCorrecta);
      Fecha f7 = new Fecha();
      fechaCorrecta = false;
      do {
        try {
          Fecha f4dd = new Fecha();
          f4dd.setFecha(f4.fechaSiguiente());
          f7.setFecha(f7.getDia(), f7.getMes(), f4dd.getYear());
          fechaCorrecta = true;
        } catch (YearException e) {
          System.out.println("Fecha invalida:" + e.getMessage());
          input.nextLine();
        }
        System.out.println(f1.toString(1));
      } while (!fechaCorrecta);

    } catch (DiaException e) {
      System.out.println("Error en el dia" + e.getMessage());
    } catch (MesException e) {
      System.out.println("Error en el mes:" + e.getMessage());
    } catch (YearException e) {
      System.out.println("Error en el año:" + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error inesperado:" + e.getMessage());
      try {
        Coche c1 = new Coche(3, 250000, "SEAT", "IBIZA", "ROJO", "DIESEL", "MANUAL");
        System.out.println(c1);
        Coche c2 = new Coche(c1);
        System.out.println(c2);
        System.out.println(c1.equals(c2));
      } catch (PuertasException ex) {
        ex.getMessage();
      } catch (PrecioException ex) {
        ex.getMessage();
      } catch (Exception ex) {
        // TODO: handle exception
        ex.getMessage();
      }
    }
    input.close();
  }
}

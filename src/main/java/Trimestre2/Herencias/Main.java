package Trimestre2.Herencias;

import Trimestre2.Herencias.HombreExceptions.HijosException;
import Trimestre2.Herencias.HombreExceptions.VivoException;

public class Main {
  public static void main(String[] args) {
    try {
      System.out.println("Testing Herencias1:");
      Herencias1 hBase = new Herencias1(1, 2, 3, 4);
      System.out.println(hBase);

      System.out.println("\nTesting Herencias2:");
      Herencias2 h2 = new Herencias2(10, 20, 30, 40, 50);
      System.out.println(h2);

      System.out.println("\nTesting Animales (herencia):");
      Mamifero m = new Mamifero(2, "MamíferoGenérico");
      Perro p = new Perro(8, "Toby");
      Gato g = new Gato(8, "Michi");
      Animal a = new Animal(5, 22, 4, 2222);

      a.setPeso(42);
      m.setNumMamas(4);
      System.out.println(a);
      System.out.println("Peso de a: " + a.getPeso());
      System.out.println("Fecha de a: " + a.getFecha());

      System.out.println();
      System.out.println(m);
      m.reproducir();

      System.out.println();
      System.out.println(p);
      p.dormir();
      p.reproducir();
      p.ladrar();
      p.grunir();

      System.out.println();
      System.out.println(g);
      g.comer();
      g.reproducir();
      g.ronronea();

      Animal[] arrayAnimales = { p, g, a };

      // Versión limpia con getSimpleName
      for (Animal animal : arrayAnimales) {
        System.out.println(animal);
      }

      // Versión con instanceof para operar según tipo
      for (int j = 0; j < arrayAnimales.length; j++) {
        if (arrayAnimales[j] instanceof Perro) {
          System.out.println("El objeto " + j + " es un Perro");
        } else if (arrayAnimales[j] instanceof Gato) {
          System.out.println("El objeto " + j + " es un Gato");
          g.comer();
        } else if (arrayAnimales[j] instanceof Mamifero) {
          System.out.println("El objeto " + j + " es un Mamifero");
        } else if (arrayAnimales[j] instanceof Animal) {
          System.out.println("El objeto " + j + " es un Animal");
        } else {
          System.out.println(arrayAnimales[j].getClass().getSimpleName());
        }
      }

      System.out.println("\nEjercicio a) ... n):");

      // a) Fecha
      Fecha fecha = new Fecha(4, 10, 2001);

      // b) Animal a1
      Animal a1 = new Animal(3, fecha);

      // c) Vertebrado v1 desde a1
      Vertebrado v1 = new Vertebrado(a1, 14);

      // d) Vector edades
      int[] edades = { 3, 16, 7, 18, 10 };

      // e) Vector nombres
      String[] nombres = { "Pepe", "Carlos", "Maria", "Juan", "Ana" };

      // f) Hombre h1
      Hombre h1 = new Hombre(
          v1.getPeso(), v1.getFecha(), v1.getNumVertebras(),
          "Pedro Pérez", true, 5, nombres, edades);

      // g) Mostrar hijos con edades
      System.out.println("g) Hijos y edades:");
      String[] nombresH = h1.getNamesHijos();
      int[] edadesH = h1.getEdadHijos();
      int limite = Math.min(nombresH.length, edadesH.length);
      for (int i = 0; i < limite; i++) {
        System.out.println("  - " + nombresH[i] + ": " + edadesH[i] + " años");
      }

      // h) a1 apunta a h1
      a1 = h1;

      // i) Cambiar peso desde referencia Animal
      a1.setPeso(45);

      // j) h1 refleja el cambio (misma referencia)
      System.out.println("j) Peso de h1 tras cambiar a1: " + h1.getPeso());

      // k) Nuevo hijo — lanzaría HijosException si supera el límite
      h1.addHijo("Raquel", 20);

      // l) h1 muere
      h1.morir();
      System.out.println("l) h1 muere. Estado vivo: " + h1.isVivo());

      // m) Hijo menor
      System.out.println("m) Hijo menor: "
          + h1.nombreHijoMenor()
          + " (" + h1.edadHijoMenor() + " años)");

      // n) Morir segunda vez — excepción esperada, el programa debe continuar
      try {
        h1.morir();
      } catch (VivoException e) {
        System.out.println("n) " + e.getMessage());
      }

    } catch (HijosException e) {
      System.out.println("Error en número de hijos: " + e.getMessage());
    } catch (VivoException e) {
      System.out.println("Error de estado vital: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error inesperado: " + e.getMessage());
    }
  }
}

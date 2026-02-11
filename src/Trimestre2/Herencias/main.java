package Trimestre2.Herencias;

public class Main {

  public static void main(String[] args) {
    System.out.println("Testing Herencias1:");
    Herencias1 h1 = new Herencias1(1, 2, 3, 4);
    System.out.println(h1);

    System.out.println("\nTesting Herencias2:");
    Herencias2 h2 = new Herencias2(10, 20, 30, 40, 50);
    System.out.println(h2);

    System.out.println("\nTesting Animales (herencia):");
    Animal a = new Animal("AnimalGenérico");
    Mamifero m = new Mamifero(2, "MamíferoGenérico");
    Perro p = new Perro(8, "Toby");
    Gato g = new Gato(8, "Michi");

    // getters/setters demo
    a.setNombre("AnimalRenombrado");
    m.setNumMamas(4);

    System.out.println(a);
    a.comer();
    a.dormir();
    a.reproducir();

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
  }
}

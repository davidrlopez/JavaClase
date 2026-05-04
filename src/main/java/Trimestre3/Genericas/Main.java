package Trimestre3.Genericas;

import Trimestre2.ExamenNetflix.Clases.Producto;
import Trimestre2.ExamenNetflix.SubClases.Pelicula;

public class Main {
    public static void main(String[] args) {
        Generica1<String> s = new Generica1<>("Hola");
        Generica1<Integer> n = new Generica1<>(42);

        System.out.println(s);
        System.out.println(n);

        System.out.println("\n--- Pruebas de Generica ---");
        Generica<Producto> inventario = new Generica<>();

        try {
            Pelicula p1 = new Pelicula();
            p1.setNombreProd("Interstellar");

            Pelicula p2 = new Pelicula();
            p2.setNombreProd("Inception");

            inventario.aniadir(p1);
            inventario.aniadir(p2);

            System.out.println("Inventario: " + inventario.toString());

            System.out.println("Primer elemento: " + inventario.primero());

            System.out.println("Extrayendo: " + inventario.extraer());
            System.out.println("Inventario después de extraer: " + inventario.toString());

            System.out.println("\n--- Pruebas de Vector ---");
            Vector<Integer> vec = new Vector<>(5);
            vec.set(0, 10);
            vec.set(1, 20);
            vec.set(2, 5);

            vec.mostrar();
            System.out.println("Máximo: " + vec.maximo());
            System.out.println("Media: " + vec.media());

        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}

package Trimestre2.ExamenNetflix.Clases;

import Trimestre2.ExamenNetflix.SubClases.Pelicula;
import Trimestre2.ExamenNetflix.SubClases.Videojuego;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        // --- Crear objetos ---
        Videojuego vj1 = null;
        Pelicula p1 = null, p2 = null;

        try {
            vj1 = new Videojuego("Zelda", 1, false, 3.99, 1, "ACCION", 0.04);
            p1 = new Pelicula("El Padrino", 2, false, 5.00, 1, "01/01/1972", "DRAMA", 175, false, 12.99);
            p2 = new Pelicula("Shrek", 3, false, 3.00, 2, "01/05/2001", "ANIMACION", 90, false, 7.99);
        } catch (Exception e) {
            System.out.println(e);
        }

        // --- Probar excepciones ---
        try {
            Pelicula pMala = new Pelicula("Error", 4, false, 2.00, 3, "01/01/2020", "WESTERN", 0, false, -1.00);
        } catch (Exception e) {
            System.out.println(e);
        }

        // --- Operar con cliente ---
        Cliente cliente = new Cliente("12345678A", "David", new ArrayList<>(), new ArrayList<>());

        try {
            cliente.alquilar(vj1);
            cliente.alquilar(p1);
            cliente.comprar(p2);
            cliente.alquilar(vj1); // ya alquilado, lanza excepción
        } catch (Exception e) {
            System.out.println(e);
        }

        // --- Mostrar resultados ---
        cliente.listadoAlquilerPeliculas();
        cliente.listadoVenta();
        System.out.printf("Total alquiler: %.2f€%n", cliente.precioTotalAlquiler());
        System.out.printf("Total ventas: %.2f€%n", cliente.precioTotalVenta());

        // --- Devolver ---
        try {
            cliente.devolver(vj1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

package Trimestre2.Interfaces.Principal;

import java.util.ArrayList;
import Trimestre2.Interfaces.Clases.*;
import Trimestre2.Interfaces.Interfaces.Prestable;

public class Main {
  public static void main(String[] args) {
    // Inicializar listas vacías para la biblioteca
    ArrayList<Publicacion> publicaciones = new ArrayList<>();
    ArrayList<Prestable> itemsPrestados = new ArrayList<>();

    // Instanciar la biblioteca
    Biblioteca miBiblioteca = new Biblioteca(itemsPrestados, publicaciones);

    // 1. Crear instancias de Libro y Revista (que heredan de Publicacion)
    System.out.println("--- Creando publicaciones ---");
    Libro libro1 = new Libro(1, "El Quijote", 1605, false);
    Libro libro2 = new Libro(2, "1984", 1949, false);
    Libro libro3 = new Libro(3, "Cien años de soledad", 1967, false);
    Revista revista1 = new Revista(4, "National Geographic", 2023, 150);

    // 2. Añadir publicaciones a la biblioteca (Probando addPublicacion)
    miBiblioteca.addPublicacion(libro1);
    miBiblioteca.addPublicacion(libro2);
    miBiblioteca.addPublicacion(libro3);
    miBiblioteca.addPublicacion(revista1);
    System.out.println("Publicaciones añadidas correctamente.");

    // Intentar añadir un duplicado para probar la excepción
    try {
      miBiblioteca.addPublicacion(new Libro(1, "Libro Repetido", 2000, false));
    } catch (IllegalArgumentException e) {
      System.out.println("-> Excepción capturada correctamente: " + e.getMessage());
    }

    // 3. Mostrar publicaciones
    System.out.println("\n--- Listado de Publicaciones ---");
    miBiblioteca.mostrarPublicaciones();

    // 4. Probar préstamos
    System.out.println("\n--- Pruebas de Préstamos ---");
    System.out.println("Prestando 'El Quijote'...");
    miBiblioteca.prestarLibro(libro1);
    System.out.println("Prestando '1984'...");
    miBiblioteca.prestarLibro(libro2);

    System.out.println("Libros prestados actualmente: " + miBiblioteca.cuentaPrestados());

    // Intentar prestar un libro que ya está prestado para probar la excepción
    try {
      System.out.println("Intentando prestar 'El Quijote' de nuevo...");
      miBiblioteca.prestarLibro(libro1);
    } catch (Exception e) {
      System.out.println("-> Excepción capturada correctamente: " + e.getMessage());
    }

    // 5. Probar devoluciones
    System.out.println("\n--- Pruebas de Devoluciones ---");
    System.out.println("Devolviendo 'El Quijote'...");
    miBiblioteca.devolverLibro(libro1);

    System.out.println("Libros prestados actualmente: " + miBiblioteca.cuentaPrestados());

    // Intentar devolver un libro no prestado
    try {
      System.out.println("Intentando devolver 'Cien años de soledad' (que no estaba prestado)...");
      miBiblioteca.devolverLibro(libro3);
    } catch (Exception e) {
      System.out.println("-> Excepción capturada correctamente: " + e.getMessage());
    }

    // 6. Probar métodos de búsqueda/filtrado
    System.out.println("\n--- Pruebas de Filtrado ---");
    int añoLimite = 1950;
    int cantidadAnteriores = miBiblioteca.publicacionesAnterioresA(añoLimite);
    System.out.println("Publicaciones anteriores al año " + añoLimite + ": " + cantidadAnteriores);
  }
}

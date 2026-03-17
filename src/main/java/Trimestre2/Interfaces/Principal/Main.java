package Trimestre2.Interfaces.Principal;

import Trimestre2.Interfaces.Clases.*;
import Trimestre2.Interfaces.Enumeraciones.*;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.*;

public class Main {
  public static void main(String[] args) {
    try {
      System.out.println("1. Creando videoclub...");
      Videoclub v = new Videoclub("VideoMax");

      System.out.println("2. Creando clientes...");
      Cliente c1 = new Cliente("FRANCISCO");
      Cliente c2 = new Cliente("JAVIER");
      Cliente c3 = new Cliente("ALEJANDRO");
      Cliente c4 = new Cliente("ANTONIO");

      System.out.println("3. Intentando crear pelicula con duracion negativa...");
      try {
        Pelicula pErronea = new Pelicula("La armada invencible", Idiomas.valueOf("ESPANOL"), -10, GeneroPelis.FICCION);
      } catch (Exception e) {
        System.out.println("Excepcion capturada: " + e.getMessage());
      }

      System.out.println("4. Numero de productos en videoclub: " + v.getNumProductos());

      System.out.println("5. Creando 5 peliculas...");
      Pelicula p1 = new Pelicula("EL SENOR DE LOS ANILLOS", Idiomas.ESPAÑOL, 200, GeneroPelis.FICCION);
      Pelicula p2 = new Pelicula("The Hobbit", Idiomas.INGLÉS, 45, GeneroPelis.FICCION);
      Pelicula p3 = new Pelicula("Star Wars III", Idiomas.INGLÉS, 89, GeneroPelis.FICCION);
      Pelicula p4 = new Pelicula("El discurso del Rey", Idiomas.ESPAÑOL, 78, GeneroPelis.COMEDIA);
      Pelicula p5 = new Pelicula("Shrek", Idiomas.FRANCÉS, 123, GeneroPelis.INFANTIL);

      System.out.println("6. Creando 2 CDs...");
      CD cd1 = new CD("U2 Boy in 1980", 0, 6); 
      CD cd2 = new CD("Queen Don't stop me now", 0, 8);

      System.out.println("7. Creando 3 Juegos...");
      Juego j1 = new Juego("Simpsons Game", "Play Station 4");
      Juego j2 = new Juego("Zelda", "Wii");
      Juego j3 = new Juego("Mario Car", "Nintendo DS");

      System.out.println("8. Registrando clientes y productos...");
      v.addCliente(c1); v.addCliente(c2); v.addCliente(c3); v.addCliente(c4);
      v.addProducto(p1); v.addProducto(p2); v.addProducto(p3); v.addProducto(p4); v.addProducto(p5);
      v.addProducto(cd1); v.addProducto(cd2);
      v.addProducto(j1); v.addProducto(j2); v.addProducto(j3);

      System.out.println("\n9. Mostrando videoclub:");
      System.out.println(v);

      System.out.println("10. Numero de productos en videoclub: " + v.getNumProductos());

      System.out.println("\n11. Francisco alquila productos...");
      v.alquilarProducto(c1, p1);
      v.alquilarProducto(c1, p2);
      v.alquilarProducto(c1, j1);

      System.out.println("12. Numero de clientes en videoclub: " + v.getNumClientes());

      System.out.println("13. Productos alquilados por Francisco:");
      for(ProductoVideoClub p : c1.getProductosAlquilados()) {
          System.out.println("- " + p.getNombre());
      }

      System.out.println("\n14. Francisco intenta alquilar The Hobbit de nuevo...");
      try {
          v.alquilarProducto(c1, p2);
      } catch (Exception e) {
          System.out.println("Excepcion capturada: " + e.getMessage());
      }

      System.out.println("15. Numero de peliculas en el videoclub: " + Pelicula.getContPeliculas());

      System.out.println("16. Javier alquila Star Wars III");
      v.alquilarProducto(c2, p3);

      System.out.println("17. Lista de clientes:");
      for(Cliente c : v.getListaClientes()) System.out.println("- " + c.getNombreCliente());

      System.out.println("18. Lista de productos:");
      for(ProductoVideoClub p : v.getListaProductos()) System.out.println("- " + p.getNombre());

      System.out.println("19. Alquileres de Francisco:");
      System.out.println(c1.toString());

      System.out.println("20. Francisco devuelve El Senor de los Anillos");
      v.devolverProducto(c1, p1);

      System.out.println("21. Retirando The Hobbit por defectuosa");
      try { v.retirarProducto(p2); } catch (Exception e) { System.out.println(e.getMessage()); }

      System.out.println("22. Retirando Shrek por defectuosa");
      v.retirarProducto(p5);

      System.out.println("23. Vendiendo El Senor de los Anillos por 4 euros");
      v.venderProducto(p1, 4);

      System.out.println("24. Creando copia de Star Wars III");
      Pelicula p6 = new Pelicula(p3);
      v.addProducto(p6);

      System.out.println("\n25. Productos agrupados:");
      v.mostrarProductosAgrupadosPorTipo();

      System.out.println("\n26. Genero de peliculas con ID entre 3 y 5:");
      for(ProductoVideoClub p : v.getListaProductos()){
          if(p instanceof Pelicula && p.getId() >= 3 && p.getId() <= 5) {
              System.out.println(p.getNombre() + ": " + ((Pelicula)p).getGenero());
          }
      }

      System.out.println("\n27. CDs de ROCK:");
      System.out.println("Solo hemos guardado enteros como genero para CDs segun la estructura actual, saltando filtro de string.");

      System.out.println("\n28. Peliculas de Javier:");
      for(ProductoVideoClub p : c2.getProductosAlquilados()){
          if(p instanceof Pelicula){
              System.out.println(((Pelicula)p).getIdioma() + " - " + p.getNombre());
          }
      }

      System.out.println("\n29. Peliculas de Francisco en ESPANOL:");
      int contEsp = 0;
      for(ProductoVideoClub p : c1.getProductosAlquilados()){
          if(p instanceof Pelicula && ((Pelicula)p).getIdioma() == Idiomas.ESPAÑOL) contEsp++;
      }
      System.out.println(contEsp);

      System.out.println("\n30. Precio por cliente:");
      v.mostrarPrecioProductosAlquiladosPorClientes();

      System.out.println("\n31. Precio total de todos los alquileres del videoclub: " + v.obtenerPrecioTotalProductosAlquilados() + " euros");

      System.out.println("\n32. Duracion peliculas en INGLES:");
      v.mostrarDuracionPeliculasIdioma("INGLÉS");

      System.out.println("\n33.");
      v.mostrarGeneroPeliculasAlquiladasPor(c1);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

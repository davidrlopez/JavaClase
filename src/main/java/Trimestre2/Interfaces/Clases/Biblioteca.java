package Trimestre2.Interfaces.Clases;

import java.util.ArrayList;

import Trimestre2.Interfaces.Interfaces.Prestable;

public class Biblioteca {

  protected ArrayList<Prestable> items;
  protected ArrayList<Publicacion> publicaciones;

  public ArrayList<Prestable> getItems() {
    return items;
  }

  public void setItems(ArrayList<Prestable> items) {
    this.items = items;
  }

  public ArrayList<Publicacion> getPublicaciones() {
    return publicaciones;
  }

  public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
    this.publicaciones = publicaciones;
  }

  public Biblioteca(ArrayList<Prestable> items, ArrayList<Publicacion> publicaciones) {
    this.items = items;
    this.publicaciones = publicaciones;
  }

  public void addPublicacion(Publicacion e) {
    for (Publicacion i : publicaciones) {
      if (i.getId() == e.getId()) {
        throw new IllegalArgumentException(
            "Publicacion repetida con id: " + e.getId() +
                " y de tipo: " + e.getClass());
      }
    }
    publicaciones.add(e);
  }

  public void prestarLibro(Libro libro) throws IllegalArgumentException {
    libro.prestar();
    if (!items.contains(libro)) {
      items.add(libro);
    }
  }

  public int cuentaPrestados() {
    int contador = 0;
    for (Prestable item : items) {
      if (item instanceof Libro) {
        if (item.prestado()) {
          contador++;
        }
      }
    }
    return contador;
  }

  public void mostrarPublicaciones() {
    for (Publicacion publicacionI : publicaciones) {
      System.out.println("ID:" + publicacionI.getId() + " Titulo:" + publicacionI.getTitulo());
      System.out.println("***********************************************");
    }
  }

  public void devolverLibro(Libro libro) throws IllegalArgumentException {
    libro.devolver();
    if (items.contains(libro)) {
      items.remove(libro);
    }
  }

  public int publicacionesAnterioresA(int año) {
    int contador = 0;
    for (Publicacion publicacionI : publicaciones) {
      if (publicacionI.getYear() < año) {
        contador++;
      }
    }
    return contador;
  }
}

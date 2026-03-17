package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.VendibleVideoClub;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.*;
import Trimestre2.Interfaces.Enumeraciones.Idiomas;
import Trimestre2.Interfaces.Enumeraciones.GeneroPelis;

public class Pelicula extends ProductoVideoClub implements VendibleVideoClub {

  private static int contPeliculas = 0;
  private Idiomas idioma;
  private int duracion;
  private GeneroPelis genero;
  private boolean vendido = false;

  public Pelicula(String nombre, Idiomas idioma, int duracion, GeneroPelis genero) throws DuracionPeliculaException {
    super(nombre);
    if (duracion <= 0) {
      throw new DuracionPeliculaException("Error, la duración de una Pelicula no puede ser negativa o 0");
    }
    this.idioma = idioma;
    this.duracion = duracion;
    this.genero = genero;
    contPeliculas++;
  }

  public Pelicula(Pelicula otra) throws DuracionPeliculaException {
    super(otra.getNombre());
    if (otra.getDuracion() <= 0) {
      throw new DuracionPeliculaException("Error, la duración de una Pelicula no puede ser negativa o 0");
    }
    this.idioma = otra.getIdioma();
    this.duracion = otra.getDuracion();
    this.genero = otra.getGenero();
    contPeliculas++;
  }

  public static int getContPeliculas() {
    return contPeliculas;
  }

  @Override
  public double getPrecio() {
    return 2.0;
  }

  public Idiomas getIdioma() {
    return idioma;
  }

  public void setIdioma(Idiomas idioma) {
    this.idioma = idioma;
  }

  public int getDuracion() {
    return duracion;
  }

  public void setDuracion(int duracion) throws DuracionPeliculaException {
    if (duracion <= 0) {
      throw new DuracionPeliculaException("Error, la duración de una Pelicula no puede ser negativa o 0");
    }
    this.duracion = duracion;
  }

  public GeneroPelis getGenero() {
    return genero;
  }

  public void setGenero(GeneroPelis genero) {
    this.genero = genero;
  }

  @Override
  public void alquilar() throws AlquilarException {
    if (this.isRetirado()) {
      System.out.println("La pelicula: " + this.getNombre() + " no se puede alquilar porque esta retirada");
    } else if (this.isVendido()) {
      System.out.println("La pelicula: " + this.getNombre() + " no se puede alquilar porque esta vendida");
    } else if (this.isAlquilado()) {
      System.out.println("La pelicula: " + this.getNombre() + " ya esta alquilada");
    } else {
      super.alquilar();
    }
  }

  @Override
  public void retirar() throws AlquilarException {
    if (this.isVendido()) {
      System.out.println("No se puede retirar la pelicula: " + this.getNombre() + " porque esta vendida");
    } else {
      super.retirar();
      contPeliculas--;
    }
  }

  @Override
  public void vender(int precio) {
    if (this.isAlquilado()) {
      System.out.println("La pelicula: " + this.getNombre() + " no puede ser vendida porque esta alquilada");
    } else if (this.isRetirado()) {
      System.out.println("La pelicula: " + this.getNombre() + " no puede ser vendida porque esta retirada");
    } else if (this.isVendido()) {
      System.out.println("La pelicula: " + this.getNombre() + " ya esta vendida");
    } else {
      this.vendido = true;
      this.setPrecio(precio);
      contPeliculas--;
    }
  }

  @Override
  public boolean isVendido() {
    return this.vendido;
  }

  @Override
  public String toString() {
    return "Pelicula [ID: " + this.getId() + ", Nombre: " + this.getNombre() + ", Idioma: " + idioma + ", Duracion: " + duracion + ", Genero: " + genero + ", Vendido: " + vendido + "]";
  }
}


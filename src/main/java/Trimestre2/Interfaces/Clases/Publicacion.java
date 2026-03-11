package Trimestre2.Interfaces.Clases;

public class Publicacion {

  private int id = 0;
  private String titulo = "";
  private int year = 0;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Publicacion(int id, String titulo, int year) {
    setId(id);
    setTitulo(titulo);
    setYear(year);
  }

  @Override
  public String toString() {
    return "Publicacion [id=" + id + ", titulo=" + titulo + ", year=" + year + ", getId()=" + getId() + ", getTitulo()="
        + getTitulo() + ", getYear()=" + getYear() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
        + "]";
  }
}

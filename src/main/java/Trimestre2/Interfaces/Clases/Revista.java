package Trimestre2.Interfaces.Clases;

public class Revista extends Publicacion {

  private int numRevista;

  public int getNumRevista() {
    return numRevista;
  }

  public void setNumRevista(int numRevista) {
    this.numRevista = numRevista;
  }

  public Revista(int id, String titulo, int year, int numRevista) {
    super(id, titulo, year);
    this.numRevista = numRevista;
  }
}

package Trimestre2.Herencias;

public class Mamifero extends Animal {
  private int numMamas;
  private String nombre;

  public Mamifero(int numMamas, String nombre) {
    super();
    this.numMamas = numMamas;
    this.nombre = nombre;
  }

  public int getNumMamas() {
    return numMamas;
  }

  public void setNumMamas(int numMamas) {
    this.numMamas = numMamas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void comer() {
    System.out.println("Mamifero - Necesita comer para sobrevivir");
  }

  public void dormir() {
    System.out.println("Mamifero - Duerme para descansar");
  }

  public void reproducir() {
    System.out.println("Mamifero - Reproduccion vivipara");
  }

  @Override
  public String toString() {
    return "Mamifero [nombre=" + nombre + ", numMamas=" + numMamas + "]";
  }
}

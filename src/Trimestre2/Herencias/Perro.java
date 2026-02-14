package Trimestre2.Herencias;

public class Perro extends Mamifero {

  public Perro(int numMamas, String nombre) {
    super(numMamas, nombre);
  }

  @Override
  public void dormir() {
    System.out.println("Perro - Duerme segun el ejercicio que realiza");
  }

  public void ladrar() {
    System.out.println("Perro - Guau guau");
  }

  public void grunir() {
    System.out.println("Perro - Grrrr...");
  }
}

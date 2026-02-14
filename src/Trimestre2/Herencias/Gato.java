package Trimestre2.Herencias;

public class Gato extends Mamifero {

  public Gato(int numMamas, String nombre) {
    super(numMamas, nombre);
  }

  @Override
  public void comer() {
    System.out.println("Gato - Su comida preferida es el pescado");
  }

  public void ronronea() {
    System.out.println("Gato - Rrrrrr");
  }
}

package Trimestre2.Herencias;

/**
 * Ejemplo sencillo de herencia en Java.
 *
 * Nota: En un fichero .java sólo puede haber una clase "public" y debe llamarse
 * igual que el fichero. El resto de clases aquí son package-private.
 */
public class AnimalesEjemploClase {
  // Clases de ejemplo: Animal, Mamifero, Perro, Gato
  // (La demo/main se ha movido a Main.java)
}

class Animal {
  private String nombre;

  // Constructor
  public Animal(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  // Métodos propios
  public void comer() {
    System.out.println("Animal - Necesita comer para sobrevivir");
  }

  public void dormir() {
    System.out.println("Animal - Es indispensable para descansar");
  }

  public void reproducir() {
    System.out.println("Animal - Origina nuevos seres vivos");
  }

  @Override
  public String toString() {
    return "[Nombre=" + this.nombre + "]";
  }
}

class Mamifero extends Animal {
  private int numMamas;

  public Mamifero(int numMamas, String nombre) {
    super(nombre);
    this.numMamas = numMamas;
  }

  public int getNumMamas() {
    return numMamas;
  }

  public void setNumMamas(int numMamas) {
    this.numMamas = numMamas;
  }

  @Override
  public void reproducir() {
    System.out.println("Mamífero - Reproducción vivípara");
  }

  @Override
  public String toString() {
    return "[" + super.toString() + ", Número de mamas=" + this.numMamas + "]";
  }
}

class Perro extends Mamifero {

  public Perro(int numMamas, String nombre) {
    super(numMamas, nombre);
  }

  @Override
  public void dormir() {
    System.out.println("Perro - Duerme en función del ejercicio que realiza");
  }

  public void ladrar() {
    System.out.println("Perro - Ladra (labor social de guardia)");
  }

  public void grunir() {
    System.out.println("Perro - Gruñe: Grrrr...");
  }
}

class Gato extends Mamifero {

  public Gato(int numMamas, String nombre) {
    super(numMamas, nombre);
  }

  @Override
  public void comer() {
    System.out.println("Gato - Su comida preferida: pescado");
  }

  public void ronronea() {
    System.out.println("Gato - Está feliz");
  }
}

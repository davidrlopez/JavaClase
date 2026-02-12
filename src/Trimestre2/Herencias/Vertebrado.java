package Trimestre2.Herencias;

public class Vertebrado extends Animal {

  private int numVertebras = 0;

  public Vertebrado(int peso, int dia, int mes, int anyo, int numVertebras) {
    super(peso, dia, mes, anyo);
    setNumVertebras(numVertebras);
  }

  public Vertebrado(int peso, Fecha fecha, int numVertebras) {
    super(peso, fecha);
    setNumVertebras(numVertebras);
  }

  public Vertebrado(Animal animal, int numVertebras) {
    super(animal);
    setNumVertebras(numVertebras);
  }

  public Vertebrado(Vertebrado vertebrado) {
    super(vertebrado);
    setNumVertebras(vertebrado.getNumVertebras());
  }

  public Vertebrado() {
    super();
  }

  public int getNumVertebras() {
    return numVertebras;
  }

  public void setNumVertebras(int numVertebras) {
    if (numVertebras < 0 || numVertebras > 1000) {
      System.out.println("Error: El número de vértebras debe estar entre 0 y 1000. Se asigna 0 por defecto.");
      this.numVertebras = 0;
    } else {
      this.numVertebras = numVertebras;
    }
  }

  public void setVertebrado(int peso, int dia, int mes, int anyo, int numVertebras) {
    setAnimal(peso, dia, mes, anyo);
    setNumVertebras(numVertebras);
  }

  public void setVertebrado(int peso, Fecha fecha, int numVertebras) {
    setAnimal(peso, fecha);
    setNumVertebras(numVertebras);
  }

  public void setVertebrado(Animal animal, int numVertebras) {
    setAnimal(animal);
    setNumVertebras(numVertebras);
  }

  public void setVertebrado(Vertebrado vertebrado) {
    if (vertebrado != null) {
      setAnimal(vertebrado);
      setNumVertebras(vertebrado.getNumVertebras());
    }
  }
}

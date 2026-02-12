package Trimestre2.Herencias;

import static Trimestre2.Herencias.HombreExceptions.*;

public class Hombre extends Vertebrado {

  private String nombre;
  private boolean vivo;
  private int numHijos = 0;
  private String[] namesHijos;
  private int[] edadHijos;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public boolean isVivo() {
    return vivo;
  }

  public void setVivo(boolean vivo) {
    this.vivo = vivo;
  }

  public int getNumHijos() {
    return numHijos;
  }

  public void setNumHijos(int numHijos) throws HijosException {
    if (numHijos < 0 || numHijos > 10) {
      throw new HijosException("El numero de hijos no puede ser negativo o mayor a 10");
    }
    this.numHijos = numHijos;
  }

  // GETTER con copia: El mundo exterior recibe una copia, no el original
  public String[] getNamesHijos() {
    return (namesHijos == null) ? null : namesHijos.clone();
  }

  // SETTER con copia: Guardamos una copia para que no nos cambien los datos desde
  // fuera
  public void setNamesHijos(String[] namesHijos) {
    this.namesHijos = (namesHijos == null) ? null : namesHijos.clone();
  }

  public int[] getEdadHijos() {
    return (edadHijos == null) ? null : edadHijos.clone();
  }

  public void setEdadHijos(int[] edadHijos) {
    this.edadHijos = (edadHijos == null) ? null : edadHijos.clone();
  }

  public Hombre() {

  }

  public Hombre(int peso, Fecha fecha, int numVertebras, String nombre, boolean vivo, int numHijos, String[] names2,
      int[] edades2) throws HijosException {
    super(peso, fecha, numVertebras);
    setNombre(nombre);
    setVivo(vivo);
    setNumHijos(numHijos);
    setNamesHijos(names2);
    setEdadHijos(edades2);
  }

  public Hombre(Animal animal2, int numVertebras, String nombre, boolean vivo, int numHijos, String[] names2,
      String[] edades2) throws HijosException {
    super(animal2, numVertebras);
    setNombre(nombre);
    setVivo(vivo);
    setNumHijos(numHijos);
    setNamesHijos(namesHijos);
    setEdadHijos(edadHijos);
  }

  public Hombre(Hombre hombre2) throws HijosException {
    super(hombre2);
    setNombre(hombre2.getNombre());
    setVivo(hombre2.isVivo());
    setNumHijos(hombre2.getNumHijos());
    setNamesHijos(hombre2.getNamesHijos());
    setEdadHijos(hombre2.getEdadHijos());
  }

  public boolean morir() throws VivoException {
    if (this.isVivo() == false) {
      throw new VivoException("El sujeto ya esta muerto, no puede volver a morir");
    }
    setVivo(this.vivo = false);
    return this.isVivo();
  }

  public int[] tenerHijos(String nombre, int edad) throws HijosException {

  }
}

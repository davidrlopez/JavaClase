package Trimestre2.Herencias;

import static Trimestre2.Herencias.HombreExceptions.*;
import java.util.Arrays;

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
    if (numHijos < 0 || numHijos > 9) {
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

  public void addHijo(String nombreHijo, int edadHijo) throws HijosException {
    int pos = getNumHijos(); // última posición libre
    setNumHijos(pos + 1); // valida (0..10) en el setter

    String[] nuevosNombres = (getNamesHijos() == null)
        ? new String[getNumHijos()]
        : Arrays.copyOf(getNamesHijos(), getNumHijos());

    int[] nuevasEdades = (getEdadHijos() == null)
        ? new int[getNumHijos()]
        : Arrays.copyOf(getEdadHijos(), getNumHijos());

    nuevosNombres[pos] = nombreHijo;
    nuevasEdades[pos] = edadHijo;

    setNamesHijos(nuevosNombres);
    setEdadHijos(nuevasEdades);
  }

  public int edadHijoMenor() throws HijosException {
    int[] edades = getEdadHijos();
    if (edades == null || edades.length == 0) {
      throw new HijosException("No hay edades de hijos registradas");
    }

    int min = edades[0];
    for (int i = 1; i < edades.length; i++) {
      if (edades[i] < min) {
        min = edades[i];
      }
    }
    return min;
  }

  public String nombreHijoMenor() throws HijosException {
    int[] edades = getEdadHijos();
    String[] nombres = getNamesHijos();
    if (edades == null || nombres == null || edades.length == 0 || nombres.length == 0) {
      throw new HijosException("No hay datos de hijos registrados");
    }

    int limite = Math.min(edades.length, nombres.length);
    int idxMin = 0;
    for (int i = 1; i < limite; i++) {
      if (edades[i] < edades[idxMin]) {
        idxMin = i;
      }
    }
    return nombres[idxMin];
  }

  public int lugarNombreHijo(String nombre) {
    String[] nombres = getNamesHijos();
    if (nombres == null)
      return -1;
    for (int i = 0; i < numHijos; i++) {
      if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
        return i;
      }
    }
    return -1;
  }

  public String darNombre(int pos) throws HijosException {
    if (pos < 0 || pos > this.numHijos - 1) {
      throw new HijosException("Fuera de rango del numero de hijos para este persona");
    }
    String[] nombres = this.getNamesHijos();
    return nombres[pos];
  }
}

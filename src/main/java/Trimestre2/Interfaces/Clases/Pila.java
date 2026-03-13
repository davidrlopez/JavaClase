package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.ColeccionInterfaz;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Pila implements ColeccionInterfaz {
  private ArrayList<Object> arrayList;
  private int maxArray;

  public Pila() {
    this.setArrayList(new ArrayList<>());
    this.setMaxArray(20);
  }

  public Pila(ArrayList<Object> arrayList, int maxArray) {
    setArrayList(arrayList);
    setMaxArray(maxArray);
  }

  public ArrayList<Object> getArrayList() {
    return arrayList;
  }

  public void setArrayList(ArrayList<Object> arrayList) {
    this.arrayList = arrayList;
  }

  public int getMaxArray() {
    return maxArray;
  }

  public void setMaxArray(int maxArray) {
    this.maxArray = maxArray;
  }

  public boolean estaVacia() {
    return this.arrayList.isEmpty();
  }

  public Object extraer() throws NoSuchElementException {
    if (estaVacia()) {
      throw new NoSuchElementException("La pila está vacía");
    }
    int ultimoIndice = this.arrayList.size() - 1;
    Object elemento = this.arrayList.get(ultimoIndice);

    this.arrayList.remove(ultimoIndice);
    return elemento;
  }

  public Object primero() throws NoSuchElementException {
    if (estaVacia()) {
      throw new NoSuchElementException();
    }
    int ultimoIndex = this.arrayList.size() - 1;
    return arrayList.get(ultimoIndex);

  }

  public boolean añadir(Object o) {
    if (this.arrayList.size() < maxArray) {
      this.arrayList.add(o);
      return true;
    } else {
      return false;
    }
  }
}

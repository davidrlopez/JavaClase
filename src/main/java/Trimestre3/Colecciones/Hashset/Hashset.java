package Trimestre3.Colecciones.Hashset;

import java.util.HashSet;
import java.util.Set;

public class Hashset {

  private Set<Integer> numeros;

  public Hashset() {
    this.numeros = new HashSet<>();
  }

  public Set<Integer> getNumeros() {
    return numeros;
  }

  public void setNumeros(Set<Integer> numeros) {
    this.numeros = numeros;
  }

  public void añadirNumero(Integer num) {
    this.numeros.add(num);
  }

  public boolean isEmptySet(Object o) {
    return this.numeros.contains(o);
  }

  public int SizeSet() {
    if (this.numeros.isEmpty()) {
      return -1;
    }

    return this.numeros.size();
  }

  public boolean isInObject(Object o) {
    return this.numeros.contains(o);
  }

  public boolean InsertObject(Integer i) {
    return this.numeros.add(i);
  }

  public void ViewObjects() {
    for (Integer integer : numeros) {
      System.out.println(integer.toString());
    }
  }

  public boolean EraseObject(Object o) throws IllegalArgumentException {
    if (this.numeros.contains(o)) {
      return this.numeros.remove(o);
    }
    throw new IllegalArgumentException("El objeto no se encuentra en la lista");
  }

  public boolean EqualitySets(Set<Integer> nums) {
    return this.numeros.equals(nums);
  }

  public Set<Integer> unionSets(Set<Integer> nums) {
    Set<Integer> conjuntoUnion = new HashSet<>(this.numeros);
    conjuntoUnion.addAll(nums);
    return conjuntoUnion;
  }

  public boolean SubSet(Set<Integer> nums) {
    return this.numeros.containsAll(nums);
  }

  public Set<Integer> diffSets(Set<Integer> nums) {
    Set<Integer> conjuntoDiff = new HashSet<>(this.numeros);
    conjuntoDiff.removeAll(nums);
    return conjuntoDiff;
  }

  @Override
  public String toString() {
    return "Conjunto [numeros=" + numeros + ", getNumeros()=" + getNumeros() + ", getClass()=" + getClass()
        + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
  }
}

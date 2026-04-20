package Trimestre3.Colecciones.Hashset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.List;

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

    // Version de clase
    // public static void mostrarArrayListHM(ArrayList<HashMap<String, Integer>>
    // alhm) {
    // for (HashMap<String, Integer> hashMap : alhm) {
    // System.out.println("Elemento " + hashMap);
    // for (String key : hashMap.keySet()) {
    // Integer value = hashMap.get(key);
    // System.out.println("Llave:" + key + " valor:" + value);
    // }
    // }
    // }
    //
    // public static void mostrarArrayListTM(ArrayList<TreeMap<String, Integer>>
    // altm) {
    // for (TreeMap<String, Integer> treeMap : altm) {
    // System.out.println("Elemento " + treeMap);
    // for (String key : treeMap.keySet()) {
    // Integer value = treeMap.get(key);
    // System.out.println("Llave:" + key + " valor:" + value);
    // }
    // }
    // }
    public static void mostrarListaDeMapas(List<? extends Map<String, Integer>> listaMapas) {
        for (Map<String, Integer> mapa : listaMapas) {
            System.out.println("Elemento " + mapa);

            // Iteramos sobre entrySet() en lugar de keySet()
            for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
                System.out.println("Llave:" + entry.getKey() + " valor:" + entry.getValue());
            }
        }
    }

    @Override
    public String toString() {
        return "Conjunto [numeros=" + numeros + ", getNumeros()=" + getNumeros() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}

package Trimestre3.Colecciones.Hashset;

import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Hashset conjunto = new Hashset();

    System.out.println("=== PRUEBA DE MÉTODOS HASHSET ===\n");

    System.out.println("1. AÑADIR NÚMEROS:");
    conjunto.añadirNumero(10);
    conjunto.añadirNumero(20);
    conjunto.añadirNumero(30);
    System.out.println("Números añadidos: 10, 20, 30\n");

    System.out.println("2. TAMAÑO DEL CONJUNTO:");
    System.out.println("Tamaño: " + conjunto.SizeSet() + "\n");

    System.out.println("3. VERIFICAR SI CONTIENE UN ELEMENTO (20):");
    System.out.println("¿Contiene 20? " + conjunto.isInObject(20) + "\n");

    System.out.println("4. INSERTAR NUEVO ELEMENTO (40):");
    System.out.println("¿Se insertó 40? " + conjunto.InsertObject(40) + "\n");

    System.out.println("5. VISUALIZAR TODOS LOS ELEMENTOS:");
    conjunto.ViewObjects();
    System.out.println();

    System.out.println("6. CREAR OTRO CONJUNTO PARA OPERACIONES:");
    Set<Integer> otroConjunto = new HashSet<>();
    otroConjunto.add(30);
    otroConjunto.add(40);
    otroConjunto.add(50);
    System.out.println("Segundo conjunto: " + otroConjunto + "\n");

    System.out.println("7. UNIÓN DE CONJUNTOS:");
    Set<Integer> union = conjunto.unionSets(otroConjunto);
    System.out.println("Unión: " + union + "\n");

    System.out.println("8. DIFERENCIA DE CONJUNTOS:");
    Set<Integer> diferencia = conjunto.diffSets(otroConjunto);
    System.out.println("Diferencia: " + diferencia + "\n");

    System.out.println("9. VERIFICAR SUBCONJUNTO:");
    Set<Integer> subConjunto = new HashSet<>();
    subConjunto.add(10);
    subConjunto.add(20);
    System.out.println("¿{10,20} es subconjunto? " + conjunto.SubSet(subConjunto) + "\n");

    System.out.println("10. ELIMINAR ELEMENTO (20):");
    try {
      System.out.println("¿Se eliminó 20? " + conjunto.EraseObject(20));
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
    System.out.println("Conjunto después de eliminar: " + conjunto.getNumeros() + "\n");

    System.out.println("11. VERIFICAR IGUALDAD DE CONJUNTOS:");
    Set<Integer> conjuntoIgual = new HashSet<>();
    conjuntoIgual.add(10);
    conjuntoIgual.add(30);
    conjuntoIgual.add(40);
    System.out.println("Conjunto actual: " + conjunto.getNumeros());
    System.out.println("Conjunto a comparar: " + conjuntoIgual);
    System.out.println("¿Son iguales? " + conjunto.EqualitySets(conjuntoIgual) + "\n");

    System.out.println("=== FIN DE PRUEBAS ===");
  }
}

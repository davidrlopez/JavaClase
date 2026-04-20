package Trimestre3.Colecciones;

import java.util.HashMap;
import java.util.Scanner;

public class Tablas {

  public static void generarEImprimirTabla() {
    HashMap<Integer, Integer> tabla = new HashMap<>();
    Scanner input = new Scanner(System.in);

    System.out.println("Introduzca el numero de la tabla:");
    int num = input.nextInt();

    for (int i = 0; i < 10; i++) {
      tabla.put(i, num * i);
    }
    System.out.println("\n--- Tabla del " + num + " ---");
    for (Integer key : tabla.keySet()) {
      Integer valor = tabla.get(key);
      System.out.println(num + " x " + key + " = " + valor);
    }
    input.close();
  }

  public static void main(String[] args) {
    generarEImprimirTabla();
  }
}

package Trimestre2;

import java.util.Scanner;

class Automovil {
  public String marca;
  public String modelo;
  public String color;
  public Integer cv;
  public double precio;

  // Constructor: Now it just RECEIVES data. It creates the object instantly.
  public Automovil(String marca, String modelo, String color, Integer cv, double precio) {
    this.marca = marca;
    this.modelo = modelo;
    this.color = color;
    this.cv = cv;
    this.precio = precio;
  }

  public void ver_datos() {
    System.out.println("Marca: " + this.marca);
    System.out.println("Modelo: " + this.modelo);
    System.out.println("Color: " + this.color);
    System.out.println("Cv: " + this.cv);
    System.out.println("Precio: " + this.precio);
  }

  public boolean comparar_potencia_automoviles(Automovil obj) {
    return (this.cv > obj.cv);
  }

  public static boolean comparar_precio_automoviles(Automovil a1, Automovil a2) {
    return (a1.precio > a2.precio);
  }

  public static double precio_medio(Automovil[] array) {
    if (array == null || array.length == 0) {
      return 0.0;
    }
    double suma = 0;
    int cantidad = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != null) {
        suma += array[i].precio;
        cantidad++;
      }
    }
    return cantidad > 0 ? (suma / cantidad) : 0.0;
  }
}

public class Automoviles {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    // 1. INPUT: The main program is responsible for talking to the user.
    System.out.println("Introduzca marca:");
    String marca = teclado.next();

    System.out.println("Introduzca modelo:");
    String modelo = teclado.next();

    System.out.println("Introduzca color:");
    String color = teclado.next();

    System.out.println("Introduzca cv:");
    Integer cv = teclado.nextInt();

    System.out.println("Introduzca precio:");
    double precio = teclado.nextDouble();

    teclado.close(); // We can safely close it here when we are done.

    // 2. CREATION: We create the object with the collected data.
    Automovil coche = new Automovil(marca, modelo, color, cv, precio);

    // 3. USE: We use the object.
    Automovil Mustang = new Automovil("Ford", "Mustang", "Rojo", 500, 45000);
    Automovil Camaro = new Automovil("Chevrolet", "Camaro", "Amarillo", 480, 40000);
    Automovil arrayAutos[];
    arrayAutos = new Automovil[10];
    arrayAutos[0] = Mustang;
    arrayAutos[1] = Camaro;
    arrayAutos[2] = new Automovil("Dodge", "Challenger Hellcat", "Morado", 707, 82000);
    arrayAutos[3] = coche; // Add the user-created car to the array
    for (int i = 0; i < arrayAutos.length; i++) {
      if (arrayAutos[i] == null) {
        System.out.println("No hay objeto en la posición");
      } else {
        System.out.println("\n--- Coche Creado ---");
        arrayAutos[i].ver_datos();
      }
    }

    System.out.println("\n--- Comparaciones ---");

    // Comparar potencia (instance method)
    if (Mustang.comparar_potencia_automoviles(Camaro)) {
      System.out.println("El Mustang es más potente que el Camaro.");
    } else {
      System.out.println("El Camaro es más potente que el Mustang (o tienen la misma potencia).");
    }

    // Comparar precio (static method)
    if (Automovil.comparar_precio_automoviles(Mustang, Camaro)) {
      System.out.println("El Mustang es más caro que el Camaro.");
    } else {
      System.out.println("El Camaro es más caro que el Mustang (o tienen el mismo precio).");
    }
    System.out.println(Automovil.precio_medio(arrayAutos));
  }
}

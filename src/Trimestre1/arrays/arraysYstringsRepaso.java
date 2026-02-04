package Trimestre1.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class arraysYstringsRepaso {

  public static void main(String[] args) {

  }

  public static String sinEspacios(String frase) {
    String sinEspacios = "";
    for (int i = 0; i < frase.length(); i++) {
      if (frase.charAt(i) != ' ') {
        sinEspacios += frase.charAt(i);
      }
    }
    return sinEspacios;
  }

  public static boolean palindromo(String frase) {
    String invertida = "";
    frase = frase.toUpperCase(); // Asignar el resultado
    frase = sinEspacios(frase);
    // Invertir la cadena
    for (int i = frase.length() - 1; i >= 0; i--) {
      invertida += frase.charAt(i);
    }

    // Comparar DESPUÉS de invertir completamente
    return invertida.equals(frase);
  }

  public static void ejercicio2() {
    int[] vector1 = new int[10];
    Scanner input;
    input = new Scanner(System.in);
    for (int i = 0; i < vector1.length; i++) {
      System.out.println("Introduzca el siguiente numero " + i);
      vector1[i] = input.nextInt();

    }
    for (int i = 0; i < vector1.length; i++) {
      if (vector1[i] == 4) {
        System.out.println(i);
      }
    }
    input.close();
  }

  public static void ejercicio4() {
    int[] vector = new int[10];
    Scanner input;
    input = new Scanner(System.in);
    int posicionMax = 0;
    int sumaMax = 0;
    for (int i = 0; i < vector.length; i++) {
      vector[i] = input.nextInt();
    }
    for (int i = 0; i < vector.length; i++) {
      String cadena = String.valueOf(vector[i]);
      int sumaActual = 0;
      for (int j = 0; j < cadena.length(); j++) {
        sumaActual += cadena.charAt(j) - '0';
      }
      if (sumaActual > sumaMax) {
        sumaMax = sumaActual;
        posicionMax = i;
      }
    }
    System.out.println(posicionMax);
    input.close();
  }

  public static void ejercicio5() {
    int[] vector = new int[10];
    int cantDigitos = 0;
    Scanner input;
    input = new Scanner(System.in);
    for (int i = 0; i < vector.length; i++) {
      vector[i] = input.nextInt();
    }
    for (int i = 0; i < vector.length; i++) {
      String cadena = String.valueOf(vector[i]);
      cantDigitos = cadena.length();
    }

    System.out.println(cantDigitos);
    input.close();
  }

  public static void ejercicio7() {
    int[] vector1 = new int[10];
    Scanner input;
    input = new Scanner(System.in);
    int contador = 0;
    for (int i = 0; i < vector1.length; i++) {
      vector1[i] = input.nextInt();
    }
    for (int i = 0; i < vector1.length; i++) {
      String cadena = String.valueOf(vector1[i]);
      if (cadena.endsWith("15")) {
        contador++;
        System.out.println(contador);
      }
    }
    input.close();
  }

  public static void ejercicio8(int estudiantes) {
    if (estudiantes > 50) {
      return;
    }
    int[][] encuesta = new int[estudiantes][4];
    Scanner input;
    input = new Scanner(System.in);
    int cantH = 0;
    int cantM = 0;
    int porcentajeH = 0;
    int porcentajeM = 0;
    int hombresTr = 0;
    int mujeresTr = 0;
    int mediaTrabajoH = 0;
    int mediaTrabajoM = 0;
    int sumaSueldoHombre = 0;
    int sumaSueldoMujer = 0;
    int mediaSueldoMujer = 0;
    int mediaSueldoHombre = 0;
    for (int i = 0; i < estudiantes; i++) {
      System.out.println("Cedula");
      encuesta[i][0] = input.nextInt();
      System.out.println("Sexo, 1-H 2-M");
      encuesta[i][1] = input.nextInt();
      System.out.println("Trabaja 1-Si 2-No");
      encuesta[i][2] = input.nextInt();
      System.out.println("Sueldo");
      encuesta[i][3] = input.nextInt();
    }
    for (int i = 0; i < estudiantes; i++) {
      int sexo = encuesta[i][1];
      int trabaja = encuesta[i][2];
      int Sueldo = encuesta[i][3];
      if (sexo == 1) {
        cantH++;
        if (trabaja == 1) {
          hombresTr++;
          sumaSueldoHombre += Sueldo;
        }
      }
      if (sexo == 2) {
        cantM++;
        if (trabaja == 1) {
          mujeresTr++;
          sumaSueldoMujer += Sueldo;
        }
      }

    }
    porcentajeH = (cantH / estudiantes) * 100;
    porcentajeM = (cantM / estudiantes) * 100;
    mediaTrabajoH = (hombresTr / cantH) * 100;
    mediaTrabajoM = (mujeresTr / cantM) * 100;
    mediaSueldoHombre = sumaSueldoHombre / hombresTr;
    mediaSueldoMujer = sumaSueldoMujer / mujeresTr;
  }

  public static void ejercicio9() {
    int[][] vehiculos = new int[20][3];
    Scanner input = new Scanner(System.in);

    for (int i = 0; i < 20; i++) {
      System.out.println("Tipo vehiculo 1-Familiar 2-Publico 3-Carga");
      vehiculos[i][0] = input.nextInt();
      System.out.println("Valor Comercial");
      vehiculos[i][1] = input.nextInt();
    }

    for (int i = 0; i < vehiculos.length; i++) {
      int tipo = vehiculos[i][0];
      double valorComercial = vehiculos[i][1];
      double valorFinal = valorComercial;

      // 1. Determinar IVA según valor
      double iva = (valorComercial > 35000) ? 0.30 : 0.21;

      // 2. Aplicar sobrecosto del 5% (tipos 2 y 3, valor > 30000)
      if ((tipo == 2 || tipo == 3) && valorComercial > 30000) {
        valorFinal += valorComercial * 0.05;
      }

      // 3. Calcular monto del IVA
      double montoIva = valorFinal * iva;
      valorFinal += montoIva;

      // 4. Descuento del 50% del IVA (tipo 1, valor <= 15000)
      if (tipo == 1 && valorComercial <= 15000) {
        valorFinal -= montoIva * 0.5;
      }

      // 5. Descuento adicional del 5% si valor final < 20000
      if (valorFinal < 20000) {
        valorFinal -= valorComercial * 0.05;
      }

      // Aquí irían tus System.out.println() para mostrar resultados
      vehiculos[i][2] = (int) valorFinal; // Guardar valor final en la columna 3
    }

    input.close();
  }

  public static void ejercicio5(String frase) {
    char[] array = frase.toCharArray();
    int[] posiciones = new int[frase.length()]; // Array para guardar posiciones
    int contador = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] == 'T' || array[i] == 't') {
        posiciones[contador] = i; // Guardar la posición
        contador++;
      }
    }

    if (contador > 0) {
      System.out.println("Se encontró la letra 'T' en las posiciones:");
      for (int i = 0; i < contador; i++) {
        System.out.println("Posición: " + posiciones[i]);
      }
      System.out.println("Total: " + contador + " veces");
    } else {
      System.out.println("No se encontró la letra 'T'");
    }
  }

  public static void ejercicio4b(String frase) {
    int posicion = 0;
    boolean encontrado = false;
    char caracter;
    for (int i = 0; i < frase.length(); i++) {
      caracter = frase.charAt(i);
      if (caracter == 'W' || caracter == 'w') {
        encontrado = true;
        posicion = i;
        System.out.println(posicion);
        break;
      }
    }
  }
}

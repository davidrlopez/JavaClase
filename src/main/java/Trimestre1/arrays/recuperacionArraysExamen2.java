package Trimestre1.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class recuperacionArraysExamen2 {

  public static void main(String[] args) {
    System.out.println("hello");
  }

  public void ejercicio1(int n) {
    int[] solucion = new int[n];
    Scanner input = new Scanner(System.in);
    int cont0s = 0;
    int mayores = 0;
    int menores = 0;
    int iguales = 0;
    double media = 0;
    double suma = 0;
    int i = 0;
    while (i < n) {
      int num = input.nextInt();
      if (num == 0) {
        cont0s++;
      }

      if (num >= 0) {
        solucion[i] = num;
        suma += num;
        i++;
      }
    }
    media = suma / n;
    int azar = (int) (Math.random() * 20) + 1;
    for (int j = 0; j < n; j++) {
      if (solucion[j] > azar) {
        mayores++;
      }

      else if (solucion[j] < azar) {
        menores++;
      } else {
        iguales++;
      }
    }
    System.out.println("media:" + media);
    System.out.println("Cantidad de numeros en el array mayores que el numero al azar:" + mayores);
    System.out.println("Cantidad de numeros en el array menores que el numero al azar:" + menores);
    System.out.println("Cantidad de numeros en el array iguales que el numero al azar:" + iguales);
    System.out.println("Cantidad de 0s en el array:" + cont0s);

    input.close();
  }

  public void ejercicio2(int atletas, int pruebas) {
    double[][] competicion = new double[atletas][pruebas];
    double maxLanz = 0;
    double minLanz = 99;
    int mejorAt = 0;
    int peorAt = 0;
    double suma = 0;
    double media = 0;
    for (int i = 0; i < atletas; i++) {
      for (int j = 0; j < pruebas; j++) {
        double azar = (Math.random() * 30) + 60;
        suma += azar;
        competicion[i][j] = azar;
        if (azar > maxLanz) {
          maxLanz = azar;
          mejorAt = i;
        }
        if (azar < minLanz) {
          minLanz = azar;
          peorAt = i;
        }
      }
    }
    int pruebasTotales = pruebas * atletas;
    media = suma / pruebasTotales;
    System.out.println("Mejor lanzamiento:" + maxLanz + " realizado por el atleta:" + mejorAt);

    System.out.println("Peor lanzamiento:" + minLanz + " realizado por el atleta:" + peorAt);

    System.out.println("media de lanzamiento:" + media);
  }

  public double ejercicio3(double apuesta, int casilla) {
    int[] jugada = new int[6];
    double ganancias = 0;
    int i = 0;

    while (i < 6) {
      int azar = (int) (Math.random() * 37);
      boolean repetido = false;

      // 1. REVISAR TODO EL ARRAY
      for (int j = 0; j < i; j++) {
        if (azar == jugada[j]) {
          repetido = true;
          break;
        }
      }

      // 2. SI NO ESTÁ REPETIDO, GUARDAR (FUERA DEL FOR)
      if (!repetido) {
        jugada[i] = azar;
        if (azar == casilla) {
          ganancias = apuesta * 2;
        }
        i++; // Solo avanzamos si el número es válido y único
      }
    }
    return ganancias;
  }

  public void ejercicio4(int n) {
    String[] matriculas = new String[n];
    int contXXX = 0;
    for (int i = 0; i < n; i++) {
      String dig = "";
      String letras = "";
      int sumaD = 0;
      for (int j = 0; j < 8; j++) {
        if (j < 4) {
          int numR = (int) (Math.random() * 10);
          dig += String.valueOf(numR);
          sumaD += numR;
        }
        if (j > 4) {
          char letR = (char) ('A' + Math.random() * 26);
          letras += String.valueOf(letR);
        }
      }
      matriculas[i] = dig + " " + letras;
      System.out.println("Matrícula: " + matriculas[i] + " | Suma: " + sumaD);
      if (letras.equals("XXX")) {
        contXXX++;
      }
    }
    System.out.println("N de matriculas con XXX:" + contXXX);
  }

  public class Factorial {

    // Método corregido con long y lógica 1..n
    public long calcularFactorial(int n) {
      if (n < 0)
        return 0; // El factorial no existe para negativos
      long res = 1;
      for (int i = 1; i <= n; i++) {
        res *= i;
      }
      return res;
    }

    public void ejercicio6() {
      Scanner sc = new Scanner(System.in);
      int[] lectura = new int[10];
      long[] salida = new long[10]; // Usamos long para evitar errores de tamaño

      System.out.println("Introduce 10 números enteros:");

      for (int i = 0; i < 10; i++) {
        System.out.print("Número " + (i + 1) + ": ");
        lectura[i] = sc.nextInt();

        // Calculamos y guardamos en la misma posición i
        salida[i] = calcularFactorial(lectura[i]);
      }

      // Mostrar resultados
      System.out.println("\n--- RESULTADOS ---");
      for (int i = 0; i < 10; i++) {
        System.out.println("El factorial de " + lectura[i] + " es: " + salida[i]);
      }

      sc.close();
    }
  }

  public void ejercicio7() {
    int[] entrada = new int[10];
    int cont = 0;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < entrada.length; i++) {
      int num = sc.nextInt();
      entrada[i] = num;
      String numeros = String.valueOf(entrada[i]);
      if (numeros.endsWith("15")) {
        cont++;
      }
    }
    sc.close();
    System.out.println(cont);
  }

  public void ejercicio8() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduzca el número de estudiantes (N <= 50): ");
    int n = sc.nextInt();

    // Matriz: N filas (estudiantes), 4 columnas (Datos)
    // col 0: Cedula, col 1: Sexo, col 2: Trabaja, col 3: Sueldo
    int[][] encuesta = new int[n][4];

    int contH = 0, contM = 0;
    int contHtrab = 0, contMtrab = 0;
    double sumaSueldoH = 0, sumaSueldoM = 0;

    for (int i = 0; i < n; i++) {
      System.out.println("\nEstudiante " + (i + 1));
      System.out.print("Cédula: ");
      encuesta[i][0] = sc.nextInt();

      System.out.print("Sexo (1-M, 2-F): ");
      encuesta[i][1] = sc.nextInt();

      System.out.print("¿Trabaja? (1-Si, 2-No): ");
      encuesta[i][2] = sc.nextInt();

      System.out.print("Sueldo: ");
      encuesta[i][3] = sc.nextInt();

      // Procesamiento de datos
      if (encuesta[i][1] == 1) { // Hombres
        contH++;
        if (encuesta[i][2] == 1) {
          contHtrab++;
          sumaSueldoH += encuesta[i][3];
        }
      } else if (encuesta[i][1] == 2) { // Mujeres
        contM++;
        if (encuesta[i][2] == 1) {
          contMtrab++;
          sumaSueldoM += encuesta[i][3];
        }
      }
    }

    // Cálculos de Porcentajes y Promedios
    double porcH = (contH * 100.0) / n;
    double porcM = (contM * 100.0) / n;

    // Porcentaje de hombres que trabajan respecto al total de hombres
    double porcHtrab = (contH > 0) ? (contHtrab * 100.0) / contH : 0;
    double promedioSueldoH = (contHtrab > 0) ? sumaSueldoH / contHtrab : 0;

    // Porcentaje de mujeres que trabajan respecto al total de mujeres
    double porcMtrab = (contM > 0) ? (contMtrab * 100.0) / contM : 0;
    double promedioSueldoM = (contMtrab > 0) ? sumaSueldoM / contMtrab : 0;

    // Salida de resultados
    System.out.println("\n--- RESULTADOS ---");
    System.out.println("1. Porcentaje de hombres: " + porcH + "%");
    System.out.println("2. Porcentaje de mujeres: " + porcM + "%");
    System.out.println("3. Hombres que trabajan: " + porcHtrab + "% | Sueldo promedio: " + promedioSueldoH);
    System.out.println("4. Mujeres que trabajan: " + porcMtrab + "% | Sueldo promedio: " + promedioSueldoM);
    sc.close();
  }

}

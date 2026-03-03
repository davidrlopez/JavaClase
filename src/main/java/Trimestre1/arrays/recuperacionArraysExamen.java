package Trimestre1.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class recuperacionArraysExamen {
  public static void main(String[] args) {
    System.out.println("hello");
  }

  public void calcular_array_unidimensional(int n) {
    int[] solucion = new int[n];
    Scanner input = new Scanner(System.in);
    int cont0 = 0;
    double suma = 0;
    double media = 0;
    int contMayor = 0;
    int contMenor = 0;
    int contIguales = 0;
    int i = 0;
    while (i < n) {
      int numero = input.nextInt();
      if (numero >= 0) {
        solucion[i] = numero;
        if (numero == 0) {
          cont0++;
        }
        suma += numero;
        i++;
      } else {
        System.out.println("introduzca un numero correcto");
      }
    }
    int azar = (int) ((Math.random() * 20 - 1) + 1);
    if (solucion[i] > azar) {
      contMayor++;
    }
    if (solucion[i] < azar) {
      contMenor++;
    } else {
      contIguales++;
    }
    media = suma / n;
    System.out.println("media:" + media);
    System.out.println("Cantidad de numeros en el array mayores que el numero al azar:" + contMayor);
    System.out.println("Cantidad de numeros en el array menores que el numero al azar:" + contMenor);
    System.out.println("Cantidad de numeros en el array iguales que el numero al azar:" + contIguales);
    System.out.println("Cantidad de 0s en el array:" + cont0);
    input.close();
  }

  public void Competicion_atletismo(int atletas, int pruebas) {
    double[][] competicion = new double[atletas][pruebas];
    double lanzMax = 0;
    double lanzMin = 0;
    double suma = 0;
    double media = 0;
    int mejorAtleta = 0;
    int peorAtleta = 0;
    for (int i = 0; i < atletas; i++) {
      for (int j = 0; j < pruebas; j++) {
        double azar = (Math.random() * 90 - 60) + 60;
        suma += azar;
        competicion[i][j] = azar;
        if (azar > lanzMax) {
          lanzMax = azar;
          mejorAtleta = i;
        }
        if (azar < lanzMin) {
          lanzMin = azar;
          peorAtleta = i;
        }
      }
    }
    int pruebasTotales = pruebas * atletas;
    media = suma / pruebasTotales;
    System.out.println("Mejor lanzamiento:" + lanzMax + " realizado por el atleta:" + mejorAtleta);
    System.out.println("Peor lanzamiento:" + lanzMin + " realizado por el atleta:" + peorAtleta);
    System.out.println("media de lanzamiento:" + media);
  }

  public double ruleta(double apuesta, int casilla) {
    int[] jugada = new int[6];
    double ganancia = 0;
    int i = 0;
    while (i < 6) {
      int azar = (int) (Math.random() * 36);
      if (jugada[jugada.length] != azar) {
        jugada[i] = azar;
        if (azar == casilla) {
          ganancia = apuesta * 2;
        } else {
          ganancia = 0;
        }
        i++;
      }
    }
    return ganancia;
  }

  public void matriculas_coche(int n) {
    String[] matricula = new String[8];
    int sumaD = 0;
    int contXXX = 0;
    for (int i = 0; i < n; i++) {
      matricula[i] = "";
      for (int j = 0; j < 8; j++) {
        if (j < 4) {
          int numAzar = (int) (Math.random() * 9);
          sumaD += numAzar;
          matricula[j] = String.valueOf(numAzar);
        }
        if (j == 4) {
          matricula[j] = " ";
        }
        if (j > 4) {
          char letraAzar = (char) (Math.random() * ('Z' - 'A') + 'A');
          matricula[j] = String.valueOf(letraAzar);
        }
        if (matricula[j].charAt(5) == 'X' && matricula[j].charAt(6) == 'X' && matricula[j].charAt(7) == 'X') {
          contXXX++;
        }
        System.out.println("Suma de digitos:" + sumaD);
        System.out.println("Numero de matriculas con XXX:" + contXXX);
      }
    }
  }
}

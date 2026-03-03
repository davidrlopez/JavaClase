package Trimestre1.arrays;

import java.util.Scanner;

public class recuperacionArraysExamen3 {

  public static void main(String[] args) {
    System.out.println("HelloWorld");
  }

  public void ejercicio1(int n) {
    int[] solucion = new int[n];
    int cont0s = 0;
    int mayores = 0;
    int menores = 0;
    int iguales = 0;
    double suma = 0;
    double media = 0;
    Scanner input = new Scanner(System.in);
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
    int azar = (int) ((Math.random() * 20) + 1);

    for (int j = 0; j < n; j++) {
      if (azar < solucion[i]) {
        mayores++;
      } else if (azar > solucion[i]) {
        menores++;
      } else {
        iguales++;
      }
    }
    media = suma / n;
    input.close();

  }

  public void ejercicio2(int atletas, int pruebas) {
    double maxLanz = 0;
    double maxLanzT = 0;
    double minLanzT = 99;
    double minLanz = 99;
    int mejorAt = 0;
    int peorAt = 0;
    double suma = 0;
    double media = 0;
    double[][] competicion = new double[atletas][pruebas];
    for (int i = 0; i < atletas; i++) {
      for (int j = 0; j < pruebas; j++) {
        double azar = (Math.random() * 30) + 60;
        suma += azar;
        competicion[i][j] = azar;
        if (azar > maxLanz) {
          maxLanz = azar;
        }
        if (azar < minLanz) {
          minLanz = azar;
        }
      }
      if (maxLanz > maxLanzT) {
        maxLanzT = maxLanz;
        mejorAt = i;
      }
      if (minLanz < minLanzT) {
        peorAt = i;
      }
    }
    int pruebasT = pruebas * atletas;
    media = suma / pruebasT;
  }

  public double ejercicio3(double apuesta, int casilla) {
    int i = 0;
    boolean repetido;
    int[] jugada = new int[6];
    double ganancias = 0;
    while (i < 6) {
      repetido = false;
      int azar = (int) (Math.random() * 37);

      do {
        for (int j = 0; j < i; j++) {
          if (azar == jugada[j]) {
            repetido = true;
            break;
          }
          if (!repetido) {
            jugada[i] = azar;
            if (jugada[i] == casilla) {
              ganancias = apuesta * 2;
            }
            i++;
          }
        }
      } while (repetido);
    }
    return ganancias;
  }

  public void ejercicio4(int n) {
    String[] matriculas = new String[n];
    int contXXX = 0;
    for (int i = 0; i < n; i++) {
      String dig = "";
      String letras = "";
      int suma = 0;
      for (int j = 0; j < 8; j++) {
        if (j < 4) {
          int numR = (int) (Math.random() * 10);
          dig += String.valueOf(numR);
          suma += numR;
        }
        if (j > 4) {
          char letraR = (char) ((Math.random() * 26) + 'A');
          letras += letraR;
        }
        System.out.println(suma);
      }
      matriculas[i] = dig + " " + letras;
      if (letras.equals("XXX")) {
        contXXX++;
      }

    }
    System.out.println(contXXX);
  }
}

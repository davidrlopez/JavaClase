package Trimestre1.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class recuperacionArrays {

  public static void main(String[] args) {
    System.out.println("hello world");
  }

  public boolean ejercicio1(double a, double b, double c) {
    for (int i = 0; i < 2; i++) {
      double x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c) / (2 * a));
      double x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c) / (2 * a));
      if (x1 > 0 && x2 > 0) {
        System.out.println("Tiene 2 soluciones:" + x1 + " y:" + x2);
        return true;
      } else {
        if (x1 > 0 || x2 > 0) {
          System.out.println("tiene 1 solucion");
          if (x1 > 0) {
            System.out.println(x1);
          } else {
            System.out.println(x2);
          }
          return true;
        } else {
          System.out.println("Sin solucion");
        }
      }
    }
    return false;
  }

  public void ejercicio2(int n) {
    Scanner input = new Scanner(System.in);
    double media = 0;
    double suma = 0;
    int num0 = 0;
    int[] solucion = new int[n];
    for (int i = 0; i < n; i++) {
      int numero = input.nextInt();
      if (numero >= 0) {
        solucion[i] = numero;
        suma += numero;
        if (numero == 0) {
          num0++;
        }
      } else {
        i--;
      }
    }
    media = suma / n;
    double azar = Math.random() * (20 - 1) + 1;
    int mayor = 0;
    int menor = 0;
    int iguales = 0;
    for (int l = 0; l < solucion.length; l++) {
      if (solucion[l] > azar) {
        mayor++;
      }
      if (solucion[l] < azar) {
        menor++;
      } else {
        iguales++;
      }
    }
    input.close();
  }

  public void Matriculas_coche(int n) {
    String[] matriculas = new String[n];
    int contXXX = 0;

    for (int i = 0; i < n; i++) {
      int sumaDigitosMatricula = 0;
      String parteNumerica = "";
      String parteLetras = "";

      // 1. Generar 4 dígitos y sumarlos
      for (int j = 0; j < 4; j++) {
        int digito = (int) (Math.random() * 10); // 0 a 9
        sumaDigitosMatricula += digito;
        parteNumerica += digito;
      }

      // 2. Generar 3 letras mayúsculas
      for (int j = 0; j < 3; j++) {
        char letra = (char) ('A' + Math.random() * 26);
        parteLetras += letra;
      }

      // 3. Formar la matrícula completa y guardarla
      String matriculaCompleta = parteNumerica + " " + parteLetras;
      matriculas[i] = matriculaCompleta;

      // 4. Mostrar suma de esta matrícula
      System.out.println("Matrícula: " + matriculaCompleta + " | Suma números: " + sumaDigitosMatricula);

      // 5. Buscar combinación "XXX"
      if (parteLetras.equals("XXX")) {
        contXXX++;
      }
    }

    System.out.println("\nTotal de matrículas con 'XXX': " + contXXX);
  }

  public void ejercicio9() {
    // 20 filas, 3 columnas (0: Tipo, 1: Val. Comercial, 2: Val. Final)
    double[][] coches = new double[20][3];
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < 20; i++) {
      System.out.println("--- Vehículo " + (i + 1) + " ---");
      System.out.print("Valor comercial: ");
      double valorCom = sc.nextDouble();
      System.out.print("Tipo (1-Familiar, 2-Público, 3-Carga): ");
      int tipo = sc.nextInt();

      // 1. Calcular IVA base
      double porcentajeIva = (valorCom > 35000) ? 0.30 : 0.21;
      double ivaCobrado = valorCom * porcentajeIva;

      double descuentoIVA = 0;
      double sobrecosto = 0;

      // 2. Regla Tipo 1 (Familiar) y valor <= 15000
      if (tipo == 1 && valorCom <= 15000) {
        descuentoIVA = ivaCobrado * 0.50;
      }

      // 3. Regla Tipo 2 o 3 y valor > 30000 (Sobrecosto)
      if ((tipo == 2 || tipo == 3) && valorCom > 30000) {
        sobrecosto = (valorCom + ivaCobrado) * 0.05;
      }

      // Cálculo temporal del valor final
      double valorFinal = valorCom + ivaCobrado - descuentoIVA + sobrecosto;

      // 4. Regla final: si es < 20000, 5% dto sobre el valor COMERCIAL
      if (valorFinal < 20000) {
        valorFinal -= (valorCom * 0.05);
      }

      // Guardar en matriz
      coches[i][0] = tipo;
      coches[i][1] = valorCom;
      coches[i][2] = valorFinal;

      System.out.println("Valor Final calculado: " + valorFinal + "€\n");
    }
    sc.close();
  }

  public void ejercicio10() {
    // Matriz: 5 salas, 20 equipos.
    // Nota: Si el enunciado exige 2 turnos estrictos, sería [5][20][2]
    int[][] sistemas = new int[5][20];
    Scanner sc = new Scanner(System.in);
    int opcion = 0;

    do {
      System.out.println("\n--- MENÚ UCPR ---");
      System.out.println("1. Asignar o cancelar turno");
      System.out.println("2. Cantidad de equipos disponibles por sala");
      System.out.println("3. Cantidad de turnos asignados en toda la UCPR");
      System.out.println("4. Salir");
      System.out.print("Elija opción: ");
      opcion = sc.nextInt();

      switch (opcion) {
        case 1:
          System.out.print("Número de sala (0-4): ");
          int s = sc.nextInt();
          System.out.print("Número de equipo (0-19): ");
          int e = sc.nextInt();

          if (sistemas[s][e] == 0) {
            System.out.print("Equipo libre. ¿Reservar? (1-Sí, 2-No): ");
            if (sc.nextInt() == 1)
              sistemas[s][e] = 1;
          } else {
            System.out.print("Equipo reservado. ¿Cancelar? (1-Sí, 2-No): ");
            if (sc.nextInt() == 1)
              sistemas[s][e] = 0;
          }
          break;

        case 2:
          for (int i = 0; i < 5; i++) {
            int disponibles = 0;
            for (int j = 0; j < 20; j++) {
              if (sistemas[i][j] == 0)
                disponibles++;
            }
            System.out.println("Sala " + i + ": " + disponibles + " equipos libres.");
          }
          break;

        case 3:
          int totalReservados = 0;
          for (int[] sala : sistemas) {
            for (int equipo : sala) {
              if (equipo == 1)
                totalReservados++;
            }
          }
          System.out.println("Total turnos asignados en la UCPR: " + totalReservados);
          break;
      }
    } while (opcion != 4);

    System.out.println("Saliendo del sistema...");
  }
}

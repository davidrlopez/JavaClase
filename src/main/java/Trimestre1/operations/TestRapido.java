package Trimestre1.operations;

import java.util.Scanner;

public class TestRapido {

    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce cuantos numeros factoriales");
        int rangoFactorial = input.nextInt();
        for (int i = 1; i <= rangoFactorial; i++) {
            System.out.println(TestRapido.factorial(i));
        }
        input.close();
    }

    public static boolean esPrimo(int nPrimo) {
        if (nPrimo <= 1) {
            return false;
        }
        if (nPrimo == 2) {
            return true;
        }
        if (nPrimo % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= nPrimo; i += 2) {
            if (nPrimo % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double randomNumber(int rangoMin, int rangoMax) {
        double rango = rangoMax - rangoMin;
        double numGen = (Math.random() * rango) + rangoMin;
        return numGen;
    }

    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int mcm(int a, int b) {
        int mcm = (a * b) / TestRapido.mcd(a, b);
        return mcm;
    }

    public static boolean numFriends(int f1, int f2) {
        int sumaf1 = 0;
        int sumaf2 = 0;
        for (int i = 1; i < f1; i++) {
            if (f1 % i == 0) {
                sumaf1 += i;
            }
        }
        for (int i = 1; i < f2; i++) {
            if (f2 % i == 0) {
                sumaf2 += i;
            }
        }
        return (sumaf1 == f2 && sumaf2 == f1);
    }

    public static String ecuacion2Grado(int a, int b, int c) {
        double discriminante = Math.pow(b, 2) - 4 * a * c;
        if (discriminante < 0) {
            return "No tiene soluciones reales";
        }
        double solucionPos = (-b + Math.sqrt(discriminante)) / (2 * a);
        double solucionNeg = (-b - Math.sqrt(discriminante)) / (2 * a);
        return "Sol1: " + solucionPos + " |Sol2:" + solucionNeg;
    }

    public static int factorial(int a) {
        int factorial = 1;
        for (int i = 1; i <= a; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int sumaFactorial(int a) {
        int sumaFactorial = 0;
        for (int i = 1; i <= a; i++) {
            sumaFactorial += TestRapido.factorial(i);
        }
        return sumaFactorial;
    }
}

package arrays;

import java.util.Scanner;
import operations.TestRapido;

public class arrays1 {

    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduzca el tamaño de la array");
        int limArray = input.nextInt();
        arrays1.leer(limArray);
        mezclar3arrays();
        int arrayB[] = { 5, 2, 4, 7, 11 };
        int valor = 11;
        System.out.println("Existe?" + buscarEnArray(arrayB, valor));
        input.close();
    }

    public static void leer(int n) {
        int array[];
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
        }
    }

    public static void estadisticasArray(double[] valores) {
        double sumaPos = 0;
        double sumaNeg = 0;
        int cantValoresPos = 0;
        int cantValoresNeg = 0;
        int suma0s = 0;

        for (int i = 0; i < valores.length; i++) {
            if (valores[i] > 0) {
                sumaPos += valores[i];
                cantValoresPos++;
            } else if (valores[i] < 0) {
                sumaNeg += valores[i];
                cantValoresNeg++;
            } else if (valores[i] == 0) {
                suma0s++;
            }
        }

        if (cantValoresPos > 0) {
            double mediaPos = sumaPos / cantValoresPos;
            System.out.println("Media positiva: " + mediaPos);
        }
        if (cantValoresNeg > 0) {
            double mediaNeg = sumaNeg / cantValoresNeg;
            System.out.println("Media negativa: " + mediaNeg);
        }
        System.out.println("Numero de 0s: " + suma0s);
    }

    //5
    public static void mezclar3arrays() {
        int array1[];
        int array2[];
        int array3[];
        int n = (int) TestRapido.randomNumber(1, 11);
        array1 = new int[n];
        array2 = new int[n];
        array3 = new int[2 * n];
        array1 = generarArray(n);
        array2 = generarArray(n);
        mostrarArray(array1);
        mostrarArray(array2);
        int cont3 = 0;
        for (int i = 0; i < n; i++) {
            array3[cont3++] = array1[i];
            array3[cont3++] = array2[i];
        }
        mostrarArray(array3);
    }

    public static void mostrarArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + ",");
            System.out.println("****************************");
        }
    }

    public static int[] generarArray(int n) {
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (TestRapido.randomNumber(1, 101));
        }
        return array;
    }

    public static boolean buscarEnArray(int array[], int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }

    public static int buscarEnArray2(int array[], int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return i;
            }
        }
        return -1;
    }
}

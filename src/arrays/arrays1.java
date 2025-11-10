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
        System.out.println("\n--- Test de busqueda de valores en array ---");
        System.out.println("Cuantos numeros quiere buscar en el array?");
        int cantidadBusquedas = input.nextInt();
        int aciertos = acertarEnArray(arrayB, cantidadBusquedas, input);
        System.out.println(
            "Numero de aciertos: " + aciertos + " de " + cantidadBusquedas
        );

        // Test para el método ordenacionArray
        System.out.println("\n--- Test de ordenación de array ---");
        int arrayParaOrdenar[] = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.print("Array original: ");
        mostrarArray(arrayParaOrdenar);

        int arrayOrdenado[] = ordenacionArray(arrayParaOrdenar.clone());
        System.out.print("Array ordenado: ");
        mostrarArray(arrayOrdenado);

        // Test para el método desplazarArray
        System.out.println("\n--- Test de desplazamiento de array ---");
        int[] arrayParaDesplazar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.print("Array original: ");
        mostrarArray(arrayParaDesplazar);

        int posicion = 4; // índice donde insertar (0-based)
        int nuevoValor = 99; // valor a insertar
        int[] resultadoDesplazado = desplazarArray(
            posicion,
            nuevoValor,
            arrayParaDesplazar.clone()
        );
        System.out.println(
            "Insertando " + nuevoValor + " en la posición " + posicion + ":"
        );
        System.out.print("Array resultante: ");
        mostrarArray(resultadoDesplazado);

        // Test para el método notasAlumnos
        System.out.println("\n--- Test de notas de alumnos ---");
        System.out.print("Introduce el número de alumnos: ");
        int numeroAlumnos = input.nextInt();
        notasAlumnos(numeroAlumnos);

        //Test mezclar y ordenar
        System.out.println("********************");
        System.out.println("Test mezclar y ordenar");
        int array1[] = generarArray(10);
        int array2[] = generarArray(10);
        int array3[] = mezclarArrays(array1, array2); // Remove redundant initialization
        array3 = ordenacionArray(array3); // Add sorting as the comment suggests
        mostrarArray(array3); // Show final sorted result
        System.out.println("********************");
        System.out.println("Introduce las filas y columnas");
        int filas = input.nextInt();
        int columnas = input.nextInt();
        int[][] array2d = generarArray2D(filas, columnas);
        mostrarArray2D(array2d);
        maxMin2d(array2d);
        System.out.println("Test generar array");
        mostrarArray(generarArray(100));
        System.out.println("Test array sumas");
        int matriz1[][] = generarArray2D(3, 3);
        int matriz2[][] = generarArray2D(3, 3);
        int matriz3[][] = sumarMatrices(matriz1, matriz2);
        mostrarArray2D(matriz1);
        mostrarArray2D(matriz2);
        mostrarArray2D(matriz3);
        System.out.println("\n--- Test de trasponer array ---");
        int matrizTraspuesta[][] = trasponerMatriz(matriz1);
        mostrarArray2D(matrizTraspuesta);
        System.out.println("\n--- Test de suma filas y columnas ---");
        int arrayFilasColumnas[][] = sumarMatricesFilaColumna(matriz1);
        System.out.println("Matriz original:");
        mostrarArray2D(matriz1);
        System.out.println("Sumas de filas:");
        mostrarArray(arrayFilasColumnas[0]);
        System.out.println("Sumas de columnas:");
        mostrarArray(arrayFilasColumnas[1]);
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
        int arrayOrdenada[] = ordenacionArray(array3);
        System.out.print(arrayOrdenada);
    }

    public static void mostrarArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("****************************");
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

    public static boolean buscarEnArray2Ordenado(int array[], int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return true;
            } else {
                if (array[i] > n) return false;
            }
        }
        return false;
    }

    public static int acertarEnArray(int array[], int n, Scanner input) {
        int aciertos = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Introduce un numero para buscar:");
            int numero = input.nextInt();
            if (buscarEnArray2(array, numero) != -1) {
                aciertos++;
            }
        }
        return aciertos;
    }

    public static int[] ordenacionArray(int array[]) {
        int minimo,
            pos_minimo = -1,
            auxiliar = 0;
        for (int i = 0; i < array.length; i++) {
            minimo = 999999;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minimo) {
                    minimo = array[j];
                    pos_minimo = j;
                }
                if (array[i] > minimo) {
                    auxiliar = array[i];
                    array[i] = minimo;
                    array[pos_minimo] = auxiliar;
                }
            }
        }
        return array;
    }

    public static int tipo_array(int array[]) {
        int respuesta;

        boolean iguales = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                iguales = false;
                break;
            }
        }

        if (iguales) {
            return 1;
        }

        boolean asc = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                asc = false;
                break;
            }
        }
        if (asc) {
            return 3;
        } else return 4;
    }

    public static int[] desplazarArray(int pos, int valor, int array[]) {
        if (pos >= 0 && pos < array.length) {
            for (int i = array.length - 1; i > pos; i--) {
                array[i] = array[i - 1];
            }
            array[pos] = valor;
        }
        return array;
    }

    public static int[] desplazarArray2(int pos, int valor, int array[]) {
        //poniendo el ultimo valor al principio
        int ultimo = array[array.length - 1];
        for (int i = array.length - 1; i > pos; i--) {
            array[i] = array[i - 1];
        }
        array[0] = ultimo;
        return array;
    }

    public static int[] desplazarArrayNveces(int n, int array[]) {
        for (int i = 0; i < n; i++) {
            array = desplazarArray2(0, 0, array);
        }
        return array;
    }

    public static void notasAlumnos(int nAlumnos) {
        int array1[] = generarArray(nAlumnos);
        int array2[] = generarArray(nAlumnos);
        int array3[] = generarArray(nAlumnos);
        double suma1 = 0;
        double suma2 = 0;
        double suma3 = 0;
        double mediaTri1 = 0;
        double mediaTri2 = 0;
        double mediaTri3 = 0;
        double mediaCurso = 0;

        for (int i = 0; i < array1.length; i++) {
            suma1 += array1[i];
        }
        mediaTri1 = suma1 / array1.length;

        for (int i = 0; i < array2.length; i++) {
            suma2 += array2[i];
        }
        mediaTri2 = suma2 / array2.length;

        for (int i = 0; i < array3.length; i++) {
            suma3 += array3[i];
        }
        mediaTri3 = suma3 / array3.length;

        mediaCurso = (mediaTri1 + mediaTri2 + mediaTri3) / 3;

        System.out.print("Notas alumnos del trimestre 1: ");
        mostrarArray(array1);
        System.out.println("Media trimestre 1: " + mediaTri1);

        System.out.print("Notas alumnos del trimestre 2: ");
        mostrarArray(array2);
        System.out.println("Media trimestre 2: " + mediaTri2);

        System.out.print("Notas alumnos del trimestre 3: ");
        mostrarArray(array3);
        System.out.println("Media trimestre 3: " + mediaTri3);

        System.out.println("Nota media del curso: " + mediaCurso);
    }

    public static int[] mezclarArrays(int array1[], int array2[]) {
        int array3[] = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        int j = 0;
        for (int i = array1.length; i < array3.length; i++) {
            array3[i] = array2[j++];
        }
        mostrarArray(array1);
        mostrarArray(array2);
        mostrarArray(array3);
        return array3;
    }

    //ej 13
    public static void ej13() {
        int array1[] = generarArray(10);
        int array2[] = generarArray(10);
        mezclarArrays(array1, array2);
    }

    public static void mostrarArray2D(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println("****************************");
    }

    public static int[][] generarArray2D(int fila, int columna) {
        int array[][] = new int[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                array[i][j] = (int) (TestRapido.randomNumber(1, 101));
            }
        }
        return array;
    }

    public static void maxMin2d(int array[][]) {
        int max, min;
        min = 99999;
        max = 0;
        int fila_max = 0;
        int col_max = 0;
        int fila_min = 0;
        int col_min = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    fila_max = i;
                    col_max = j;
                }
                if (array[i][j] < min) {
                    min = array[i][j];
                    fila_min = i;
                    col_min = j;
                }
            }
        }
        System.out.println(
            "Fila maxima=" + fila_max + " Columna maxima=" + col_max
        );
        System.out.println(
            "Fila minima=" + fila_min + " Columna minima=" + col_min
        );
    }

    public static int[][] rellenar_matriz(int n) {
        int array[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (TestRapido.randomNumber(1, 101));
            }
        }
        return array;
    }

    public static boolean matriz_simetrica(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != array[j][i]) {}
            }
        }
        return false;
    }

    public static int[][] sumarMatrices(int matrizA[][], int matrizB[][]) {
        int matrizC[][] = new int[matrizA.length][matrizA[0].length];
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                matrizC[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        return matrizC;
    }

    public static int[][] trasponerMatriz(int A[][]) {
        int matriz[][] = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                matriz[j][i] = A[i][j];
            }
        }
        return matriz;
    }

    public static int[][] matrizIdentidad(int n) {
        //metodo menos eficiente
        int array[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }

    public static int[][] matrizIdentidadOpt(int n) {
        int array[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i][i] = 1;
        }
        return array;
    }

    //ej 6
    public static int[][] sumarMatricesFilaColumna(int matrizA[][]) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;

        // Create result: [0] = row sums array, [1] = column sums array
        int resultado[][] = new int[2][]; // Fixed: proper initialization
        resultado[0] = new int[filas]; // Row sums
        resultado[1] = new int[columnas]; // Column sums

        // Calculate row sums
        for (int i = 0; i < filas; i++) {
            // Fixed: i < filas
            for (int j = 0; j < columnas; j++) {
                // Fixed: j < columnas
                resultado[0][i] += matrizA[i][j];
            }
        }

        // Calculate column sums
        for (int j = 0; j < columnas; j++) {
            // Fixed: j < columnas
            for (int i = 0; i < filas; i++) {
                // Fixed: i < filas
                resultado[1][j] += matrizA[i][j];
            }
        }

        return resultado;
    }
}

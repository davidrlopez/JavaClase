package arrays;

import java.util.Arrays;
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
        "Numero de aciertos: " + aciertos + " de " + cantidadBusquedas);

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
        arrayParaDesplazar.clone());
    System.out.println(
        "Insertando " + nuevoValor + " en la posición " + posicion + ":");
    System.out.print("Array resultante: ");
    mostrarArray(resultadoDesplazado);

    // Test para el método notasAlumnos
    System.out.println("\n--- Test de notas de alumnos ---");
    System.out.print("Introduce el número de alumnos: ");
    int numeroAlumnos = input.nextInt();
    notasAlumnos(numeroAlumnos);

    // Test mezclar y ordenar
    System.out.println("********************");
    System.out.println("Test mezclar y ordenar");
    double array1[] = generarArray(10);
    double array2[] = generarArray(10);
    // Convert to int arrays for mezclarArrays method
    int[] intArray1 = new int[array1.length];
    int[] intArray2 = new int[array2.length];
    for (int i = 0; i < array1.length; i++) {
      intArray1[i] = (int) array1[i];
      intArray2[i] = (int) array2[i];
    }
    int array3[] = mezclarArrays(intArray1, intArray2); // Remove redundant initialization
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
    double[] tempArray = generarArray(100);
    int[] intArray = new int[tempArray.length];
    for (int i = 0; i < tempArray.length; i++) {
      intArray[i] = (int) tempArray[i];
    }
    mostrarArray(intArray);
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

    // Test para el ejercicio de salto de longitud
    System.out.println("\n--- Test de competicion de salto de longitud ---");
    System.out.print("Introduce el numero de atletas: ");
    int numeroAtletas = input.nextInt();
    saltoLongitud(numeroAtletas);

    // Test para el ejercicio de búsqueda en array generado
    System.out.println("\n--- Test de búsqueda en array generado ---");
    System.out.print("Introduce el valor a buscar: ");
    int valorBuscar = input.nextInt();
    System.out.print("Introduce el tamaño del array: ");
    int tamanoArray = input.nextInt();

    boolean encontrado = ejercicioBusqueda(valorBuscar, tamanoArray);
    System.out.println("¿El valor " + valorBuscar + " existe en el array? " +
        (encontrado ? "SÍ" : "NO"));

    // Test para el ejercicio de análisis de notas
    System.out.println("\n--- Test de análisis de notas ---");
    analisisNotas();

    // Test para el método desviacionTipica
    System.out.println("\n--- Test de desviación típica ---");
    double[] datos = generarArray(10); // Generate random doubles directly

    System.out.print("Datos para calcular desviación típica: ");
    for (int i = 0; i < datos.length; i++) {
      System.out.printf("%.1f", datos[i]);
      if (i < datos.length - 1)
        System.out.print(", ");
    }
    System.out.println();

    double desviacion = desviacionTipica(datos);
    System.out.printf("Desviación típica: %.2f%n", desviacion);

    // Test para el método generarArrayPares
    System.out.println("\n--- Test de generarArrayPares ---");
    double[] arrayOriginal = generarArray(10); // Generate array with 10 elements

    System.out.print("Array original: ");
    mostrarArray(arrayOriginal);

    double[] arrayPares = generarArrayPares(arrayOriginal);
    System.out.print("Array con elementos de posiciones pares: ");
    mostrarArray(arrayPares);

    // Ejercicio 10: Análisis de vector de 10 elementos aleatorios
    System.out.println("\n--- Ejercicio 10: Vector de 10 elementos aleatorios ---");
    System.out.println("=== ANÁLISIS DE VECTOR DE 10 ELEMENTOS ALEATORIOS ===");
    double[] vectorDouble = generarArray(10);
    int[] vector = new int[vectorDouble.length];
    for (int i = 0; i < vectorDouble.length; i++) {
      vector[i] = (int) vectorDouble[i];
    }
    System.out.print("Vector generado: ");
    mostrarArray(vector);
    valoresArray(vector);

    // Test buscar_ocurrencias_array - Binary Search todas las ocurrencias
    System.out.println("\n--- Test buscar_ocurrencias_array (Binary Search) ---");

    // Usar un valor que probablemente exista en el array (el máximo del ejercicio
    // anterior)
    int valorParaBuscar = vector[0]; // Tomar el primer valor del array como ejemplo
    System.out.println("Buscando todas las ocurrencias del valor: " + valorParaBuscar);

    // Crear una copia del vector para no modificar el original
    int[] vectorParaBusqueda = vector.clone();

    int totalOcurrencias = buscar_ocurrencias_array(vectorParaBusqueda, valorParaBuscar);
    System.out.println("Método retorna: " + totalOcurrencias + " ocurrencias");
    // test intercambiar maximos array
    System.out.println("\n===Test intercambiar maximos entre arrays===");

    // Crear un nuevo array int desordenado directamente
    int[] arrayIntercambiar = new int[10];
    for (int i = 0; i < arrayIntercambiar.length; i++) {
      arrayIntercambiar[i] = (int) TestRapido.randomNumber(1, 101);
    }

    System.out.println("Array original");
    mostrarArray(arrayIntercambiar);
    System.out.println("Array intercambiada");
    int[] vectorIntercambiado = cambiarMaximo(arrayIntercambiar.clone());
    mostrarArray(vectorIntercambiado);

    // Test generar2Vectores method
    System.out.println("\n=== Test generar2Vectores ===");
    int[] testArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    System.out.print("Array de entrada: ");
    mostrarArray(testArray);

    int[][] resultado2Vectores = generar2Vectores(testArray);
    System.out.print("Vector 1 (impares +15, pares sin cambio): ");
    mostrarArray(resultado2Vectores[0]);
    System.out.print("Vector 2 (resto división por 3): ");
    mostrarArray(resultado2Vectores[1]);

    // Test devolverMinimo method
    System.out.println("\n=== Test devolverMinimo ===");
    int[] testArrayMinimo = { 15, 3, 8, 1, 12, 7, 20, 0, 9, 5 };
    System.out.print("Array de entrada: ");
    mostrarArray(testArrayMinimo);

    int[] resultadoMinimo = devolverMinimo(testArrayMinimo);
    System.out.println("Valor mínimo: " + resultadoMinimo[0]);
    System.out.println("Posición del mínimo: " + resultadoMinimo[1]);

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

  // 5
  public static void mezclar3arrays() {
    int array1[];
    int array2[];
    int array3[];
    int n = (int) TestRapido.randomNumber(1, 11);
    array1 = new int[n];
    array2 = new int[n];
    array3 = new int[2 * n];
    double[] tempArray1 = generarArray(n);
    double[] tempArray2 = generarArray(n);
    for (int i = 0; i < n; i++) {
      array1[i] = (int) tempArray1[i];
      array2[i] = (int) tempArray2[i];
    }
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

  public static void mostrarArray(double array[]) {
    for (int i = 0; i < array.length; i++) {
      System.out.printf("%.1f", array[i]);
      if (i < array.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println();
    System.out.println("****************************");
  }

  public static void mostrarArray(String array[]) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      if (i < array.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println();
    System.out.println("****************************");
  }

  public static double[] generarArray(int n) {
    double array[] = new double[n];
    for (int i = 0; i < n; i++) {
      array[i] = TestRapido.randomNumber(1, 101);
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
        if (array[i] > n)
          return false;
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
    } else
      return 4;
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
    // poniendo el ultimo valor al principio
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
    double array1[] = generarArray(nAlumnos);
    double array2[] = generarArray(nAlumnos);
    double array3[] = generarArray(nAlumnos);
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

  // ej 13
  public static void ej13() {
    double array1[] = generarArray(10);
    double array2[] = generarArray(10);
    // Convert to int arrays for mezclarArrays method
    int[] intArray1 = new int[array1.length];
    int[] intArray2 = new int[array2.length];
    for (int i = 0; i < array1.length; i++) {
      intArray1[i] = (int) array1[i];
      intArray2[i] = (int) array2[i];
    }
    mezclarArrays(intArray1, intArray2);
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
        "Fila maxima=" + fila_max + " Columna maxima=" + col_max);
    System.out.println(
        "Fila minima=" + fila_min + " Columna minima=" + col_min);
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
        if (array[i][j] != array[j][i]) {
        }
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

  // 7
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
    // metodo menos eficiente
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

  // ej 6
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

  public static double[][] generarArrayDobleAzar(
      int filas,
      int columnas,
      double li,
      double ls) {
    double array[][] = new double[filas][columnas];
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        array[i][j] = Math.random() * (ls - li) + li;
      }
    }
    return array;
  }

  public static void mostrarArray2D(double array[][]) {
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

  // variacion del ejercicio 8, competicion de salto de longitud, participan n
  // atletas con 3 intentos cada uno, por tanto tendrremos n filas
  // con los atletas pero 3 columnas con los intentos. El salto se generara al
  // azar dentro del rango [7..8,95] Array bidimensional
  // array unidimensional para los nombres de los atletas.
  // hay q sacar la mejor marca de salto, media total , media por atleta.
  // {System.out.printf("%.2f",marcas[i][j]); System.out.print(" ");}
  // System.out.println(""); para imprimir bien redondeando

  public static void saltoLongitud(int n) {
    double marcas[][] = new double[n][3];
    String atletas[] = new String[n];

    // Generar marcas de salto entre 7.0 y 8.85 metros
    marcas = generarArrayDobleAzar(n, 3, 7.0, 8.85);

    // Aplicar posibilidad de salto nulo (10% de probabilidad por intento)
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        if (Math.random() <= 0.1) {
          marcas[i][j] = 0.0; // Salto nulo
        }
      }
    }

    // Generar nombres de atletas
    for (int i = 0; i < n; i++) {
      atletas[i] = "Atleta " + (i + 1);
    }

    // Mostrar resultados de todos los atletas
    System.out.println("\n=== COMPETICION DE SALTO DE LONGITUD ===");
    System.out.println("Resultados por atleta (3 intentos):");
    System.out.println("------------------------------------");

    for (int i = 0; i < n; i++) {
      System.out.print(atletas[i] + ": ");
      for (int j = 0; j < 3; j++) {
        System.out.printf("%.2f", marcas[i][j]);
        if (j < 2)
          System.out.print(" - ");
      }
      System.out.println();
    }

    // Calcular mejor marca de salto
    double mejorMarca = 0.0;
    String mejorAtleta = "";
    int mejorIntento = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        if (marcas[i][j] > mejorMarca) {
          mejorMarca = marcas[i][j];
          mejorAtleta = atletas[i];
          mejorIntento = j + 1;
        }
      }
    }

    // Calcular media total (excluyendo saltos nulos)
    double sumaTotal = 0.0;
    int intentosValidos = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        if (marcas[i][j] > 0) { // Solo contar saltos válidos
          sumaTotal += marcas[i][j];
          intentosValidos++;
        }
      }
    }

    double mediaTotal = (intentosValidos > 0) ? sumaTotal / intentosValidos : 0.0;

    // Calcular y mostrar media por atleta y mejor marca personal
    System.out.println("\n=== ESTADISTICAS POR ATLETA ===");
    System.out.println("--------------------------------");

    for (int i = 0; i < n; i++) {
      double sumaAtleta = 0.0;
      double mejorMarcaAtleta = 0.0;
      int intentosValidosAtleta = 0;

      for (int j = 0; j < 3; j++) {
        if (marcas[i][j] > 0) { // Solo contar saltos válidos
          sumaAtleta += marcas[i][j];
          intentosValidosAtleta++;
          if (marcas[i][j] > mejorMarcaAtleta) {
            mejorMarcaAtleta = marcas[i][j];
          }
        }
      }

      double mediaAtleta = (intentosValidosAtleta > 0) ? sumaAtleta / intentosValidosAtleta : 0.0;
      String mejorMarcaStr = (mejorMarcaAtleta > 0) ? String.format("%.2f m", mejorMarcaAtleta) : "Sin saltos válidos";
      System.out.printf("%s - Media: %.2f m - Mejor marca: %s%n",
          atletas[i], mediaAtleta, mejorMarcaStr);
    }

    // Mostrar resumen final
    System.out.println("\n=== RESUMEN FINAL ===");
    System.out.println("--------------------");
    System.out.printf("Mejor marca de la competicion: %.2f m (%s - Intento %d)%n",
        mejorMarca, mejorAtleta, mejorIntento);
    System.out.printf("Media total de la competicion: %.2f m%n", mediaTotal);
    System.out.printf("Total de participantes: %d atletas%n", n);
    System.out.printf("Saltos válidos: %d de %d intentos totales%n", intentosValidos, n * 3);
  }

  // Ejercicio de búsqueda en array generado
  // 1 crear metodo que acepte un valor a buscar y un tamaño n array
  // 2 generar array de entero al azar tamaño n
  // 3 devolver booleano indicando si existe o no
  public static boolean ejercicioBusqueda(int valorABuscar, int tamañoArray) {
    // Generar array de entero al azar tamaño n
    double[] arrayTemp = generarArray(tamañoArray);
    int[] array = new int[arrayTemp.length];
    for (int i = 0; i < arrayTemp.length; i++) {
      array[i] = (int) arrayTemp[i];
    }

    // Mostrar el array generado para verificación
    System.out.print("Array generado: ");
    mostrarArray(array);

    // Devolver booleano indicando si existe o no
    return buscarEnArray(array, valorABuscar);
  }

  public static int[][] tablaMultiplicar(int numero) {
    int tabla[][] = new int[10][3];
    for (int i = 0; i < 10; i++) {
      tabla[i][0] = numero;
      tabla[i][i] = i;
      tabla[i][2] = i * numero;
    }
    return tabla;
  }

  public static int aparicionesArray(int valor, int array[]) {
    int apariciones = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == valor) {
        apariciones++;
      }
    }
    return apariciones;
  }

  // Ejercicio 4: Análisis de notas reales
  // Diseñar una clase que pida por teclado 10 elementos de tipo real.
  // Calcular la media aritmética de todas las notas, y además indicar
  // cuántas notas son superiores, inferiores o iguales a la media.
  public static void analisisNotas() {
    Scanner input = new Scanner(System.in);
    double[] notas = new double[10];

    // Pedir por teclado 10 elementos de tipo real
    System.out.println("Introduce 10 notas (números reales):");
    for (int i = 0; i < 10; i++) {
      System.out.print("Nota " + (i + 1) + ": ");
      notas[i] = input.nextDouble();
    }

    // Calcular la media aritmética
    double suma = 0.0;
    for (double nota : notas) {
      suma += nota;
    }
    double media = suma / 10;

    // Contar notas superiores, inferiores e iguales a la media
    int superiores = 0;
    int inferiores = 0;
    int iguales = 0;

    for (double nota : notas) {
      if (nota > media) {
        superiores++;
      } else if (nota < media) {
        inferiores++;
      } else {
        iguales++;
      }
    }

    // Mostrar resultados
    System.out.println("\n=== ANÁLISIS DE NOTAS ===");
    System.out.print("Notas introducidas: ");
    for (int i = 0; i < notas.length; i++) {
      System.out.printf("%.2f", notas[i]);
      if (i < notas.length - 1)
        System.out.print(", ");
    }
    System.out.println();
    System.out.printf("Media aritmética: %.2f%n", media);
    System.out.println("Notas superiores a la media: " + superiores);
    System.out.println("Notas inferiores a la media: " + inferiores);
    System.out.println("Notas iguales a la media: " + iguales);
    System.out.println("Total de notas analizadas: " + (superiores + inferiores + iguales));
  }

  // ejercicio 5
  public static double desviacionTipica(double[] datos) {
    double desviacion;
    double suma = 0;
    double media;

    // Calculate mean
    for (int i = 0; i < datos.length; i++) {
      suma += datos[i];
    }
    media = suma / datos.length;
    suma = 0;

    // Calculate variance
    for (int i = 0; i < datos.length; i++) {
      suma += Math.pow(datos[i] - media, 2);
    }
    desviacion = suma / (datos.length - 1);
    desviacion = Math.sqrt(desviacion);

    return desviacion;
  }

  // metodo equals sin Arrays.equals
  public static boolean equalsSinUtil(double array1[], double array2[]) {
    if (array1.length != array2.length) {
      return false;
    }
    for (int i = 0; i < array1.length; i++) {
      if (array1[i] != array2[i]) {
        return false;
      }
    }
    return true;
  }

  // ejercicio 9
  public static double[] generarArrayPares(double array[]) {
    double array_par[] = new double[(array.length + 1) / 2];
    int pos_par = 0;
    for (int i = 0; i < array.length; i += 2) {
      array_par[pos_par] = array[i];
      pos_par++;
    }
    return array_par;
  }

  // Ejercicio 10: Continuando desde la versión original
  public static int valoresArray(int array[]) {
    // Guardar array original para encontrar posición del mínimo
    int[] arrayOriginal = array.clone();

    Arrays.sort(array);
    int minimo = array[0];
    int maximo = array[array.length - 1];
    int maximos = 0;

    // Contar las repeticiones del valor máximo
    for (int i = 0; i < array.length; i++) {
      if (array[i] == maximo) {
        maximos++;
      }
    }

    // Encontrar posición del mínimo en el array original
    int posicionMinimo = 0;
    for (int i = 0; i < arrayOriginal.length; i++) {
      if (arrayOriginal[i] == minimo) {
        posicionMinimo = i;
        break;
      }
    }

    // Mostrar resultados
    System.out.println("a) ELEMENTO MENOR:");
    System.out.println("   Valor menor: " + minimo);
    System.out.println("   Posición: " + posicionMinimo);

    System.out.println("b) ELEMENTO MAYOR:");
    System.out.println("   Valor mayor: " + maximo);
    System.out.println("   Veces que se repite: " + maximos);

    if (maximos > 1) {
      System.out.print("   Posiciones donde aparece: ");
      boolean primera = true;
      for (int i = 0; i < arrayOriginal.length; i++) {
        if (arrayOriginal[i] == maximo) {
          if (!primera) {
            System.out.print(", ");
          }
          System.out.print(i);
          primera = false;
        }
      }
      System.out.println();
    }

    return maximos; // Retornamos el número de repeticiones del máximo
  }

  public static int buscar_ocurrencias_array(int array[], int valor) {

    int ocurrencias = 0;

    Arrays.sort(array);
    int posicion = Arrays.binarySearch(array, valor);

    if (posicion >= 0) {
      System.out.println("Se encontró " + valor + " en las posiciones:");
      int i = posicion;
      while (i >= 0 && array[i] == valor) {
        i--;
      }
      int j = i + 1;
      while (j < array.length && array[j] == valor) {
        System.out.println("- Posicion: " + j);
        ocurrencias++;
        j++;
      }
    } else
      System.out.println("El valor " + valor + " no se encontró");
    System.out.println("Total de concurrencias de " + valor + ": " + ocurrencias);

    return ocurrencias;
  }

  public static int[] cambiarMaximo(int array[]) {
    int maximo = array[0]; // Inicializar con el primer elemento
    int pos_maximo = 0;

    // Encontrar el máximo y su posición
    for (int i = 1; i < array.length; i++) {
      if (array[i] > maximo) {
        maximo = array[i];
        pos_maximo = i;
      }
    }
    // Intercambiar el máximo con el último elemento (SOLO UNA VEZ)
    int ultimo = array[array.length - 1];
    array[array.length - 1] = maximo;
    array[pos_maximo] = ultimo;

    return array;
  }

  // ejercicio 19 PROBABLE EXAMEN
  public static int[][] generar2Vectores(int[] arrayEntrada) {
    int vectorSol[][] = new int[2][arrayEntrada.length];

    for (int i = 0; i < arrayEntrada.length; i++) {
      // vector2: resto de dividir por 3
      vectorSol[1][i] = arrayEntrada[i] % 3;

      // vector1: si es impar sumar 15, si es par mantener el valor original
      if (arrayEntrada[i] % 2 != 0) {
        vectorSol[0][i] = arrayEntrada[i] + 15;
      } else {
        vectorSol[0][i] = arrayEntrada[i];
      }
    }
    return vectorSol;
  }

  // ejercicio 22
  public static int[] devolverMinimo(int array[]) {
    int minimo = array[0]; // Inicializar con el primer elemento
    int pos_minimo = 0;
    int vectorSol[] = new int[2];

    // Encontrar el mínimo y su posición
    for (int i = 1; i < array.length; i++) {
      if (array[i] < minimo) {
        minimo = array[i];
        pos_minimo = i;
      }
    }

    // Almacenar el mínimo valor y su posición
    vectorSol[0] = minimo;
    vectorSol[1] = pos_minimo;

    return vectorSol;
  }

  public static int[] devolverMaximo(int array[]) {
    int maximo = array[0]; // Inicializar con el primer elemento
    int pos_maximo = 0;
    int vectorSol[] = new int[2];

    // Encontrar el mínimo y su posición
    for (int i = 1; i < array.length; i++) {
      if (array[i] > maximo) {
        maximo = array[i];
        pos_maximo = i;
      }
    }

    // Almacenar el mínimo valor y su posición
    vectorSol[0] = maximo;
    vectorSol[1] = pos_maximo;

    return vectorSol;
  }

  public static double ejercicio24(int array[]) {
    double media = 0;
    int cont = 0;
    int suma = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != 0) {
        suma += array[i];
        cont++;
      }
      media = suma / cont;
    }
    return media;
  }

  public static int[] ejercicio25(int array[]) {
    int vectorSol[] = new int[2];
    int maximo = 0;
    int minimo = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != 0) {
        devolverMinimo(array);
        devolverMaximo(array);
      }
      vectorSol[0] = maximo;
      vectorSol[1] = minimo;

    }
    return vectorSol;
  }

  // Ejercicios 26-27 no salen. EJERCICIO 29 SALE CASI SEGURO
  public static void ejercicio28() {
    int[][] array = {
        { 12, 34, 56 },
        { 45, 67, 89, 23, 45 },
        { 67, 89 }
    };
    int sumaTotal = 0;
    int sumaFila1 = 0;
    int sumaFila2 = 0;
    int sumaFila3 = 0;
    int maximo = array[0][0]; // Inicializar con el primer elemento
    int pos_maximo = 0;
    for (int i = 0; i < array.length; i++) {
      sumaTotal += array[array.length][i];
      sumaFila1 += array[0][i];
      sumaFila2 += array[1][i];
      sumaFila3 += array[2][i];
      if (array[i][i] > maximo) {
        maximo = array[i][i];
        pos_maximo = i;
      }

    }
    int[][] vectorFilas = {
        { sumaFila1 },
        { sumaFila2 },
        { sumaFila3 }
    };
    int[][] vectorMax = {
        { maximo },
        { pos_maximo }
    };
    System.out.println("Suma total de todos los elementos=" + sumaTotal);
    System.out.println("**********************************************");
    System.out.println("Suma por fila");
    System.out.println("Fila 1=" + sumaFila1);
    System.out.println("Fila 2=" + sumaFila2);
    System.out.println("Fila 3=" + sumaFila3);
    System.out.println("**********************************************");
    System.out.println("Vector de la suma de las filas=" + vectorFilas);
    System.out.println("**********************************************");
    System.out.println("Valor maximo de la matriz(valor,posicion)=" + vectorMax);

  }

  // Ejercicio 29 version de clase recorriendo 2 veces, intentar hacer despues
  // recorriendo una sola vez
  public static void media_meses(double temp[][], String meses[]) {
    for (int i = 0; i < temp.length; i++) {
      double suma = 0;

      // Sum all temperatures for the current month
      for (int j = 0; j < temp[i].length; j++) {
        suma += temp[i][j];
      }

      // Calculate average for the month
      double media = suma / temp[i].length;

      // Display result with proper formatting
      System.out.printf("Mes %s: Temperatura media = %.1f°C (%d días)%n",
          meses[i], media, temp[i].length);
    }
  }

  public static void maxmin_meses(double temp[][], String meses[]) {
    double max;
    double min;
    int dia_max = 0;
    int dia_min = 0;

    for (int i = 0; i < temp.length; i++) {
      max = temp[i][0];
      min = temp[i][0];
      dia_max = 1;
      dia_min = 1;

      for (int j = 0; j < temp[i].length; j++) {
        if (temp[i][j] > max) {
          max = temp[i][j];
          dia_max = j + 1; // +1 because days start from 1
        }
        if (temp[i][j] < min) {
          min = temp[i][j];
          dia_min = j + 1; // +1 because days start from 1
        }
      }

      System.out.println("Mes " + meses[i] + ":");
      System.out.println("  Temperatura máxima: " + max + "°C (día " + dia_max + ")");
      System.out.println("  Temperatura mínima: " + min + "°C (día " + dia_min + ")");
      System.out.println();
    }
  }

  public static void maxmin_año(double temp[][], String meses[]) {
    double maxAnual = temp[0][0];
    double minAnual = temp[0][0];
    int mesMax = 0;
    int diaMax = 0;
    int mesMin = 0;
    int diaMin = 0;

    double sumaTotal = 0;
    int totalDias = 0;

    // Find overall max and min for the entire year
    for (int i = 0; i < temp.length; i++) {
      for (int j = 0; j < temp[i].length; j++) {
        // Track overall maximum
        if (temp[i][j] > maxAnual) {
          maxAnual = temp[i][j];
          mesMax = i;
          diaMax = j + 1; // +1 because days start from 1
        }

        // Track overall minimum
        if (temp[i][j] < minAnual) {
          minAnual = temp[i][j];
          mesMin = i;
          diaMin = j + 1; // +1 because days start from 1
        }

        // Calculate total for yearly average
        sumaTotal += temp[i][j];
        totalDias++;
      }
    }

    double mediaAnual = sumaTotal / totalDias;

    // Display yearly statistics
    System.out.println("=== ANÁLISIS ANUAL DE TEMPERATURAS ===");
    System.out.println("--------------------------------------");
    System.out.printf("Temperatura máxima del año: %.1f°C%n", maxAnual);
    System.out.printf("  Fecha: %s, día %d%n", meses[mesMax], diaMax);
    System.out.println();
    System.out.printf("Temperatura mínima del año: %.1f°C%n", minAnual);
    System.out.printf("  Fecha: %s, día %d%n", meses[mesMin], diaMin);
    System.out.println();
    System.out.printf("Temperatura media anual: %.1f°C%n", mediaAnual);
    System.out.printf("Rango térmico anual: %.1f°C%n", (maxAnual - minAnual));
    System.out.printf("Total de días registrados: %d días%n", totalDias);
  }

  public static double[][] generarMatrizAzar(
      int filas,
      int dias_mes[],
      double li,
      double ls) {
    double array[][] = new double[filas][];
    for (int i = 0; i < 12; i++) {
      array[i] = new double[dias_mes[i]];
      for (int j = 0; j < dias_mes[i]; j++) {
        array[i][j] = Math.random() * (ls - li) + li;
      }
    }
    return array;
  }

  public static void ejercicio29() {
    // Array with days per month (non-leap year)
    int dia_mes[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // Create jagged array for temperatures (each month has different number of
    // days)
    double temp[][] = new double[12][];
    for (int i = 0; i < 12; i++) {
      temp[i] = new double[dia_mes[i]];
    }

    // Array of month names
    String[] meses = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    // Generate random temperatures for each day of the year (realistic ranges)
    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < dia_mes[i]; j++) {
        // Different temperature ranges for different seasons
        double tempMin, tempMax;
        if (i >= 11 || i <= 1) { // Winter: Dec, Jan, Feb
          tempMin = 5.0;
          tempMax = 15.0;
        } else if (i >= 2 && i <= 4) { // Spring: Mar, Apr, May
          tempMin = 15.0;
          tempMax = 25.0;
        } else if (i >= 5 && i <= 7) { // Summer: Jun, Jul, Aug
          tempMin = 25.0;
          tempMax = 40.0;
        } else { // Autumn: Sep, Oct, Nov
          tempMin = 10.0;
          tempMax = 25.0;
        }
        temp[i][j] = Math.random() * (tempMax - tempMin) + tempMin;
      }
    }

    // Perform comprehensive temperature analysis
    System.out.println("=== EJERCICIO 29: ANÁLISIS COMPLETO DE TEMPERATURAS ANUALES ===");
    System.out.println("================================================================");

    // Monthly analysis
    System.out.println("\n1. ANÁLISIS POR MESES:");
    maxmin_meses(temp, meses);

    // Annual analysis
    System.out.println("\n2. ANÁLISIS ANUAL:");
    maxmin_año(temp, meses);

    // Monthly averages
    System.out.println("\n3. TEMPERATURAS MEDIAS MENSUALES:");
    media_meses(temp, meses);

    System.out.println("\n=== FIN DEL ANÁLISIS ===");
  }
}

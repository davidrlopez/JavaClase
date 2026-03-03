package Trimestre1.operations;

import java.util.Arrays;
import java.util.Scanner;

public class program2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("***********************");
            System.out.println("Menú de opciones:");
            System.out.println("1.- Calcular longitud de circunferencia");
            System.out.println("2.- Calcular superficie de circunferencia");
            System.out.println("3.- Calcular cuadrado");
            System.out.println("4.- Pares e impares");
            System.out.println("5.- Resolver ecuacion 2ºgrado");
            System.out.println("6.- Serie Fibonacci");
            System.out.println("7.- Factorial Iterativo");
            System.out.println("8.- Progresión geométrica");
            System.out.println("9.- MCM Y MCD");
            System.out.println("10.- Ordenar arrays");
            System.out.println("11.- Comprobacion primos");
            System.out.println("12.- Salir");
            System.out.print("Introduzca opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Error: debe introducir un número");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduzca radio: ");
                    if (sc.hasNextDouble()) {
                        double radio = sc.nextDouble();
                        System.out.println(
                            Metodos.longitud_circunferencia(radio)
                        );
                    }
                    break;
                case 2:
                    System.out.print("Introduzca radio: ");
                    if (sc.hasNextDouble()) {
                        double radio = sc.nextDouble();
                        System.out.println(
                            Metodos.superficie_circunferencia(radio)
                        );
                    }
                    break;
                case 3:
                    System.out.print("Introduzca número: ");
                    if (sc.hasNextDouble()) {
                        double n = sc.nextDouble();
                        System.out.println(n * n);
                    }
                    break;
                case 4:
                    System.out.print(
                        "Introduzca cuantos numeros aleatorios quiere generar para definir pares e impares: "
                    );
                    if (sc.hasNextInt()) {
                        int RandomN = sc.nextInt();
                        for (int i = 0; i <= RandomN; i++) {
                            int numGen = misMetodos.numRandomAscii(RandomN);
                            System.out.println(
                                numGen + "=>" + misMetodos.esPar(numGen)
                            );
                        }
                    }
                    break;
                case 5:
                    System.out.print("Introduzca valores para a, b y c: ");
                    if (sc.hasNextInt()) {
                        int a = sc.nextInt();
                        int b = sc.nextInt();
                        int c = sc.nextInt();
                        double[] soluciones = misMetodos.ec2grado_resolver(
                            a,
                            b,
                            c
                        );

                        if (soluciones.length == 0) {
                            System.out.println(
                                "La ecuación no tiene soluciones reales."
                            );
                        } else {
                            System.out.println(
                                "Las soluciones son: " +
                                    Arrays.toString(soluciones)
                            );
                        }
                        break;
                    }
                case 6:
                    System.out.print(
                        "Introduzca el limite de la serie Fibonacci: "
                    );
                    if (sc.hasNextInt()) {
                        int nFibo = sc.nextInt();
                        for (int i = 1; i <= nFibo; i++) {
                            System.out.print(misMetodos.fibonnaci(i) + " ");
                        }
                    }
                    break;
                case 7:
                    System.out.print(
                        "Introduzca el numero a calcular el factorial: "
                    );
                    if (sc.hasNextInt()) {
                        int nFact = sc.nextInt();
                        for (int i = 1; i <= nFact; i++) {
                            System.out.print(misMetodos.numFactorial(i) + " ");
                        }
                    }
                    break;
                case 8:
                    System.out.print("Introduzca el termino base y la razon: ");
                    if (sc.hasNextInt()) {
                        int nTermino = sc.nextInt();
                        int nRazon = sc.nextInt();
                        System.out.println(
                            "Introduzca la cantidad de terminos"
                        );

                        int nTerminos = sc.nextInt();
                        for (int i = 1; i <= nTerminos; i++) {
                            System.out.print(
                                misMetodos.progGeo(nTermino, nRazon, i) + " "
                            );
                        }
                    }
                    break;
                case 9:
                    System.out.print("Introduzca a y b: ");
                    if (sc.hasNextInt()) {
                        int nA = sc.nextInt();
                        int nB = sc.nextInt();
                        System.out.println("MCM:" + misMetodos.mcm(nA, nB));
                        System.out.println("MCD:" + misMetodos.mcd(nA, nB));
                    }
                case 10:
                    System.out.print("Introduzca cuantos numeros ordenar: ");
                    if (sc.hasNextInt()) {
                        int cantidad = sc.nextInt();
                        int[] numeros = new int[cantidad];

                        for (int i = 0; i < cantidad; i++) {
                            System.out.print(
                                "Introduzca el numero " + (i + 1) + ": "
                            );
                            numeros[i] = sc.nextInt();
                        }

                        System.out.println(
                            "Array ordenado: " +
                                Arrays.toString(misMetodos.ordenArray(numeros))
                        );
                    }
                    break;
                case 11:
                    System.out.print("Introduzca un numero: ");
                    if (sc.hasNextInt()) {
                        int esPrimo = sc.nextInt();
                        System.out.println(misMetodos.esPrimo(esPrimo));
                    }
                case 12:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 12);

        sc.close();
    }
}

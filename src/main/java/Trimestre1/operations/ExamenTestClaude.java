package Trimestre1.operations;

import java.util.Scanner;

public class ExamenTestClaude {

    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduzca el numero de dias");
        int nDias = input.nextInt();
        ExamenTestClaude.temperaturas(nDias);
        ExamenTestClaude.contarDigitos();
        System.out.println("Indica el numero de la serie fibonacci");
        int nFibo = input.nextInt();
        int sumaFibo = ExamenTestClaude.fibonacci(nFibo);
        System.out.println("Suma: " + sumaFibo);
        System.out.println(
            "Introduce el numero limite para la serie de suma factorial"
        );
        int numF = input.nextInt();
        System.out.println(ExamenTestClaude.factorialSuma(numF));
        System.out.println(ExamenTestClaude.ecuacion2grado(3, 7, -10));
        System.out.println("Introduzca los numeros para sacar el mcm y mcd");
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println("MCD:" + ExamenTestClaude.mcd(a, b));
        System.out.println("MCM:" + ExamenTestClaude.mcm(a, b));
        System.out.println(
            "Introduce dos numeros para comprobar si son amigos"
        );
        int aFriends = input.nextInt();
        int bFriends = input.nextInt();
        System.out.println(
            "Son amigos?:" + ExamenTestClaude.numFriends(aFriends, bFriends)
        );
        input.close();
    }

    /*EJERCICIO 1: Método temperaturas()
    Crear un método llamado temperaturas que recibirá como parámetro de entrada un número entero n. Dicho número será el número de días para los cuales se generarán temperaturas aleatorias en el rango [15..35] como números enteros (grados Celsius).
    El método debe:

    Mostrar la temperatura de cada día
    Calcular y mostrar la temperatura media
    Indicar cuántos días la temperatura fue superior a 25 grados
    Devolver la temperatura máxima registrada*/
    public static double randomNumber(int rangoMin, int rangoMax) {
        double rango = rangoMax - rangoMin;
        double numGen = (Math.random() * rango) + rangoMin;
        return numGen;
    }

    public static int temperaturas(int nDias) {
        int mediaTemp = 0;
        int sumaTemp = 0;
        int cont25 = 0;
        int tempActual = 0;
        int tempMax = 0;
        for (int i = 1; i <= nDias; i++) {
            tempActual = (int) ExamenTestClaude.randomNumber(15, 36);
            if (tempActual > 25) {
                cont25++;
            }
            if (tempActual > tempMax) {
                tempMax = tempActual;
            }
            sumaTemp = sumaTemp + tempActual;
            mediaTemp = sumaTemp / nDias;
            System.out.println("Dia " + i + ":Temperatura:" + tempActual);
            System.out.println("*****************************");
        }
        System.out.println(
            "Media temperatura:" +
                mediaTemp +
                "|Temperatura máxima:" +
                tempMax +
                "|Dias con mas de 25 grados:" +
                cont25
        );
        return mediaTemp;
    }

    /*EJERCICIO 2: Método contarDigitos()
    Crear un método llamado contarDigitos que no recibirá ningún parámetro de entrada. El método leerá números enteros positivos por teclado hasta que se introduzca el número 0 (el 0 no se procesa).
    El método debe mostrar:

    Cuántos números de 1 dígito se introdujeron
    Cuántos números de 2 dígitos se introdujeron
    Cuántos números de 3 o más dígitos se introdujeron
    El número más grande introducido

    El método no devuelve nada. */
    public static void contarDigitos() {
        int UnDig = 0;
        int DosDig = 0;
        int MasDig = 0;
        int MaxDig = 0;
        Scanner input;
        input = new Scanner(System.in);
        int Numeros = 0;
        do {
            System.out.println(
                "Introduce un numero positivo distinto de 0 para contar sus dígitos. 0 para salir"
            );
            Numeros = input.nextInt();
            if (Numeros == 0) {
                break;
            }
            if (Numeros < 0) {
                System.out.println("Introduce un numero positivo");
                Numeros = input.nextInt();
            }
            if (Numeros > 0 && Numeros < 10) {
                UnDig++;
            }
            if (Numeros >= 10 && Numeros < 100) {
                DosDig++;
            }
            if (Numeros >= 100) {
                MasDig++;
            } else {
                System.out.println("Introduce un numero");
            }
            if (Numeros > MaxDig) {
                MaxDig = Numeros;
            }
            System.out.println("Cantidad de numeros 1 dígito:" + UnDig);
            System.out.println("Cantidad de numeros de 2 dígitos:" + DosDig);
            System.out.println(
                "|Cantidad de numeros de  al menos 3 dígitos:" + MasDig
            );
            System.out.println("|Numero mas grande:" + MaxDig);
        } while (Numeros != 0);
    }

    /*EJERCICIO 8: Método secuenciaFibonacci()
    Crear un método llamado secuenciaFibonacci que recibirá un parámetro entero n. El método debe:

    Generar los primeros n números de la secuencia de Fibonacci
    Mostrar cada número de la secuencia
    Calcular la suma de todos los números generados
    Devolver dicha suma

    Fibonacci: 1, 1, 2, 3, 5, 8, 13, 21, ... */
    public static int fibonacci(int nFibo) {
        int a = 0,
            b = 1;
        int sumaFibo = 0; // ← Nueva variable para acumular

        System.out.print("Serie Fibonacci: "); // ← Nuevo: mostrar

        for (int i = 1; i <= nFibo; i++) {
            // ← Empieza en 1, no en 2
            int actual;

            if (i == 1 || i == 2) {
                actual = 1;
                System.out.print("1 "); // ← Nuevo: mostrar los 1's
            } else {
                actual = a + b;
                System.out.print(actual + " "); // ← Nuevo: mostrar
                a = b;
                b = actual;
            }

            sumaFibo += actual; // ← Nuevo: sumar TODOS
        }

        System.out.println("\nSuma: " + sumaFibo);
        return sumaFibo; // ← Devuelve SUMA, no último número
    }

    /*EJERCICIO 10: Método factorialSuma()
    Crear un método llamado factorialSuma que recibirá un parámetro entero n. El método debe:

    Calcular el factorial de cada número desde 1 hasta n
    Mostrar cada factorial calculado
    Sumar todos los factoriales
    Devolver la suma total

    Ejemplo: Si n=4 → 1! + 2! + 3! + 4! = 1 + 2 + 6 + 24 = 33 */
    public static int factorialSuma(int numF) {
        int sumaTotal = 0;

        for (int i = 1; i <= numF; i++) {
            int factorial = 1;
            for (int j = 2; j <= i; j++) {
                factorial *= j;
            }
            System.out.println(i + "! = " + factorial);
            sumaTotal += factorial;
        }

        return sumaTotal;
    }

    public static String ecuacion2grado(int a, int b, int c) {
        double discriminante = Math.pow(b, 2) - 4 * a * c;

        if (discriminante < 0) {
            return "No tiene soluciones reales";
        }

        double sol1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double sol2 = (-b - Math.sqrt(discriminante)) / (2 * a);

        return "Sol1: " + sol1 + ", Sol2: " + sol2;
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
        int mcm = (a * b) / ExamenTestClaude.mcd(a, b);
        return mcm;
    }

    public static boolean numFriends(int a, int b) {
        int sumaA = 0;
        int sumaB = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                sumaA = sumaA + i;
            }
        }
        for (int i = 1; i < b; i++) {
            if (b % i == 0) {
                sumaB = sumaB + i;
            }
        }
        return (sumaB == a && sumaA == b);
    }

    public static int sumImpares(int a) {
        return a * a;
    }

    public static int sumPares(int a) {
        return a * (a + 1);
    }

    public static boolean esPrimo(int primo) {
        if (primo <= 1) {
            return false;
        }
        if (primo == 2) {
            return true;
        }
        if (primo % 2 == 0) {
            return false;
        }
        for (int i = 3; i < primo; i += 2) {
            if (primo % i == 0) {
                return false;
            }
        }
        return true;
    }
}

import java.util.Scanner;

public class Examen1Juanpedro {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Media total:" + Examen1Juanpedro.ohm(n));
        System.out.println(Examen1Juanpedro.numeroMenor(4));
        Examen1Juanpedro.Divisores();
        Examen1Juanpedro.estadisticas();
    }

    public static double randomNumber(double rango1, double rango2) {
        double range = rango2 - rango1;
        double numberRGen = (Math.random() * range) + rango1;
        return numberRGen;
    }

    public static double ohm(int n) {
        //Crear un método llamado ley_de_ohm que recibirá unparámetro de
        //entrada entero n. Dicho número será el número de iteraciones de un
        //bucle que permitirá hacer cálculos sobre el voltaje conforme a la ley de
        //Ohm: V = R • l. La intensidad I se generará al azar en el rango [10..100]
        //como número entero. La resistencia R se generará al azar en el rango
        //[20.100] como número entero. Se deben mostrar los resultados según el
        //siguiente formato. Además nos debe indicar cuál es el valor medio del voltaje
        if (n <= 0) {
            return 0;
        }
        int sumaV = 0;
        int v = 0;
        int r = 0;
        int l = 0;
        for (int i = 1; i <= n; i++) {
            r = (int) Examen1Juanpedro.randomNumber(20, 101);
            l = (int) Examen1Juanpedro.randomNumber(10, 101);
            v = r * l;
            sumaV = sumaV + v;
            System.out.println(
                "V" + i + ":" + v + " R" + i + ":" + r + " L" + i + ":" + l
            );
        }
        double media = (double) sumaV / n;
        return media;
    }

    public static int numeroMenor(int nInput) {
        //    Crear un método llamado numero menor que aceptará como único
        //parámetro de entrada un número entero. Dicho número indicará el
        //número de datos enteros que habrá que leer por teclado a continuación.
        //Habrá que determinar cuál es el mínimo de entre los anteriores números
        //leídos. A continuación se generará al azar otro número entero en el rango
        //[1.100). EI método devolverá el menor de los 2 números (del mínimo
        //calculado de entre los leídos por teclado y del generado al azar).
        System.out.println("*****************************");
        Scanner input;
        input = new Scanner(System.in);
        int numeroActual = 101;
        for (int i = 1; i <= nInput; i++) {
            System.out.println("Introduce el numero " + i);
            int numeroLeido = input.nextInt();
            if (numeroLeido < numeroActual) {
                numeroActual = numeroLeido;
            }
        }
        int numeroRandom = (int) Examen1Juanpedro.randomNumber(1, 101);
        int minTotal = Math.min(numeroActual, numeroRandom);
        System.out.println(
            "Numero aleatorio generado para divisores:" + numeroRandom
        );
        System.out.println("El numero mas pequeño es:" + minTotal);
        return minTotal;
    }

    public static int Divisores() {
        System.out.println("*****************************");
        int numgen = (int) Examen1Juanpedro.randomNumber(1, 101);
        System.out.println(
            "numero aleatorio generado para divisores:" + numgen
        );
        for (int i = 1; i <= numgen; i++) {
            if (numgen % i == 0) {
                System.out.println(i + " Es divisor de " + numgen);
            }
        }
        return numgen;
        //Crear un método llamado Divisores que contenga el programa que realice
        //la siguiente función:
        //Debe generar al azar un número dentro del rango [1..100]. Debe mostrar
        //cuáles son los divisores de dicho número.
        //Por ejemplo, si se ha generado al azar el número 20, sus divisores serán 1,2, 4, 5, 10, 20.
    }

    public static void estadisticas() {
        //Crear un método llamado estadísticas que no aceptará ningún parámetro
        //de entrada. EI método leerá datos reales por teclado hasta que cl valor
        //introducido sea-:L-El método imprimirá la media de los valores positivos
        //introducidos, la media de los valores negativos introducidos y l,} cantidad
        //de 0 introducidos. El metodo mo devolverá nada
        System.out.println("*****************************");
        Scanner input;
        input = new Scanner(System.in);
        Double valores = 0.0;
        int cantValoresPos = 0;
        int cantValoresNeg = 0;
        double sumaPos = 0;
        double sumaNeg = 0;
        int suma0s = 0;
        do {
            System.out.println(
                "Introduzca el siguiente numero, al añadir -1 se saldra del programa añadendo este valor tambien"
            );
            valores = input.nextDouble();
            if (valores == -1) {
                break;
            }
            if (valores > 0) {
                sumaPos = sumaPos + valores;
                cantValoresPos++;
            }
            if (valores < 0) {
                sumaNeg = sumaNeg + valores;
                cantValoresNeg++;
            }
            if (valores == 0) {
                suma0s++;
            }
        } while (valores != -1);
        if (cantValoresPos > 0) {
            Double mediaPos = sumaPos / cantValoresPos;
            System.out.println("media positiva:" + mediaPos);
        }
        if (cantValoresNeg > 0) {
            Double mediaNeg = sumaNeg / cantValoresNeg;
            System.out.println("media negativa:" + mediaNeg);
        }
        System.out.println("numero de 0s:" + suma0s);

        input.close();
    }
}

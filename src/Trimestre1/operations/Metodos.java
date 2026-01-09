package operations;

import java.util.Scanner;

public class Metodos {

    public static void main(String[] args) {
        hello(5, "Hola");
        hello(10, "Adios");
        random(1, 1000);
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduzca el numero para calcular el factorial");
        int numF = input.nextInt();
        System.out.println("Introduzca el numero a mostrar su tabla");
        int numM = input.nextInt();
        System.out.println(numM);
        int resultadoF = Metodos.facto(numF);
        System.out.println("Factorial de: " + numF + "=" + resultadoF);
        Metodos.factoriales();
        Metodos.tablaMulti(numM);
        Metodos.tablasMulti(numM);
        Metodos.num_perf(28);
        Metodos.num_primos(1009);
        Metodos.num_primos2(0, 100);
        System.out.println("Primer primo a partir de 30: " + num_primosF30());
        for (int i = 0; i < 10; i++) {
            double r = Metodos.random(1, 100);
            double longi = Metodos.longitud_circunferencia(r);
            double supe = Metodos.superficie_circunferencia(r);

            System.out.println("Longitud: " + longi);
            System.out.println("Area: " + supe);
            System.out.println("_____________________");
        }
        input.close();
    }

    public static void hello(int n, String texto) {
        System.out.println("_____________________");
        for (int i = 0; i < n; i++) {
            System.out.println(texto);
        }
    }

    public static int random(int a, int b) {
        double aleatorio = Math.random() * (b - a + 1) + a;
        int azar = (int) aleatorio;
        return azar;
    }

    public static double longitud_circunferencia(double r) {
        double longi = 2 * Math.PI * r;
        return longi;
    }

    public static double superficie_circunferencia(double r) {
        double supe = Math.PI * r * r;
        return supe;
    }

    public static int facto(int numF) {
        int resultadoF = 1;
        for (int i = 1; i <= numF; i++) {
            resultadoF *= i;
        }
        return resultadoF;
    }

    public static void factoriales() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Factorial(" + i + ")= " + Metodos.facto(i));
            System.out.println("_______________");
        }
    }

    public static void tablaMulti(int numM) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(numM + " * " + i + "=" + (numM * i));
        }
    }

    public static void tablasMulti(int numM) {
        for (int i = 1; i <= numM; i++) {
            tablaMulti(i);
        }
    }

    public static void divisores(int numM) {
        if (numM <= 0) {
            System.out.println("Error en numero");
        } else {
            System.out.println("Divisores de " + numM + "=");
            for (int i = 1; i <= numM; i++) {
                if (numM % i == 0) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void datos_divisores(int numM) {
        int contar = 0,
            sumar = 0;
        if (numM <= 0) {
            System.out.println("Error en numero");
        } else {
            System.out.println("Divisores de " + numM + "=");
            for (int i = 1; i <= numM; i++) {
                if (numM % i == 0) {
                    contar++;
                    sumar += i;
                }
            }
            System.out.println("El numero de divisores es:" + contar);
            System.out.println("La suma de los divisores es:" + sumar);
        }
    }

    //16
    public static boolean num_perf(int n) {
        if (n <= 1) {
            return false;
        }
        int sumar = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sumar += i;
                if (i * i != n) {
                    sumar += n / i;
                }
            }
        }
        return sumar == n;
    }

    //17 SALE EN EXAMEN
    public static boolean num_friends(int n1, int n2) {
        if (n1 <= 1 || n2 <= 1) {
            return false;
        }

        int sumarA = 0;
        int sumarB = 0;

        for (int i = 1; i <= n1 / 2; i++) {
            if (n1 % i == 0) {
                sumarA += i;
            }
        }

        for (int i = 1; i <= n2 / 2; i++) {
            if (n2 % i == 0) {
                sumarB += i;
            }
        }

        if (sumarA == n2 && sumarB == n1) {
            System.out.println("Numeros amigos");
            return true;
        } else {
            System.out.println("Numeros no amigos");
            return false;
        }
    }

    public static boolean num_primos(int n1) {
        if (n1 <= 1) {
            return false;
        }
        for (int i = 2; i <= n1 / 2; i++) {
            if (n1 % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean num_primos2(int n1, int n2) {
        System.out.println("Primos entre " + n1 + " y " + n2 + ":");
        boolean encontrado = false;

        for (int i = n1; i <= n2; i++) {
            if (Metodos.num_primos(i)) {
                System.out.println(i);
                encontrado = true;
            }
        }

        return encontrado;
    }

    //21
    public static int num_primosF30() {
        int n = 30;
        do {
            n++;
        } while (!Metodos.num_primos(n));
        return n;
    }
}

/*public static int num_primosF30(int n1) {
    int n = 30;
    do {
        n++;
    } while (num_primos(n)==false);
    System.out.println(n);
    return n;
}
}*/ //version profesor

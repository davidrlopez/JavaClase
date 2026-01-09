package operations;

import java.util.Arrays;
import java.util.Scanner;

public class misMetodos {

    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        int inputFriends1 = input.nextInt();
        System.out.println(suma_imparesN(5));
        misMetodos.mostrarMensaje(5, "Metodo ejecutandose");
        misMetodos.numMax(1.0, 5.0);
        misMetodos.betweenNandM(1, 5);
        misMetodos.esMayus('A');
        System.out.println(esMayus('#'));
        System.out.println(esNum('å'));
        int RandomN = input.nextInt();
        System.out.println(
            misMetodos.esLetra((char) misMetodos.numRandomAscii(RandomN))
        );
        System.out.println(
            misMetodos.esNum((char) misMetodos.numRandomAscii(RandomN))
        );
        System.out.println("Creando 5 numeros aleatorios");
        for (int i = 0; i < 5; i++) {
            int randomAscii = misMetodos.numRandomAscii(RandomN);
            char randomChar = (char) randomAscii;
            System.out.println(
                "Caracter: " + randomChar + " (ASCII: " + randomAscii + ")"
            );
            System.out.println("Es letra? " + misMetodos.esLetra(randomChar));
            System.out.println("Es numero? " + misMetodos.esNum(randomChar));
            System.out.println("--------------------");
        }

        System.out.println(misMetodos.toMinuscula('Ñ'));
        System.out.println(misMetodos.minInStrings("Ies José Planes"));
        System.out.println(misMetodos.distancia(2, 5, 1, 5));
        System.out.println(
            "Introduce dos numeros double para comprobar si son amigos"
        );

        int inputFriends2 = input.nextInt();
        System.out.println(
            "¿Son amigos? " +
                misMetodos.numFriends(inputFriends1, inputFriends2)
        );
        input.close();
    }

    public static int suma_imparesN(int n) {
        int suma = 0;
        for (int i = 1; i <= 2 * n; i += 2) {
            suma += i;
        }
        return suma;
    }

    public static int suma_imparesNchatgpt(int n) {
        return n * n;
    }

    public static int suma_paresNchatgpt(int n) {
        return n * (n + 1);
    }

    public static void mostrarMensaje(int n, String texto) {
        for (int i = 0; i < n; i++) {
            System.out.println(texto);
        }
    }

    /*public static int numMax(int n1, int n2){
        if(n1>n2){
            return n1;
        }
        else
        return n2;
        }*/
    // version mas eficiente con ternario
    public static int numMax(int n1, int n2) {
        System.out.println("estoy en maximos de enteros");
        return (n1 > n2) ? n1 : n2;
    }

    public static double numMax(Double n1, Double n2) {
        System.out.println("estoy en maximos de dobles");
        return (n1 > n2) ? n1 : n2;
    }

    public static void betweenNandM(int n1, int n2) {
        if (n1 < n2) {
            for (int i = (n1 + 1); i <= (n2 - 1); i++) {
                System.out.println(i);
            }
        } else {
            for (int i = (n2 + 1); i <= (n1 - 1); i++) {
                System.out.println(i);
            }
        }
    }

    //7 vale para ambos enteros y dobles segun el input
    public static double doble(double n) {
        return 2 * n;
    }

    /*public static double longitudAreaCirculo(char x, double r) {
        if (x == 'l') {
            double longitud = 2 * Math.PI * r;
            return longitud;
        } else if (x == 'a') {
            double area = Math.PI * r * r;
            return area;
        } else {
            System.out.println(
                "Error opcion no valida, usa l para longitud o a para area"
            );
        }
    }*/

    /*public static double longitudAreaCirculo(char opcion, double r) {
        switch (opcion) {
            case 'a':
                return Math.PI * r * r;
            case 'l':
                return 2 * Math.PI * r;
            default:
                System.out.println("Error en la opcion");
                return -1;
        }
    }
    }*/

    public static boolean esPar(int n) {
        return (n % 2 == 0); //? true : false; redundante ya que solo hay una condicion
    }

    public static boolean esMayus(char x) {
        int ascii = (int) x;
        if ((ascii >= 65 && ascii <= 90) || ascii == 209) {
            System.out.println("es mayus");
            return true;
        } else {
            System.out.println("no es mayus");
            return false;
        }
    }

    //simplificado sin print
    /*public static boolean esMayus(char x) {
        int ascii = (int) x;
        return ((ascii >= 65 && ascii <= 90) || ascii == 209);
        }*/
    public static boolean esLetra(char x) {
        int ascii = (int) x;
        return (
            (ascii >= 65 && ascii <= 90) ||
            ascii == 209 ||
            (ascii >= 97 && ascii <= 122) ||
            ascii == 241
        );
    }

    //14
    public static boolean esNum(char x) {
        int ascii = (int) x;
        return ((ascii >= 48 && ascii <= 57));
    }

    public static int numRandomAscii(int RandomN) {
        double asciiRandom = Math.random() * RandomN;
        return (int) asciiRandom;
    }

    public static char toMinuscula(char x) {
        char respuesta = x;
        if (esMayus(x)) {
            //si es mayus es implicito q es una letra por tanto innecesario llamar a esLetra
            respuesta = (char) ((int) x + 32);
        }
        return respuesta;
    }

    public static String minInStrings(String texto) {
        char caracter = 0;
        char letra = 0;
        String respuesta = "";
        for (int i = 0; i <= texto.length() - 1; i++) {
            caracter = texto.charAt(i);
            letra = misMetodos.toMinuscula(caracter);
            respuesta = respuesta + letra;
            System.out.println(letra);
        }
        return respuesta;
    }

    public static Double distancia(double x1, double x2, double y1, double y2) {
        double y = y1 - y2;
        double x = x1 - x2;
        double distancia = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
        return distancia;
    }

    public static double Pow(double number) {
        number = Math.pow(number, 2);
        return number;
    }

    public static boolean numFriends(int inputFriends1, int inputFriends2) {
        int respuesta1 = 0;
        int respuesta2 = 0;

        for (int i = 1; i < inputFriends1; i++) {
            if (inputFriends1 % i == 0) {
                respuesta1 += i;
            }
        }

        for (int i = 1; i < inputFriends2; i++) {
            if (inputFriends2 % i == 0) {
                respuesta2 += i;
            }
        }
        return (respuesta1 == inputFriends2 && respuesta2 == inputFriends1);
    }

    public static boolean numFriends2(int num1, int num2) {
        int sumaDivisores1 = sumaDivisoresPropios(num1);
        int sumaDivisores2 = sumaDivisoresPropios(num2);

        return (sumaDivisores1 == num2 && sumaDivisores2 == num1);
    }

    public static int sumaDivisoresPropios(int n) {
        if (n <= 1) return 0;

        int suma = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                suma += i;

                if (i * i != n) {
                    suma += n / i;
                }
            }
        }
        return suma;
    }

    //  array no permitido en examen
    public static double[] ec2grado_resolver(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant >= 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[] { x1, x2 };
        } else {
            return new double[0];
        }
    }

    public static int fibonnaci(int nFibo) {
        if (nFibo == 0) {
            return 0;
        }
        if (nFibo == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= nFibo; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static long numFactorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static double progGeo(int termino, int razon, int n) {
        if (razon == 1) {
            return n * termino;
        }
        return termino * Math.pow(razon, n - 1);
    }

    //calculadno primero el mcm
    public static int mcm(int a, int b) {
        int resultado = 1;
        int i = 2;
        int x = a,
            y = b;

        while (x > 1 || y > 1) {
            int countX = 0,
                countY = 0;

            while (x % i == 0) {
                x /= i;
                countX++;
            }

            while (y % i == 0) {
                y /= i;
                countY++;
            }

            int maxCount = Math.max(countX, countY);
            for (int j = 0; j < maxCount; j++) {
                resultado *= i;
            }

            i++;
        }

        return resultado;
    }

    public static int mcd(int a, int b) {
        int resultado = (a * b) / (misMetodos.mcm(a, b));
        return resultado;
    }

    public static int[] ordenArray(int[] numeros) {
        Arrays.sort(numeros);
        return numeros;
    }

    public static boolean esPrimo(int numPrim) {
        if (numPrim <= 1) {
            return false;
        }
        for (int i = 2; i * i <= numPrim; i++) {
            if (numPrim % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean esPrimoMuyOptimizado(int numPrim) {
        // Casos base: 0, 1 y negativos no son primos
        if (numPrim <= 1) {
            return false;
        }

        // El 2 es el único primo par
        if (numPrim == 2) {
            return true;
        }

        // Todos los demás números pares no son primos
        if (numPrim % 2 == 0) {
            return false;
        }

        // Si llegamos aquí, numPrim es impar y > 2.
        // Solo necesitamos comprobar divisores impares (i = 3, 5, 7...)
        // Empezamos en 3 y sumamos 2 en cada iteración (i += 2)
        for (int i = 3; i * i <= numPrim; i += 2) {
            if (numPrim % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static double deposito_bancario(
        double capital,
        double interes,
        double años
    ) {
        double valor = 0;
        for (int i = 0; i <= años; i++) {
            capital = ((valor * (interes * Math.pow(1 + interes, años))) /
                    Math.pow(1 + interes, años) -
                1);
        }
        return capital;
    }
}

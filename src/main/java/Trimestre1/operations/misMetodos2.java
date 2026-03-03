package Trimestre1.operations;

import java.util.Scanner;

public class misMetodos2 {

    public static void main(String[] args) {
        System.out.println(suma_imparesN(5));
        misMetodos2.mostrarMensaje(5, "Metodo ejecutandose");
        misMetodos2.numMax(1.0, 5.0);
        misMetodos2.betweenNandM(1, 5);
        misMetodos2.esMayus('A');
        System.out.println(esMayus('#'));
        System.out.println(esNum('å'));
        System.out.println(
            misMetodos2.esLetra((char) misMetodos2.numRandomAscii())
        );
        System.out.println(
            misMetodos2.esNum((char) misMetodos2.numRandomAscii())
        );
        System.out.println("Creando 5 numeros aleatorios");
        for (int i = 0; i < 5; i++) {
            int randomAscii = misMetodos2.numRandomAscii();
            char randomChar = (char) randomAscii;
            System.out.println(
                "Caracter: " + randomChar + " (ASCII: " + randomAscii + ")"
            );
            System.out.println("Es letra? " + misMetodos2.esLetra(randomChar));
            System.out.println("Es numero? " + misMetodos2.esNum(randomChar));
            System.out.println("--------------------");
        }

        System.out.println(misMetodos2.toMinuscula('Ñ'));
        System.out.println(misMetodos2.minInStrings("Ies José Planes"));
        System.out.println(misMetodos2.distancia(2, 5, 1, 5));
        System.out.println(
            "Introduce dos numeros double para comprobar si son amigos"
        );
        Scanner input;
        input = new Scanner(System.in);
        int inputFriends1 = input.nextInt();
        int inputFriends2 = input.nextInt();
        System.out.println(
            "¿Son amigos? " +
                misMetodos2.numFriends2(inputFriends1, inputFriends2)
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

    public static int numRandomAscii() {
        double asciiRandom = Math.random() * 255;
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
            letra = misMetodos2.toMinuscula(caracter);
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

    // Método principal que usa entrada del usuario
    public static boolean numFriends2(int inputFriends1, int inputFriends2) {
        int sumaDivisores1 = sumaDivisoresPropios(inputFriends1); // ← Llama al método auxiliar
        int sumaDivisores2 = sumaDivisoresPropios(inputFriends2); // ← Llama al método auxiliar

        return (
            sumaDivisores1 == inputFriends2 && sumaDivisores2 == inputFriends1
        );
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

    public static boolean esPrimo(int numPrim) {
        if (numPrim < 1) {
            return false;
        }
        for (int i = 2; i * i < numPrim; i++) {
            if (numPrim % i == 0) {
                return false;
            }
        }
        return true;
    }
}

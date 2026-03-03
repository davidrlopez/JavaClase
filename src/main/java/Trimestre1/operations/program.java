package Trimestre1.operations;

import java.util.Scanner;

public class program {

    public static void main(String[] args) {
        Scanner teclado;
        teclado = new Scanner(System.in);
        int opcion;
        double inputNumber;
        do {
            System.out.println("***********************");
            System.out.println("Menú de opciones: ");
            System.out.println("1.- Calcular longitud de circunferencia");
            System.out.println("2.- Calcular superficie de circunferencia ");
            System.out.println("3.- Calcular cuadrado");
            System.out.println("4.- Salir");
            System.out.println("Introduzca opción: ");
            opcion = teclado.nextInt();
            if (opcion != 4) {
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca radio: ");
                        inputNumber = teclado.nextDouble();
                        System.out.println(
                            Metodos.longitud_circunferencia(inputNumber)
                        );
                        break;
                    case 2:
                        System.out.println("Introduzca radio: ");
                        inputNumber = teclado.nextDouble();
                        System.out.println(
                            Metodos.superficie_circunferencia(inputNumber)
                        );
                        break;
                    case 3:
                        System.out.println("Introduzca numero: ");
                        inputNumber = teclado.nextDouble();
                        System.out.println(misMetodos.Pow(inputNumber));
                        break;
                    default:
                        System.out.println("Pulsada otra opcion");
                }
            }
        } while (opcion != 4);
        teclado.close();
    }
}

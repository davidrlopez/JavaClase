import java.util.Scanner;

public class Operations2 {

    /*  public static void main(String[] args) {
        int num = 0;
        int n = 0;
        double pot = 0;
        double suma = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce numero");
        num = input.nextInt();
        while (n <= 10) {
            pot = Math.pow(num, n++);
            suma += pot;
        }
        System.out.println(suma);
        input.close();
    }
}
*/

    /*public static void main(String[] args) {
        int num = 0;
        int n;
        int contador = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce la cantidad de numeros a introducir");
        n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Introduce numero");
            num = input.nextInt();
            if (num == 0) {
                contador++;
            }
        }
        System.out.println("Numero total de 0s: " + contador);
        input.close();
    }
    }*/
    /*public static void main(String[] args) {
        int num = 0;
        int n;
        double media = 0;
        int numTot = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce la cantidad de numeros a introducir");
        n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Introduce numero");
            num = input.nextInt();
            numTot += num;
            media = numTot / n;
        }
        System.out.println("Media: " + media);
        input.close();
    }
    }*/
    //mi version
    /*public static void main(String[] args) {
        int a = 0;
        int b = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce a");
        a = input.nextInt();
        System.out.println("Introduce b");
        b = input.nextInt();
        if (a > b) {
            for (int i = 0; i <= a; i++) {
                a--;
                System.out.println(a);
            }
        } else {
            for (int i = 0; i <= b; i++) {
                b--;
                System.out.println(b);
            }
            input.close();
        }
    }
    }*/
    //profesor1
    /*  public static void main(String[] args) {
        int a = 0;
        int b = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce a");
        a = input.nextInt();
        System.out.println("Introduce b");
        b = input.nextInt();
        if (a > b) {
            for (int i = a; i >= b; i--) {
                System.out.println(i);
            }
        } else {
            for (int i = b; i >= a; i--) {
                System.out.println(i);
            }
            input.close();
        }
    }
}
*/
    //profesor2
    /*  public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int mayor = 0;
        int menor = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce a");
        a = input.nextInt();
        System.out.println("Introduce b");
        b = input.nextInt();
        if (a > b) {
            mayor = a;
            menor = b;
        } else {
            mayor = b;
            menor = a;
        }
        for (int i = mayor; i >= menor; i--) {
            System.out.println(i);
        }
        input.close();
    }
    } */

    /*public static void main(String[] args) {
        int a = 0;
        int b = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce a");
        a = input.nextInt();
        System.out.println("Introduce b");
        b = input.nextInt();
        for (int i = a; i <= b; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println(i);
                input.close();
            }
        }
    }
    }*/

    /*public static void main(String[] args) {
        double a;
        a = 2;
        String respuesta = (a % 2 == 0) ? "Par" : "Impar";
        {
            System.out.println(respuesta);
        }
    }
    }*/

    /*public static void main(String[] args) {
        double n;
        Scanner input;
        input = new Scanner(System.in);
        do{
        System.out.println("Introduce dato");
        n = input.nextDouble();
        if(n>=0){
            System.out.println("Cuadrado de "+n+"="+n*n);
        }
        else{
            System.out.println("Dato erroneo");
        }
        while (n>=0)
    }
    }
    }*/

    //bucles aninados
    /*public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("j=" + j);
            }
        }
    }
    }*/
    //ejercicio 1 ejercicios tema
    /*public static void main(String[] args) {
        int suma2 = 0;
        int suma5 = 0;
        for (int i = 50; i <= 500; i++) {
            if (i % 2 == 0) {
                suma2 += i;
            }
            if (i % 3 == 0) {
                System.out.println(2 + " ");
            }
            if (i % 5 == 0) {
                suma5++;
            }
        }
        System.out.println("\nSuma de pares: " + suma2);
        System.out.println("Cantidad de multiplos: " + suma5);
    }
    }*/
    //ejercicio 2
    /*public static void main(String[] args) {
        int suma2 = 0;
        int limite = 0;
        int i = 1;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce el limite");
        limite = input.nextInt();
        do {
            suma2 += i;
            i++;
        } while (suma2 + i <= limite);
        System.out.println("i:" + (i - 1) + " Suma:" + (suma2));
        input.close();
    }
    }*/

    /*public static void main(String[] args) {
        double resultado = 0;
        System.out.println("Soluciones a la ecuacion");
        for (int i = -10; i <= 10; i++) {
            resultado = Math.pow(i, 3) - 4 * Math.pow(i, 2) + i + 6;

            System.out.println(resultado);
        }
    }
    }*/

    //ejercicio 1 ejercicios tema
    /*public static void main(String[] args) {
        int suma2 = 0;
        int suma5 = 0;
        for (int i = 50; i <= 500; i++) {
            if (i % 2 == 0) {
                suma2 += i;
            }
            if (i % 3 == 0) {
                System.out.println(i);
            }
            if (i % 5 == 0) {
                suma5++;
            }
        }
        System.out.println("\nSuma de pares: " + suma2);
        System.out.println("Cantidad de multiplos: " + suma5);
    }
    }*/
    //ejercicio 2
    /*public static void main(String[] args) {
        int suma2 = 0;
        int limite;
        int i = 1;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce el limite");
        limite = input.nextInt();
        do {
            suma2 += i;
            i++;
        } while (suma2 + i <= limite);
        System.out.println("i:" + (i - 1) + " Suma:" + (suma2));
        input.close();
    }
}*/

    /*public static void main(String[] args) {
        int numero1 = 0;
        int numero2 = 0;
        double cociente = 0;
        double resto = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce el numero1");
        numero1 = input.nextInt();
        System.out.println("Introduce el numero2");
        numero2 = input.nextInt();
        do {
            cociente = numero1 / numero2;
            resto = numero1 % numero2;
        } while (resto >= numero2);

        System.out.println("cociente: " + cociente + " resto: " + resto);
        input.close();
    }
    }*/
    //8
    /*public static void main(String[] args) {
        int numero = 0;
        int mayor = 0;
        Scanner input;
        input = new Scanner(System.in);
        for (int i = 0; i <= 10; i++) {
            System.out.println("Introduce el siguiente numero");
            numero = input.nextInt();
            if (numero > mayor) {
                mayor = numero;
            }
        }
        System.out.println(mayor);
        input.close();
    }
    }*/
    public static void main(String[] args) {
        int numero1 = 0;
        int numero2 = 0;
        double cociente = 0;
        double resto = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce el numero1");
        numero1 = input.nextInt();
        System.out.println("Introduce el numero2");
        numero2 = input.nextInt();
        do {
            cociente = numero1 / numero2;
            resto = numero1 % numero2;
        } while (resto >= numero2);

        System.out.println("cociente: " + cociente + " resto: " + resto);
        input.close();
    }
}

package operations;

import java.util.Scanner;

public class Operations {

    /*public static void main(String[] args) {
        double hipotenusa;
        double a;
        double b;

        a = 83;
        b = 13;
        hipotenusa = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        System.out.println("Raiz cuadrada=" + hipotenusa + "cm");
    }
}
*/
    /*public static void main(String[] args) {
        double a;
        double b;
        double c;
        a = 1;
        b = -5;
        c = 6;
        double x1;
        double x2;
        double n;
        double resto = -(b + Math.sqrt(Math.pow(b, 2) - 4 * a * c));

        if (resto < 0) {
            System.out.println("Sin raiz real");
            return;
        }

        x1 = (-b + resto) / (2 * a);
        x2 = (-b - resto) / (2 * a);
        System.out.println("X1=" + x1 + " " + "X2=" + x2);
    }
    } */

    /*public static void main(String[] args) {
        double a;
        a = 7;
        if (a % 2 == 0) {
            System.out.println("El numero es par");
        } else System.out.println("El numero es impar");
    }
    }*/

    /*public static void main(String[] args) {
        double a;
        a = 0;
        if (a == 0) {
            System.out.println("El numero es 0");
            return;
        } else if (a < 0) {
            System.out.println("El numero es negativo");
        } else System.out.println("El numero es positivo");
    }
    }*/

    //alternativa simple

    /*  public static void main(String[] args) {
        double edad;
        edad = -35;
        if (edad > 0) {
            System.out.println("Edad:");
            return;
        } else System.out.println("El numero no es valido:" + " " + edad);
    }
    } */

    /*public static void main(String[] args) {
        double duracion;
        double coste1;
        double coste2;
        duracion = 4;
        coste1 = 0.25 * duracion;
        coste2 = (0.25 * 3) + (duracion-3) * 0.31;
        if (duracion == 0) {
            System.out.println("la llamada no existe 0");
            return;
        } else if (duracion < 3) {
            System.out.println(
                "Duracion de la llamada:" +
                    duracion +
                    " " +
                    "coste de la llamada" +
                    coste1
            );
        }
        System.out.println(
            "Duracion de la llamada:" +
                duracion +
                " " +
                "coste de la llamada" +
                coste2
        );
    }
    }*/

    //Alternativa doble
    /*public static void main(String[] args) {
        int nota;
        nota = 2;
        if (nota >= 5) {
            System.out.println("El alumno aprueba");
        } else System.out.println("El alumno suspende");
    }
    }*/

    /*public static void main(String[] args) {
        int nota;
        nota = -2;
        if (nota < 0 || >10) {
            System.out.println("El numero es incorrecto");
        } else System.out.println("El numero es correcto");
    }
    }*/

    /*public static void main(String[] args) {
        int año;
        año = 204;
        if (año % 400 == 0) {
            System.out.println("El año es bisiesto");
            return;
        } else if (año % 4 == 0 && año % 100 != 0) {
            System.out.println("El año es bisiesto");
        } else System.out.println("El año no es bisiesto");
    }
}*/

    /*public static void main(String[] args) {
        double a;
        double b;
        double c;
        a = 3;
        b = 5;
        c = 8;
        if (a == b + c || b == a + c || c == a + b) {
            System.out.println(
                "Uno de los numeros es la suma de los otros dos"
            );
        } else System.out.println(
            "Ninguna de las sumas da como resultado uno de los numeros"
        );
    }
    }*/

    /*  public static void main(String[] args) {
        double horas;
        double dineroHora;
        horas = 20;
        dineroHora = 8.4;
        if (horas == 0) {
            System.out.println("Sin horas trabajadas");
            return;
        }
        double salarioSemanal;
        double salarioMensual;
        double salarioBase = horas * dineroHora;
        if (horas <= 40) {
            salarioSemanal = salarioBase;
            salarioMensual = salarioSemanal * 4;
            System.out.println("Salario:" + salarioSemanal + "€");
            System.out.println("Salario mensual:" + salarioMensual + "€");
        } else {
            double horasExtras = horas - 40;
            salarioSemanal = salarioBase + (horasExtras * (dineroHora * 1.5));
            salarioMensual = salarioSemanal * 4;
            System.out.println("Salario semanal:" + salarioSemanal + "€");
            System.out.println("Salario mensual:" + salarioMensual + "€");
        }
    }
}
*/

    /*public static void main(String[] args) {
        Scanner input; //declaracion del objeto
        input = new Scanner(System.in); //creacion del objeto
        double a;
        System.out.println("Introduce un numero: ");
        a = input.nextInt();
        if (a == 0) {
            System.out.println("El numero es 0");
            return;
        } else if (a < 0) {
            System.out.println("El numero es negativo");
        } else System.out.println("El numero es positivo");
    }
    }*/

    /*public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        double a;
        double b;
        System.out.println("Introduce el primer numero: ");
        a = input.nextInt();
        System.out.println("Introduce el segundo numero: ");
        b = input.nextInt();
        if (a == b) {
            System.out.println("Los numeros son iguales");
            return;
        } else if (a < b) {
            System.out.println("El segundo numero es mayor");
        } else System.out.println("El primer numero es mayor");
    }
    }*/

    /*public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        double a;
        do {
            System.out.println("El numero debe estar entre 0-10");
            System.out.println("Introduce la nota: ");
            a = input.nextInt();
        } while (a < 0 || a > 10);
        {
            if (a < 5) {
                System.out.println("Suspenso");
                return;
            } else if (a < 6) {
                System.out.println("Aprobado");
                return;
            } else if (a < 7) {
                System.out.println("Bien");
                return;
            } else if (a <= 8) {
                System.out.println("Notable");
                return;
            } else {
                System.out.println("Sobresaliente");
            }
        }
    }
    }*/

    /*public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        int dia;
        System.out.println(
            "Introduce el día de la semana según su valor numérico: "
        );
        do {
            System.out.println("Debe ser del 1 al 7: ");
            dia = input.nextInt();
        } while (dia < 1 || dia > 7);
        {
            switch (dia) {
                case 1:
                    System.out.println("Lunes");
                    break;
                case 2:
                    System.out.println("Martes");
                    break;
                case 3:
                    System.out.println("Miércoles");
                    break;
                case 4:
                    System.out.println("Jueves");
                    break;
                case 5:
                    System.out.println("Viernes");
                    break;
                case 6:
                    System.out.println("Sábado");
                    break;
                case 7:
                    System.out.println("Domingo");
                    break;
                default:
                    System.out.println("Valor inválido");
            }
        }
    }
    }*/

    /*public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        double a;
        do {
            System.out.println("El numero debe estar entre 0-10");
            System.out.println("Introduce la nota: ");
            a = input.nextInt();
        } while (a < 0 || a > 10);
        {
            if (a < 5) {
                System.out.println("E");
                return;
            } else if (a < 6) {
                System.out.println("D");
                return;
            } else if (a < 7) {
                System.out.println("C");
                return;
            } else if (a <= 8) {
                System.out.println("B");
                return;
            } else {
                System.out.println("A");
            }
        }
    }
    }*/

    /*public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        int hora;
        int minutos;
        int segundos;
        do {
            System.out.println(
                "Introduce la hora actual y se tira la hora +1 segundo: "
            );
            System.out.println("Introduce la hora: ");
            hora = input.nextInt();
            System.out.println("Introduce los minutos: ");
            minutos = input.nextInt();
            System.out.println("Introduce los segundos: ");
            segundos = input.nextInt();
        } while (
            hora < 0 ||
            hora >= 24 ||
            minutos < 0 ||
            minutos >= 60 ||
            segundos < 0 ||
            segundos >= 60
        );
        segundos = segundos + 1;
        if (segundos >= 60) {
            segundos = 00;
            minutos = minutos + 1;
        }
        if (minutos >= 60) {
            hora = hora + 1;
            minutos = 00;
        }
        if (hora >= 24) {
            hora = 00;
        }
        {
            System.out.println(hora + ":" + minutos + ":" + segundos);
        }
    }
/*}

    /*public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        int num1;
        int num2;
        int num3;
        System.out.println("Introduce 3 numeros y se detectara el menor: ");
        System.out.println("Introduce el primer numero: ");
        num1 = input.nextInt();
        System.out.println("Introduce el segundo numero: ");
        num2 = input.nextInt();
        System.out.println("Introduce el tercer numero: ");
        num3 = input.nextInt();
        if ((num1 == num2) & (num1 == num3) & (num2 == num3)) {
            System.out.println("Los numeros son iguales");
            return;
        } else if ((num1 < num2) & (num1 < num3)) {
            System.out.println(num1 + " es el menor");
        } else if ((num2 < num1) & (num2 < num3)) {
            System.out.println(num2 + " es el menor");
        } else if ((num3 < num2) & (num3 < num1)) {
            System.out.println(num3 + " es el menor");
        }
    }
    }*/

    /*public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double horas;
        double precioHora;
        System.out.println("Introduce lo que cobras por hora: ");
        precioHora = input.nextDouble();
        do {
            System.out.print("Introduce las horas trabajadas: ");
            horas = input.nextDouble();
            if (horas < 0) {
                System.out.println("Introduce un número positivo");
            }
        } while (horas < 0);

        double sueldoBruto;
        double sueldoNeto;
        if (horas > 35) {
            sueldoBruto = 35 * precioHora + (horas - 35) * precioHora * 1.5;
        } else {
            sueldoBruto = horas * precioHora;
        }

        if (sueldoBruto <= 100) {
            sueldoNeto = sueldoBruto;
        } else if (sueldoBruto > 100 && sueldoBruto <= 200) {
            sueldoNeto = ((sueldoBruto - 100) * 0.9) + 100;
        } else {
            sueldoNeto = 100 + (100 * 0.9) + ((sueldoBruto - 200) * 0.75);
        }

        double sueldoNetoMensual = sueldoNeto * 4;
        System.out.println("Sueldo Bruto:" + sueldoBruto + "€ semanal");
        System.out.println("Sueldo Neto:" + sueldoNeto + "€ semanal");
        System.out.println("Sueldo Neto Mensual:" + sueldoNetoMensual + "€");
        input.close();
    }
    }*/

    //Ejercicios instrucciones repetitivas

    //2 primeros version do while
    /*public static void main(String[] args) {
        int numero = 0;
        do {
            System.out.print(++numero + " ");
        } while (numero < 5);
    }
    }*/

    /*public static void main(String[] args) {
        int numero = 0;
        int contador = 0;
        do {
            numero += 2;
            System.out.print(numero + " ");
            contador++;
        } while (contador < 5);
    }
    }*/

    /*public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i * 2 + " ");
        }
    }
    }*/

    //version for

    /*public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " ");
        }
    }
}*/
    /*public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i * 2 + " ");
        }
    }
    }*/

    /*public static void main(String[] args) {
        for (int i = 100; i >= 90; i--) {
            System.out.println(i + " ");
        }
    }
    }*/

    /*public static void main(String[] args) {
        for (int i = 24; i <= 45; i++) {
            if (i % 3 == 0) System.out.println(i + " ");
        }
    }
    }*/

    //version optimizada

    /*  public static void main(String[] args) {
        for (int i = 24; i <= 45; i+=3) {
             System.out.println(i + " ");
        }
    }
    }*/
    /*public static void main(String[] args) {
        for (int i = 45, contador = 1; i <= 59; i += 3, contador++) {  //version compacta sin if
            System.out.println(contador);
        }
    }
    }*/

    /*public static void main(String[] args) {
        //falta el contador
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("El numero debe estar entre 0-10");
        double[] notas = new double[15];
        for (int i = 0; i < 15; i++) {
            double a;
            do {
                System.out.println("Introduce la nota" + (i + 1) + ": ");
                a = input.nextDouble();
            } while (a < 0 || a > 10);
            notas[i] = a;
        }
        int contador = 0;
        for (double nota : notas) {
            if (nota <= 5) {
                contador++;
                System.out.println("Alumnos suspensos: " + contador);
                return;
            }
            input.close();
        }
    }
}*/

    //generar valores aleatorios

    /*public static void main(String[] args) {
        double a;
        a = Math.random() * 10 + 1;
        int b;
        b = (int) a;
        if (b % 2 == 0) {
            System.out.println("El numero es par: " + b);
        } else System.out.println("El numero es impar: " + b);
    }
    }*/

    /*public static void main(String[] args) {
        double a;
        a = Math.random() * (30 - 10 + 1) + 10; //Math.random()*(b=b-a+1)+a  ejemplo 10..30
        int b;
        b = (int) a;
        if (b % 2 == 0) {
            System.out.println("El numero es par: " + b);
        } else System.out.println("El numero es impar: " + b);
    }
    }*/

    /*public static void main(String[] args) {
        double peso, altura;
        double IMC;
        peso = Math.random() * (200 - 0.5 + 1) + 0.5;
        altura = Math.random() * (3 - 0.2) + 0.2; //se quita el +1 al ser valor cercano al 1 dando una altura erronea
        IMC = peso / Math.pow(altura, altura);
        int IMCR;
        IMCR = (int) IMC;
        System.out.println(IMCR);
    }
    }*/

    /*public static void main(String[] args) {
        int aleatorio;
        double azar;
        for (double i = 1; i <= 100; i++) {
            azar = Math.random() * 1000 + 1;
            aleatorio = (int) azar;
            System.out.println(aleatorio);
        }
    }
    }*/

    /*public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        double aleatorio = input.nextDouble();
        double azar = input.nextDouble();
        for (double i = 1; i <= 100; i++) {
            azar = Math.random() * 100 + 1;
            aleatorio = (int) azar;
            System.out.println(aleatorio);
        }
        input.close();
    }
    }*/
    /*public static void main(String[] args) {
        double peso;
        double altura;
        double IMC;
        for (int i = 1; i <= 100; i++) {
            peso = Math.random() * (200 - 0.5 + 1) + 0.5;
            altura = Math.random() * (3 - 0.2) + 0.2;
            IMC = peso / Math.pow(altura, 2);
            System.out.println(
                "Peso: " + peso + " altura: " + altura + " IMC: " + IMC
            );
        }
    }
}*/

    /*public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        double peso;
        double altura;
        System.out.println("Introduce de cuantas personas hacemos el IMC: ");
        int personas = input.nextInt();
        double IMC;
        for (int i = 1; i <= personas; i++) {
            peso = Math.random() * (200 - 0.5 + 1) + 0.5;
            altura = Math.random() * (3 - 0.2) + 0.2;
            IMC = peso / Math.pow(altura, 2);
            if (IMC >= 15 && IMC <= 30) {
                System.out.println(
                    "Peso: " + peso + " altura:" + altura + " IMC: " + IMC
                );
            }
        }
        input.close();
    }
    }*/
    //33
    /*public static void main(String[] args) {
        int aprobados, suspensos;
        aprobados = suspensos = 0;
        for (int i = 1; i <= 15; i++) {
            double nota = Math.random() * 10 + 1;
            if (nota < 5) {
                suspensos++;
            } else {
                aprobados++;
            }
        }
        System.out.println(
            "Alumnos aprobados:" +
                aprobados +
                " Porcentaje aprobados:" +
                ((100 * aprobados) / 15)
        );
        System.out.println(
            "Alumnos suspensos:" +
                suspensos +
                " Porcentaje suspensos:" +
                ((100 * suspensos) / 15)
        );
    }
}*/
    //con scanner
    /*public static void main(String[] args) {
        int aprobados, suspensos;
        aprobados = suspensos = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce numero de alumnos");
        int alumnos = input.nextInt();
        for (int i = 1; i <= alumnos; i++) {
            double nota = Math.random() * 10 + 1;
            if (nota < 5) {
                suspensos++;
            } else {
                aprobados++;
            }
            input.close();
        }
        System.out.println(
            "Alumnos aprobados:" +
                aprobados +
                " Porcentaje aprobados:" +
                ((100 * aprobados) / 15)
        );
        System.out.println(
            "Alumnos suspensos:" +
                suspensos +
                " Porcentaje suspensos:" +
                ((100 * suspensos) / 15)
        );
    }
}*/

    //quiniela
    /*public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            double resultado = Math.random() * (3 - 1 + 1) + 1;
            int quiniela = (int) resultado;
            if (quiniela == 3) {
                System.out.println("Partido:" + i + " X");
            } else {
                System.out.println("Partido:" + i + " " + quiniela);
            }
        }
    }
    }*/

    /*public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            double resultado = Math.random() * 9;
            int quiniela = (int) resultado;
            System.out.print(quiniela);
        }
    }
    }*/
    //38
    /* public static void main(String[] args) {
        int suma = 0;
        for (int i = 1; i <= 10; i++) {
            suma = suma + i;
        }
        System.out.println(suma);
    }
    }*/
    /*public static void main(String[] args) {
        long suma = 0;
        Scanner input;
        input = new Scanner(System.in);
        int cantidad = input.nextInt();
        for (int i = 1; i <= cantidad; i++) {
            suma += i;
        }
        System.out.println(suma);
        input.close();
    }
    }*/
    //39
    /*public static void main(String[] args) {
        int factorial = 1;
        for (int i = 1; i <= 7; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }
    }*/

    /*public static void main(String[] args) {
        System.out.println("Introduce el numero que quieres factorizar");
        Scanner input;
        input = new Scanner(System.in);
        int interacciones = input.nextInt();
        double factorial = 1;
        for (int i = 1; i <= interacciones; i++) {
            factorial *= i;
        }
        System.out.println(
            "El factor de " + interacciones + " es:" + factorial
        );
        input.close();
    }
    }*/
    //34
    /*public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        int ninos, adultos, jovenes, edad;
        ninos = adultos = jovenes = 0;
        double precio_nino, precio_joven, precio_adulto, ingresos;
        double azar;
        precio_nino = 0;
        precio_joven = 20;
        precio_adulto = 40;
        System.out.println("Introduzca numero de visitantes: ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            azar = Math.random() * 100 + 1;
            edad = (int) azar;
            if (edad < 4) {
                ninos++;
            } else {
                if (edad < 12) {
                    jovenes++;
                } else {
                    adultos++;
                }
            }
        }
        ingresos =
            ninos * precio_nino +
            jovenes * precio_joven +
            adultos * precio_adulto;
        System.out.println("Numero de menores: " + ninos);
        System.out.println("Numero de jovenes: " + jovenes);
        System.out.println("Numero de adultos: " + adultos);
        System.out.println("Ingresos totales: " + ingresos);
        input.close();
    }
    }*/

    /*  public static void main(String[] args) {
        int aprobados, suspensos;
        aprobados = suspensos = 0;
        double nota = suma_notas = media_nota = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce numero de alumnos");
        int alumnos = input.nextInt();
        for (int i = 1; i <= alumnos; i++) {
            nota = Math.random() * 10;
            suma_notas = suma_notas + (int) nota;
            if (nota < 5 && nota >= 0) {
                suspensos++;
            } else {
                if (nota >= 5 && nota <= 10) {
                    aprobados++;
                }
                input.close();
            }
        }
        media_nota = suma_notas / alumnos;
        System.out.println(
            "Alumnos aprobados:" +
                aprobados +
                " Porcentaje aprobados:" +
                ((100 * aprobados) / alumnos)
        );
        System.out.println(
            "Alumnos suspensos:" +
                suspensos +
                " Porcentaje suspensos:" +
                ((100 * suspensos) / alumnos)
        );
        System.out.println("Nota media:" + media_nota);
    }
}
*/

    public static void main(String[] args) {
        int aprobados, suspensos, suma_notas, n10;
        aprobados = suspensos = suma_notas = n10 = 0;
        double nota,
            media_nota = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Introduce numero de alumnos");
        int alumnos = input.nextInt();
        for (int i = 1; i <= alumnos; i++) {
            nota = Math.random() * 10 + 1;
            suma_notas = suma_notas + (int) nota;
            if ((int) nota == 10) {
                n10++;
            }
            if (nota < 5 && nota >= 0) {
                suspensos++;
            } else {
                if (nota >= 5 && nota <= 10) {
                    aprobados++;
                }
                input.close();
            }
        }
        media_nota = suma_notas / alumnos;
        System.out.println(
            "Alumnos aprobados:" +
                aprobados +
                " Porcentaje aprobados:" +
                ((100 * aprobados) / alumnos)
        );
        System.out.println(
            "Alumnos suspensos:" +
                suspensos +
                " Porcentaje suspensos:" +
                ((100 * suspensos) / alumnos)
        );
        System.out.println("Nota media:" + media_nota);
        System.out.println("Numero de 10s: " + n10);
    }
}

package Trimestre1.operations;

public class misMetodosClaude {

    public static void main(String[] args) {
        // Pruebas de métodos
        System.out.println("Suma impares (5): " + sumaImparesN(5));
        mostrarMensaje(3, "Método ejecutándose");
        System.out.println("Máximo entero: " + numMax(1, 5));
        System.out.println("Máximo double: " + numMax(1.0, 5.0));
        betweenNandM(1, 5);

        // Pruebas de caracteres
        System.out.println("\n--- Pruebas de caracteres ---");
        System.out.println("'A' es mayúscula? " + esMayuscula('A'));
        System.out.println("'#' es mayúscula? " + esMayuscula('#'));
        System.out.println("'5' es número? " + esNumero('5'));
        System.out.println("'å' es número? " + esNumero('å'));

        // Pruebas con caracteres aleatorios
        System.out.println("\n--- 5 caracteres aleatorios ---");
        for (int i = 0; i < 5; i++) {
            int randomAscii = numRandomAscii();
            char randomChar = (char) randomAscii;
            System.out.printf(
                "Carácter: %c (ASCII: %d)%n",
                randomChar,
                randomAscii
            );
            System.out.println("  Es letra? " + esLetra(randomChar));
            System.out.println("  Es número? " + esNumero(randomChar));
            System.out.println("--------------------");
        }

        // Pruebas de conversión
        System.out.println("\n--- Conversión de texto ---");
        System.out.println("'Ñ' a minúscula: " + toMinuscula('Ñ'));
        System.out.println(
            "Texto en minúsculas: " + textoAMinusculas("IES José Planes")
        );

        // Pruebas de distancia
        System.out.println("\n--- Cálculo de distancia ---");
        System.out.println(
            "Distancia entre (2,5) y (1,5): " + distancia(2, 5, 1, 5)
        );
    }

    /**
     * Suma los primeros n números impares.
     * Optimización: usa la fórmula matemática n² en lugar de bucle.
     * @param n cantidad de números impares a sumar
     * @return suma de los n primeros impares
     */
    public static int sumaImparesN(int n) {
        return n * n; // Fórmula matemática: 1+3+5+...+(2n-1) = n²
    }

    /**
     * Suma los primeros n números pares.
     * @param n cantidad de números pares a sumar
     * @return suma de los n primeros pares
     */
    public static int sumaParesN(int n) {
        return n * (n + 1); // Fórmula: 2+4+6+...+2n = n(n+1)
    }

    /**
     * Muestra un mensaje n veces por consola.
     * @param n número de repeticiones
     * @param texto mensaje a mostrar
     */
    public static void mostrarMensaje(int n, String texto) {
        for (int i = 0; i < n; i++) {
            System.out.println(texto);
        }
    }

    /**
     * Retorna el mayor de dos enteros.
     * @param n1 primer número
     * @param n2 segundo número
     * @return el mayor de los dos
     */
    public static int numMax(int n1, int n2) {
        return Math.max(n1, n2); // Usa la API de Java (más legible)
    }

    /**
     * Retorna el mayor de dos doubles (sobrecarga).
     * @param n1 primer número
     * @param n2 segundo número
     * @return el mayor de los dos
     */
    public static double numMax(double n1, double n2) {
        return Math.max(n1, n2);
    }

    /**
     * Imprime los números entre n1 y n2 (exclusivos).
     * Funciona en ambas direcciones.
     * @param n1 primer límite
     * @param n2 segundo límite
     */
    public static void betweenNandM(int n1, int n2) {
        int inicio = Math.min(n1, n2) + 1;
        int fin = Math.max(n1, n2);

        for (int i = inicio; i < fin; i++) {
            System.out.println(i);
        }
    }

    /**
     * Retorna el doble de un número.
     * @param n número a duplicar
     * @return el doble del número
     */
    public static double doble(double n) {
        return n * 2; // Multiplicación es más eficiente que 2*n
    }

    /**
     * Verifica si un número es par.
     * @param n número a verificar
     * @return true si es par, false si es impar
     */
    public static boolean esPar(int n) {
        return (n & 1) == 0; // Operación bitwise: más eficiente que módulo
    }

    /**
     * Verifica si un carácter es letra mayúscula.
     * Usa la API de Java para manejar Unicode correctamente.
     * @param c carácter a verificar
     * @return true si es mayúscula
     */
    public static boolean esMayuscula(char c) {
        return Character.isUpperCase(c);
    }

    /**
     * Verifica si un carácter es una letra (mayúscula o minúscula).
     * Maneja correctamente caracteres Unicode como Ñ, á, é, etc.
     * @param c carácter a verificar
     * @return true si es letra
     */
    public static boolean esLetra(char c) {
        return Character.isLetter(c);
    }

    /**
     * Verifica si un carácter es un dígito numérico.
     * @param c carácter a verificar
     * @return true si es un dígito (0-9)
     */
    public static boolean esNumero(char c) {
        return Character.isDigit(c);
    }

    /**
     * Genera un código ASCII aleatorio entre 0 y 255.
     * @return código ASCII aleatorio
     */
    public static int numRandomAscii() {
        return (int) (Math.random() * 256); // 0-255 (256 valores)
    }

    /**
     * Convierte un carácter a minúscula.
     * Maneja correctamente Ñ -> ñ y otros caracteres especiales.
     * @param c carácter a convertir
     * @return carácter en minúscula
     */
    public static char toMinuscula(char c) {
        return Character.toLowerCase(c);
    }

    /**
     * Convierte un texto completo a minúsculas.
     * Optimización: usa StringBuilder en lugar de concatenación de strings.
     * @param texto texto a convertir
     * @return texto en minúsculas
     */
    public static String textoAMinusculas(String texto) {
        return texto.toLowerCase(); // Mucho más eficiente

        /* Alternativa manual si se requiere:
        StringBuilder resultado = new StringBuilder(texto.length());
        for (int i = 0; i < texto.length(); i++) {
            resultado.append(Character.toLowerCase(texto.charAt(i)));
        }
        return resultado.toString();
        */
    }

    /**
     * Calcula la distancia euclidiana entre dos puntos.
     * @param x1 coordenada x del primer punto
     * @param y1 coordenada y del primer punto
     * @param x2 coordenada x del segundo punto
     * @param y2 coordenada y del segundo punto
     * @return distancia entre los puntos
     */
    public static double distancia(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.hypot(dx, dy); // Más preciso que sqrt(dx²+dy²)
    }

    /**
     * Calcula el cuadrado de un número.
     * Nota: Este método es redundante con Math.pow(n, 2).
     * @param numero número a elevar al cuadrado
     * @return el cuadrado del número
     */
    public static double cuadrado(double numero) {
        return numero * numero; // Más eficiente que Math.pow para cuadrados
    }
}

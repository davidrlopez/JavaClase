public class ProyectoCirculo {

    public static void main(String[] args) {
        final double pi = 3.1416;
        double radio;
        double s;
        double l;

        radio = 5.25;
        s = pi * (radio * radio);
        l = 2 * pi * radio;

        System.out.println("Superficie=" + s + " " + "Longitud=" + l);
    }
}

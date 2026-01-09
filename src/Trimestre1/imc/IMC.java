package imc;

public class IMC {

    public static void main(String[] args) {
        double peso;
        double altura;
        double IMC;

        peso = 83;
        altura = 1.83;
        IMC = peso / Math.pow(altura, 2);

        System.out.println("IMC=" + IMC);
    }
}

/*Pseudocodigo ProyectoCilindro

    Entorno
        Con las varibales radio y altura, y con la constante PI=3.1416

    Algoritmo
        Calcular:
        // --- Volumen ---
        volumen ← PI * radio^2 * altura

        // --- Superficie total (lateral + 2 bases) ---
        superficieTotal ← 2 * PI * radio * (radio + altura)

     Salida
        IMPRIMIR "Volumen:" volumen
        IMPRIMIR "Superficie total:" superficieTotal
FIN PROCEDIMIENTO*/

package Trimestre1.proyectocilindro;

public class ProyectoCilindro {

    public static void main(String[] args) {
        //final double pi = 3.1416;
        double radio;
        double altura;
        double superficieTotal;
        double volumenTotal;

        radio = 3;
        altura = 5;
        superficieTotal = 2 * Math.PI * radio * (radio * altura);
        volumenTotal = Math.PI * (radio * radio) * altura;

        System.out.println(
            "Superficie=" +
                superficieTotal +
                "cm2" +
                " " +
                "Volumen=" +
                volumenTotal +
                "cm2"
        );
    }
}

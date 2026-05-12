package Olimpiadas;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final Random random = new Random(50);

        /* 1. Declara una variable de tipo Goku y otra de tipo Freezer */
        Goku goku = new Goku("Goku", 30);
        Freezer freezer = new Freezer("Freezer", 30);

        /*
         * 2. Instancia las variables de tipo Goku y de tipo Freezer, con vida inicial =
         * 30
         */

        int ronda = 1;

        while ((!goku.isMuerto()) && (!freezer.isMuerto())) {
            int atacante = random.nextInt(2);

            System.out.println("Ronda " + ronda++);

            switch (atacante) {
                /* 3.Case 0 -> ataca Goku, Case 1 -> ataca Freezer */
                case 0:
                    goku.atacar(freezer);
                    System.out.println("Goku: Ataca a Freezer");
                    System.out.println("Freezer: recibe 10 de dano");
                    break;
                case 1:
                    freezer.atacar(goku);
                    System.out.println("Freezer : Ataca a Goku");
                    System.out.println("Goku: recibe 10 de dano");

                    break;
            }

            /* 4. Mostrar vida de Goku y Freezer */
            System.out.println("Goku: vida=" + goku.getVida());
            System.out.println("Freezer: vida=" + freezer.getVida());
            System.out.println();

        }
    }

}

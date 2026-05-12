package Olimpiadas;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final Random random = new Random(20);

        /* 1. Declara las variables de tipo Goku, Freezer y Vegeta */
        Goku goku = new Goku("Goku", 30);
        Vegeta vegeta = new Vegeta("Vegeta", 30);
        Freezer freezer = new Freezer("Freezer", 30);

        /*
         * 2. Instancia las variables de tipo Goku y de tipo Freezer, con vida inicial =
         * 30
         */

        /* 3. Crea una lista de heroes y añade a Goku y Vegeta */
        ArrayList<Heroe> heroes = new ArrayList<>();
        heroes.add(goku);
        heroes.add(vegeta);

        int ronda = 1;

        while ((!goku.isMuerto()) && (!freezer.isMuerto()) && (!vegeta.isMuerto())) {
            int atacante = random.nextInt(4);

            System.out.println("Ronda " + ronda++);

            switch (atacante) {
                /* Ataca el Heroe en la posición 0 de la lista */
                case 0:
                    goku.atacar(freezer);
                    System.out.println("Goku: Ataca a Freezer");
                    System.out.println("Freezer: recibe 10 de dano");
                    break;
                /* Ataca el Heroe en la posición 1 de la lista */
                case 1:
                    vegeta.atacar(freezer);
                    System.out.println("Vegeta: Ataca a Freezer");
                    System.out.println("Freezer: recibe 10 de dano");
                    break;
                /* Freezer ataca al heroe en la posición 0 de la lista */
                case 2:
                    freezer.atacar(goku);
                    System.out.println("Freezer : Ataca a Goku");
                    System.out.println("Goku: recibe 10 de dano");
                    break;
                /* Freezer ataca al heroe en la posición 1 de la lista */
                case 3:
                    freezer.atacar(vegeta);
                    System.out.println("Freezer : Ataca a Vegeta");
                    System.out.println("Vegeta: recibe 10 de dano");
                    break;
            }

            /* 4. Mostrar vida de Goku, Freezer y Vegeta */
            System.out.println("Goku: vida=" + goku.getVida());
            System.out.println("Vegeta: vida=" + vegeta.getVida());
            System.out.println("Freezer: vida=" + freezer.getVida());
            System.out.println();

        }
    }

}

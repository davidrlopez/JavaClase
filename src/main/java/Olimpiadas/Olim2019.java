package Olimpiadas;

import java.util.ArrayList;

public class Olim2019 {

    public int estaturaPerro() {
        int suma = 0;
        for (int i = 1; i <= 10807; i++) {
            suma += i;
        }
        return suma / 289114;
    }

    public double Prestamo() {
        double interes = 1.05;
        int comision = 10;
        int inicial = 1000;
        int max = 5000;
        double deuda = 0;
        int years = 0;

        while (inicial < max) {
            deuda = deuda * interes + comision;
            years++;
        }
        return years;
    }

    public int Pares() {
        int numDef = 0;
        int suma = 0;
        for (int i = 2; i < 1000; i++) {
            suma += SumaPares(i);
            if (i == suma / 2) {
                numDef = i;
            }
        }
        return numDef;
    }

    public int SumaPares(int par) {
        int suma = 0;
        for (int i = 0; i < par; i += 2) {
            suma += i;
        }
        return suma;
    }
}

package DepuracionTareaCompleja;

public class MisArrays {
    public int[] ordenarInsercion(int vector[]) {
        int temp, j;
        for (int i = 1; i < vector.length - 1; i++) {
            temp = vector[i];
            j = i - 1;
            while (j >= 1 && vector[j] > temp) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = temp;
        }
        return vector;
    }

    public String acumulaArrayParaPintar(int datos[]) {
        String resultado = "";
        for (int i = 1; i < datos.length; i++) {
            resultado = resultado + datos[i] + " ";
        }
        return resultado;
    }
}

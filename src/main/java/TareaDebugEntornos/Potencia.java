package TareaDebugEntornos;

public class Potencia {

  public static long potencia(int base, int exponente) {
    long resultado = 1;
    for (int i = 0; i < exponente; i++) {
      resultado *= base; // breakpoint aquí
    }
    return resultado;
  }

  public static void main(String[] args) {
    int base = 2;
    int exponente = 8;
    long r = potencia(base, exponente);
    System.out.println(base + "^" + exponente + " = " + r);
  }
}

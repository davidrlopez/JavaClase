package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.Extremos;

public final class Math3 implements Extremos {

  public int min(int[] a) {
    int minActual = 0;
    for (int i : a) {
      Math.min(minActual, i);
    }
    return minActual;
  }

  public int max(int[] a) {
    int maxActual = 0;
    for (int i : a) {
      Math.max(maxActual, i);
    }
    return maxActual;
  }

  public double min(double[] a) {
    double minActual = 0;
    for (double i : a) {
      Math.min(minActual, i);
    }
    return minActual;
  }

  public double max(double[] a) {
    double maxActual = 0;
    for (double i : a) {
      Math.max(maxActual, i);
    }
    return maxActual;
  }
}

package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.Estadisticas;

public class ArrayReales implements Estadisticas {
  private double[] arrayReal = new double[0];

  public double[] getArrayReal() {
    return arrayReal;
  }

  public void setArrayReal(double[] arrayReal) {
    this.arrayReal = arrayReal;
  }

  public ArrayReales(double[] arrayReal) {
    setArrayReal(arrayReal);
  }

  public double minimo() {
    double minimo = this.arrayReal[0];
    for (double d : arrayReal) {
      if (d < minimo) {
        minimo = d;
      }
    }
    return minimo;
  }

  public double maximo() {
    double maximo = this.arrayReal[0];
    for (double d : arrayReal) {
      if (d > maximo) {
        maximo = d;
      }
    }
    return maximo;
  }

  public double sumatorio() {
    double suma = this.arrayReal[0];
    for (double d : arrayReal) {
      suma += d;
    }
    return suma;
  }
}

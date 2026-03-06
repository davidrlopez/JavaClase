package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.Relaciones;

public class Numero implements Relaciones {
  private int valor;

  public Numero(int valor) {
    setValor(valor);
  }

  public int getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  @Override
  public boolean esMayor(Object b) {
    if (b instanceof Numero) {
      return this.valor > ((Numero) b).getValor();
    }
    return false;
  }

  @Override
  public boolean esMenor(Object b) {
    if (b instanceof Numero) {
      return this.valor < ((Numero) b).getValor();
    }
    return false;
  }

  @Override
  public boolean esIgual(Object b) {
    if (b instanceof Numero) {
      return this.valor == ((Numero) b).getValor();
    }
    return false;
  }
}

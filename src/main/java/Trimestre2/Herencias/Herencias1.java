package Trimestre2.Herencias;

public class Herencias1 {
  public int at1;
  public int at2;
  protected int at3;
  int at4;

  public Herencias1() {
    this.at1 = this.at2 = this.at3 = this.at4 = 0;
  }

  public Herencias1(int at1, int at2, int at3, int at4) {
    this.at1 = at1;
    this.at2 = at2;
    this.at3 = at3;
    this.at4 = at4;
  }

  public int getAt1() {
    return at1;
  }

  public void setAt1(int at1) {
    this.at1 = at1;
  }

  public int getAt2() {
    return at2;
  }

  public void setAt2(int at2) {
    this.at2 = at2;
  }

  public int getAt3() {
    return at3;
  }

  public void setAt3(int at3) {
    this.at3 = at3;
  }

  public int getAt4() {
    return at4;
  }

  public void setAt4(int at4) {
    this.at4 = at4;
  }

  @Override
  public String toString() {
    return "Herencias1 [at1=" + at1 + ", at2=" + at2 + ", at3=" + at3 + ", at4=" + at4 + "]";
  }

  public void metodo() {
    System.out.println("Soy metodo de A");
  }
}

package Trimestre2.Herencias;

public class Herencias2 extends Herencias1 {

  int at5;

  public Herencias2() {
    super();
    this.at5 = 0;
  }

  public Herencias2(int i1, int i2, int i3, int i4, int i5) {
    super(i1, i2, i3, i4);
    this.at5 = i5;
  }

  public int getAt5() {
    return at5;
  }

  public void setAt5(int at5) {
    this.at5 = at5;
  }

  @Override
  public String toString() {
    return super.toString() + " Herencias2 [at5=" + at5 + "]";
  }

  @Override
  public void metodo() {
    System.out.println("Soy metodo de B");
  }

}

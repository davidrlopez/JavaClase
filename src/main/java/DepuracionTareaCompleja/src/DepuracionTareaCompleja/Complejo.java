/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DepuracionTareaCompleja;

/**
 *
 * @author Alumno
 */
public class Complejo {
  private int r, i;

  public Complejo(int r, int i) {
    this.r = r;
    this.i = i;
  }

  public Complejo() {
    this(1, 0);
  }

  public Complejo(Complejo c) {
    this(c.r, c.i);
  }

  public int getR() {
    return this.r;
  }

  public int getI() {
    return this.i;
  }

  public void setR(int r) {
    this.r = r;
  }

  public void setI(int i) {
    this.i = i;
  }

  public void setComplejo(int r, int i) {
    this.r = r;
    this.i = i;
  }

  public void setComplejo(Complejo c) {
    this.setComplejo(c.r, c.i);
    // this.r=c.r;
    // this.i = c.i;
  }

  @Override
  public String toString() {
    return "{" + this.r + "+" + this.i + "i}";
  }

  public boolean equals(int r, int i) {
    if (this.r == r && this.i == i)
      return true;
    else
      return false;
  }

  public boolean equals(Complejo c) {
    /*
     * if (this.r==c.r && this.i==c.i)
     * return true;
     * else
     * return false;
     */
    return this.equals(c.r, c.i);
  }

  public Complejo sumaComplejo(int c, int d) {
    Complejo e = new Complejo();
    e.r = this.r + c;
    e.i = this.i + d;
    return e;
  }

  public Complejo sumaComplejo(Complejo g) {
    /*
     * Complejo e=new Complejo();
     * e.r=this.r + g.r;
     * e.i=this.i + g.i;
     * return e;
     */
    return this.sumaComplejo(g.r, g.i);
  }

  public Complejo complejoResta(int r, int i) {
    // Complejo e=new Complejo(this.r-r, this.i-i);
    // return e;

    return new Complejo(this.r - r, this.i - i);
  }

  public Complejo complejoResta(Complejo c) {

    return this.complejoResta(c.r, c.i);
  }

  public Complejo complejoProducto(int r, int i) {
    return new Complejo(this.r * r - this.i * i, this.r * i + this.i * r);
  }

  public Complejo complejoProducto(Complejo c) {
    return this.complejoProducto(c.r, c.i);
  }

  public Complejo complejoCociente(int r, int i) {
    int real = (this.r * r + this.i * i) / (r * r + i * i);
    int imaginaria = (this.i * r - this.r * i) / (r * r + i * i);
    return new Complejo(real, imaginaria);
  }

  public Complejo complejoCociente(Complejo c) {
    return this.complejoCociente(c.r, c.i);
  }

}

package EjerciciosPOO1;

public class Circulo {
  private int cx;
  private int cy;
  private int r;

  public Circulo() {
    this.cx = this.cy = -1;
    this.r = 0;
  }

  public Circulo(int cx, int cy, int r) {
    this.cx = cx;
    this.cy = cy;
    this.r = r;
  }

  public int getCx() {
    return cx;
  }

  public void setCx(int cx) {
    this.cx = cx;
  }

  public int getCy() {
    return cy;
  }

  public void setCy(int cy) {
    this.cy = cy;
  }

  public int getR() {
    return r;
  }

  public void setR(int r) {
    this.r = r;
  }

  public void verDatos() {
    System.out.println("---------------------");
    System.out.println("Coordenada X:" + this.getCx());
    System.out.println("Coordenada Y:" + this.getCy());
    System.out.println("Radio:" + this.getR());

  }

  public String toString() {
    return "Coordenada X:" + this.getCx() + " Coordenada Y:" + this.getCy() + " Radio:" + this.getR();
  }

  public boolean equals(Circulo c1) {
    if (this.getCx() == c1.getCx() && this.getCy() == c1.getCy() && this.getR() == c1.getR()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean equals(int cx, int cy, int radio) {
    Circulo c1 = new Circulo(cx, cy, r);
    return this.equals(c1);
  }

  public void ampliaCirculo(int escalar) {
    this.setR(escalar * this.getR());
  }

  public double distanciaCirculo(Circulo c1) {
    double distancia;
    distancia = Math.sqrt(Math.pow(this.getCx() - c1.getCx(), 2) +
        Math.pow(this.getCy() - c1.getCy(), 2));
    return distancia;
  }

  public double distanciaCirculo(double cx, double cy) {
    double distancia;
    distancia = Math.sqrt(Math.pow(this.getCx() - cx, 2) +
        Math.pow(this.getCy() - cy, 2));
    return distancia;
  }
}

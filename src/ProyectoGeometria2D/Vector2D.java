package ProyectoGeometria2D;

public class Vector2D {

  private double dirX;
  private double dirY;

  public Vector2D() {
    this(0, 0);
  }

  public Vector2D(double dirX, double dirY) {
    this.dirX = dirX;
    this.dirY = dirY;
  }

  public double getDirX() {
    return dirX;
  }

  public void setDirX(double dirX) {
    this.dirX = dirX;
  }

  public double getDirY() {
    return dirY;
  }

  public void setDirY(double dirY) {
    this.dirY = dirY;
  }

  public double moduloVector(double dirX, double dirY) {
    return Math.sqrt(Math.pow(dirX, 2) + Math.pow(dirY, 2));
  }

  public void normalizarVector(double dirX, double dirY) {
    if (moduloVector(dirX, dirY) != 0) {
      this.dirX = this.dirX / moduloVector(dirX, dirY);
      this.dirY = this.dirY / moduloVector(dirX, dirY);
    }
  }

  public double calcularProductoEscalar(double x2, double y2) {
    return (this.dirX * x2) + (this.dirY * y2);
  }

  public double productoVectorial2D(double x2, double y2) {
    return (this.dirX * y2) - (this.dirY * x2);
  }
}

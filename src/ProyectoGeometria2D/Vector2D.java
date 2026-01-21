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

  public Vector2D(Punto2D p1, Punto2D p2) {
    this.dirX = p2.getX() - p1.getX();
    this.dirY = p2.getY() - p1.getY();
  }

  public void Ver_Datos_Vector2D() {
    System.out.println("Vector2D [dirX=" + dirX + ", dirY=" + dirY + "]");
  }

  public double ObtenerDirX() {
    return dirX;
  }

  public double ObtenerDirY() {
    return dirY;
  }

  public void CambiarDirX(double dirX) {
    this.dirX = dirX;
  }

  public void CambiarDirY(double dirY) {
    this.dirY = dirY;
  }

  public double Módulo_Vector2D() {
    return Math.sqrt(Math.pow(this.dirX, 2) + Math.pow(this.dirY, 2));
  }

  public void Normalizar_Vector2D() {
    double modulo = Módulo_Vector2D();
    if (modulo != 0) {
      this.dirX = this.dirX / modulo;
      this.dirY = this.dirY / modulo;
    }
  }

  public double Producto_escalar_Vector2D(Vector2D otro) {
    return (this.dirX * otro.ObtenerDirX()) + (this.dirY * otro.ObtenerDirY());
  }

  public double Producto_vectorial_Vector2D(Vector2D otro) {
    return (this.dirX * otro.ObtenerDirY()) - (this.dirY * otro.ObtenerDirX());
  }

  public Vector2D Producto_vector_escalar(double escalar) {
    return new Vector2D(this.dirX * escalar, this.dirY * escalar);
  }

  public Vector2D Sumar_Vector2D(Vector2D otro) {
    return new Vector2D(this.dirX + otro.ObtenerDirX(), this.dirY + otro.ObtenerDirY());
  }

  public boolean Vectores_Paralelos(Vector2D otro) {
    double productoVectorial = this.Producto_vectorial_Vector2D(otro);
    return Math.abs(productoVectorial) < 0.0001;
  }
}

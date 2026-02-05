package Trimestre2.Excepciones.RepasoExcepciones;

import Trimestre2.Excepciones.RepasoExcepciones.ExceptionsCirculo.*;
import Trimestre2.Excepciones.ProyectoGeometria2D.*;

public class Circulo {
  private Punto2D centro;
  private int r;

  // 1. Constructor por defecto
  public Circulo() {
    this.centro = new Punto2D(-1, -1);
    this.r = 0;
  }

  // 2. Centro (-1,-1) y radio entero
  public Circulo(int radio) throws RadioException {
    this.centro = new Punto2D(-1, -1);
    setRadio(radio); // Usamos el setter para centralizar la validación
  }

  // 3. Dos enteros para centro y uno para radio
  public Circulo(int x, int y, int radio) throws RadioException {
    this.centro = new Punto2D(x, y);
    if (radio < 0)
      throw new RadioException("El radio no puede ser negativo");
    this.r = radio;
  }

  // 4. Punto2D de entrada y radio entero
  public Circulo(Punto2D punto, int radio) throws RadioException {
    this.centro = punto;
    setRadio(radio);
  }

  // 5. Punto2D de entrada y radio como String
  public Circulo(Punto2D punto, String radioStr) throws RadioException {
    this.centro = punto;

    /*
     * * EXPLICACIÓN REGEX PARA RADIO:
     * "\\d+" -> Busca uno o más dígitos (0-9).
     * No incluimos "-" porque el enunciado dice que el radio no puede ser negativo.
     */
    if (radioStr == null || !radioStr.matches("\\d+")) {
      throw new RadioException("El radio '" + radioStr + "' no es un número entero positivo válido.");
    }

    this.r = Integer.parseInt(radioStr);
  }

  // 6.
  // Constructor que recibe todo como String (Centro x, Centro y, Radio)
  public Circulo(String xStr, String yStr, String radioStr) throws RadioException, CentroException {

    /*
     * * EXPLICACIÓN REGEX PARA COORDENADAS:
     * "-?\\d+"
     * -? -> El signo menos es opcional (el centro sí puede ser negativo).
     * \\d+ -> Uno o más dígitos.
     */
    String regexCoordenadas = "-?\\d+";

    if (xStr == null || !xStr.matches(regexCoordenadas) ||
        yStr == null || !yStr.matches(regexCoordenadas)) {
      throw new CentroException("Las coordenadas del centro deben ser números enteros.");
    }

    // Si el centro es válido, validamos el radio con el mismo criterio anterior
    if (radioStr == null || !radioStr.matches("\\d+")) {
      throw new RadioException("El radio debe ser un número entero no negativo.");
    }

    // Una vez validados por Regex, el parseInt es seguro y no saltará
    // NumberFormatException
    this.centro = new Punto2D(Double.parseDouble(xStr), Double.parseDouble(yStr));
    this.r = Integer.parseInt(radioStr);
  }

  // ... (Resto de métodos: area, longitud, distancia...) ...

  // 7. Constructor de copia
  public Circulo(Circulo otro) {
    this.centro = otro.getCentro();
    this.r = otro.getRadio();
  }

  // --- MÉTODOS DE ACCESO ---

  public Punto2D getCentro() {
    return centro;
  }

  public int getRadio() {
    return r;
  }

  public void setCentro(Punto2D punto) {
    this.centro = punto;
  }

  public void setCentro(int x, int y) {
    this.centro = new Punto2D(x, y);
  }

  public void setRadio(int radio) throws RadioException {
    if (radio < 0)
      throw new RadioException("Radio negativo");
    this.r = radio;
  }

  public void setCirculo(int x, int y, int radio) throws RadioException {
    this.centro = new Punto2D(x, y);
    setRadio(radio);
  }

  public void setCirculo(Circulo otro) {
    this.centro = otro.centro;
    this.r = otro.r;
  }

  public void setCirculo(Punto2D punto, int radio) throws RadioException {
    this.centro = punto;
    setRadio(radio);
  }

  // --- MÉTODOS ---

  @Override
  public String toString() {
    return "Centro: " + centro.toString() + " Radio: " + r;
  }

  public boolean equals(Circulo otro) {
    return this.r == otro.r &&
        this.centro.getX() == otro.centro.getX() &&
        this.centro.getY() == otro.centro.getY();
  }

  public boolean equals(int radio, Punto2D punto) {
    return this.r == radio &&
        this.centro.getX() == punto.getX() &&
        this.centro.getY() == punto.getY();
  }

  public boolean equals(int x, int y, int radio) {
    return this.r == radio &&
        this.centro.getX() == x &&
        this.centro.getY() == y;
  }

  public double area() {
    return Math.PI * Math.pow(r, 2);
  }

  public double longitud() {
    return 2 * Math.PI * r;
  }

  public void ampliaCirculo(int cantidad) throws RadioException {
    setRadio(this.r + cantidad);
  }

  // --- DISTANCIAS ---

  public double distancia(Circulo otro) {
    return calcularDistancia(otro.centro.getX(), otro.centro.getY());
  }

  public double distancia(Punto2D punto) {
    return calcularDistancia(punto.getX(), punto.getY());
  }

  public double distancia(int x, int y) {
    return calcularDistancia(x, y);
  }

  // Método privado auxiliar para no repetir código de Pitágoras
  private double calcularDistancia(double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - centro.getX(), 2) + Math.pow(y2 - centro.getY(), 2));
  }
}

package EjerciciosPOO1;

public class Coche {
  private int numPuertas;
  private int precio;
  private String marca;
  private String modelo;
  private String color;
  private String combustible;
  private String transmision;

  public Coche() {
    this.numPuertas = 3;
    this.precio = 0;
    this.marca = " ";
    this.color = " ";
    this.modelo = " ";
    this.combustible = "Gasolina";
    this.transmision = "Manual";
  }

  public int getNumPuertas() {
    return numPuertas;
  }

  public void setNumPuertas(int numPuertas) {
    this.numPuertas = numPuertas;
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    this.precio = precio;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getCombustible() {
    return combustible;
  }

  public void setCombustible(String combustible) {
    this.combustible = combustible;
  }

  public String getTransmision() {
    return transmision;
  }

  public void setTransmision(String transmision) {
    this.transmision = transmision;
  }

  public Coche(int puertas, int precio, String marca, String color, String modelo, String combusible,
      String transimision) {
    this.numPuertas = puertas;
    this.precio = precio;
    this.marca = marca;
    this.color = color;
    this.modelo = modelo;
    this.combustible = combustible;
    this.transmision = transmision;

  }

  public static void main(String[] args) {
    System.out.println("Hello");
  }
}

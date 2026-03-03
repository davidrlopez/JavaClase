package Trimestre2.Excepciones.EjerciciosPOO1;

import static Trimestre2.Excepciones.EjerciciosPOO1.ExcepcionesCoche.*;

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

  public void setNumPuertas(int numP) throws PuertasException {
    if (numP < 3 || numP > 6) {
      throw new PuertasException("Numero de puertas no valido: " + numP);
    } else {
      this.numPuertas = numP;
    }
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int pr) throws PrecioException {
    if (pr < 0) {
      throw new PrecioException("Precio negativo: " + pr);
    } else {
      this.precio = pr;
    }
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

  public void setCombustible(String comb) throws CombustibleException {
    if (comb.toUpperCase() == "GASOLINA" || comb.toUpperCase() == "DIESEL") {
      this.combustible = comb;
    } else {
      throw new CombustibleException("Solo GASOLINA o DIESEL");
    }
  }

  public String getTransmision() {
    return transmision;
  }

  public void setTransmision(String tran) throws CambioException {
    if (tran.toUpperCase() == "MANUAL" || tran.toUpperCase() == "AUTOMATICO") {
      this.transmision = tran;
    } else {
      throw new CambioException("Solo MANUAL o AUTOMATICO");
    }
  }

  public void setCoche(int puertas, int precio, String marca, String color, String modelo, String combustible,
      String transmision) throws PuertasException, PrecioException, CombustibleException, CambioException {
    this.setNumPuertas(puertas);
    this.setPrecio(precio);
    this.setMarca(marca);
    this.setModelo(modelo);
    this.setColor(color);
    this.setCombustible(combustible);
    this.setTransmision(transmision);
  }

  public Coche(int puertas, int precio, String marca, String color, String modelo, String combustible,
      String transmision) throws PuertasException, PrecioException, CombustibleException, CambioException {
    this.setCoche(puertas, precio, marca, color, modelo, combustible, transmision);
  }

  public Coche(Coche c) {
    this.numPuertas = c.getNumPuertas();
    this.precio = c.getPrecio();
    this.marca = c.getMarca();
    this.color = c.getColor();
    this.modelo = c.getModelo();
    this.combustible = c.getCombustible();
    this.transmision = c.getTransmision();

  }

  @Override
  public String toString() {
    return "Coche{" +
        "numPuertas=" + numPuertas +
        ", precio=" + precio +
        ", marca='" + marca + '\'' +
        ", modelo='" + modelo + '\'' +
        ", color='" + color + '\'' +
        ", combustible='" + combustible + '\'' +
        ", transmision='" + transmision + '\'' +
        '}';
  }

  public void verDatos() {
    System.out.println("---------------------");
    System.out.println("Marca:" + this.getMarca());
    System.out.println("Modelo:" + this.getModelo());
    System.out.println("Color:" + this.getColor());
    System.out.println("Precio" + this.getPrecio());
    System.out.println("Numero de puertas" + this.getNumPuertas());
    System.out.println("Combustible" + this.getCombustible());
    System.out.println("Transmision" + this.getTransmision());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Coche coche = (Coche) o;
    return numPuertas == coche.numPuertas &&
        precio == coche.precio &&
        marca.equals(coche.marca) &&
        modelo.equals(coche.modelo) &&
        color.equals(coche.color) &&
        combustible.equals(coche.combustible) &&
        transmision.equals(coche.transmision);
  }

  @Override
  public int hashCode() {
    int result = numPuertas;
    result = 31 * result + precio;
    result = 31 * result + marca.hashCode();
    result = 31 * result + modelo.hashCode();
    result = 31 * result + color.hashCode();
    result = 31 * result + combustible.hashCode();
    result = 31 * result + transmision.hashCode();
    return result;
  }

  public static void main(String[] args) {
    Coche c1 = new Coche();
    Coche c2 = new Coche();
    c1.verDatos();
    c2.verDatos();

    System.out.println("--- Test de Excepciones Personalizadas ---");

    // Test 1: Intentar crear un coche con numero de puertas no valido
    try {
      System.out.println("Intentando crear coche con 1 puerta...");
      Coche cFallido = new Coche(1, 18000, "Ford", "Rojo", "Focus", "GASOLINA", "MANUAL");
      // Si la linea anterior no lanza excepcion, llegamos aqui (fallo del test)
      System.out.println("ERROR: El coche se creó y no debería.");
      System.out.println(cFallido);
    } catch (PuertasException e) {
      System.out.println("Excepción capturada correctamente: " + e.getMessage());
    } catch (PrecioException e) {
      System.out.println("Excepción inesperada de precio: " + e.getMessage());
    } catch (CombustibleException e) {
      System.out.println("Excepcion en el combustible: " + e.getMessage());
    } catch (CambioException e) {
      System.out.println("Excepcion en el cambio" + e.getMessage());
    }

    // Test 2: Intentar crear un coche con precio negativo
    try {
      System.out.println("Intentando crear coche con precio incorrecto...");
      Coche cFallido2 = new Coche(3, -20000, "Renault", "Amarillo", "Megane", "GASOLINA", "MANUAL");
      // Si la linea anterior no lanza excepcion, llegamos aqui (fallo del test)
      System.out.println("ERROR: El coche se creó y no debería.");
      System.out.println(cFallido2);
    } catch (PrecioException e) {
      System.out.println("Excepción capturada correctamente: " + e.getMessage());
    } catch (PuertasException e) {
      System.out.println("Excepción inesperada de puertas: " + e.getMessage());
    } catch (CombustibleException e) {
      System.out.println("Excepcion en el combustible: " + e.getMessage());
    } catch (CambioException e) {
      System.out.println("Excepcion en el cambio" + e.getMessage());
    }
    try {
      System.out.println("Intentando crear coche con combustible incorrecto...");
      Coche cFallido3 = new Coche(3, 10000, "Dacia", "Negro", "Sandero", "GASOFA", "MANUAL");
      // Si la linea anterior no lanza excepcion, llegamos aqui (fallo del test)
      System.out.println("ERROR: El coche se creó y no debería.");
      System.out.println(cFallido3);
    } catch (PrecioException e) {
      System.out.println("Excepción capturada correctamente: " + e.getMessage());
    } catch (PuertasException e) {
      System.out.println("Excepción inesperada de puertas: " + e.getMessage());
    } catch (CombustibleException e) {
      System.out.println("Excepcion en el combustible: " + e.getMessage());
    } catch (CambioException e) {
      System.out.println("Excepcion en el cambio" + e.getMessage());
    }
    try {
      System.out.println("Intentando crear coche con cambio incorrecto...");
      Coche cFallido4 = new Coche(3, 12000, "Citroen", "Blanco", "C3", "GASOLINA", "MANUALITCO");
      // Si la linea anterior no lanza excepcion, llegamos aqui (fallo del test)
      System.out.println("ERROR: El coche se creó y no debería.");
      System.out.println(cFallido4);
    } catch (PrecioException e) {
      System.out.println("Excepción capturada correctamente: " + e.getMessage());
    } catch (PuertasException e) {
      System.out.println("Excepción inesperada de puertas: " + e.getMessage());
    } catch (CombustibleException e) {
      System.out.println("Excepcion en el combustible: " + e.getMessage());
    } catch (CambioException e) {
      System.out.println("Excepcion en el cambio" + e.getMessage());
    }

  }
}

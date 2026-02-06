package Trimestre2.Excepciones.RepasoExcepciones;

import static Trimestre2.Excepciones.RepasoExcepciones.ExceptionsCoche.*;

public class Coche {

  private int numPuertas = 3;
  private int precio = 0;
  private String marca = "";
  private String modelo = "";
  private String color = "";
  private String combustible = "GASOLINA";
  private String cambio = "MANUAL";

  public int getPuertas() {
    return this.numPuertas;
  }

  public void setPuertas(int n) throws PuertasException {
    if (n != 3 || n != 4 || n != 5 || n != 6) {
      throw new PuertasException("Las puertas solo pueden ser 3,4,5,6");
    }
    this.numPuertas = n;
  }

  public int getPrecio() {
    return this.precio;
  }

  public void setPrecio(int n) throws PrecioException {
    if (n < 0) {
      throw new PrecioException("El precio no puede ser negativo");
    }
    this.precio = n;
  }

  public String getMarca() {
    return this.marca;
  }

  public void setMarca(String s) throws MarcaException {
    String regexMarca = "^[a-zA-Z]+$";
    if (s == null || !s.trim().matches(regexMarca)) {
      throw new MarcaException("Las marcas no contienen numeros");
    }
    this.marca = s;
  }

  public String getModelo() {
    return this.modelo;
  }

  public void setModelo(String s) {
    this.modelo = s;
  }

  public String getCombustible() {
    return this.combustible;
  }

  public void setCombustible(String s) throws CombustibleException {
    if (s.trim().toUpperCase() != "GASOLINA" || s.trim().toUpperCase() != "DIESEL") {
      throw new CombustibleException("Solo se acepta GASOLINA O DIESEL");
    }
    this.combustible = s;
  }

  public String getCambio() {
    return this.cambio;
  }

  public void setCambio(String s) throws CambioException {
    if (s.trim().toUpperCase() != "MANUAL" || s.trim().toUpperCase() != "AUTOMATICO") {
      throw new CambioException("Solo se acepta MANUAL o AUTOMATICO");
    }
    this.cambio = s;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String s) {
    this.color = s;
  }

  public Coche() throws CambioException, CombustibleException, PrecioException, PuertasException {

  }

  public Coche(int pu, int pre, String ma, String mo, String co, String comb, String camb)
      throws PuertasException, PrecioException, MarcaException, CombustibleException, CambioException {
    setPuertas(pu);
    setPrecio(pre);
    setMarca(ma);
    setModelo(mo);
    setColor(co);
    setCombustible(comb);
    setCambio(camb);
  }

  public Coche(Coche otro)
      throws PuertasException, PrecioException, MarcaException, CombustibleException, CambioException {
    setPuertas(otro.numPuertas);
    setPrecio(otro.precio);
    setMarca(otro.marca);
    setModelo(otro.modelo);
    setColor(otro.color);
    setCombustible(otro.combustible);
    setCambio(otro.cambio);
  }

  @Override
  public String toString() {
    return "Puertas:" + this.numPuertas + " Precio:" + this.precio + " Marca:" + this.marca + " Modelo:" + this.modelo
        + " Color:" + this.color + " Combustible:" + this.combustible + " Cambio:" + this.cambio;
  }

  public boolean equals(Coche otro) {
    if (otro == null) {
      return false;
    }
    return this.numPuertas == otro.numPuertas &&
        this.precio == otro.precio &&
        this.marca.equals(otro.marca) &&
        this.modelo.equals(otro.modelo) &&
        this.color.equals(otro.color) &&
        this.combustible.equals(otro.combustible) &&
        this.cambio.equals(otro.cambio);
  }
}

package TareaHerenciasII.Vehiculo;

import TareaHerenciasII.Fecha.Fecha;
import static TareaHerenciasII.FechaExceptions.FechasException.*;
import static TareaHerenciasII.VehiculoExceptions.VehiculoExceptions.*;

public class Vehiculo {

  protected String modelo = "";
  protected int precio = 0;
  protected Fecha fechaCompra;

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) throws PrecioIncorrecto {
    if (precio < 0) {
      throw new PrecioIncorrecto("Precio no puede ser nulo o negativo");
    }
    this.precio = precio;
  }

  public Fecha getFechaCompra() {
    return fechaCompra;
  }

  public void setFechaCompra(Fecha fechaCompra) {
    this.fechaCompra = fechaCompra;
  }

  public void setFechaCompra(int dia, int mes, int anio)
      throws DiaException, MesException, YearException {
    this.setFechaCompra(new Fecha(dia, mes, anio));
  }

  public Vehiculo(String modelo, int precio, Fecha fechaCompra) throws PrecioIncorrecto {
    setModelo(modelo);
    setPrecio(precio);
    setFechaCompra(fechaCompra);
  }

  public Vehiculo(String modelo, int precio, int dia, int mes, int anio)
      throws PrecioIncorrecto, DiaException, MesException, YearException {
    setModelo(modelo);
    setPrecio(precio);
    setFechaCompra(dia, mes, anio);
  }

  public Vehiculo(Vehiculo otro) throws PrecioIncorrecto {
    setModelo(otro.modelo);
    setPrecio(otro.precio);
    setFechaCompra(otro.fechaCompra);
  }

  public Vehiculo() throws PrecioIncorrecto, DiaException, MesException, YearException {
    setModelo(modelo);
    setFechaCompra(new Fecha());
    setPrecio(precio);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
    result = prime * result + precio;
    result = prime * result + ((fechaCompra == null) ? 0 : fechaCompra.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vehiculo other = (Vehiculo) obj;
    if (modelo == null) {
      if (other.modelo != null)
        return false;
    } else if (!modelo.equals(other.modelo))
      return false;
    if (precio != other.precio)
      return false;
    if (fechaCompra == null) {
      if (other.fechaCompra != null)
        return false;
    } else if (!fechaCompra.equals(other.fechaCompra))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Vehiculo [modelo=" + modelo + ", precio=" + precio + ", fechaCompra=" + fechaCompra + "]";
  }

}

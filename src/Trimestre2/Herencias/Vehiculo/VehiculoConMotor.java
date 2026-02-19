package Trimestre2.Herencias.Vehiculo;

import Trimestre2.Excepciones.RepasoExcepciones.Fecha;
import static Trimestre2.Excepciones.RepasoExcepciones.FechasException.*;
import static Trimestre2.Herencias.Vehiculo.VehiculoExceptions.*;

public class VehiculoConMotor extends Vehiculo {

  private int potencia = 0;

  public int getPotencia() {
    return potencia;
  }

  public void setPotencia(int potencia) throws PotenciaIncorrecta {
    if (potencia < 0) {
      throw new PotenciaIncorrecta("La potencia no puede ser negativa");
    }
    this.potencia = potencia;
  }

  public VehiculoConMotor(int potencia) throws PotenciaIncorrecta, PrecioIncorrecto, DiaException, MesException, YearException {
    super();
    setPotencia(potencia);
  }

  public VehiculoConMotor(String modelo, int precio, Fecha fechaCompra, int potencia)
      throws PotenciaIncorrecta, PrecioIncorrecto {
    super(modelo, precio, fechaCompra);
    setPotencia(potencia);
  }

  public VehiculoConMotor(String modelo, int precio, int dia, int mes, int anio, int potencia)
      throws PotenciaIncorrecta, PrecioIncorrecto, DiaException, MesException, YearException {
    super(modelo, precio, dia, mes, anio);
    setPotencia(potencia);
  }

  public VehiculoConMotor(Vehiculo otro, int potencia) throws PotenciaIncorrecta, PrecioIncorrecto {
    super(otro);
    setPotencia(potencia);
  }

  public VehiculoConMotor(VehiculoConMotor otro) throws PotenciaIncorrecta, PrecioIncorrecto {
    super(otro);
    setPotencia(otro.getPotencia());
  }

  public VehiculoConMotor() throws PotenciaIncorrecta, PrecioIncorrecto, DiaException, MesException, YearException {
    super();
    setPotencia(potencia);
  }

  public void setVehiculoConMotor(String modelo, int precio, Fecha fechaCompra, int potencia)
      throws PotenciaIncorrecta, PrecioIncorrecto {
    setModelo(modelo);
    setPrecio(precio);
    setFechaCompra(fechaCompra);
    setPotencia(potencia);
  }

  public void setVehiculoConMotor(String modelo, int precio, int dia, int mes, int anio, int potencia)
      throws PotenciaIncorrecta, PrecioIncorrecto, DiaException, MesException, YearException {
    setModelo(modelo);
    setPrecio(precio);
    setFechaCompra(dia, mes, anio);
    setPotencia(potencia);
  }

  public void setVehiculoConMotor(Vehiculo v, int potencia) throws PotenciaIncorrecta, PrecioIncorrecto {
    setModelo(v.getModelo());
    setPrecio(v.getPrecio());
    setFechaCompra(v.getFechaCompra());
    setPotencia(potencia);
  }

  public void setVehiculoConMotor(VehiculoConMotor v) throws PotenciaIncorrecta, PrecioIncorrecto {
    setModelo(v.getModelo());
    setPrecio(v.getPrecio());
    setFechaCompra(v.getFechaCompra());
    setPotencia(v.getPotencia());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + potencia;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    VehiculoConMotor other = (VehiculoConMotor) obj;
    if (potencia != other.potencia)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "VehiculoConMotor [potencia=" + potencia + ", " + super.toString() + "]";
  }

}

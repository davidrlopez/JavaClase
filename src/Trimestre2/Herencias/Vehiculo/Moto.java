package Trimestre2.Herencias.Vehiculo;

import java.util.Arrays;
import Trimestre2.Excepciones.RepasoExcepciones.Fecha;
import static Trimestre2.Excepciones.RepasoExcepciones.FechasException.*;
import static Trimestre2.Herencias.Vehiculo.VehiculoExceptions.*;

public class Moto extends VehiculoConMotor {
  private int[] kms = new int[0];
  private int[] gastos = new int[0];
  private String matricula = "";
  private String propietario = "";
  private int numRevisiones = 0;

  public int[] getKms() {
    return Arrays.copyOf(kms, kms.length);
  }

  public void setKms(int[] kms) {
    if (kms == null) {
      this.kms = new int[0];
      return;
    }
    this.kms = Arrays.copyOf(kms, kms.length);
  }

  public int[] getGastos() {
    return Arrays.copyOf(gastos, gastos.length);
  }

  public void setGastos(int[] gastos) {
    if (gastos == null) {
      this.gastos = new int[0];
      return;
    }
    this.gastos = Arrays.copyOf(gastos, gastos.length);
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getPropietario() {
    return propietario;
  }

  public void setPropietario(String propietario) {
    this.propietario = propietario;
  }

  public int getNumRevisiones() {
    return numRevisiones;
  }

  public void setNumRevisiones(int numRevisiones) throws RevisionesIncorrectas {
    if (numRevisiones < 0) {
      throw new RevisionesIncorrectas("Las revisiones no pueden ser negativas");
    }
    if (numRevisiones > kms.length || numRevisiones > gastos.length) {
      throw new RevisionesIncorrectas("El numero de revisiones supera los datos disponibles");
    }
    this.numRevisiones = numRevisiones;
  }

  public Moto()
      throws PrecioIncorrecto, PotenciaIncorrecta, DiaException, MesException, YearException, RevisionesIncorrectas {
    super();
    setKms(kms);
    setGastos(gastos);
    setMatricula(matricula);
    setPropietario(propietario);
    setNumRevisiones(numRevisiones);
  }

  public Moto(String modelo, int precio, int dia, int mes, int anio, int potencia, int[] kms, int[] gastos,
      String matricula, String propietario, int numRevisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, DiaException, MesException, YearException, RevisionesIncorrectas {
    super(modelo, precio, dia, mes, anio, potencia);
    setKms(kms);
    setGastos(gastos);
    setMatricula(matricula);
    setPropietario(propietario);
    setNumRevisiones(numRevisiones);
  }

  public Moto(String modelo, int precio, Fecha fechaCompra, int potencia, int[] kms, int[] gastos,
      String matricula, String propietario, int numRevisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(modelo, precio, fechaCompra, potencia);
    setKms(kms);
    setGastos(gastos);
    setMatricula(matricula);
    setPropietario(propietario);
    setNumRevisiones(numRevisiones);
  }

  public Moto(Vehiculo vehiculo, int potencia, int[] kms, int[] gastos, String matricula, String propietario,
      int numRevisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(vehiculo, potencia);
    setKms(kms);
    setGastos(gastos);
    setMatricula(matricula);
    setPropietario(propietario);
    setNumRevisiones(numRevisiones);
  }

  public Moto(VehiculoConMotor vehiculoMotor, int[] kms, int[] gastos, String matricula, String propietario,
      int numRevisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(vehiculoMotor);
    setKms(kms);
    setGastos(gastos);
    setMatricula(matricula);
    setPropietario(propietario);
    setNumRevisiones(numRevisiones);
  }

  public Moto(Moto otra)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(otra);
    setKms(otra.kms);
    setGastos(otra.gastos);
    setMatricula(otra.matricula);
    setPropietario(otra.propietario);
    setNumRevisiones(otra.numRevisiones);
  }

  public void setMoto(String modelo, int precio, int dia, int mes, int anio, int potencia, int[] kms, int[] gastos,
      String matricula, String propietario, int numRevisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, DiaException, MesException, YearException, RevisionesIncorrectas {
    setVehiculoConMotor(modelo, precio, dia, mes, anio, potencia);
    setKms(kms);
    setGastos(gastos);
    setMatricula(matricula);
    setPropietario(propietario);
    setNumRevisiones(numRevisiones);
  }

  public void setMoto(String modelo, int precio, Fecha fechaCompra, int potencia, int[] kms, int[] gastos,
      String matricula, String propietario, int numRevisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    setVehiculoConMotor(modelo, precio, fechaCompra, potencia);
    setKms(kms);
    setGastos(gastos);
    setMatricula(matricula);
    setPropietario(propietario);
    setNumRevisiones(numRevisiones);
  }

  public void setMoto(Vehiculo vehiculo, int potencia, int[] kms, int[] gastos, String matricula, String propietario,
      int numRevisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    setVehiculoConMotor(vehiculo, potencia);
    setKms(kms);
    setGastos(gastos);
    setMatricula(matricula);
    setPropietario(propietario);
    setNumRevisiones(numRevisiones);
  }

  public void setMoto(VehiculoConMotor vehiculoMotor, int[] kms, int[] gastos, String matricula, String propietario,
      int numRevisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    setVehiculoConMotor(vehiculoMotor);
    setKms(kms);
    setGastos(gastos);
    setMatricula(matricula);
    setPropietario(propietario);
    setNumRevisiones(numRevisiones);
  }

  public void setMoto(Moto otra) throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    setMoto((VehiculoConMotor) otra, otra.kms, otra.gastos, otra.matricula, otra.propietario, otra.numRevisiones);
  }

  protected void ordenKms() {
    int limite = Math.min(numRevisiones, Math.min(kms.length, gastos.length));
    for (int i = 0; i < limite - 1; i++) {
      for (int j = 0; j < limite - i - 1; j++) {
        if (kms[j] > kms[j + 1]) {
          int auxKm = kms[j];
          kms[j] = kms[j + 1];
          kms[j + 1] = auxKm;

          int auxGasto = gastos[j];
          gastos[j] = gastos[j + 1];
          gastos[j + 1] = auxGasto;
        }
      }
    }
  }

  protected int lugarRevisionMasCara() {
    int limite = Math.min(numRevisiones, gastos.length);
    if (limite == 0) {
      return -1;
    }
    int posicion = 0;
    for (int i = 1; i < limite; i++) {
      if (gastos[i] > gastos[posicion]) {
        posicion = i;
      }
    }
    return posicion;
  }

  protected int posicionRevision(int posicion) throws RevisionesIncorrectas {
    int limite = Math.min(numRevisiones, kms.length);
    if (limite == 0) {
      throw new RevisionesIncorrectas("No hay revisiones registradas");
    }
    if (posicion < 0 || posicion >= limite) {
      throw new RevisionesIncorrectas("Posicion de revision fuera de rango");
    }
    return kms[posicion];
  }

  public void tenerRevision(int kmRevision, int gastoRevision) {
    kms = Arrays.copyOf(kms, kms.length + 1);
    gastos = Arrays.copyOf(gastos, gastos.length + 1);
    kms[kms.length - 1] = kmRevision;
    gastos[gastos.length - 1] = gastoRevision;
    numRevisiones++;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Arrays.hashCode(gastos);
    result = prime * result + Arrays.hashCode(kms);
    result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
    result = prime * result + numRevisiones;
    result = prime * result + ((propietario == null) ? 0 : propietario.hashCode());
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
    Moto other = (Moto) obj;
    if (!Arrays.equals(gastos, other.gastos))
      return false;
    if (!Arrays.equals(kms, other.kms))
      return false;
    if (matricula == null) {
      if (other.matricula != null)
        return false;
    } else if (!matricula.equals(other.matricula))
      return false;
    if (numRevisiones != other.numRevisiones)
      return false;
    if (propietario == null) {
      if (other.propietario != null)
        return false;
    } else if (!propietario.equals(other.propietario))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Moto [kms=" + Arrays.toString(kms) + ", gastos=" + Arrays.toString(gastos) + ", matricula=" + matricula
        + ", propietario=" + propietario + ", numRevisiones=" + numRevisiones + ", " + super.toString() + "]";
  }
}

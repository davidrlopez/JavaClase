package TareaHerenciasII.Vehiculo;

import java.util.Arrays;
import TareaHerenciasII.Fecha.Fecha;
import static TareaHerenciasII.FechaExceptions.FechasException.*;
import static TareaHerenciasII.VehiculoExceptions.VehiculoExceptions.*;
import TareaHerenciasII.Motor.VehiculoConMotor;
import TareaHerenciasII.Principal.Revision;

public class Moto extends VehiculoConMotor {
  private Revision[] listRevisiones = new Revision[0];
  private String matricula = "";
  private String propietario = "";
  private int numRevisiones = 0;

  public Revision[] getListRevisiones() {
    return Arrays.copyOf(listRevisiones, numRevisiones);
  }

  public void setListRevisiones(Revision[] listRevisiones) throws RevisionesIncorrectas {
    if (listRevisiones == null) {
      throw new RevisionesIncorrectas("El array de revisiones no puede ser null");
    }
    for (Revision revision : listRevisiones) {
      if (revision == null) {
        throw new RevisionesIncorrectas("No puede haber revisiones null en el array");
      }
    }
    this.listRevisiones = Arrays.copyOf(listRevisiones, listRevisiones.length);
    this.numRevisiones = listRevisiones.length;
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
    if (numRevisiones > listRevisiones.length) {
      throw new RevisionesIncorrectas("El numero de revisiones supera el tamaño del array");
    }
    this.numRevisiones = numRevisiones;
  }

  public Moto()
      throws PrecioIncorrecto, PotenciaIncorrecta, DiaException, MesException, YearException, RevisionesIncorrectas {
    super();
    setMatricula(matricula);
    setPropietario(propietario);
    setListRevisiones(new Revision[0]);
    setNumRevisiones(0);
  }

  public Moto(String modelo, int precio, Fecha fechaCompra, int potencia, String matricula, String propietario)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(modelo, precio, fechaCompra, potencia);
    setMatricula(matricula);
    setPropietario(propietario);
    setListRevisiones(new Revision[0]);
    setNumRevisiones(0);
  }

  public Moto(String modelo, int precio, int dia, int mes, int anio, int potencia, String matricula,
      String propietario)
      throws PrecioIncorrecto, PotenciaIncorrecta, DiaException, MesException, YearException, RevisionesIncorrectas {
    super(modelo, precio, dia, mes, anio, potencia);
    setMatricula(matricula);
    setPropietario(propietario);
    setListRevisiones(new Revision[0]);
    setNumRevisiones(0);
  }

  public Moto(String modelo, int precio, Fecha fechaCompra, int potencia, String matricula, String propietario,
      Revision[] revisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(modelo, precio, fechaCompra, potencia);
    setMatricula(matricula);
    setPropietario(propietario);
    setListRevisiones(revisiones);
  }

  public Moto(String modelo, int precio, int dia, int mes, int anio, int potencia, String matricula,
      String propietario, Revision[] revisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, DiaException, MesException, YearException, RevisionesIncorrectas {
    super(modelo, precio, dia, mes, anio, potencia);
    setMatricula(matricula);
    setPropietario(propietario);
    setListRevisiones(revisiones);
  }

  public Moto(Vehiculo vehiculo, int potencia, String matricula, String propietario)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(vehiculo, potencia);
    setMatricula(matricula);
    setPropietario(propietario);
    setListRevisiones(new Revision[0]);
    setNumRevisiones(0);
  }

  public Moto(Vehiculo vehiculo, int potencia, String matricula, String propietario, Revision[] revisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(vehiculo, potencia);
    setMatricula(matricula);
    setPropietario(propietario);
    setListRevisiones(revisiones);
  }

  public Moto(VehiculoConMotor vehiculoMotor, String matricula, String propietario)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(vehiculoMotor);
    setMatricula(matricula);
    setPropietario(propietario);
    setListRevisiones(new Revision[0]);
    setNumRevisiones(0);
  }

  public Moto(VehiculoConMotor vehiculoMotor, String matricula, String propietario, Revision[] revisiones)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(vehiculoMotor);
    setMatricula(matricula);
    setPropietario(propietario);
    setListRevisiones(revisiones);
  }

  public Moto(Moto otra)
      throws PrecioIncorrecto, PotenciaIncorrecta, RevisionesIncorrectas {
    super(otra);
    setMatricula(otra.matricula);
    setPropietario(otra.propietario);
    setListRevisiones(otra.listRevisiones);
  }

  public void ordenKms() {
    Revision[] ordenadas = Arrays.copyOf(listRevisiones, numRevisiones);
    for (int i = 0; i < ordenadas.length - 1; i++) {
      for (int j = 0; j < ordenadas.length - i - 1; j++) {
        if (ordenadas[j].getKms() > ordenadas[j + 1].getKms()) {
          Revision aux = ordenadas[j];
          ordenadas[j] = ordenadas[j + 1];
          ordenadas[j + 1] = aux;
        }
      }
    }
    this.listRevisiones = ordenadas;
  }

  protected int revisionMasCara() {
    if (numRevisiones == 0) {
      return -1;
    }
    int posicion = 0;
    for (int i = 1; i < numRevisiones; i++) {
      if (listRevisiones[i].getGastos() > listRevisiones[posicion].getGastos()) {
        posicion = i;
      }
    }
    return posicion;
  }

  protected int lugarRevisionMasCara() {
    return revisionMasCara();
  }

  public int getPosRevisionMasCara() {
    return revisionMasCara();
  }

  protected int posicionRevision(Revision revision) {
    if (numRevisiones == 0) {
      System.out.println("No hay revisiones registradas");
      return -1;
    }

    for (int i = 0; i < numRevisiones; i++) {
      if (listRevisiones[i].equals(revision)) {
        System.out.println("Revision encontrada en la posicion: " + i);
        return i;
      }
    }

    System.out.println("La revision no existe");
    return -1;
  }

  public void tenerRevision(Revision nuevaRevision) throws RevisionesIncorrectas {
    if (nuevaRevision == null) {
      throw new RevisionesIncorrectas("La revision no puede ser null");
    }
    listRevisiones = Arrays.copyOf(listRevisiones, numRevisiones + 1);
    listRevisiones[numRevisiones] = nuevaRevision;
    numRevisiones++;
  }

  public void tenerRevision(int kmRevision, int gastoRevision)
      throws KmsIncorrectos, GastosIncorrectos, RevisionesIncorrectas {
    tenerRevision(new Revision(kmRevision, gastoRevision));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Arrays.hashCode(listRevisiones);
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
    if (!Arrays.equals(listRevisiones, other.listRevisiones))
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
    return "Moto [listRevisiones=" + Arrays.toString(getListRevisiones()) + ", matricula=" + matricula
        + ", propietario=" + propietario + ", numRevisiones=" + numRevisiones + ", " + super.toString() + "]";
  }
}

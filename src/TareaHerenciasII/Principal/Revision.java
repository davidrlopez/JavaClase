package TareaHerenciasII.Principal;

import static TareaHerenciasII.VehiculoExceptions.VehiculoExceptions.*;

public class Revision {

  private int kms = 0;
  private double gastos = 0;

  public Revision() {
  }

  public Revision(int kms, double gastos) throws KmsIncorrectos, GastosIncorrectos {
    setKms(kms);
    setGastos(gastos);
  }

  public Revision(Revision otra) throws KmsIncorrectos, GastosIncorrectos {
    this(otra.kms, otra.gastos);
  }

  public int getKms() {
    return kms;
  }

  public void setKms(int kms) throws KmsIncorrectos {
    if (kms < 0) {
      throw new KmsIncorrectos("Los kms no pueden ser negativos");
    }
    this.kms = kms;
  }

  public double getGastos() {
    return gastos;
  }

  public void setGastos(double gastos) throws GastosIncorrectos {
    if (gastos < 0) {
      throw new GastosIncorrectos("Los gastos no pueden ser negativos");
    }
    this.gastos = gastos;
  }

  @Override
  public String toString() {
    return "Revision [kms=" + kms + ", gastos=" + gastos + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Revision other = (Revision) obj;
    return kms == other.kms && Double.compare(gastos, other.gastos) == 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + kms;
    long temp = Double.doubleToLongBits(gastos);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}

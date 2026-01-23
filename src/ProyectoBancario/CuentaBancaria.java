package ProyectoBancario;

public class CuentaBancaria {
  // Attributes
  private String iban;
  private double saldo;
  private String dniPropietario;

  // Constructors
  public CuentaBancaria() {
    this.dniPropietario = "";
    this.iban = "";
    this.saldo = 0;
  }

  public CuentaBancaria(String iban, String dniPropietario, double saldo) {
    this.iban = iban;
    this.dniPropietario = dniPropietario;
    this.saldo = saldo;
  }

  // Methods returning current balance
  public double ingresar(double cantidad) {
    if (cantidad > 0) {
      saldo += cantidad;
    } else {
      System.out.println("Error: La cantidad a ingresar debe ser positiva.");
    }
    return saldo;
  }

  public double retirar(double cantidad) {
    if (cantidad > 0 && this.saldo >= cantidad) {
      saldo -= cantidad;
    } else {
      System.out.println("Error: Saldo insuficiente o cantidad no válida.");
    }
    return saldo;
  }

  public double transferir(CuentaBancaria destino, double cantidad, double comision) {
    double Tcomision = cantidad * comision;
    double totalRetirar = cantidad + Tcomision;

    if (this.saldo >= totalRetirar) {
      this.retirar(totalRetirar); // Subtracts amount + commission
      destino.ingresar(cantidad); // Adds amount to destination
      System.out.println("Transferencia realizada con éxito.");
    } else {
      System.out.println("Error: No hay saldo suficiente para la transferencia.");
    }
    return this.saldo;
  }

  public boolean tieneMasSaldoQue(CuentaBancaria otra) {
    return this.saldo > otra.getSaldo();
  }

  @Override
  public String toString() {
    return "CuentaBancaria { " +
        "IBAN='" + iban + "'" +
        ", Saldo=" + saldo +
        ", DNI='" + dniPropietario + "'" +
        " }";
  }

  // Getters and Setters
  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public String getDniPropietario() {
    return dniPropietario;
  }

  public void setDniPropietario(String dniPropietario) {
    this.dniPropietario = dniPropietario;
  }
}

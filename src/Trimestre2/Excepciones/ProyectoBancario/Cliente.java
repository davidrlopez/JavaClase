package Trimestre2.Excepciones.ProyectoBancario;

import java.util.Arrays;

public class Cliente {

  private String nombre;
  private String dni_propietario;
  private int num_cuentas;
  private CuentaBancaria cuenta[];
  private final static int num_maximo_cuentas = 10;

  public Cliente() {
    this.nombre = "";
    this.dni_propietario = "";
    this.num_cuentas = 0;
    this.cuenta = new CuentaBancaria[num_maximo_cuentas];
  }

  public Cliente(String nombre, String dni_propietario, int num_cuentas, CuentaBancaria cuenta[],
      int num_maximo_cuentas) {
    this.nombre = nombre;
    this.dni_propietario = dni_propietario;
    this.num_cuentas = num_cuentas;
    this.cuenta = cuenta;
  }

  @Override
  public String toString() {
    return "Cliente [nombre=" + nombre + ", dni_propietario=" + dni_propietario + ", num_cuentas=" + num_cuentas
        + ", cuenta=" + Arrays.toString(cuenta) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
        + ", toString()=" + super.toString() + "]";
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDni_propietario() {
    return dni_propietario;
  }

  public void setDni_propietario(String dni_propietario) {
    this.dni_propietario = dni_propietario;
  }

  public int getNum_cuentas() {
    return num_cuentas;
  }

  public void setNum_cuentas(int num_cuentas) {
    this.num_cuentas = num_cuentas;
  }

  public CuentaBancaria[] getCuenta() {
    return cuenta;
  }

  public void setCuenta(CuentaBancaria[] cuenta) {
    this.cuenta = cuenta;
  }

  public static int getNumMaximoCuentas() {
    return num_maximo_cuentas;
  }

  public double ingresarEnCuenta(int indice, double cantidad) {
    if (indice >= 0 && indice < num_cuentas && cuenta[indice] != null) {
      return this.cuenta[indice].ingresar(cantidad);
    }
    return -1;
  }

  public boolean ingresarEnCuenta(String iban, double cantidad) { // version mejor de clase con boolean e iban
    for (int i = 0; i < num_cuentas; i++) {
      if (this.cuenta[i].getIban() == iban) {
        this.cuenta[i].ingresar(cantidad);
        return true;
      }
    }
    System.out.println("Error en el iban");
    return false;
  }

  public double reintegroEnCuenta(int indice, double cantidad) {
    if (indice >= 0 && indice < num_cuentas && cuenta[indice] != null) {
      return this.cuenta[indice].retirar(cantidad);
    }
    return -1;
  }

  public boolean reintegroEnCuenta(String iban, double cantidad) { // version mejor de clase con boolean e iban
    for (int i = 0; i < num_cuentas; i++) {
      if (this.cuenta[i].getIban() == iban) {
        this.cuenta[i].retirar(cantidad);
        return true;
      }
    }
    System.out.println("Error en el iban");
    return false;
  }

  public double TransferenciaCuentaCuenta(CuentaBancaria destino, int indice, double cantidad, double comision) {
    if (destino != null && indice >= 0 && indice < num_cuentas && cuenta[indice] != null) {
      if (!destino.getDniPropietario().equals(this.cuenta[indice].getDniPropietario())) {
        comision = 0.01;
      }

      return this.cuenta[indice].transferir(destino, cantidad, comision);
    }
    return -1;
  }

  // Versiones booleanas para Cliente
  public boolean ingresarEnCuentaExito(int indice, double cantidad) {
    if (indice >= 0 && indice < num_cuentas && cuenta[indice] != null) {
      return this.cuenta[indice].ingresarExito(cantidad);
    }
    return false;
  }

  public boolean reintegroEnCuentaExito(int indice, double cantidad) {
    if (indice >= 0 && indice < num_cuentas && cuenta[indice] != null) {
      return this.cuenta[indice].retirarExito(cantidad);
    }
    return false;
  }

  public boolean TransferenciaCuentaCuentaExito(CuentaBancaria destino, int indice, double cantidad, double comision) {
    if (destino != null && indice >= 0 && indice < num_cuentas && cuenta[indice] != null) {
      if (!destino.getDniPropietario().equals(this.cuenta[indice].getDniPropietario())) {
        comision = 0.01;
      }
      return this.cuenta[indice].transferirExito(destino, cantidad, comision);
    }
    return false;
  }

  public boolean anadir_cuenta(CuentaBancaria c) {
    if (this.num_cuentas < Cliente.num_maximo_cuentas) {
      this.cuenta[this.num_cuentas] = c;
      this.num_cuentas++;
      System.out.println("Se ha creado la cuenta");
      return true;
    } else {
      System.out.println("No se ha podido crear la cuenta");
      return false;
    }
  }

  public boolean BorrarCuentas(CuentaBancaria destino, int indice) {
    if (destino == null || indice < 0 || indice >= num_cuentas || cuenta[indice] == null) {
      return false;
    }
    if (destino.getIban() != null && destino.getDniPropietario() != null) {
      double cantidad = this.cuenta[indice].getSaldo();
      double comision = 0;
      double resultado = TransferenciaCuentaCuenta(destino, indice, cantidad, comision);
      if (resultado != -1) {
        for (int i = indice; i < num_cuentas - 1; i++) {
          this.cuenta[i] = this.cuenta[i + 1];
        }
        this.cuenta[num_cuentas - 1] = null;
        this.num_cuentas--;
      } else {
        System.out.println("No se pudo realizar la transferencia");
        return false;
      }
    }
    System.out.println("Operacion completada");
    return true;

  }

  public double saldoTodasCuentas(String dni) {
    double saldoTotal = 0;
    if (dni == null || !dni.equals(this.dni_propietario)) {
      return -1;
    }
    for (int i = 0; i < num_cuentas; i++) {
      if (cuenta[i] != null) {
        saldoTotal += cuenta[i].getSaldo();
      }
    }
    return saldoTotal;
  }

  public CuentaBancaria maximaCuentaCliente() { // version calse superioir devolviendo objeto
    double saldo_max = 0;
    CuentaBancaria cta_max = null;
    for (int i = 0; i < this.num_cuentas; i++) {
      if (this.cuenta[i].getSaldo() > saldo_max) {
        saldo_max = this.cuenta[i].getSaldo();
        cta_max = this.cuenta[i];
      }
    }
    return cta_max;
  }

  public int maximaCuentaCliente(String dni) {
    if (dni == null || !dni.equals(this.dni_propietario) || num_cuentas == 0) {
      return -1;
    }
    int max = -1;
    for (int i = 0; i < num_cuentas; i++) {
      if (cuenta[i] != null) {
        if (max == -1 || cuenta[i].getSaldo() > cuenta[max].getSaldo()) {
          max = i;
        }
      }
    }
    return max;
  }

  public CuentaBancaria[] CuentasOrdenadas(String dni) {
    // Validamos que el DNI pasado sea el del dueño
    if (dni != null && dni.equals(this.dni_propietario)) {

      CuentaBancaria[] copia = Arrays.copyOf(this.cuenta, this.num_cuentas);
      Arrays.sort(copia, (c1, c2) -> Double.compare(c2.getSaldo(), c1.getSaldo()));
      return copia;

    } else {
      System.out.println("DNI no válido o no coincide.");
      return new CuentaBancaria[0]; // Devolvemos un array vacío en caso de error
    }
  }

  // CLASE
  /*
   * public boolean BorrarCuentaCliente(String iban) {
   * for (int i=0; i < this.num_cuentas;i++) {
   *
   * if (this.cuenta[i].getIban() == iban) {
   * this.cuenta[0].getSaldo(this.cuenta[0].getSaldo() +
   * this.cuenta[i].getSaldo());
   *
   * for (int j = i; j < Cliente.num_maximo_cuentas-1;j++) {
   *
   * this.cuenta[Cliente.num_maximo_cuentas-1] = null;
   * this.num_cuentas[j] = this.cuenta[j+1];
   * System.out.println("Cuenta borrada");
   * return true;
   * }
   *
   * }
   *
   * }
   * System.out.println("Error en la iban cuenta a borrar")
   * return false;
   * }
   *
   * public boolean Transferencia_cuenta_a_cuenta(Cliente cli_destino, String
   * iban_origen, String iban_destino, double cantidad)
   * {
   * for (int i = 0; i < this.Num_cuentas; i++)
   * {
   * if (this.cuentas[i].getIban() == iban_origen)
   * {
   * for (int j = 0; j < cli_destino.Num_cuentas; j++)
   * {
   * if (cli_destino.cuentas[j].getIban() == iban_destino)
   * {
   * return this.cuentas[i].transferencia(cli_destino.cuentas[j], cantidad);
   * }
   * }
   * System.out.println("Error en iban de destino, transferencia no realizada");
   * return false;
   * }
   * }
   * System.out.println("Error en iban de origen, transferencia no realizada");
   * return false;
   * }
   * }
   */
}

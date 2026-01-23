package ProyectoBancario;

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

  public double reintegroEnCuenta(int indice, double cantidad) {
    if (indice >= 0 && indice < num_cuentas && cuenta[indice] != null) {
      return this.cuenta[indice].retirar(cantidad);
    }
    return -1;
  }

  public double TransferenciaCuentaCuenta(CuentaBancaria destino, int indice, double cantidad, double comision) {
    if (indice >= 0 && indice < num_cuentas && cuenta[indice] != null) {
      if (destino.getDniPropietario() != this.cuenta[indice].getDniPropietario()) {
        comision = 0.01;
      }

      return this.cuenta[indice].transferir(destino, cantidad, comision);
    }
    return -1;
  }

  public boolean BorrarCuentas(CuentaBancaria destino, int indice) {
    if (indice < 0 || indice >= num_cuentas || cuenta[indice] == null) {
      return false;
    }
    if (destino.getIban() != null && destino.getDniPropietario() != null) {
      double cantidad = this.cuenta[indice].getSaldo();
      double comision = 0;
      double resultado = TransferenciaCuentaCuenta(destino, indice, cantidad, comision);
      if (resultado != -1) {
        this.cuenta[indice] = null;
      } else {
        System.out.println("No se pudo realizar la transferencia");
        return false;
      }
    }
    System.out.println("Operacion completada");
    return true;

  }

  public double saldoTodasCuentas(String dni) {
    this.dni_propietario = dni;
    double saldoTotal = 0;
    if (dni != null) {
      for (int i = 0; i < cuenta.length; i++) {
        saldoTotal += cuenta[i].getSaldo();
      }
    }
    return saldoTotal;
  }

  public int maximaCuentaCliente(String dni) {
    this.dni_propietario = dni;
    int max = 0;
    if (dni != null) {
      for (int i = 0; i < cuenta.length; i++) {
        if (max > cuenta[i].getSaldo()) {
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
}

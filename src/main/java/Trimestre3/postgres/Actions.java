package Trimestre3.postgres;

import java.util.ArrayList;

public class Actions {

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

    public boolean TransferenciaCuentaCuentaExito(CuentaBancaria destino, int indice, double cantidad,
            double comision) {
        if (destino != null && indice >= 0 && indice < num_cuentas && cuenta[indice] != null) {
            if (!destino.getDniPropietario().equals(this.cuenta[indice].getDniPropietario())) {
                comision = 0.01;
            }
            return this.cuenta[indice].transferirExito(destino, cantidad, comision);
        }
        return false;
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

}

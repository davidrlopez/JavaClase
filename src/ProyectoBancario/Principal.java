package ProyectoBancario;

public class Principal {
    public static void main(String[] args) {
        // Create two accounts
        CuentaBancaria cuenta1 = new CuentaBancaria("ES001", "12345678A", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("ES002", "87654321B", 500);

        System.out.println("Saldo Inicial 1: " + cuenta1.getSaldo());
        System.out.println("Saldo Inicial 2: " + cuenta2.getSaldo());

        // Test Transfer
        System.out.println("\n--- Transfiriendo 200 de cuenta1 a cuenta2 ---");
        // Now transferir returns the current saldo of the source account
        double nuevoSaldo = cuenta1.transferir(cuenta2, 200);

        System.out.println("Saldo Final 1: " + nuevoSaldo); // Should be 798.0
        System.out.println("Saldo Final 2: " + cuenta2.getSaldo()); // Should be 700.0
    }
}

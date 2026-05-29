package Trimestre3.postgres;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import Trimestre3.postgres.Exceptions.WithdrawException;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final BankDao data;
    private final Inserts inserts;
    private final Actions actions;

    public Menu(Connection conn) throws SQLException {
        this.data = new BankDao(conn);
        this.inserts = new Inserts(conn);
        this.actions = new Actions(data);

    }

    public void run() throws SQLException {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    \n=== DATABANK ===
                    1. Bancos
                    2. Sucursales
                    3. Cuentas
                    4. Movimientos
                    5. Crear tablas SQL
                    6. Insertar inserts random
                    0. Salir
                    """);
            System.out.print("Opción: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> menuBanks();
                case "2" -> menuBranches();
                case "3" -> menuAccounts();
                case "4" -> menuMovements();
                case "5" -> createTables();
                case "6" -> inserts.randomTest();
                case "0" -> exit = true;
                default -> System.out.println("Opción no válida");
            }
        }
    }

    // ── TABLAS ────────────────────────────────────────────────────────────────

    private void createTables() {
        System.out.print("Ruta del archivo SQL [Enter para usar src/main/resources/sql/databank.sql]: ");
        String input = scanner.nextLine().trim();
        String route = input.isEmpty() ? "src/main/resources/sql/databank.sql" : input;

        try {
            inserts.importFile(route);
        } catch (IllegalArgumentException e) {
            System.err.println("Archivo no válido: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }

    // ── BANCOS ────────────────────────────────────────────────────────────────

    private void menuBanks() {
        System.out.println("""
                \n-- BANCOS --
                1. Ver todos
                2. Insertar
                3. Actualizar
                4. Eliminar
                0. Volver
                """);
        System.out.print("Opción: ");

        switch (scanner.nextLine().trim()) {
            case "1" -> {
                try {
                    data.getAllBanks();
                } catch (SQLException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "2" -> {
                try {
                    System.out.print("Código banco: ");
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("NF banco: ");
                    String nf = scanner.nextLine().trim();
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Domicilio fiscal: ");
                    String dom = scanner.nextLine().trim();
                    System.out.print("Población: ");
                    String pob = scanner.nextLine().trim();
                    if (data.insertBank(id, nf, name, dom, pob)) {
                        System.out.println("Banco insertado");
                    }
                } catch (SQLException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "3" -> {
                try {
                    System.out.print("Código banco a actualizar: ");
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("NF banco: ");
                    String nf = scanner.nextLine().trim();
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Domicilio fiscal: ");
                    String dom = scanner.nextLine().trim();
                    System.out.print("Población: ");
                    String pob = scanner.nextLine().trim();
                    if (data.updateBank(id, nf, name, dom, pob)) {
                        System.out.println("Banco actualizado");
                    } else {
                        System.out.println("No existe ese banco");
                    }
                } catch (SQLException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "4" -> {
                try {
                    System.out.print("Código banco a eliminar: ");
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    if (data.deleteBank(id)) {
                        System.out.println("Banco eliminado");
                    } else {
                        System.out.println("No existe ese banco");
                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "0" -> {
            }
            default -> System.out.println("Opción no válida");
        }
    }

    // ── SUCURSALES ────────────────────────────────────────────────────────────

    private void menuBranches() {
        System.out.println("""
                \n-- SUCURSALES --
                1. Ver todas
                2. Insertar
                3. Actualizar
                4. Eliminar
                0. Volver
                """);
        System.out.print("Opción: ");

        switch (scanner.nextLine().trim()) {
            case "1" -> {
                try {
                    data.getAllBranches();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "2" -> {
                try {
                    System.out.print("Código banco: ");
                    int idB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int idS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Localidad: ");
                    String loc = scanner.nextLine().trim();
                    System.out.print("Provincia: ");
                    String prov = scanner.nextLine().trim();
                    if (data.insertBranch(idB, idS, name, loc, prov)) {
                        System.out.println("Sucursal insertada");
                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "3" -> {
                try {
                    System.out.print("Código banco: ");
                    int idB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int idS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Localidad: ");
                    String loc = scanner.nextLine().trim();
                    System.out.print("Provincia: ");
                    String prov = scanner.nextLine().trim();
                    if (data.updateBranch(idB, idS, name, loc, prov)) {
                        System.out.println("Sucursal actualizada");
                    } else {
                        System.out.println("No existe esa sucursal");
                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "4" -> {
                try {
                    System.out.print("Código banco: ");
                    int idB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int idS = Integer.parseInt(scanner.nextLine().trim());
                    if (data.deleteBranch(idB, idS)) {
                        System.out.println("Sucursal eliminada");
                    } else {
                        System.out.println("No existe esa sucursal");
                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "0" -> {
            }
            default -> System.out.println("Opción no válida");
        }
    }

    // ── CUENTAS ───────────────────────────────────────────────────────────────

    private void menuAccounts() {
        System.out.println("""
                \n-- CUENTAS --
                1. Ver todas
                2. Retirar dinero
                3. Ingresar dinero
                4. Transferencia
                5. Insertar
                6. Eliminar
                7. Actualizar
                0. Volver
                """);
        System.out.print("Opción: ");

        switch (scanner.nextLine().trim()) {
            case "1" -> {
                try {
                    List<Accounts> accounts = data.getAllAccounts();
                    System.out.printf("%-10s | %-10s | %-10s | %-24s | %-10s | %-15s%n",
                            "BANK_ID", "BRANCH_ID", "ACC_NUM", "IBAN", "DNI", "BALANCE");
                    System.out.println("-".repeat(95));
                    for (Accounts account : accounts) {
                        System.out.printf("%-10d | %-10d | %-10s | %-24s | %-10s | %-15.2f%n",
                                account.getCodB(),
                                account.getCodS(),
                                account.getAccNum(),
                                account.getIban(),
                                account.getDni(),
                                account.getBalance());
                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "2" -> {
                try {
                    System.out.println("IBAN:");
                    String iban = scanner.nextLine().trim();
                    System.out.println("DNI:");
                    String dni = scanner.nextLine().trim();
                    System.out.println("Cantidad a retirar");
                    double withdraw = Double.parseDouble(scanner.nextLine().trim());
                    Accounts account = data.findAccountByIbanAndDni(iban, dni)
                            .orElseThrow(() -> new IllegalArgumentException("Cuenta o DNI incorrectos"));
                    actions.withdraw(account, withdraw);
                    System.out.println("Retirada realizada");
                } catch (SQLException | WithdrawException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "3" -> {
                try {
                    System.out.println("Cantidad a ingresar");
                    double deposit = Double.parseDouble(scanner.nextLine().trim());
                    System.out.println("IBAN:");
                    String iban = scanner.nextLine().trim();
                    Accounts account = data.findAccountByIban(iban)
                            .orElseThrow(() -> new IllegalArgumentException("Cuenta incorrecta"));
                    actions.deposit(account, deposit);
                    System.out.println("Ingreso realizado");
                } catch (SQLException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }

            case "4" -> {
                try {
                    System.out.println("Cuenta origen:");
                    System.out.println("IBAN:");
                    String iban = scanner.nextLine().trim();
                    System.out.println("DNI");
                    String dni = scanner.nextLine().trim();
                    Accounts origin = data.findAccountByIbanAndDni(iban, dni)
                            .orElseThrow(() -> new IllegalArgumentException("Cuenta o DNI incorrectos"));
                    System.out.println("Cuenta destino:");
                    System.out.println("IBAN:");
                    String ibanD = scanner.nextLine().trim();
                    Accounts destiny = data.findAccountByIban(ibanD)
                            .orElseThrow(() -> new IllegalArgumentException(
                                    "No se encuentra la cuenta o no esta disponible"));
                    System.out.println("Cantidad a transferir:");
                    double amount = Double.parseDouble(scanner.nextLine().trim());
                    actions.transaction(origin, destiny, amount);
                    System.out.println("Transferencia realizada");
                } catch (SQLException | WithdrawException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "5" -> {
                try {
                    System.out.print("Código banco: ");
                    int idB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int idS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("DNI titular: ");
                    String dni = scanner.nextLine().trim();
                    System.out.print("Saldo inicial: ");
                    double amount = Double.parseDouble(scanner.nextLine().trim());
                    Accounts account = data.createAccount(idB, idS, dni, amount);
                    System.out.println("Cuenta insertada: " + account.getIban());
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "6" -> {
                try {
                    System.out.print("Código banco: ");
                    int idB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int idS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Número de cuenta: ");
                    String accNum = scanner.nextLine().trim();
                    if (data.deleteAccount(idB, idS, accNum)) {
                        System.out.println("Cuenta eliminada");
                    } else {
                        System.out.println("No existe esa cuenta");
                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "7" -> {
                try {
                    System.out.print("IBAN: ");
                    String iban = scanner.nextLine().trim();
                    System.out.println("DNI dueño: ");
                    String dni = scanner.nextLine().trim();
                    System.out.print("Saldo: ");
                    double amount = Double.parseDouble(scanner.nextLine().trim());
                    Accounts account = data.findAccountByIbanAndDni(iban, dni)
                            .orElseThrow(() -> new IllegalArgumentException("Cuenta o DNI incorrectos"));
                    if (data.updateAccount(account.getIban(), amount)) {
                        System.out.println("Cuenta actualizada");
                    } else {
                        System.out.println("No existe esa cuenta");
                    }
                } catch (SQLException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "0" -> {
            }
            default -> System.out.println("Opción no válida");
        }
    }

    // ── MOVIMIENTOS ───────────────────────────────────────────────────────────

    private void menuMovements() {
        System.out.println("""
                \n-- MOVIMIENTOS --
                1. Ver todos
                2. Insertar
                3. Eliminar
                0. Volver
                """);
        System.out.print("Opción: ");

        switch (scanner.nextLine().trim()) {
            case "1" -> {
                try {
                    data.getAllMovements();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "2" -> {
                try {
                    System.out.print("Num operación: ");
                    long numOperac = Long.parseLong(scanner.nextLine().trim());
                    System.out.print("Código banco: ");
                    int idBank = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int idBranch = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Número cuenta: ");
                    String accNum = scanner.nextLine().trim();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    Date fecha;
                    try {
                        LocalDate localDate = LocalDate.parse(scanner.nextLine().trim(),
                                DateTimeFormatter.ISO_LOCAL_DATE);
                        fecha = Date.valueOf(localDate);
                    } catch (DateTimeParseException e) {
                        System.err.println("Formato de fecha incorrecto. Usa YYYY-MM-DD (ej: 2024-03-15)");
                        return;
                    }
                    System.out.print("Cantidad: ");
                    double amount = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Tipo operación: ");
                    String tipo = scanner.nextLine().trim();
                    System.out.print("Observación: ");
                    String observacion = scanner.nextLine().trim();
                    if (data.insertMovement(numOperac, idBank, idBranch, accNum, amount, tipo, observacion)) {
                        System.out.println("Movimiento insertado");
                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "3" -> {
                try {
                    System.out.print("Num operación a eliminar: ");
                    int numOp = Integer.parseInt(scanner.nextLine().trim());
                    if (data.deleteMovement(numOp)) {
                        System.out.println("Movimiento eliminado");
                    } else {
                        System.out.println("No existe ese movimiento");
                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "0" -> {
            }
            default -> System.out.println("Opción no válida");
        }
    }
}

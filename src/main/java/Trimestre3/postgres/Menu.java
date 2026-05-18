package Trimestre3.postgres;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final BankDao data;
    private final Inserts inserts;

    public Menu(Connection conn) {
        this.data = new BankDao(conn);
        this.inserts = new Inserts(conn);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    \n=== DATABANK ===
                    1. Crear tablas desde SQL
                    2. Bancos
                    3. Sucursales
                    4. Cuentas
                    5. Movimientos
                    0. Salir
                    """);
            System.out.print("Opción: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> createTables();
                case "2" -> menuBanks();
                case "3" -> menuBranches();
                case "4" -> menuAccounts();
                case "5" -> menuMovements();
                case "0" -> exit = true;
                default -> System.out.println("Opción no válida");
            }
        }
    }

    // ── TABLAS ────────────────────────────────────────────────────────────────

    private void createTables() {
        System.out.print("Ruta del archivo SQL [Enter para usar sql/databank.sql]: ");
        String input = scanner.nextLine().trim();
        String route = input.isEmpty() ? "sql/databank.sql" : input;

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
                } catch (SQLException e) {
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
                } catch (SQLException e) {
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
                } catch (SQLException e) {
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
                2. Insertar
                3. Eliminar
                4. Actualizar
                0. Volver
                """);
        System.out.print("Opción: ");

        switch (scanner.nextLine().trim()) {
            case "1" -> {
                try {
                    List<Accounts> accounts = data.getAllAccounts();
                    System.out.printf("%-10s | %-10s | %-10s | %-24s | %-10s | %-15s%n",
                            "COD_BANCO", "COD_SUCUR", "NUM_CTA", "IBAN", "DNI", "SALDO");
                    System.out.println("-".repeat(95));
                    for (Accounts account : accounts) {
                        System.out.printf("%-10d | %-10d | %-10d | %-24s | %-10s | %-15.2f%n",
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
            case "3" -> {
                try {
                    System.out.print("Código banco: ");
                    int idB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int idS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Número de cuenta: ");
                    long accNum = Long.parseLong(scanner.nextLine().trim());
                    if (data.deleteAccount(idB, idS, accNum)) {
                        System.out.println("Cuenta eliminada");
                    } else {
                        System.out.println("No existe esa cuenta");
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
                    System.out.print("Número de cuenta: ");
                    long accNum = Long.parseLong(scanner.nextLine().trim());
                    System.out.println("DNI dueño: ");
                    String dni = scanner.nextLine().trim();
                    System.out.print("Saldo: ");
                    double amount = Double.parseDouble(scanner.nextLine().trim());
                    if (data.updateAccount(idB, idS, accNum, dni, amount)) {
                        System.out.println("Cuenta actualizada");
                    } else {
                        System.out.println("No existe esa cuenta");
                    }
                } catch (Exception e) {
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
                    int numOp = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código banco: ");
                    int idB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int idS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Número cuenta: ");
                    long accNum = Long.parseLong(scanner.nextLine().trim());
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
                    String obs = scanner.nextLine().trim();
                    if (data.insertMovement(numOp, idB, idS, accNum, fecha, amount, tipo, obs)) {
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

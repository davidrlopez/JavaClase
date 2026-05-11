package Trimestre3.postgres;

import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Data data;
    private final Inserts inserts;

    public Menu(Connection conn) {
        this.data = new Data(conn);
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
                    int cod = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("NF banco: ");
                    String nf = scanner.nextLine().trim();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    System.out.print("Domicilio fiscal: ");
                    String dom = scanner.nextLine().trim();
                    System.out.print("Población: ");
                    String pob = scanner.nextLine().trim();
                    data.insertBank(cod, nf, nombre, dom, pob);
                    System.out.println("Banco insertado");
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "3" -> {
                try {
                    System.out.print("Código banco a actualizar: ");
                    int cod = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("NF banco: ");
                    String nf = scanner.nextLine().trim();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    System.out.print("Domicilio fiscal: ");
                    String dom = scanner.nextLine().trim();
                    System.out.print("Población: ");
                    String pob = scanner.nextLine().trim();
                    data.updateBank(cod, nf, nombre, dom, pob);
                    System.out.println("Banco actualizado");
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "4" -> {
                try {
                    System.out.print("Código banco a eliminar: ");
                    int cod = Integer.parseInt(scanner.nextLine().trim());
                    data.deleteBank(cod);
                    System.out.println("Banco eliminado");
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
                    int codB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int codS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    System.out.print("Localidad: ");
                    String loc = scanner.nextLine().trim();
                    System.out.print("Provincia: ");
                    String prov = scanner.nextLine().trim();
                    data.insertBranch(codB, codS, nombre, loc, prov);
                    System.out.println("Sucursal insertada");
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "3" -> {
                try {
                    System.out.print("Código banco: ");
                    int codB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int codS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    System.out.print("Localidad: ");
                    String loc = scanner.nextLine().trim();
                    System.out.print("Provincia: ");
                    String prov = scanner.nextLine().trim();
                    data.updateBranch(codB, codS, nombre, loc, prov);
                    System.out.println("Sucursal actualizada");
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "4" -> {
                try {
                    System.out.print("Código banco: ");
                    int codB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int codS = Integer.parseInt(scanner.nextLine().trim());
                    data.deleteBranch(codB, codS);
                    System.out.println("Sucursal eliminada");
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
                0. Volver
                """);
        System.out.print("Opción: ");

        switch (scanner.nextLine().trim()) {
            case "1" -> {
                try {
                    data.getAllAccounts();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "2" -> {
                try {
                    System.out.print("Código banco: ");
                    int codB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int codS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Número de cuenta: ");
                    int numCta = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("DNI titular: ");
                    String dni = scanner.nextLine().trim();
                    System.out.print("Saldo inicial: ");
                    double saldo = Double.parseDouble(scanner.nextLine().trim());
                    data.insertAccount(codB, codS, numCta, dni, saldo);
                    System.out.println("Cuenta insertada");
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "3" -> {
                try {
                    System.out.print("Código banco: ");
                    int codB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int codS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Número de cuenta: ");
                    int numCta = Integer.parseInt(scanner.nextLine().trim());
                    data.deleteAccount(codB, codS, numCta);
                    System.out.println("Cuenta eliminada");
                } catch (SQLException e) {
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
                    int codB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Código sucursal: ");
                    int codS = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Número cuenta: ");
                    int numCta = Integer.parseInt(scanner.nextLine().trim());
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
                    double cantidad = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Tipo operación: ");
                    String tipo = scanner.nextLine().trim();
                    System.out.print("Observación: ");
                    String obs = scanner.nextLine().trim();
                    data.insertMovement(numOp, codB, codS, numCta, fecha, cantidad, tipo, obs);
                    System.out.println("Movimiento insertado");
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            case "3" -> {
                try {
                    System.out.print("Num operación a eliminar: ");
                    int numOp = Integer.parseInt(scanner.nextLine().trim());
                    data.deleteMovement(numOp);
                    System.out.println("Movimiento eliminado");
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

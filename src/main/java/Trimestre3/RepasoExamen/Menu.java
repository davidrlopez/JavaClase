package Trimestre3.RepasoExamen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner input = new Scanner(System.in);
    private final Connection conn;

    public Menu(Connection conn) {
        this.conn = conn;
    }

    public void run() {
        int option;
        do {
            mostrarMenu();
            option = leerEntero("Opcion: ");

            try {
                switch (option) {
                    case 1:
                        crearTablas();
                        break;
                    case 2:
                        insertarDatosIniciales();
                        break;
                    case 3:
                        insertarDepartamentoManual();
                        break;
                    case 4:
                        insertarEmpleadoManual();
                        break;
                    case 5:
                        mostrarEmpleadosDepartamento();
                        break;
                    case 6:
                        mostrarSueldoDepartamento();
                        break;
                    case 7:
                        eliminarDepartamento();
                        break;
                    case 8:
                        subirSueldoEmpleadosDeJefe();
                        break;
                    case 9:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
            }
        } while (option != 9);
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("1-Crear Tablas");
        System.out.println("2-Insertar Auto");
        System.out.println("3-Insertar Departamento Manual");
        System.out.println("4-Insertar Empleado Manual");
        System.out.println("5-Mostrar empleados de un departamento");
        System.out.println("6-Sueldo total de un departamento");
        System.out.println("7-Eliminar departamento y sus empleados");
        System.out.println("8-Subir sueldo a empleados de un jefe");
        System.out.println("9-Salir");
    }

    private void crearTablas() throws SQLException {
        String departamento = "CREATE TABLE IF NOT EXISTS Departamento ("
                + "COD_DEPART INT PRIMARY KEY, "
                + "NOM_DEPART VARCHAR(10), "
                + "JEFE_DEPART VARCHAR(8), "
                + "DIRECCION VARCHAR(35), "
                + "ACTIVIDAD VARCHAR(35)"
                + ")";

        String empleado = "CREATE TABLE IF NOT EXISTS Empleado ("
                + "DNI VARCHAR(8) PRIMARY KEY, "
                + "NOM_EMPLE VARCHAR(30), "
                + "DIRECCION VARCHAR(35), "
                + "SUELDO DOUBLE, "
                + "COD_DEPART INT, "
                + "JEFE VARCHAR(8), "
                + "FOREIGN KEY (COD_DEPART) REFERENCES Departamento(COD_DEPART), "
                + "FOREIGN KEY (JEFE) REFERENCES Empleado(DNI)"
                + ")";

        try (Statement st = conn.createStatement()) {
            st.executeUpdate(departamento);
            st.executeUpdate(empleado);
        }

        System.out.println("Tablas creadas");
    }

    private void insertarDatosIniciales() throws SQLException {
        conn.setAutoCommit(false);
        try {
            insertarDepartamento(10, "VENTAS", "11111111", "Calle Mayor 1", "Comercial");
            insertarDepartamento(20, "INFOR", "22222222", "Calle Luna 2", "Sistemas");
            insertarDepartamento(30, "RRHH", "33333333", "Calle Sol 3", "Personal");

            insertarEmpleado("11111111", "Ana Lopez", "Calle A", 2200, 10, null);
            insertarEmpleado("22222222", "Luis Perez", "Calle B", 2400, 20, null);
            insertarEmpleado("33333333", "Marta Ruiz", "Calle C", 2300, 30, null);
            insertarEmpleado("44444444", "Juan Gil", "Calle D", 1500, 10, "11111111");
            insertarEmpleado("55555555", "Sara Cano", "Calle E", 1600, 10, "11111111");
            insertarEmpleado("66666666", "Pablo Mora", "Calle F", 1700, 20, "22222222");
            insertarEmpleado("77777777", "Nora Diaz", "Calle G", 1750, 20, "22222222");
            insertarEmpleado("88888888", "Ivan Rey", "Calle H", 1450, 30, "33333333");
            insertarEmpleado("99999999", "Leo Sanz", "Calle I", 1550, 30, "33333333");
            insertarEmpleado("00000000", "Eva Rios", "Calle J", 1800, 20, "22222222");

            conn.commit();
            System.out.println("Datos iniciales insertados");
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    private void insertarDepartamentoManual() throws SQLException {
        int codigo = leerEntero("Codigo departamento: ");
        String nombre = leerTexto("Nombre departamento: ");
        String jefe = leerTexto("Jefe departamento: ");
        String direccion = leerTexto("Direccion: ");
        String actividad = leerTexto("Actividad: ");

        insertarDepartamento(codigo, nombre, jefe, direccion, actividad);
        System.out.println("Departamento insertado");
    }

    private void insertarEmpleadoManual() throws SQLException {
        String dni = leerTexto("DNI: ");
        String nombre = leerTexto("Nombre empleado: ");
        String direccion = leerTexto("Direccion: ");
        double sueldo = leerDouble("Sueldo: ");
        int departamento = leerEntero("Codigo departamento: ");
        String jefe = leerTexto("DNI jefe, vacio si no tiene: ");

        insertarEmpleado(dni, nombre, direccion, sueldo, departamento, jefe.trim().isEmpty() ? null : jefe);
        System.out.println("Empleado insertado");
    }

    private void mostrarEmpleadosDepartamento() throws SQLException {
        int departamento = leerEntero("Codigo departamento: ");
        String sql = "SELECT DNI, NOM_EMPLE, DIRECCION, SUELDO, COD_DEPART, JEFE "
                + "FROM Empleado "
                + "WHERE COD_DEPART = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departamento);
            try (ResultSet rs = ps.executeQuery()) {
                boolean hayDatos = false;
                while (rs.next()) {
                    hayDatos = true;
                    mostrarEmpleado(rs);
                }
                if (!hayDatos) {
                    System.out.println("No hay empleados en ese departamento");
                }
            }
        }
    }

    private void mostrarSueldoDepartamento() throws SQLException {
        int departamento = leerEntero("Codigo departamento: ");
        String sql = "SELECT SUM(SUELDO) FROM Empleado WHERE COD_DEPART = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departamento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Sueldo total: " + rs.getDouble(1));
                }
            }
        }
    }

    private void eliminarDepartamento() throws SQLException {
        int departamento = leerEntero("Codigo departamento: ");
        List<String> dnis = buscarDnisDepartamento(departamento);

        conn.setAutoCommit(false);
        try {
            for (String dni : dnis) {
                quitarJefe(dni);
            }

            int empleadosBorrados;
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM Empleado WHERE COD_DEPART = ?")) {
                ps.setInt(1, departamento);
                empleadosBorrados = ps.executeUpdate();
            }

            int departamentosBorrados;
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM Departamento WHERE COD_DEPART = ?")) {
                ps.setInt(1, departamento);
                departamentosBorrados = ps.executeUpdate();
            }

            conn.commit();
            System.out.println("Departamentos borrados: " + departamentosBorrados);
            System.out.println("Empleados borrados: " + empleadosBorrados);
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    private void subirSueldoEmpleadosDeJefe() throws SQLException {
        String jefe = leerTexto("DNI del jefe: ");

        try (PreparedStatement ps = conn.prepareStatement("UPDATE Empleado SET SUELDO = SUELDO * 1.05 WHERE JEFE = ?")) {
            ps.setString(1, jefe);
            int filas = ps.executeUpdate();
            System.out.println("Empleados actualizados: " + filas);
        }

        String sql = "SELECT DNI, NOM_EMPLE, DIRECCION, SUELDO, COD_DEPART, JEFE "
                + "FROM Empleado "
                + "WHERE JEFE = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, jefe);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    mostrarEmpleado(rs);
                }
            }
        }
    }

    private void insertarDepartamento(int codigo, String nombre, String jefe, String direccion, String actividad)
            throws SQLException {
        String sql = "INSERT INTO Departamento "
                + "(COD_DEPART, NOM_DEPART, JEFE_DEPART, DIRECCION, ACTIVIDAD) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, jefe);
            ps.setString(4, direccion);
            ps.setString(5, actividad);
            ps.executeUpdate();
        }
    }

    private void insertarEmpleado(String dni, String nombre, String direccion, double sueldo, int departamento, String jefe)
            throws SQLException {
        String sql = "INSERT INTO Empleado "
                + "(DNI, NOM_EMPLE, DIRECCION, SUELDO, COD_DEPART, JEFE) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setDouble(4, sueldo);
            ps.setInt(5, departamento);
            ps.setString(6, jefe);
            ps.executeUpdate();
        }
    }

    private List<String> buscarDnisDepartamento(int departamento) throws SQLException {
        List<String> dnis = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement("SELECT DNI FROM Empleado WHERE COD_DEPART = ?")) {
            ps.setInt(1, departamento);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    dnis.add(rs.getString("DNI"));
                }
            }
        }

        return dnis;
    }

    private void quitarJefe(String dni) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE Empleado SET JEFE = NULL WHERE JEFE = ?")) {
            ps.setString(1, dni);
            ps.executeUpdate();
        }
    }

    private void mostrarEmpleado(ResultSet rs) throws SQLException {
        System.out.println(
                rs.getString("DNI") + " | " +
                        rs.getString("NOM_EMPLE") + " | " +
                        rs.getString("DIRECCION") + " | " +
                        rs.getDouble("SUELDO") + " | Departamento: " +
                        rs.getInt("COD_DEPART") + " | Jefe: " +
                        rs.getString("JEFE"));
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero decimal");
            }
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return input.nextLine().trim();
    }
}

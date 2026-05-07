package Trimestre3.postgres;

import java.sql.*;

public class Data {

    private final Connection conn;

    public Data(Connection conn) {
        this.conn = conn;
    }

    public void insertPersonaje(String nombre, String apellido1, String apellido2, double sueldo) throws SQLException {
        String sql = "INSERT INTO personajes (nombre, apellido1, apellido2, sueldo) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, apellido1);
        ps.setString(3, apellido2); // null si no tiene
        ps.setDouble(4, sueldo);
        ps.executeUpdate();
        ps.close();
    }

    public void getAllPersonajes() throws SQLException {
        String sql = "SELECT * FROM personajes";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.printf("%-4d | %-10s | %-10s | %-10s | %.2f%n",
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2") != null ? rs.getString("apellido2") : "<null>",
                    rs.getDouble("sueldo"));
        }
        rs.close();
        stmt.close();
    }

    public void updatePersonaje(int id, String nombre, String apellido1, String apellido2, double sueldo)
            throws SQLException {
        String sql = "UPDATE personajes SET nombre = ?, apellido1 = ?, apellido2 = ?, sueldo = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, apellido1);
        ps.setString(3, apellido2);
        ps.setDouble(4, sueldo);
        ps.setInt(5, id);
        ps.executeUpdate();
        ps.close();
    }

    public void deletePersonaje(int id) throws SQLException {
        String sql = "DELETE FROM personajes WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }
}

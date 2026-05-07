package Trimestre3.postgres;

import java.sql.*;

public class Data {

    private final Connection conn;

    public Data(Connection conn) {
        this.conn = conn;
    }

    public void insertPersonaje(String nombre, String email) throws SQLException {
        String sql = "INSERT INTO personajes (nombre, email) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, email);
        ps.executeUpdate();
        ps.close();
    }

    public void getAllPersonajes() throws SQLException {
        String sql = "SELECT * FROM personajes";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " + rs.getString("nombre") + " | " + rs.getString("email"));
        }
        rs.close();
        stmt.close();
    }

    public void updatePersonaje(int id, String nombre, String email) throws SQLException {
        String sql = "UPDATE personajes SET nombre = ?, email = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, email);
        ps.setInt(3, id);
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

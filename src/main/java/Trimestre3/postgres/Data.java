package Trimestre3.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class Data {
    private final Connection conn;

    public Data(Connection conn) {
        this.conn = conn;
    }

    public ResultSet getUsuario(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeQuery();
    }

    public void insertUsuario(String nombre, String email) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, email);
        ps.executeUpdate();
    }
}

package repository;

import db.Database;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<User> findAll() throws Exception {
        List<User> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement st = Database.getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new User(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")));
            }
        }
        return usuarios;
    }

    public void save(User u) throws Exception {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try (PreparedStatement ps = Database.getConnection().prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.executeUpdate();
        }
    }
}

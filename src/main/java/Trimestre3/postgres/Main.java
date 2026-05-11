package Trimestre3.postgres;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Properties props = new Properties();
        props.load(new FileInputStream(".properties"));

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        System.out.println("Connecting: " + url);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected");
            new Menu(conn).run();
        } catch (SQLException e) {
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error: " + e.getMessage());

            switch (e.getSQLState()) {
                case "08001", "08006" -> System.err.println("Server unreachable");
                case "28P01" -> System.err.println("Wrong credentials");
                case "3D000" -> System.err.println("DB doesn't exist");
                case "42P01" -> System.err.println("Table doesn't exist");
                default -> System.err.println("Unknown error: " + e.getSQLState());
            }
        }
    }
}

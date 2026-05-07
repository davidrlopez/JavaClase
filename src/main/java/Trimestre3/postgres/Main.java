package Trimestre3.postgres;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://100.72.238.39:5432/myapp";
        String usuario = "dev";
        String password = "dev";

        System.out.println("Connecting: " + url);

        try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
            System.out.println("Connected");
            Data data = new Data(conn);

            // INSERT
            data.insertPersonaje("Alice", "alice@test.com");
            data.insertPersonaje("Bob", "bob@test.com");
            System.out.println("Users inserted");

            // SELECT ALL
            System.out.println("\n-- All users --");
            data.getAllPersonajes();

            // UPDATE
            data.updatePersonaje(1, "Alice Updated", "alice_new@test.com");
            System.out.println("Personaje 1 updated");

            // SELECT ALL again
            System.out.println("\n-- After update --");
            data.getAllPersonajes();

            // DELETE
            data.deletePersonaje(2);
            System.out.println("Personaje 2 deleted");

            // SELECT ALL again
            System.out.println("\n-- After delete --");
            data.getAllPersonajes();

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            if (e.getMessage().contains("Connection refused")) {
                System.err.println("Server down");
            } else if (e.getMessage().contains("pg_hba.conf")) {
                System.err.println("Bridge connection problem");
            }
        }
    }
}

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
            data.insertPersonaje("Kratos", "Esparta", null, 9999.99);
            data.insertPersonaje("Samus", "Aran", null, 7500.00);
            System.out.println("Personajes inserted");

            // SELECT ALL
            System.out.println("\n-- All personajes --");
            data.getAllPersonajes();

            // UPDATE
            data.updatePersonaje(5, "Don", "Quijote", "Mancha", 100.00);
            System.out.println("\nPersonaje 5 updated");

            // SELECT ALL
            System.out.println("\n-- After update --");
            data.getAllPersonajes();

            // DELETE
            data.deletePersonaje(6);
            System.out.println("\nPersonaje 6 deleted");

            // SELECT ALL
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

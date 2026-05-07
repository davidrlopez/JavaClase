package Trimestre3.postgres;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://100.72.238.39:5432/myapp";
        String usuario = "dev";
        String password = "dev";

        System.out.println("Connenting: " + url);

        try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

            System.out.println("Connected");

            Data data = new Data(conn);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());

            if (e.getMessage().contains("Connection refused")) {
                System.err.println("server down");
            } else if (e.getMessage().contains("pg_hba.conf")) {
                System.err.println("Brige connection problem");
            }
        }
    }
}

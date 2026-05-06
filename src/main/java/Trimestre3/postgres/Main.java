package Trimestre3.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        // --- 1. CONFIGURA ESTOS DATOS ---
        // Sustituye por la IP de Tailscale (100.x.x.x) del servidor (Mac o Linux) donde
        // está PostgreSQL
        String ipTailscale = "100.72.238.39";
        String puerto = "5432";
        String nombreBaseDatos = "postgres";
        String usuario = "dev";
        String password = "dev";

        // --- 2. CADENA DE CONEXIÓN ---
        String url = "jdbc:postgresql://" + ipTailscale + ":" + puerto + "/" + nombreBaseDatos;

        System.out.println("Intentando conectar a: " + url);

        // --- 3. CONECTAR Y PROBAR ---
        try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

            if (conn != null) {
                System.out.println("✅ ¡Conexión exitosa a PostgreSQL a través de Tailscale!");

                // Vamos a hacer una consulta rápida para comprobar que podemos leer datos
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT version();"); // Consulta que devuelve la versión de PostgreSQL

                if (rs.next()) {
                    System.out.println("Versión del servidor: " + rs.getString(1));
                }

                // Cerramos recursos
                rs.close();
                stmt.close();
            } else {
                System.out.println("❌ Fallo al realizar la conexión.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error de conexión con la base de datos.");
            System.err.println("Motivo: " + e.getMessage());

            // Pistas para solucionar errores comunes:
            if (e.getMessage().contains("Connection refused")) {
                System.err.println(
                        "PISTA: El servidor está apagado, la IP de Tailscale es incorrecta, o el Firewall del servidor está bloqueando el puerto 5432.");
            } else if (e.getMessage().contains("pg_hba.conf") || e.getMessage().contains("no pg_hba.conf entry")) {
                System.err.println(
                        "PISTA: PostgreSQL te está bloqueando. Debes configurar el archivo pg_hba.conf en tu servidor para permitir la IP de Tailscale.");
            }
        }
    }
}

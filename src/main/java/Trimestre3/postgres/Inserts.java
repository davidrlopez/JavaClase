package Trimestre3.postgres;

import java.sql.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.io.InputStream;

public class Inserts {

    private final Connection conn;

    public Inserts(Connection conn) {
        this.conn = conn;
    }

    public void importFile(String route) throws SQLException {
        InputStream is = Inserts.class.getClassLoader().getResourceAsStream(route);

        if (is == null) {
            throw new IllegalArgumentException("Archivo no encontrado en classpath: " + route);
        }

        String content;
        try {
            content = new String(is.readAllBytes());
        } catch (Exception e) {
            throw new SQLException("No se pudo leer el archivo: " + e.getMessage(), e);
        }

        content = Arrays.stream(content.split("\n"))
                .filter(line -> !line.stripLeading().startsWith("\\"))
                .collect(Collectors.joining("\n"));

        conn.setAutoCommit(false);
        try {
            for (String sql : content.split(";")) {
                String trimmed = sql.strip();
                if (trimmed.isEmpty() || trimmed.startsWith("--"))
                    continue;

                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(trimmed);
                }
            }
            conn.commit();
            System.out.println("Tablas creadas correctamente");

        } catch (SQLException e) {
            conn.rollback();
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error: " + e.getMessage());
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

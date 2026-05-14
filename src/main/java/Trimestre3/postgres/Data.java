package Trimestre3.postgres;

import java.sql.*;

public class Data {

    private final Connection conn;

    public Data(Connection conn) {
        this.conn = conn;
    }

    public void insertBank(int codBanco, String nfBanco, String nombre, String domFiscal, String poblacion)
            throws SQLException {
        String sql = "INSERT INTO BANK (COD_BANCO, NF_BANCO, NOMBRE_BANC, DOM_FISCAL, POBLACION) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codBanco);
            ps.setString(2, nfBanco);
            ps.setString(3, nombre);
            ps.setString(4, domFiscal);
            ps.setString(5, poblacion);
            ps.executeUpdate();
        }
    }

    public void getAllBanks() throws SQLException {
        String sql = "SELECT * FROM BANK";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-10s | %-10s | %-30s | %-35s | %-35s%n",
                    "COD", "NF", "NOMBRE", "DOM_FISCAL", "POBLACION");
            System.out.println("-".repeat(130));
            while (rs.next()) {
                System.out.printf("%-10d | %-10s | %-30s | %-35s | %-35s%n",
                        rs.getInt("COD_BANCO"),
                        rs.getString("NF_BANCO"),
                        rs.getString("NOMBRE_BANC"),
                        rs.getString("DOM_FISCAL"),
                        rs.getString("POBLACION"));
            }
        }
    }

    public void updateBank(int codBanco, String nfBanco, String nombre, String domFiscal, String poblacion)
            throws SQLException {
        String sql = "UPDATE BANK SET NF_BANCO=?, NOMBRE_BANC=?, DOM_FISCAL=?, POBLACION=? WHERE COD_BANCO=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nfBanco);
            ps.setString(2, nombre);
            ps.setString(3, domFiscal);
            ps.setString(4, poblacion);
            ps.setInt(5, codBanco);
            ps.executeUpdate();
        }
    }

    public void deleteBank(int codBanco) throws SQLException {
        String sql = "DELETE FROM BANK WHERE COD_BANCO=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codBanco);
            ps.executeUpdate();
        }
    }

    public void insertBranch(int codBanco, int codSucur, String nombre, String loc, String prov)
            throws SQLException {
        String sql = "INSERT INTO BRANCH (COD_BANCO, COD_SUCUR, NOMBRE_SUC, LOC_SUC, PROV_SUC) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codBanco);
            ps.setInt(2, codSucur);
            ps.setString(3, nombre);
            ps.setString(4, loc);
            ps.setString(5, prov);
            ps.executeUpdate();
        }
    }

    public void getAllBranches() throws SQLException {
        String sql = "SELECT * FROM BRANCH";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-10s | %-10s | %-35s | %-35s | %-35s%n",
                    "COD_BANCO", "COD_SUCUR", "NOMBRE", "LOCALIDAD", "PROVINCIA");
            System.out.println("-".repeat(130));
            while (rs.next()) {
                System.out.printf("%-10d | %-10d | %-35s | %-35s | %-35s%n",
                        rs.getInt("COD_BANCO"),
                        rs.getInt("COD_SUCUR"),
                        rs.getString("NOMBRE_SUC"),
                        rs.getString("LOC_SUC"),
                        rs.getString("PROV_SUC"));
            }
        }
    }

    public void updateBranch(int codBanco, int codSucur, String nombre, String loc, String prov)
            throws SQLException {
        String sql = "UPDATE BRANCH SET NOMBRE_SUC=?, LOC_SUC=?, PROV_SUC=? WHERE COD_BANCO=? AND COD_SUCUR=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, loc);
            ps.setString(3, prov);
            ps.setInt(4, codBanco);
            ps.setInt(5, codSucur);
            ps.executeUpdate();
        }
    }

    public void deleteBranch(int codBanco, int codSucur) throws SQLException {
        String sql = "DELETE FROM BRANCH WHERE COD_BANCO=? AND COD_SUCUR=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codBanco);
            ps.setInt(2, codSucur);
            ps.executeUpdate();
        }
    }

    public void insertAccount(int codBanco, int codSucur, int numCta, String dni, double saldo)
            throws SQLException {
        String sql = "INSERT INTO ACCOUNT (COD_BANCO, COD_SUCUR, NUM_CTA, DNI_DUENO, SALDO) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codBanco);
            ps.setInt(2, codSucur);
            ps.setInt(3, numCta);
            ps.setString(4, dni);
            ps.setDouble(5, saldo);
            ps.executeUpdate();
        }
    }

    public void getAllAccounts() throws SQLException {
        String sql = "SELECT * FROM ACCOUNT";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-15s%n",
                    "COD_BANCO", "COD_SUCUR", "NUM_CTA", "DNI", "SALDO");
            System.out.println("-".repeat(65));
            while (rs.next()) {
                System.out.printf("%-10d | %-10d | %-10d | %-10s | %-15.2f%n",
                        rs.getInt("COD_BANCO"),
                        rs.getInt("COD_SUCUR"),
                        rs.getInt("NUM_CTA"),
                        rs.getString("DNI_DUENO"),
                        rs.getDouble("SALDO"));
            }
        }
    }

    public void deleteAccount(int codBanco, int codSucur, int numCta) throws SQLException {
        String sql = "DELETE FROM ACCOUNT WHERE COD_BANCO=? AND COD_SUCUR=? AND NUM_CTA=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codBanco);
            ps.setInt(2, codSucur);
            ps.setInt(3, numCta);
            ps.executeUpdate();
        }
    }

    public void updateAccount(int codBanco, int codSucur, int numCta, String dni, double saldo)
            throws SQLException {
        String sql = "UPDATE ACCOUNT SET DNI_DUENO=?, SALDO=? WHERE COD_BANCO=? AND COD_SUCUR=? AND NUM_CTA=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codBanco);
            ps.setInt(2, codSucur);
            ps.setInt(3, numCta);
            ps.setString(4, dni);
            ps.setDouble(5, saldo);
            ps.executeUpdate();
        }
    }

    public void insertMovement(int numOperac, int codBanco, int codSucur, int numCta,
            Date fecha, double cantidad, String tipo, String observacion)
            throws SQLException {
        String sql = """
                INSERT INTO MOVEMENT
                (NUM_OPERAC, COD_BANCO, COD_SUCUR, NUM_CTA, FECHA, CANTIDAD, TIPO_OPERAC, OBSERVACION)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numOperac);
            ps.setInt(2, codBanco);
            ps.setInt(3, codSucur);
            ps.setInt(4, numCta);
            ps.setDate(5, fecha);
            ps.setDouble(6, cantidad);
            ps.setString(7, tipo);
            ps.setString(8, observacion);
            ps.executeUpdate();
        }
    }

    public void getAllMovements() throws SQLException {
        String sql = "SELECT * FROM MOVEMENT";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-12s | %-12s | %-20s | %-50s%n",
                    "NUM_OP", "COD_BANCO", "COD_SUCUR", "NUM_CTA", "FECHA", "CANTIDAD", "TIPO", "OBSERVACION");
            System.out.println("-".repeat(150));
            while (rs.next()) {
                System.out.printf("%-10d | %-10d | %-10d | %-10d | %-12s | %-12.2f | %-20s | %-50s%n",
                        rs.getInt("NUM_OPERAC"),
                        rs.getInt("COD_BANCO"),
                        rs.getInt("COD_SUCUR"),
                        rs.getInt("NUM_CTA"),
                        rs.getDate("FECHA"),
                        rs.getDouble("CANTIDAD"),
                        rs.getString("TIPO_OPERAC"),
                        rs.getString("OBSERVACION"));
            }
        }
    }

    public void deleteMovement(int numOperac) throws SQLException {
        String sql = "DELETE FROM MOVEMENT WHERE NUM_OPERAC=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numOperac);
            ps.executeUpdate();
        }
    }
}

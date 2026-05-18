package Trimestre3.postgres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankDao {

    private final Connection conn;

    public BankDao(Connection conn) {
        this.conn = conn;
    }

    private long getNextAccountNumber() throws SQLException {
        String sql = "SELECT nextval('account_num_cta_seq')";

        try (PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getLong(1);
        }
    }

    public boolean insertBank(int idBank, String nfBanco, String name, String domFiscal, String poblation)
            throws SQLException {
        String sql = "INSERT INTO BANK (COD_BANCO, NF_BANCO, NOMBRE_BANC, DOM_FISCAL, POBLACION) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            ps.setString(2, nfBanco);
            ps.setString(3, name);
            ps.setString(4, domFiscal);
            ps.setString(5, poblation);
            return ps.executeUpdate() > 0;
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

    public boolean updateBank(int idBank, String nfBanco, String name, String domFiscal, String poblation)
            throws SQLException {
        String sql = "UPDATE BANK SET NF_BANCO=?, NOMBRE_BANC=?, DOM_FISCAL=?, POBLACION=? WHERE COD_BANCO=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nfBanco);
            ps.setString(2, name);
            ps.setString(3, domFiscal);
            ps.setString(4, poblation);
            ps.setInt(5, idBank);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteBank(int idBank) throws SQLException {
        String sql = "DELETE FROM BANK WHERE COD_BANCO=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean insertBranch(int idBank, int idBranch, String name, String loc, String prov)
            throws SQLException {
        String sql = "INSERT INTO BRANCH (COD_BANCO, COD_SUCUR, NOMBRE_SUC, LOC_SUC, PROV_SUC) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            ps.setInt(2, idBranch);
            ps.setString(3, name);
            ps.setString(4, loc);
            ps.setString(5, prov);
            return ps.executeUpdate() > 0;
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

    public boolean updateBranch(int idBank, int idBranch, String name, String loc, String prov)
            throws SQLException {
        String sql = "UPDATE BRANCH SET NOMBRE_SUC=?, LOC_SUC=?, PROV_SUC=? WHERE COD_BANCO=? AND COD_SUCUR=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, loc);
            ps.setString(3, prov);
            ps.setInt(4, idBank);
            ps.setInt(5, idBranch);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteBranch(int idBank, int idBranch) throws SQLException {
        String sql = "DELETE FROM BRANCH WHERE COD_BANCO=? AND COD_SUCUR=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            ps.setInt(2, idBranch);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean existsBank(int idBank) throws SQLException {
        String sql = "SELECT 1 FROM BANK WHERE COD_BANCO=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean existsBranch(int idBank, int idBranch) throws SQLException {
        if (!existsBank(idBank)) {
            throw new IllegalArgumentException("That bank doesn't exist.");
        }

        String sql = "SELECT 1 FROM BRANCH WHERE COD_BANCO=? AND COD_SUCUR=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            ps.setInt(2, idBranch);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public Accounts createAccount(int idBank, int idBranch, String dni, double amount)
            throws SQLException {
        if (!existsBranch(idBank, idBranch)) {
            throw new IllegalArgumentException("That bank or branch doesn't exist.");
        }

        Accounts account = Accounts.createNew(idBank, idBranch, getNextAccountNumber(), dni, amount);
        insertAccount(account);
        return account;
    }

    public boolean insertAccount(Accounts account) throws SQLException {
        String sql = "INSERT INTO ACCOUNT (COD_BANCO, COD_SUCUR, NUM_CTA, IBAN, DNI_DUENO, SALDO) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, account.getCodB());
            ps.setInt(2, account.getCodS());
            ps.setLong(3, account.getAccNum());
            ps.setString(4, account.getIban());
            ps.setString(5, account.getDni());
            ps.setDouble(6, account.getBalance());
            return ps.executeUpdate() > 0;
        }
    }

    public List<Accounts> getAllAccounts() throws SQLException {
        String sql = "SELECT * FROM ACCOUNT";
        List<Accounts> accounts = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                accounts.add(new Accounts(
                        rs.getInt("COD_BANCO"),
                        rs.getInt("COD_SUCUR"),
                        rs.getLong("NUM_CTA"),
                        rs.getString("IBAN"),
                        rs.getString("DNI_DUENO"),
                        rs.getDouble("SALDO")));
            }
        }

        return accounts;
    }

    public boolean deleteAccount(int idBank, int idBranch, long accNum) throws SQLException {
        String sql = "DELETE FROM ACCOUNT WHERE COD_BANCO=? AND COD_SUCUR=? AND NUM_CTA=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            ps.setInt(2, idBranch);
            ps.setLong(3, accNum);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateAccount(int idBank, int idBranch, long accNum, String dni, double amount)
            throws SQLException {
        String sql = "UPDATE ACCOUNT SET DNI_DUENO=?, SALDO=? WHERE COD_BANCO=? AND COD_SUCUR=? AND NUM_CTA=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            ps.setDouble(2, amount);
            ps.setInt(3, idBank);
            ps.setInt(4, idBranch);
            ps.setLong(5, accNum);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean insertMovement(int numOperac, int idBank, int idBranch, long accNum,
            Date fecha, double amount, String tipo, String observacion)
            throws SQLException {
        String sql = """
                INSERT INTO MOVEMENT
                (NUM_OPERAC, COD_BANCO, COD_SUCUR, NUM_CTA, FECHA, CANTIDAD, TIPO_OPERAC, OBSERVACION)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numOperac);
            ps.setInt(2, idBank);
            ps.setInt(3, idBranch);
            ps.setLong(4, accNum);
            ps.setDate(5, fecha);
            ps.setDouble(6, amount);
            ps.setString(7, tipo);
            ps.setString(8, observacion);
            return ps.executeUpdate() > 0;
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
                        rs.getLong("NUM_CTA"),
                        rs.getDate("FECHA"),
                        rs.getDouble("CANTIDAD"),
                        rs.getString("TIPO_OPERAC"),
                        rs.getString("OBSERVACION"));
            }
        }
    }

    public boolean deleteMovement(int numOperac) throws SQLException {
        String sql = "DELETE FROM MOVEMENT WHERE NUM_OPERAC=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numOperac);
            return ps.executeUpdate() > 0;
        }
    }
}

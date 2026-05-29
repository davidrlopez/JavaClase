package Trimestre3.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankDao {

    private final Connection conn;

    public BankDao(Connection conn) {
        this.conn = conn;
    }

    public long getNextAccountNumber() throws SQLException {
        String sql = "SELECT nextval('account_numSEQ')";

        try (PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getLong(1);
        }
    }

    public long getNextMovementNumber() throws SQLException {
        String sql = "SELECT nextval('movement_numSEQ')";

        try (PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getLong(1);
        }
    }

    public boolean insertBank(int idBank, String nfBanco, String name, String domFiscal, String poblation)
            throws SQLException {
        String sql = "INSERT INTO BANK (BANK_ID, BANK_NF, BANK_NAME, DOM_FISCAL, POBLATION) VALUES (?, ?, ?, ?, ?)";
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
                    "BANK_ID", "BANK_NF", "BANK_NAME", "DOM_FISCAL", "POBLATION");
            System.out.println("-".repeat(130));
            while (rs.next()) {
                System.out.printf("%-10d | %-10s | %-30s | %-35s | %-35s%n",
                        rs.getInt("BANK_ID"),
                        rs.getString("BANK_NF"),
                        rs.getString("BANK_NAME"),
                        rs.getString("DOM_FISCAL"),
                        rs.getString("POBLATION"));
            }
        }
    }

    public boolean updateBank(int idBank, String nfBanco, String name, String domFiscal, String poblation)
            throws SQLException {
        String sql = "UPDATE BANK SET BANK_NF=?, BANK_NAME=?, DOM_FISCAL=?, POBLATION=? WHERE BANK_ID=?";
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
        String sql = "DELETE FROM BANK WHERE BANK_ID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean insertBranch(int idBank, int idBranch, String name, String loc, String prov)
            throws SQLException {
        String sql = "INSERT INTO BRANCH (BANK_ID, BRANCH_ID, BRANCH_NAME, BRANCH_LOC, SUC_PROV) VALUES (?, ?, ?, ?, ?)";
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
                    "BANK_ID", "BRANCH_ID", "BRANCH_NAME", "BRANCH_LOC", "SUC_PROV");
            System.out.println("-".repeat(130));
            while (rs.next()) {
                System.out.printf("%-10d | %-10d | %-35s | %-35s | %-35s%n",
                        rs.getInt("BANK_ID"),
                        rs.getInt("BRANCH_ID"),
                        rs.getString("BRANCH_NAME"),
                        rs.getString("BRANCH_LOC"),
                        rs.getString("SUC_PROV"));
            }
        }
    }

    public boolean updateBranch(int idBank, int idBranch, String name, String loc, String prov)
            throws SQLException {
        String sql = "UPDATE BRANCH SET BRANCH_NAME=?, BRANCH_LOC=?, SUC_PROV=? WHERE BANK_ID=? AND BRANCH_ID=?";
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
        String sql = "DELETE FROM BRANCH WHERE BANK_ID=? AND BRANCH_ID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            ps.setInt(2, idBranch);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean existsBank(int idBank) throws SQLException {
        String sql = "SELECT 1 FROM BANK WHERE BANK_ID=?";
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

        String sql = "SELECT 1 FROM BRANCH WHERE BANK_ID=? AND BRANCH_ID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            ps.setInt(2, idBranch);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean existsAcc(String iban) throws SQLException {
        String sql = "SELECT 1 FROM ACCOUNT WHERE IBAN=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, iban);
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
        String sql = "INSERT INTO ACCOUNT (BANK_ID, BRANCH_ID, ACC_NUM, IBAN, DNI, BALANCE) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, account.getCodB());
            ps.setInt(2, account.getCodS());
            ps.setString(3, account.getAccNum());
            ps.setString(4, account.getIban());
            ps.setString(5, account.getDni());
            ps.setDouble(6, account.getBalance());
            return ps.executeUpdate() > 0;
        }
    }

    public List<Accounts> getAllAccounts() throws SQLException {
        String sql = "SELECT BANK_ID, BRANCH_ID, ACC_NUM, IBAN, DNI, BALANCE FROM ACCOUNT";
        List<Accounts> accounts = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                accounts.add(mapAccount(rs));
            }
        }

        return accounts;
    }

    public Optional<Accounts> findAccountByIbanAndDni(String iban, String dni) throws SQLException {
        String sql = """
                SELECT BANK_ID, BRANCH_ID, ACC_NUM, IBAN, DNI, BALANCE
                FROM ACCOUNT
                WHERE IBAN = ? AND DNI = ?
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, iban);
            ps.setString(2, dni);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return Optional.empty();
                }

                return Optional.of(mapAccount(rs));
            }
        }
    }

    public Optional<Accounts> findAccountByIban(String iban) throws SQLException {
        String sql = """
                SELECT BANK_ID, BRANCH_ID, ACC_NUM, IBAN, DNI, BALANCE
                FROM ACCOUNT
                WHERE IBAN = ?
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, iban);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return Optional.empty();
                }

                return Optional.of(mapAccount(rs));
            }
        }
    }

    private Accounts mapAccount(ResultSet rs) throws SQLException {
        Accounts account = new Accounts(
                rs.getInt("BANK_ID"),
                rs.getInt("BRANCH_ID"),
                rs.getString("ACC_NUM"),
                rs.getString("DNI"),
                rs.getDouble("BALANCE"));
        account.setIban(rs.getString("IBAN"));
        return account;
    }

    public boolean deleteAccount(int idBank, int idBranch, String accNum) throws SQLException {
        String sql = "DELETE FROM ACCOUNT WHERE BANK_ID=? AND BRANCH_ID=? AND ACC_NUM=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBank);
            ps.setInt(2, idBranch);
            ps.setString(3, accNum);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateAccount(String iban, double amount)
            throws SQLException {
        String sql = "UPDATE ACCOUNT SET BALANCE=? WHERE IBAN=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.setString(2, iban);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean insertMovement(long numOperac, int idBank, int idBranch, String accNum, double amount, String tipo,
            String observacion)
            throws SQLException {
        String sql = """
                INSERT INTO MOVEMENT
                (OP_ID, BANK_ID, BRANCH_ID, ACC_NUM, DT, AMMOUNT, OP_TYPE, OBSERVATION)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        LocalDateTime fecha = LocalDateTime.now();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, numOperac);
            ps.setInt(2, idBank);
            ps.setInt(3, idBranch);
            ps.setString(4, accNum);
            ps.setDate(5, java.sql.Date.valueOf(fecha.toLocalDate()));
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
                    "OP_ID", "BANK_ID", "BRANCH_ID", "ACC_NUM", "DT", "AMMOUNT", "OP_TYPE", "OBSERVATION");
            System.out.println("-".repeat(150));
            while (rs.next()) {
                System.out.printf("%-10d | %-10d | %-10d | %-10s | %-12s | %-12.2f | %-20s | %-50s%n",
                        rs.getInt("OP_ID"),
                        rs.getInt("BANK_ID"),
                        rs.getInt("BRANCH_ID"),
                        rs.getString("ACC_NUM"),
                        rs.getDate("DT"),
                        rs.getDouble("AMMOUNT"),
                        rs.getString("OP_TYPE"),
                        rs.getString("OBSERVATION"));
            }
        }
    }

    public boolean deleteMovement(int numOperac) throws SQLException {
        String sql = "DELETE FROM MOVEMENT WHERE OP_ID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numOperac);
            return ps.executeUpdate() > 0;
        }
    }
}

package Trimestre3.postgres;

import java.sql.*;

import java.math.BigInteger;

public class Accounts {

    private String iban;
    private double balance;

    public Accounts() {
        this.balance = 0;
    }

    public static String generateIban(String ccc) {
        String countrySur = "142800";
        String calculateNumber = ccc + countrySur;
        BigInteger biggie = new BigInteger(calculateNumber);
        BigInteger module = new BigInteger("97");
        int rest = biggie.remainder(module).intValue();
        int controlDigits = 98 - rest;
        String dcFormat = String.format("%02d", controlDigits);

        return "ES" + dcFormat + ccc;
    }

    public boolean createAcc(Connection conn, String doc) throws SQLException {
        String docF = doc.toUpperCase();

        if (docF.matches("^\\d{8}-?[A-Z]$")) {
            System.out.println("DNI validated");
        } else if (docF.matches("^[XYZ]\\d{7}-?[A-Z]$")) {
            System.out.println("NIE validated.");
        } else {
            System.out.println("Error: Insert a valid DNI or NIE");
            return false;
        }
        String sqlInsert = "INSERT INTO account(balance,docF) VALUES (?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, docF);
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long idGenerated = generatedKeys.getLong(1);
                    String baseNumber = String.format("%010d", idGenerated);
                    String ccc = "5929" + "3621" + "06" + baseNumber;
                    String finalIban = generateIban(ccc);
                    updateIban(conn, idGenerated, finalIban);
                    return true;
                }
            } catch (Exception e) {
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
                return false;
            }
        } finally {
            System.out.println("Process finished succesfully for document: " + docF);
        }
        return false;
    }

    private void updateIban(Connection conn, long id, String finalIban) throws SQLException {
        String sqlUpdate = "UPDATE accounts SET iban = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, finalIban);
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
        }
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

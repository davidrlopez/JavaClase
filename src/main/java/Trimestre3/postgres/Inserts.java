package Trimestre3.postgres;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inserts {

    private final Connection conn;

    public Inserts(Connection conn) {
        this.conn = conn;
    }

    private static String generateName() {
        String[] sils = {
                "ma", "ri", "car", "los", "pe", "dro", "lu", "na",
                "an", "to", "ni", "o", "e", "le", "na", "gar",
                "ci", "a", "ro", "ber", "to", "fer", "nan", "do"
        };
        int numSil = (int) (Math.random() * 3) + 2;
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < numSil; i++) {
            String sil = sils[(int) (Math.random() * sils.length)];
            if (i == 0) {
                name.append(Character.toUpperCase(sil.charAt(0))).append(sil.substring(1));
            } else {
                name.append(sil);
            }
        }
        return name.toString();
    }

    private static String generateLastName() {
        String[] lastN = { "García", "Martínez", "López", "Sánchez", "González",
                "Pérez", "Rodríguez", "Fernández", "Torres", "Ramírez",
                "Díaz", "Moreno", "Jiménez", "Ruiz", "Hernández" };
        return lastN[(int) (Math.random() * lastN.length)];
    }

    private static String sqlText(String value) {
        return value == null ? "NULL" : "'" + value.replace("'", "''") + "'";
    }

    private static String bankInsert(int bankId) {
        return String.format(Locale.US,
                "INSERT INTO BANK (BANK_ID, BANK_NF, BANK_NAME, DOM_FISCAL, POBLATION) VALUES (%d, %s, %s, %s, %s) ON CONFLICT (BANK_ID) DO NOTHING;",
                bankId,
                sqlText(String.format("NF%04d", bankId)),
                sqlText("Bank " + bankId),
                sqlText("Address " + bankId),
                sqlText("City " + bankId));
    }

    private static String branchInsert(int bankId, int branchId) {
        return String.format(Locale.US,
                "INSERT INTO BRANCH (BANK_ID, BRANCH_ID, BRANCH_NAME, BRANCH_LOC, SUC_PROV) VALUES (%d, %d, %s, %s, %s) ON CONFLICT (BANK_ID, BRANCH_ID) DO NOTHING;",
                bankId,
                branchId,
                sqlText("Branch " + branchId),
                sqlText("City " + branchId),
                sqlText("Province " + branchId));
    }

    private static String accountInsert(Accounts account) {
        return String.format(Locale.US,
                "INSERT INTO ACCOUNT (BANK_ID, BRANCH_ID, ACC_NUM, IBAN, DNI, BALANCE) VALUES (%d, %d, %s, %s, %s, %.2f) ON CONFLICT (BANK_ID, BRANCH_ID, ACC_NUM) DO NOTHING;",
                account.getCodB(),
                account.getCodS(),
                sqlText(account.getAccNum()),
                sqlText(account.getIban()),
                sqlText(account.getDni()),
                account.getBalance());
    }

    public boolean randomTest() throws SQLException {
        String userHome = System.getProperty("user.home");
        Scanner input = new Scanner(System.in);
        System.out.println("Save as (without .sql):");
        String fileName = input.next();
        if (!fileName.toLowerCase().endsWith(".sql")) {
            fileName += ".sql";
        }
        Path filePath = Paths.get(userHome, fileName);
        if (Files.exists(filePath)) {
            String baseName = fileName.substring(0, fileName.lastIndexOf("."));
            String extension = fileName.substring(fileName.lastIndexOf("."));
            filePath = Paths.get(userHome, baseName + "-2" + extension);
        }

        int iterationsR = (int) (Math.random() * 1000) + 1;

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            for (int i = 0; i < iterationsR; i++) {
                double balance = Math.random() * 1_000_000;
                String doc = Client.generateDoc().replace("-", "");
                long accNum = i + 1L;
                int bankId = (int) (Math.random() * 200) + 1;
                int branchId = (int) (Math.random() * 50) + 1;

                ArrayList<Accounts> accs = new ArrayList<>();
                Accounts acc = Accounts.createNew(bankId, branchId, accNum, doc, balance);
                accs.add(acc);
                String fullName = generateName() + " " + generateLastName() + " " + generateLastName();
                Client b = new Client(fullName, doc, accs, accs.size());
                writer.write(bankInsert(acc.getCodB()));
                writer.newLine();
                writer.write(branchInsert(acc.getCodB(), acc.getCodS()));
                writer.newLine();
                writer.write(accountInsert(b.getAccs().get(0)));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            return false;
        }

        System.out.println("***************************************************");
        System.out.println("File created at: " + filePath.toAbsolutePath());
        return importFile(filePath.toAbsolutePath().toString());
    }

    public boolean importFile(String route) throws SQLException {
        Path filePath = Paths.get(route);
        System.out.println("Attempting to read file from: " + filePath.toAbsolutePath());

        if (!Files.exists(filePath)) {
            throw new IllegalArgumentException("File does not exist: " + route);
        }

        String content;
        try {
            content = Files.readString(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new SQLException("Failed to read file", e);
        }

        content = Arrays.stream(content.split("\n"))
                .filter(line -> !line.stripLeading().startsWith("--"))
                .collect(Collectors.joining("\n"));

        conn.setAutoCommit(false);
        try (Statement stmt = conn.createStatement()) {
            String[] queries = content.split(";");

            for (String sql : queries) {
                String trimmed = sql.strip();
                if (!trimmed.isEmpty()) {
                    stmt.execute(trimmed);
                }
            }
            conn.commit();
            System.out.println("Database updated successfully!");
            return true;
        } catch (SQLException e) {
            conn.rollback();
            System.err.println("Transaction rolled back due to error: " + e.getMessage());
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

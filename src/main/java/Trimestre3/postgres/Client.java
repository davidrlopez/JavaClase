package Trimestre3.postgres;

import java.util.ArrayList;
import java.sql.*;

public class Client {

    private String name;
    private String dni;
    private String nie;
    private int numAcc;
    private ArrayList<Accounts> accs = new ArrayList<>();
    private int accCount = 0;
    private final static int max_accs = 10;

    public static boolean validateDni(String dni) {
        if (dni.matches("\\d{8}-?[A-Za-z]")) {
            String DIGIT_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
            String numbers = dni.replaceAll("[^0-9]", "");
            String letter = dni.replaceAll("[^A-Za-z]", "").toUpperCase();

            int numberDni = Integer.parseInt(numbers);
            int index = numberDni % 23;

            return letter.equals(String.valueOf(DIGIT_CONTROL.charAt(index)));
        }
        return false;
    }

    public static boolean validateNie(String nie) {
        if (nie.matches("^[XYZ]\\d{7}-?[A-Z]$")) {
            String DIGIT_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
            String numbers = nie.replaceAll("[^0-9]", "");
            String letter = nie.replaceAll("[^A-Za-z]", "").toUpperCase();

            int numberNie = Integer.parseInt(numbers);
            int index = numberNie % 23;

            return letter.equals(String.valueOf(DIGIT_CONTROL.charAt(index)));
        }
        return false;
    }

    public boolean addAccount(Accounts acc, Connection conn, String doc) throws SQLException {
        if (this.accs.size() < Client.max_accs) {
            Accounts newAcc = new Accounts();
            newAcc.createAcc(conn, doc);
            accs.add(newAcc);
            this.accCount++;
            System.out.println("Account added");
            System.out.println("Current accounts:");
            for (Accounts accounts : accs) {
                System.out.println(accs.indexOf(accounts) + ":" + accounts.getIban());
            }
            return true;
        } else {
            System.out.println("Could not create account");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNie() {
        return nie;
    }

    public void setNie(String nie) {
        this.nie = nie;
    }

    public int getNumAcc() {
        return numAcc;
    }

    public void setNumAcc(int numAcc) {
        this.numAcc = numAcc;
    }

    public ArrayList<Accounts> getAccs() {
        return accs;
    }

    public void setAccs(ArrayList<Accounts> accs) {
        this.accs = accs;
    }

    public int getAccCount() {
        return accCount;
    }

    public void setAccCount(int accCount) {
        this.accCount = accCount;
    }

    public static int getMaxAccs() {
        return max_accs;
    }
}

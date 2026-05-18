package Trimestre3.postgres;

import java.util.ArrayList;

public class Client {

    private String name;
    private String doc;
    private int numAcc;
    private ArrayList<Accounts> accs = new ArrayList<>();
    private int accCount = 0;
    private final static int max_accs = 10;

    public static boolean validateDni(String doc) {
        if (doc.matches("\\d{8}-?[A-Za-z]")) {
            String DIGIT_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
            String numbers = doc.replaceAll("[^0-9]", "");
            String letter = doc.replaceAll("[^A-Za-z]", "").toUpperCase();

            int numberDni = Integer.parseInt(numbers);
            int index = numberDni % 23;

            return letter.equals(String.valueOf(DIGIT_CONTROL.charAt(index)));
        }
        return false;
    }

    public static boolean validateNie(String doc) {
        if (doc.matches("^[XYZ]\\d{7}-?[A-Z]$")) {
            String DIGIT_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
            String numbers = doc.replaceAll("[^0-9]", "");
            String letter = doc.replaceAll("[^A-Za-z]", "").toUpperCase();

            int numberNie = Integer.parseInt(numbers);
            int index = numberNie % 23;

            return letter.equals(String.valueOf(DIGIT_CONTROL.charAt(index)));
        }
        return false;
    }

    public boolean addAccount(Accounts acc) {
        if (this.accs.size() < Client.max_accs) {
            accs.add(acc);
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

    public String getDoc() {
        return doc;
    }

    public String getDni() {
        return doc;
    }

    public void setDni(String doc) {
        this.doc = doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
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

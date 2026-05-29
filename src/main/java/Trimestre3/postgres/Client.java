package Trimestre3.postgres;

import java.util.ArrayList;

public class Client {

    private String name;
    private String doc;
    private ArrayList<Accounts> accs = new ArrayList<>();
    private int accCount = 0;
    private final static int max_accs = 10;

    public static boolean validateDoc(String doc) {
        if (doc.matches("^[XYZ]\\d{7}-?[A-Z]$") || doc.matches("\\d{8}-?[A-Za-z]")) {
            String DIGIT_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
            String numbers = doc.replaceAll("[^0-9]", "");
            String letter = doc.replaceAll("[^A-Za-z]", "").toUpperCase();

            int numberNie = Integer.parseInt(numbers);
            int index = numberNie % 23;

            return letter.equals(String.valueOf(DIGIT_CONTROL.charAt(index)));
        }
        return false;
    }

    public static String generateDoc() {
        String DIGIT_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numbers = (int) (Math.random() * 90_000_000) + 10_000_000;
        char letter = DIGIT_CONTROL.charAt(numbers % 23);
        String fullDoc = numbers + "-" + letter;
        if (!validateDoc(fullDoc)) {
            return "Invalid dni";
        }
        return fullDoc;
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

    public void setDoc(String doc) throws IllegalArgumentException {
        if (!validateDoc(doc)) {
            throw new IllegalArgumentException("Invalid doc");
        }
        this.doc = doc;
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

    public Client(String name, String doc, ArrayList<Accounts> accs, int accCount) throws IllegalArgumentException {
        this.name = name;
        setDoc(doc);
        this.accs = accs;
        this.accCount = accCount;
    }
}

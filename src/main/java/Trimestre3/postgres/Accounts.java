package Trimestre3.postgres;

import java.math.BigInteger;

public class Accounts {

    private String iban;
    private double balance;
    private int idB;
    private int idS;
    private long accNum;
    private String dni;

    public Accounts() {
        this.balance = 0;
    }

    public Accounts(int idB, int idS, long accNum, String iban, String dni, double balance) {
        this.idB = idB;
        this.idS = idS;
        this.accNum = accNum;
        this.iban = iban;
        this.dni = dni;
        this.balance = balance;
    }

    public static Accounts createNew(int idB, int idS, long accNum, String dni, double balance) {
        String bank = String.format("%04d", idB);
        String branch = String.format("%04d", idS);
        String accountNumber = String.format("%010d", accNum);
        String ccc = bank + branch + "06" + accountNumber;
        String iban = generateIban(ccc);

        return new Accounts(idB, idS, accNum, iban, dni, balance);
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

    public int getCodB() {
        return idB;
    }

    public void setCodB(int idB) {
        this.idB = idB;
    }

    public int getCodS() {
        return idS;
    }

    public void setCodS(int idS) {
        this.idS = idS;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}

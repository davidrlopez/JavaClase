package Trimestre3.postgres;

import java.sql.SQLException;
import java.util.List;

public class Actions {

    private final BankDao bankDao;

    public Actions(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    public Accounts createAccount(Client client, int idBank, int idBranch, double amount) throws SQLException {
        Accounts account = bankDao.createAccount(idBank, idBranch, client.getDni(), amount);
        client.addAccount(account);
        return account;
    }

    public List<Accounts> listAccounts() throws SQLException {
        return bankDao.getAllAccounts();
    }

    public boolean updateAccount(int idBank, int idBranch, long accNum, String dni, double amount)
            throws SQLException {
        return bankDao.updateAccount(idBank, idBranch, accNum, dni, amount);
    }

    public boolean deleteAccount(int idBank, int idBranch, long accNum) throws SQLException {
        return bankDao.deleteAccount(idBank, idBranch, accNum);
    }
}

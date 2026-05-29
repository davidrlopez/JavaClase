package Trimestre3.postgres;

import java.sql.SQLException;
import Trimestre3.postgres.Exceptions.WithdrawException;

public class Actions {

    private final BankDao bankDao;

    public Actions(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    public boolean withdraw(Accounts account, double withdraw)
            throws SQLException, WithdrawException {
        String tipo = this.getClass().getSimpleName();
        String observacion = " ";
        if (withdraw < 0) {
            throw new IllegalArgumentException("Withdraw amount can't be negative");
        }
        if (withdraw > account.getBalance()) {
            throw new WithdrawException(account.getBalance(), withdraw);
        }
        long numOperac = bankDao.getNextMovementNumber();
        account.setBalance(account.getBalance() - withdraw);
        bankDao.updateAccount(account.getIban(), account.getBalance());
        bankDao.insertMovement(numOperac, account.getCodB(), account.getCodS(), account.getAccNum(),
                account.getBalance(),
                tipo, observacion);
        return true;
    }

    public boolean deposit(Accounts account, double deposit)
            throws SQLException, IllegalArgumentException {
        String tipo = this.getClass().getSimpleName();
        String observacion = " ";
        if (deposit < 0) {
            throw new IllegalArgumentException("Deposit amount can't be negative");
        }
        long numOperac = bankDao.getNextMovementNumber();
        account.setBalance(account.getBalance() + deposit);
        bankDao.updateAccount(account.getIban(), account.getBalance());
        bankDao.insertMovement(numOperac, account.getCodB(), account.getCodS(), account.getAccNum(),
                account.getBalance(),
                tipo, observacion);
        return true;
    }

    public boolean transaction(Accounts origin, Accounts destiny, double amount)
            throws SQLException, WithdrawException, IllegalArgumentException {
        String tipo = this.getClass().getSimpleName();
        String observacion = " ";
        if (amount < 0) {
            throw new IllegalArgumentException("Transaction amount can't be negative");
        }
        if (amount > origin.getBalance()) {
            throw new WithdrawException(origin.getBalance(), amount);
        }
        if (!bankDao.existsAcc(destiny.getIban())) {
            throw new IllegalArgumentException("Destiny account doesn't exists.");
        }
        origin.setBalance(origin.getBalance() - amount);
        destiny.setBalance(destiny.getBalance() + amount);
        bankDao.updateAccount(origin.getIban(), origin.getBalance());
        long numOperac = bankDao.getNextMovementNumber();
        bankDao.insertMovement(numOperac, origin.getCodB(), origin.getCodS(), origin.getAccNum(), origin.getBalance(),
                tipo,
                observacion);
        bankDao.updateAccount(destiny.getIban(), destiny.getBalance());
        long numOperacD = bankDao.getNextMovementNumber();
        bankDao.insertMovement(numOperacD, destiny.getCodB(), destiny.getCodS(), destiny.getAccNum(),
                destiny.getBalance(), tipo,
                observacion);
        return true;
    }
}

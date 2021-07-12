package by.training.task04.bean;

import java.util.Objects;

public class Account {
    private int idAccount;
    private int balance;
    private boolean accountStatus;

    public Account() {

    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Account(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public boolean getAccountStatus() {
        return accountStatus;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return idAccount == account.idAccount && Double.compare(account.balance, balance) == 0 && accountStatus == account.accountStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), balance, accountStatus, idAccount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", balance=" + balance +
                ", accountStatus=" + accountStatus +
                '}';
    }
}

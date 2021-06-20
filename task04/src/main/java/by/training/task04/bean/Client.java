package by.training.task04.bean;

import java.util.Arrays;
import java.util.Objects;

public class Client {
    private int idClient;
    private Account[] accounts;

    public Client() {

    }

    public Client(Account[] accounts) {
        this.accounts = accounts;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Arrays.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accounts);
    }
}

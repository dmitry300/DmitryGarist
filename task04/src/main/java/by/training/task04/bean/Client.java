package by.training.task04.bean;

import java.util.List;
import java.util.Objects;

public class Client {
    private int idClient;
    private List<Account> accounts;

    public Client() {
    }

    public Client(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient && Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idClient, accounts);
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", accounts=" + accounts +
                '}';
    }
}

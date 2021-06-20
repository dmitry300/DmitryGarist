package by.training.task04.bean;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private Client[] clients;

    public Bank() {

    }

    public Bank(Client[] clients) {
        this.clients = clients;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Arrays.equals(clients, bank.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clients);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "clients=" + Arrays.toString(clients) +
                '}';
    }
}

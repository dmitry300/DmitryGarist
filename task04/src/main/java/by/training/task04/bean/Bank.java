package by.training.task04.bean;

import java.util.List;
import java.util.Objects;

public class Bank {
    private List<Client> clients;

    public Bank() {

    }

//    public Bank(Client[] clients) {
//        this.clients = clients;
//    }

    public Bank(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(clients, bank.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clients);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "clients=" + clients +
                '}';
    }
}

package by.training.task04.service;

public interface Blocking {
    boolean block(int idAccount);
    boolean unblock(int idAccount);
}

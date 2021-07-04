package by.training.task04.service;

public interface BlockingLoad {
    boolean block(int idAccount);
    boolean unblock(int idAccount);
}

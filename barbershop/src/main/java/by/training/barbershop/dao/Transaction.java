package by.training.barbershop.dao;

import by.training.barbershop.dao.exception.DatabaseConnectionException;
import by.training.barbershop.dao.impl.AbstractDao;

public interface Transaction {
    void initTransaction(AbstractDao dao, AbstractDao... daos) throws DatabaseConnectionException;
    void endTransaction();
    void end();
    void commit();
    void rollback();
}

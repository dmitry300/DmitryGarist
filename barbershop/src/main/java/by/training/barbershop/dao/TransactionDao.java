package by.training.barbershop.dao;

import by.training.barbershop.dao.impl.AbstractDao;

public interface TransactionDao {
    void initTransaction(AbstractDao dao, AbstractDao... daos);
    void endTransaction();
    void init(AbstractDao dao);
    void end();
    void commit();
    void rollback();
}

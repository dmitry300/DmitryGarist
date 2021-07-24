package by.training.task06.controller.impl;

import by.training.task06.bean.SquareMatrix;
import by.training.task06.controller.Command;
import by.training.task06.service.exception.ServiceException;
import by.training.task06.bean.ThreadBean;
import by.training.task06.service.impl.ThreadLockRunnable;
import by.training.task06.service.provider.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class LockerThread implements Command {
    private static final Logger logger = LogManager.getLogger(LockerThread.class);
    @Override
    public void executeCommand(String fileNameForMatrix, String fileNameForThread) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        try {
            SquareMatrix squareMatrix  = (SquareMatrix) serviceProvider.getLoaderMatrix().read(fileNameForMatrix);
            List<ThreadBean> listThread = (List<ThreadBean>) serviceProvider.getLoaderThread().read(fileNameForThread);
            ReentrantLock locker = new ReentrantLock(); // создаем заглушку
            int i = 0;
            for (ThreadBean threadNumber : listThread) {
                ThreadLockRunnable threadLockRunnable = new ThreadLockRunnable(squareMatrix, locker, i, threadNumber.getNumber());
                Thread t = new Thread(threadLockRunnable);
                t.setName("Поток " + i++);
                t.start();
            }
        } catch (ServiceException e) {
            logger.error("service exception" + e);
        }
    }
}

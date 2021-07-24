package by.training.task06.service.impl;

import by.training.task06.bean.MatrixException;
import by.training.task06.bean.SquareMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockRunnable implements Runnable {
    private static final Logger logger = LogManager.getLogger(ThreadLockRunnable.class);

    private final SquareMatrix matrix; //common resource
    private final ReentrantLock locker;
    private final int indexChange;
    private final double number;

    /**
     * @param matrix      common resource
     * @param locker      by java.util.concurrent.locks.ReentrantLock
     * @param indexChange index element matrix for changing
     * @param number      number taking from ThreadBean
     */
    public ThreadLockRunnable(SquareMatrix matrix, ReentrantLock locker, int indexChange, double number) {
        this.matrix = matrix;
        this.locker = locker;
        this.indexChange = indexChange;
        this.number = number;

    }

    public void run() {
        logger.info(Thread.currentThread());
        locker.lock(); // устанавливаем блокировку
        try {
            matrix.setElement(indexChange, indexChange, number);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.print(number + " ---" + Thread.currentThread());
        } catch (InterruptedException | MatrixException e) {
            logger.error("Error sleep Thread or not corrected matrix");
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(matrix);
            locker.unlock(); // снимаем блокировку
        }
    }

}


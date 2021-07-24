package by.training.task06.service.impl;

import by.training.task06.bean.MatrixException;
import by.training.task06.bean.SquareMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ThreadSemaphoreRunnable implements Runnable {
    private static final Logger logger = LogManager.getLogger(ThreadSemaphoreRunnable.class);

    private final SquareMatrix matrix; //common resource
    private final Semaphore semaphore;
    private final int indexChange;
    private final double number;

    /**
     * @param matrix      common resource
     * @param semaphore   by java.util.concurrent.Semaphore
     * @param indexChange index element matrix for changing
     * @param number      number taking from ThreadBean
     */
    public ThreadSemaphoreRunnable(SquareMatrix matrix, Semaphore semaphore, int indexChange, double number) {
        this.matrix = matrix;
        this.semaphore = semaphore;
        this.indexChange = indexChange;
        this.number = number;
    }

    public void run() {
        logger.info(Thread.currentThread());
        try {
            semaphore.acquire();
            matrix.setElement(indexChange, indexChange, number);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.print(number + " ---" + Thread.currentThread());
        } catch (InterruptedException | MatrixException e) {
            logger.error("Error sleep Thread or not corrected matrix");
            Thread.currentThread().interrupt();
        }
        System.out.println(matrix);
        semaphore.release();
    }
}


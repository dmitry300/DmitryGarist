package by.training.task06.service.impl;

import by.training.task06.bean.MatrixException;
import by.training.task06.bean.SquareMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class ThreadBarrierRunnable implements Runnable {
    private static final Logger logger = LogManager.getLogger(ThreadBarrierRunnable.class);

    private final SquareMatrix matrix; //common resource
    private final CyclicBarrier cyclicBarrier;
    private final int indexChange;
    private final double number;

    /**
     * @param matrix        common resource
     * @param cyclicBarrier by java.util.concurrent.CyclicBarrier
     * @param indexChange   index element matrix for changing
     * @param number        number taking from ThreadBean
     */
    public ThreadBarrierRunnable(SquareMatrix matrix, CyclicBarrier cyclicBarrier, int indexChange, double number) {
        this.matrix = matrix;
        this.cyclicBarrier = cyclicBarrier;
        this.indexChange = indexChange;
        this.number = number;

    }

    public void run() {
        logger.info(Thread.currentThread());

        try {
            matrix.setElement(indexChange, indexChange, number);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.print(number + " ---" + Thread.currentThread());
            cyclicBarrier.await();
        } catch (InterruptedException | MatrixException | BrokenBarrierException e) {
            logger.error("Error sleep Thread or not corrected matrix");
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(matrix);

        }
    }

}


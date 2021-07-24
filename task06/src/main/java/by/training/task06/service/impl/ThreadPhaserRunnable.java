package by.training.task06.service.impl;

import by.training.task06.bean.MatrixException;
import by.training.task06.bean.SquareMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class ThreadPhaserRunnable implements Runnable {
    private static final Logger logger = LogManager.getLogger(ThreadPhaserRunnable.class);

    private final SquareMatrix matrix; //common resource
    private final Phaser phaser;
    private final int indexChange;
    private final double number;

    /**
     * @param matrix      common resource
     * @param phaser      by java.util.concurrent.Phaser
     * @param indexChange index element matrix for changing
     * @param number      number taking from ThreadBean
     */
    public ThreadPhaserRunnable(SquareMatrix matrix, Phaser phaser, int indexChange, double number) {
        this.matrix = matrix;
        this.phaser = phaser;
        this.indexChange = indexChange;
        this.number = number;
        phaser.register();
    }

    public void run() {
        logger.info(Thread.currentThread());
        try {
            phaser.arriveAndAwaitAdvance();
            matrix.setElement(indexChange, indexChange, number);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.print(number + " ---" + Thread.currentThread());
        } catch (InterruptedException | MatrixException e) {
            logger.error("Error sleep Thread or not corrected matrix");
            Thread.currentThread().interrupt();
        }
        System.out.println(matrix);
        phaser.arriveAndDeregister();
    }
}


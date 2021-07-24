package by.training.task06.controller.impl;

import by.training.task06.bean.SquareMatrix;
import by.training.task06.bean.ThreadBean;
import by.training.task06.controller.Command;
import by.training.task06.service.exception.ServiceException;
import by.training.task06.service.impl.ThreadPhaserRunnable;
import by.training.task06.service.provider.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.Phaser;

public class PhaserThread implements Command {
    private static final Logger logger = LogManager.getLogger(PhaserThread.class);

    @Override
    public void executeCommand(String fileNameForMatrix, String fileNameForThread) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        try {
            SquareMatrix squareMatrix = (SquareMatrix) serviceProvider.getLoaderMatrix().read(fileNameForMatrix);
            List<ThreadBean> listThread = (List<ThreadBean>) serviceProvider.getLoaderThread().read(fileNameForThread);
            Phaser phaser = new Phaser(1);
            int i = 0;
            phaser.arriveAndAwaitAdvance();
            for (ThreadBean threadNumber : listThread) {
                ThreadPhaserRunnable threadPhaserRunnable = new ThreadPhaserRunnable(squareMatrix, phaser, i, threadNumber.getNumber());
                Thread t = new Thread(threadPhaserRunnable);
                t.setName("Поток " + i++);
                t.start();
            }
            phaser.arriveAndDeregister();
        } catch (
                ServiceException e) {
            logger.error("service exception" + e);
        }
    }
}

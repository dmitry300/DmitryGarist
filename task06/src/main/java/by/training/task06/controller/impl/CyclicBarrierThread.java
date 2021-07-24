package by.training.task06.controller.impl;

import by.training.task06.bean.SquareMatrix;
import by.training.task06.bean.ThreadBean;
import by.training.task06.controller.Command;
import by.training.task06.service.exception.ServiceException;
import by.training.task06.service.impl.ThreadBarrierRunnable;
import by.training.task06.service.provider.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread implements Command {
    private static final Logger logger = LogManager.getLogger(CyclicBarrierThread.class);

    @Override
    public void executeCommand(String fileNameForMatrix, String fileNameForThread) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        try {
            SquareMatrix squareMatrix = (SquareMatrix) serviceProvider.getLoaderMatrix().read(fileNameForMatrix);
            List<ThreadBean> listThread = (List<ThreadBean>) serviceProvider.getLoaderThread().read(fileNameForThread);
            CyclicBarrier cyclicBarrier = new CyclicBarrier(20);
            int i = 0;
            for (ThreadBean threadNumber : listThread) {
                ThreadBarrierRunnable threadBarrierRunnable = new ThreadBarrierRunnable(squareMatrix, cyclicBarrier, i, threadNumber.getNumber());
                Thread t = new Thread(threadBarrierRunnable);
                t.setName("Поток " + i++);
                t.start();
            }
        } catch (
                ServiceException e) {
            logger.error("service exception" + e);
        }
    }
}

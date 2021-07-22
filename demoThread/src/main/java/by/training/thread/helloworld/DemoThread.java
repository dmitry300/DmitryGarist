package by.training.thread.helloworld;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoThread extends Thread {
    private static final Logger logger = LogManager.getLogger(DemoThread.class);

    @Override
    public void run() {
        System.out.println("Hello demoThread");
        logger.info("demo thread: hello world");
    }

    public static void main(String[] args) {
        System.out.println("Hello mainThread");
        DemoThread demoThread = new DemoThread();
        demoThread.setName("daughter thread");
        demoThread.start();

        logger.info("main thread: hello world");
    }
}

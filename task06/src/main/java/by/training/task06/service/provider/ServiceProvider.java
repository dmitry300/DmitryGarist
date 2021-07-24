package by.training.task06.service.provider;

import by.training.task06.service.Loading;
import by.training.task06.service.Reader;
import by.training.task06.service.impl.ConsoleReader;
import by.training.task06.service.impl.LoaderMatrix;
import by.training.task06.service.impl.LoaderThread;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    public static ServiceProvider getInstance() {
        return instance;
    }

    private final Loading loaderMatrix = new LoaderMatrix();
    private final Loading loaderThread = new LoaderThread();
    private final Reader userReader = new ConsoleReader();

    public Reader getUserReader() {
        return userReader;
    }

    public Loading getLoaderMatrix() {
        return loaderMatrix;
    }

    public Loading getLoaderThread() {
        return loaderThread;
    }
}

package by.training.barbershop.dao.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger log = LogManager.getLogger(ConnectionPool.class);
    private static final int DEFAULT_POOL_SIZE = 32;
    private static boolean isCreated;
    private static ConnectionPool instance;
    private static final ReentrantLock lock = new ReentrantLock(true);
    private final BlockingDeque<Connection> freeConnection;
    private final Queue<Connection> givenAwayConnection;

    public static ConnectionPool getInstance() {
        if (!isCreated) {
            lock.lock();
            if (instance == null) {
                instance = new ConnectionPool();
                isCreated = true;
            }
            lock.unlock();
        }
        return instance;
    }

    private ConnectionPool() {
        freeConnection = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenAwayConnection = new ArrayDeque<>();
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                Connection connection = ConnectionFactory.getConnection();
                boolean isAdded = freeConnection.add(connection);
                log.info("Connection added to freeConnection: {}", isAdded);
            } catch (SQLException e) {
                log.error("Connection not received: {}", e.getMessage());
            }
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = freeConnection.take();
            givenAwayConnection.offer(connection);
        } catch (InterruptedException e) {
            log.error("InterruptedException in getConnection: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (givenAwayConnection.remove(connection)) {
            try {
                freeConnection.put(connection);
            } catch (InterruptedException e) {
                log.error("InterruptedException in releaseConnection: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Destroys pool. Closes all connections. Stops timer task if specified
     */
    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnection.take().close();
            } catch (SQLException e) {
                log.error("SQLException in destroyPool: {}", e.getMessage());
            } catch (InterruptedException e) {
                log.error("InterruptedException in destroyPool: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                log.error("Error while driver deregistration: {}", e.getMessage());
            }
        });
    }
}

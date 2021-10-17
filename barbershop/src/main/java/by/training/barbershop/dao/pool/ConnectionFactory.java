package by.training.barbershop.dao.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final Logger log = LogManager.getLogger(ConnectionFactory.class);
    private static final Properties properties = new Properties();
    private static final String DATABASES_PROPERTIES = "database.properties";
    private static final String PROPERTY_URL = "db.url";
    private static final String PROPERTY_DRIVER = "db.driver";
    private static final String PROPERTY_USER = "db.user";
    private static final String PROPERTY_PASSWORD = "db.password";
    private static String DATABASE_URL = null;
    private static String DATABASE_USER = null;
    private static String DATABASE_PASSWORD = null;

    static {
        try (InputStream inputStream = ConnectionFactory.class
                .getClassLoader().getResourceAsStream(DATABASES_PROPERTIES)) {
            properties.load(inputStream);
            DATABASE_URL = properties.getProperty(PROPERTY_URL);
            String DATABASE_DRIVER = properties.getProperty(PROPERTY_DRIVER);
            DATABASE_USER = properties.getProperty(PROPERTY_USER);
            DATABASE_PASSWORD = properties.getProperty(PROPERTY_PASSWORD);
            Class.forName(DATABASE_DRIVER);
        } catch (IOException e) {
            log.error("IOException: {}", e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("db.driver {} not found", properties.getProperty(PROPERTY_DRIVER));
        }
    }

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, properties);
    }
}

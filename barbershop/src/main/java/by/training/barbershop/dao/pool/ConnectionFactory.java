package by.training.barbershop.dao.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class for database connection creation
 */
class   ConnectionFactory {
    private static final Logger logg = LogManager.getLogger();
    private static final Properties dbProperties = new Properties();
    private static final String DB_PROPERTY_FILE = "properties/database.properties";
    private static final String DB_URL_PROPERTY = "url";
    private static final String DB_DRIVER_PROPERTY = "driver";
    private static final String DB_URL;

    static {
        try (InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream(DB_PROPERTY_FILE)) {
            if (inputStream == null) {
                logg.fatal("Database property file doesn't exist");
                throw new RuntimeException("Database property file doesn't exist");
            }

            dbProperties.load(inputStream);
            DB_URL = dbProperties.getProperty(DB_URL_PROPERTY);
            String driver = dbProperties.getProperty(DB_DRIVER_PROPERTY);

            if (DB_URL == null) {
                logg.fatal("Database url property doesn't exist.");
                throw new RuntimeException("Database url property doesn't exist.");
            }

            if (driver == null) {
                logg.fatal( "Driver property doesn't exist.");
                throw new RuntimeException("Driver property doesn't exist.");
            }

            Class.forName(driver);
        } catch (IOException e) {
            logg.fatal( "Error while reading property file");
            throw new RuntimeException("Error while reading property file");
        } catch (ClassNotFoundException e) {
            logg.fatal("Driver class not found", e);
            throw new RuntimeException("Driver class not found: " + e.getMessage());
        }
    }

    private ConnectionFactory() {
    }

    /**
     * Creates database connection
     *
     * @return new database connection
     * @throws SQLException if error while creating connection occurred
     */
    static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, dbProperties);
    }
}

package by.training.barbershop.dao.pool;

import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.testng.Assert.*;

public class ConnectionPoolTest {

    @BeforeClass
    public void initPool() {
        ConnectionPool.getInstance();
    }

    @Test
    public void releaseConnectionTest() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/barbershop_db";
        String user = "root";
        String password = "31478965";
        Connection connection = DriverManager.getConnection(url, user, password);;
        boolean res = ConnectionPool.getInstance().releaseConnection(connection);
        Assert.assertFalse(res);
    }

    @AfterClass
    public void destroyPool() {
        ConnectionPool.getInstance().destroyPool();
    }
}
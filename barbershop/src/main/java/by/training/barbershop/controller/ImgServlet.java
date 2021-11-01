package by.training.barbershop.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ImgServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();
    private static final String PICTURE_PROPERTIES = "properties/picture.properties";
    private static final String BASE_PATH_PROPERTY = "image.path.base";

    private String basePicturePath;

    /**
     * Initializes image properties
     */
    @Override
    public void init() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Properties properties = new Properties();
            properties.load(classLoader.getResourceAsStream("properties/img.properties"));
            basePicturePath = properties.getProperty(BASE_PATH_PROPERTY);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Property file exists");
        }
    }

    /**
     * Uploads requested image
     *
     * @param req  http request
     * @param resp http response
     * @throws IOException ist thrown when send redirect exception occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getParameter("path");
        if (path == null) {
            logger.log(Level.ERROR, "Property file contains invalid parameters: path");
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        String fullPath = basePicturePath + path;
        try (InputStream fileStream = new FileInputStream(fullPath)) {
            ServletOutputStream outputStream = resp.getOutputStream();
            fileStream.transferTo(outputStream);
        } catch (IOException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

package org.example.util;

import org.example.exception.FileNameException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class ConnectionUtil {
    private static final String PROPERTIES_FILE = "application.properties";
    private static final Properties PROPERTIES = loadProperties();

    private ConnectionUtil() {}

    static {
        try {
            Class.forName(PROPERTIES.getProperty("database.driver"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load JDBC driver for MySQL", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = PROPERTIES.getProperty("database.url");
        String username = PROPERTIES.getProperty("database.username");
        String password = PROPERTIES.getProperty("database.password");
        return DriverManager.getConnection(url, username, password);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = ConnectionUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            throw new FileNameException("Sorry, unable to find " + PROPERTIES_FILE, e);
        }
        return properties;
    }
}


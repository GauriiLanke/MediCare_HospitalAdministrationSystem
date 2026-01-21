package com.medicare.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DBConnection Utility Class
 * --------------------------
 * Provides centralized database connection
 * using Singleton design pattern.
 * All DAO classes use this class to connect
 * with MySQL database.
 */

public class DBConnection {

    // Database configuration constants
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";

    private static final String URL ="jdbc:mysql://localhost:3306/medicare_db?useSSL=false";

    private static final String USERNAME ="root";

    private static final String PASSWORD ="root";

    // Single connection instance
    private static Connection connection = null;

    // Private constructor to prevent object creation
    private DBConnection() {
    }

    // Returns database connection object
    public static Connection getDBConnection() {

        try {

            // Create new connection if not available
            if (connection == null ||connection.isClosed()) {

                // Load MySQL Driver
                Class.forName(DRIVER);

                // Establish Connection
                connection =DriverManager.getConnection(
                        URL, USERNAME, PASSWORD
                    );

                System.out.println("Database Connected Successfully!");
            }

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL Driver Not Found!");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return connection;
    }
}

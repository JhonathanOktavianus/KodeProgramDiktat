/**
 * @author 1972046 JHONATHAN OKTAVIANUS
 */

package com.jhonathan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/demodb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // MySql versi 8
        // Class.forName("com.mysql.jdbc.Driver"); // MySql versi 5
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }
}

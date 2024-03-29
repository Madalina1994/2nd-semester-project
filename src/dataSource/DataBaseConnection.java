package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String id = "cphbs96"; //Insert ORACLE id and password
    private static final String pw = "cphbs96";
    private static Connection connection;

    private static void intializeConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", id, pw);
        } catch (SQLException e) {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("Could not create a Connection in DBConnector.getConnection(): " + e);
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            intializeConnection();
        }
        return connection;
    }

    public static void releaseConnection(Connection con) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

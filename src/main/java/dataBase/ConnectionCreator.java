package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static final String URL = "jdbc:mysql://localhost:3306/hotelbooking?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection createConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(" не подключилось");
            throw new IllegalArgumentException();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }
}

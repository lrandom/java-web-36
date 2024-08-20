package luan.niit.com.javaweb36.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DB {
    public static final String URL = "jdbc:mysql://localhost:3306/java36";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "koodinh@";
    public Connection connection;

    public Connection getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, DB_USER, DB_PASS);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.bankmsys;
import java.sql.*;

public class DbUtil {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/bankmsys";
        String user = "root";
        String pass = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }
}

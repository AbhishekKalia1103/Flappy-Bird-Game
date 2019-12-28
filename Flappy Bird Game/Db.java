package iflappy;

import java.sql.*;

public class Db {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iflappy", "root", "123");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    }
}

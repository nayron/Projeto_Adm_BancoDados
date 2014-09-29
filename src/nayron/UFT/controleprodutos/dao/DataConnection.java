package nayron.UFT.controleprodutos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/controle", "root", "abc123");
    }
}

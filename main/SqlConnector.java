package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {
    //global connector for controller classes
    private static final String URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER="admin";
    private static final String PASSWORD="password";
    //user name and pass belongs above
    private static Connection connection = null;
    //a connection is created otherwise an error messages will be shown isntead.
    public static Connection getConnection() throws SQLException{
        if(connection==null||connection.isClosed()){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try{
                    connection=DriverManager.getConnection(URL, USER, PASSWORD);
                    System.out.println("You are connected.");
                } catch (SQLException e){
                    System.err.println("Something has gone wrong with Userame and Password. "+e.getMessage());
                }
            } catch (ClassNotFoundException e) {
                System.err.println("Driver connector has gone wrong. "+e.getMessage());
            }
        }
        return connection;
    }
//close connection method
    public static void closeConnection(){
        if(connection!=null){
            try {
                connection.close();
                System.out.println("connection is closed");
            } catch (Exception e) {
                System.err.println("something has gone wrong"+ e.getMessage());
            }
        }
    }
}
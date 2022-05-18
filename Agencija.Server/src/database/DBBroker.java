/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andrej
 */
public class DBBroker {
    private Connection connection;
    private static DBBroker instance;
    
     public static DBBroker getInstance() {
         if(instance == null) {
             instance = new DBBroker();
         }
        return instance;
    }
     
     public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                String url = "jdbc:mysql://localhost:3306/";
                String user = "root";
                String password = "";
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            } catch (SQLException ex) {
                System.out.println("Neuspesno uspostavljanje konekcije!\n" + ex.getMessage());
                throw ex;
            }
        }
        return connection;
    }

     public void disconnect() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska disconnect");
            }
        }
    }

    public void commit() throws Exception {
        if (connection != null) {
            try {
                this.connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception();
            }
        }
    }

    public void rollback() throws Exception {
        if (connection != null) {
            try {
                this.connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception();
            }
        }
    }

    

   
    
}

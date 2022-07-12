/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import constants.MyServerConstants;
import domain.AbstractDomainObject;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Andrej
 */
public class DBBroker {
    
    private static DBBroker instance;
    private Connection connection;

    public Connection getConnection() throws SQLException, IOException {
        if (connection == null || connection.isClosed()) {
            try {
                
               Properties properties = new Properties();
                properties.load(new FileInputStream("config/dbconfig.properties"));
                
                String url = properties.getProperty(MyServerConstants.DB_CONFIG_URL);
                String user = properties.getProperty(MyServerConstants.DB_CONFIG_USERNAME);
                String password = properties.getProperty(MyServerConstants.DB_CONFIG_PASSWORD);
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            } catch (SQLException ex) {
                System.out.println("Neuspesno uspostavljanje konekcije!\n" + ex.getMessage());
                throw ex;
            }
        }
        return connection;
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException, IOException {
        String sql = "SELECT * FROM " + ado.tableName() + " " + ado.alias()
                + " " + ado.join() + " " + ado.condition();
        System.out.println(sql);
        Statement s = getConnection().createStatement();
        ResultSet rs = s.executeQuery(sql);
        return ado.getList(rs);
    }

    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException, IOException {
        String sql = "INSERT INTO " + ado.tableName() + " "
                + ado.insertColumns() + " VALUES(" + ado.insertValue() + ")";
        System.out.println(sql);
        PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(AbstractDomainObject ado) throws SQLException, IOException {
        String sql = "UPDATE " + ado.tableName() + " SET "
                + ado.updateValue() + " WHERE " + ado.primaryKeyValue();
        System.out.println(sql);
        Statement s = getConnection().createStatement();
        s.executeUpdate(sql);
    }

    public void delete(AbstractDomainObject ado) throws SQLException, IOException {
        String sql = "DELETE FROM " + ado.tableName() + " WHERE " + ado.primaryKeyValue();
        System.out.println(sql);
        Statement s = getConnection().createStatement();
        s.executeUpdate(sql);
    }
}

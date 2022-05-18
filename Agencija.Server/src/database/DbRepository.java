/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.SQLException;
import repository.Repository;

/**
 *
 * @author Andrej
 */
public interface DbRepository <T,K> extends Repository<T,K>{
    default public void connect() throws SQLException{
        DBBroker.getInstance().getConnection();
    }
    
    default public void disconnect() throws SQLException{
        DBBroker.getInstance().getConnection().close();
    }
    
    default public void commit() throws SQLException{
        DBBroker.getInstance().getConnection().commit();
    }
    
    default public void rollback() throws SQLException{
        DBBroker.getInstance().getConnection().rollback();
    }
}

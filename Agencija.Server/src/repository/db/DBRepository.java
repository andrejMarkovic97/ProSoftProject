/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import java.io.IOException;
import java.sql.SQLException;
import repository.Repository;

/**
 *
 * @author Andrej
 */
public interface DBRepository<T,K> extends Repository<T, K>{
    default public void connect() throws SQLException, IOException{
        DBConnectionFactory.getInstance().getConnection();
    }
    
    default public void disconnect() throws SQLException, IOException{
        DBConnectionFactory.getInstance().getConnection().close();
    }
    
    default public void commit() throws SQLException, IOException{
        DBConnectionFactory.getInstance().getConnection().commit();
    }
    
    default public void rollback() throws SQLException, IOException{
        DBConnectionFactory.getInstance().getConnection().rollback();
    }
}

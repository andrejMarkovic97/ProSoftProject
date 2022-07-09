/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import domain.Rental;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DBConnectionFactory;
import repository.db.DBRepository;

/**
 *
 * @author Andrej
 */
public class RepositoryRental implements DBRepository<Rental, Long>{
  private Connection connection;

    public RepositoryRental() {
    }
  
    @Override
    public List<Rental> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Rental t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Rental t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Rental t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rental getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteEmployeesRentalsByID(long employeeID) throws Exception {
         String sql = "DELETE FROM rental WHERE EmployeeID="+employeeID+"";
        try {
           connection = DBConnectionFactory.getInstance().getConnection();
           Statement  statement = connection.createStatement();
            
            statement.executeUpdate(sql);
            System.out.println("Successfully deleted employee rentals");
        } catch (SQLException ex) {
           ex.printStackTrace();
           throw new Exception("Can't delete rentals from employee");
        }
    }
    
}

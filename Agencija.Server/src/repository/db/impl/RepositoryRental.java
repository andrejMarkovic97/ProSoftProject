/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import domain.Employee;
import domain.Listing;
import domain.Rental;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
        try {
            List<Rental> rentals = new ArrayList<>();
            String query = "SELECT * FROM rental r JOIN listing l ON (r.listingid=l.listingid)"
                    + " JOIN employee e ON (r.employeeid = e.employeeid)";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Rental r = new Rental();
                Employee e = new Employee();
                e.setEmployeeID(rs.getLong("EmployeeID"));
                e.setFirstName(rs.getString("FirstName"));
                e.setLastName(rs.getString("LastName"));
                e.setRole(rs.getString("Role"));
                e.setUsername(rs.getString("Username"));
                e.setPassword(rs.getString("Password"));
                
                Listing l = new Listing();
                l.setListingID(rs.getLong("ListingID"));
                l.setPublicationDate(new Date(rs.getDate("PublicationDate").getTime()));
                l.setPrice(rs.getInt("Price"));
                l.setAdditionalDescription(rs.getString("AdditionalDescription"));
                
                r.setEmployee(e);
                r.setListing(l);
                r.setRentingDate((new Date(rs.getDate("RentingDate").getTime())));
                
                rentals.add(r);
            }
            rs.close();
            statement.close();
            System.out.println("Rental list loaded successfully!");
            return rentals;
        } catch (SQLException ex) {
            System.out.println("Unsuccessful rental list loading\n" + ex.getMessage());
            throw ex;

        }
    }

    @Override
    public void add(Rental t) throws Exception {
        String query = "INSERT INTO RENTAL(ListingID,EmployeeID,RentingDate) VALUES(?,?,?)";
        try {
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, t.getListing().getListingID());
            statement.setLong(2, t.getEmployee().getEmployeeID());
            statement.setDate(3, new java.sql.Date(t.getRentingDate().getTime()));
            statement.executeUpdate();
            
            System.out.println("Rental added");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failure in adding rental");
        }
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

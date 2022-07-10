/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import domain.Location;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.db.DBConnectionFactory;
import repository.db.DBRepository;

/**
 *
 * @author Andrej
 */
public class RepositoryLocation implements DBRepository<Location, Long>{
  private Connection connection;

    public RepositoryLocation() {
    }
  
    @Override
    public List<Location> getAll() throws Exception {
         try {
            List<Location> locations = new ArrayList<>();
            String query = "SELECT * FROM location";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Location l = new Location();
                l.setLocationID(rs.getLong("LocationID"));
                l.setCity(rs.getString("City"));
                l.setNeighborhood(rs.getString("Neighborhood"));
               locations.add(l);
            }
            rs.close();
            statement.close();
            System.out.println("Location list loaded successfully!");
            return locations;
        } catch (SQLException ex) {
            System.out.println("Unsuccessful location list loading\n" + ex);
            throw ex;

        }
    }

    @Override
    public void add(Location t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Location t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Location t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

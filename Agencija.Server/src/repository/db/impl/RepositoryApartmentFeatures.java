/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;


import domain.ApartmentFeatures;
import domain.Employee;
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
public class RepositoryApartmentFeatures implements DBRepository<ApartmentFeatures, Long>{
  private Connection connection;

    public RepositoryApartmentFeatures() {
    }
  
    @Override
    public List<ApartmentFeatures> getAll() throws Exception {
       try {
            List<ApartmentFeatures> features = new ArrayList<>();
            String query = "SELECT * FROM apartmentfeatures";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                ApartmentFeatures af = new ApartmentFeatures();
                af.setFeatureID(rs.getLong("FeatureID"));
                af.setFeatureName(rs.getString("FeatureName"));
                features.add(af);
            }
            rs.close();
            statement.close();
            System.out.println("Apartment features list loaded successfully!");
            return features;
        } catch (SQLException ex) {
            System.out.println("Unsuccessful features list loading\n" + ex.getMessage());
            throw ex;

        } 
    }

    @Override
    public void add(ApartmentFeatures t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(ApartmentFeatures t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ApartmentFeatures t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ApartmentFeatures getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
 
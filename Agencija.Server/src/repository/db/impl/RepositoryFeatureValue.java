/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import domain.FeatureValue;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DBConnectionFactory;
import repository.db.DBRepository;

/**
 *
 * @author Andrej
 */
public class RepositoryFeatureValue implements DBRepository<FeatureValue, Long> {

    private Connection connection;

    public RepositoryFeatureValue() {
    }

    @Override
    public List<FeatureValue> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(FeatureValue fv) throws Exception {
        String query = "INSERT INTO FEATUREVALUE(ListingID,FeatureID,Value) VALUES(?,?,?)";
        try {
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, fv.getListing().getListingID());
            statement.setLong(2, fv.getAppFeatures().getFeatureID());
            statement.setString(3, fv.getValue());
            statement.executeUpdate();
            System.out.println("Feature value added!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failure in adding feature values");
        }
    }

    @Override
    public void edit(FeatureValue t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(FeatureValue t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FeatureValue getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addFeatureValues(ArrayList<FeatureValue> list, long id) {
        String query = "INSERT INTO FEATUREVALUE VALUES(?,?,?)";
        try {
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            for (FeatureValue featureValue : list) {
                featureValue.getListing().setListingID(id);
                ps.setLong(1, id);
                ps.setLong(2, featureValue.getAppFeatures().getFeatureID());
                ps.setString(3, featureValue.getValue());
                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("Feature values added");
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryFeatureValue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RepositoryFeatureValue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import domain.ApartmentFeatures;
import domain.FeatureValue;
import domain.Listing;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        try {
            String sql = "UPDATE FEATUREVALUE SET Value='" + t.getValue() + "'"
                    + "WHERE ListingID=" + t.getListing().getListingID() + ""
                    + " AND FeatureID=" + t.getAppFeatures().getFeatureID();
            System.out.println(sql);
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.prepareStatement(sql);

            statement.executeUpdate(sql);
            System.out.println("Successfully updated Feature value");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Unsuccessfully updated feature value, Error :" + ex.getMessage());
        }
    }

    @Override
    public void delete(FeatureValue t) throws IOException {
        String sql = "DELETE FROM FEATUREVALUE WHERE ListingID=" + t.getListing().getListingID();
        System.out.println(sql);
        try {
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryFeatureValue.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public ArrayList<FeatureValue> getAllByID(long id) throws IOException, SQLException {
        String query = "SELECT * FROM featurevalue fv JOIN apartmentfeatures af"
                + " ON (fv.featureid = af.featureid) WHERE listingid =" + id;
        System.out.println(query);
        try {
            ArrayList<FeatureValue> features = new ArrayList<>();

            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                FeatureValue fv = new FeatureValue();
                ApartmentFeatures at = new ApartmentFeatures();
                at.setFeatureID(rs.getLong("FeatureID"));
                at.setFeatureName(rs.getString("FeatureName"));
                fv.setAppFeatures(at);
                Listing listing = new Listing();
                listing.setListingID(rs.getLong("ListingID"));
                fv.setListing(listing);
                fv.setValue(rs.getString("Value"));
                features.add(fv);
            }
            rs.close();
            statement.close();
            System.out.println("feature value list loaded successfully!");
            return features;
        } catch (SQLException ex) {
            System.out.println("Unsuccessful features list loading\n" + ex.getMessage());
            throw ex;

        }
    }

    public void deleteByID(long listingID) throws IOException {
        String sql = "DELETE FROM FEATUREVALUE WHERE ListingID="+listingID;
        System.out.println(sql);
        try {
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryFeatureValue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

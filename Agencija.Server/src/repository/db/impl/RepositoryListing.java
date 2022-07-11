/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import domain.Listing;
import domain.Location;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class RepositoryListing implements DBRepository<Listing, Long> {

    private Connection connection;
    private long id;

    public RepositoryListing() {

    }

    @Override
    public List<Listing> getAll() throws Exception {
        try {
            List<Listing> listings = new ArrayList<>();
            String query = "SELECT * FROM listing l JOIN location loc ON (l.locationid=loc.locationid)";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Listing l = new Listing();
                l.setListingID(rs.getLong("ListingID"));
                l.setPublicationDate(new Date(rs.getDate("PublicationDate").getTime()));
                l.setPrice(rs.getInt("Price"));
                l.setAdditionalDescription(rs.getString("AdditionalDescription"));
                Location loc = new Location();
                loc.setLocationID(rs.getLong("LocationID"));
                loc.setCity(rs.getString("City"));
                loc.setNeighborhood(rs.getString("Neighborhood"));
                l.setLocation(loc);
                listings.add(l);
            }
            rs.close();
            statement.close();
            System.out.println("Listing list loaded successfully!");
            return listings;
        } catch (SQLException ex) {
            System.out.println("Unsuccessful listing list loading\n" + ex.getMessage());
            throw ex;

        }
    }

    @Override
    public void add(Listing l) throws IOException, Exception {
        String query = "INSERT INTO Listing(PublicationDate,Price,AdditionalDescription,LocationID) VALUES(?,?,?,?)";
        try {
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, new Date(l.getPublicationDate().getTime()));
            statement.setInt(2, l.getPrice());
            statement.setString(3, l.getAdditionalDescription());
            statement.setLong(4, l.getLocation().getLocationID());
            statement.executeUpdate();

            System.out.println("Listing added");
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            RepositoryFeatureValue storageValues = new RepositoryFeatureValue();
            storageValues.addFeatureValues(l.getFeatureValues(), id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failure in adding employee");
        }

    }

    @Override
    public void edit(Listing t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Listing t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Listing getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

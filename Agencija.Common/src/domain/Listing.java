/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Andrej
 */
public class Listing extends AbstractDomainObject implements Serializable{
   private long listingID;
    private Date publicationDate;
    private int price;
    private String additionalDescription;
    private ArrayList<FeatureValue> featureValues;
    private ArrayList<Rental> rentals;
    private Location location;

    public Listing() {
    }

    public Listing(long listingID, Date publicationDate, int price, String additionalDescription, ArrayList<FeatureValue> featureValues, ArrayList<Rental> rentals, Location location) {
        this.listingID = listingID;
        this.publicationDate = publicationDate;
        this.price = price;
        this.additionalDescription = additionalDescription;
        this.featureValues = featureValues;
        this.rentals = rentals;
        this.location = location;
    }

   

    

    public ArrayList<FeatureValue> getFeatureValues() {
        return featureValues;
    }

    public void setFeatureValues(ArrayList<FeatureValue> featureValues) {
        this.featureValues = featureValues;
    }

    public long getListingID() {
        return listingID;
    }

    public void setListingID(long listingID) {
        this.listingID = listingID;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(ArrayList<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public String tableName() {
        return " listing ";
    }

    @Override
    public String alias() {
        return " l ";
    }

    @Override
    public String join() {
        return " join location loc on (l.locationid=loc.locationid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Location loc = new Location(rs.getLong("LocationID"), rs.getString("City"),rs.getString("Neighborhood"));
            
            Listing listing = new Listing(rs.getLong("ListingID"), new Date(rs.getDate("PublicationDate").getTime()),
                    rs.getInt("Price"), rs.getString("AdditionalDescription"), null, null, loc);

            lista.add(listing);
        }

        rs.close();
        return lista;
    }

    @Override
    public String insertColumns() {
        return " (PublicationDate, Price, AdditionalDescription, LocationID) ";
    }

    @Override
    public String primaryKeyValue() {
        return " ListingID = "+listingID;
    }

    @Override
    public String insertValue() {
        return " '"+new java.sql.Date(publicationDate.getTime())+"', "+price+"',"
                + " '"+additionalDescription+"', "+location.getLocationID(); 
    }

    @Override
    public String updateValue() {
        return " price="+price+", AdditionalDescription='"+additionalDescription+"',"
                + " LocationID="+location.getLocationID()+" ";
    }

    @Override
    public String condition() {
        return "WHERE listingID= "+listingID;
    }
    
}

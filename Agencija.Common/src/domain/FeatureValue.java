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
public class FeatureValue extends AbstractDomainObject implements Serializable{
    private String value;
    private Listing listing;
    private ApartmentFeatures appFeatures;

    public FeatureValue() {
    }

    public FeatureValue(String value, Listing listing, ApartmentFeatures appFeatures) {
        this.value = value;
        this.listing = listing;
        this.appFeatures = appFeatures;
    }

    

    public ApartmentFeatures getAppFeatures() {
        return appFeatures;
    }

    public void setAppFeatures(ApartmentFeatures appFeatures) {
        this.appFeatures = appFeatures;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    @Override
    public String tableName() {
        return " featurevalue";
    }

    @Override
    public String alias() {
        return " fv";
    }

    @Override
    public String join() {
        return " join listing l on (fv.listingid = l.listingid) "
                + "join apartmentfeatures af on (fv.featureid=af.featureid) "
                + "join location loc on (l.locationid=loc.locationid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
         ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            Location loc = new Location(rs.getLong("LocationID"), rs.getString("City"), rs.getString("Neighborhood"));
            
            Listing l = new Listing(rs.getLong("ListingID"), new Date(rs.getDate("PublicationDate").getTime())
                    ,rs.getInt("Price"),rs.getString("AdditionalDescription"),null,null,loc);
            
            ApartmentFeatures af = new ApartmentFeatures(rs.getLong("FeatureID"), rs.getString("FeatureName"),null);
            
           FeatureValue fv = new FeatureValue(rs.getString("Value"), l, af);

            lista.add(fv);
        }

        rs.close();
        return lista;
    }

    @Override
    public String insertColumns() {
        return " (ListingID, FeatureID, Value) ";
    }

    @Override
    public String primaryKeyValue() {
        return " ListingID= "+listing.getListingID();
    }

    @Override
    public String insertValue() {
        return listing.getListingID()+", "+appFeatures.getFeatureID()+", '"+value+"'";
    }

    @Override
    public String updateValue() {
        return " Value='"+value+"' ";
    }

    @Override
    public String condition() {
//        return " Where ListingID="+listing.getListingID()+" AND FeatureID="+appFeatures.getFeatureID()+" ";
        return"";
    }
    
}

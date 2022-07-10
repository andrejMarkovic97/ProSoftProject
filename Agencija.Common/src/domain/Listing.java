/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Andrej
 */
public class Listing implements Serializable{
   private long listingID;
    private Date publicationDate;
    private int price;
    private String additionalDescription;
    private ArrayList<FeatureValue> featureValues;
    private Location location;

    public Listing() {
    }

    public Listing(long listingID, Date publicationDate, int price, String additionalDescription, ArrayList<FeatureValue> featureValues,Location location) {
        this.listingID = listingID;
        this.publicationDate = publicationDate;
        this.price = price;
        this.additionalDescription = additionalDescription;
        this.featureValues = featureValues;
        this.location=location;
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
    
}

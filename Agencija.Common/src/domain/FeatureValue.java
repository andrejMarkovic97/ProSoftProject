/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Andrej
 */
public class FeatureValue implements Serializable{
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
    
}

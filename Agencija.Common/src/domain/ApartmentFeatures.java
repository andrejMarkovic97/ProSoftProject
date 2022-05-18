/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Andrej
 */
public class ApartmentFeatures implements Serializable{

    private long featureID;
    private String featureName;
    private ArrayList<FeatureValue> featureValues;

    public ApartmentFeatures() {
    }

    public ApartmentFeatures(long featureID, String featureName, ArrayList<FeatureValue> featureValues) {
        this.featureID = featureID;
        this.featureName = featureName;
        this.featureValues = featureValues;
    }

    public ArrayList<FeatureValue> getFeatureValues() {
        return featureValues;
    }

    public void setFeatureValues(ArrayList<FeatureValue> featureValues) {
        this.featureValues = featureValues;
    }

    public long getFeatureID() {
        return featureID;
    }

    public void setFeatureID(long featureID) {
        this.featureID = featureID;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

}

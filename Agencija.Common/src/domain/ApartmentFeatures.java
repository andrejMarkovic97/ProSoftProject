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

/**
 *
 * @author Andrej
 */
public class ApartmentFeatures extends AbstractDomainObject implements Serializable {

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

    @Override
    public String tableName() {
        return " apartmentfeatures ";
    }

    @Override
    public String alias() {
        return " af ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            ApartmentFeatures a = new ApartmentFeatures();
            a.setFeatureID(rs.getLong("FeatureID"));
            a.setFeatureName(rs.getString("FeatureName"));

            lista.add(a);
        }

        rs.close();
        return lista;
    }

    @Override
    public String insertColumns() {
        return "";
    }

    @Override
    public String primaryKeyValue() {
        return " FeatureID="+featureID;
    }

    @Override
    public String insertValue() {
        return "";
    }

    @Override
    public String updateValue() {
        return "";
    }

    @Override
    public String condition() {
        return "";
    }

}

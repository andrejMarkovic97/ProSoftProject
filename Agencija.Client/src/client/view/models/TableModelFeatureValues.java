/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.models;

import client.controller.ClientController;
import domain.ApartmentFeatures;
import domain.FeatureValue;
import domain.Listing;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andrej
 */
public class TableModelFeatureValues extends AbstractTableModel{
    private ArrayList<FeatureValue> list;
    private Listing listing;
    String[] columns = {"Feature name", "Value"};

    public TableModelFeatureValues() {
        list = new ArrayList<>();
    }

   

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FeatureValue fv  = list.get(rowIndex);
       
        switch (columnIndex) {
            case 0:
                return fv.getAppFeatures().getFeatureName();
            case 1:
                return fv.getValue();
            default:
                return "return!";
        }
    }

    public void fillTable() {
        try {
            list = ClientController.getInstance().getAllFeatureValues();
            ArrayList<FeatureValue> newList = new ArrayList<>();
            for (FeatureValue featureValue : list) {
                if(featureValue.getListing().getListingID()==listing.getListingID()){
                    listing.setFeatureValues(new ArrayList<>());
                    listing.getFeatureValues().add(featureValue);
                    newList.add(featureValue);
                }
            }
            list=newList;
            fireTableDataChanged();
        } catch (Exception ex) {
            System.out.println("Can't fill table, Error : "+ex.getMessage());
            Logger.getLogger(TableModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public FeatureValue getFeatureValue(int row) {
        return list.get(row);
    }

    public void UpdateFeatureValue(FeatureValue newFv) {
        for (FeatureValue featureValue : list) {
            if(featureValue.getAppFeatures().getFeatureID()==newFv.getAppFeatures().getFeatureID()
                    && featureValue.getListing().getListingID()==newFv.getListing().getListingID()){
                featureValue=newFv;
            }
        }
        fireTableDataChanged();
    }

    public ArrayList<FeatureValue> getList() {
        return list;
    }
}

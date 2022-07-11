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
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andrej
 */
public class TableModelApartmentFeatures extends AbstractTableModel {

    private ArrayList<ApartmentFeatures> list;
    private Listing listing = null;
    String[] columns = {"Feature name", "Value"};

    public TableModelApartmentFeatures() {
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
        ApartmentFeatures af = list.get(rowIndex);
       
        switch (columnIndex) {
            case 0:
                return af.getFeatureName();
            case 1:
                if (af.getFeatureValues()!=null && af.getFeatureValues().size() > 0) {
                    for (FeatureValue featureValue : af.getFeatureValues()) {
                        if(featureValue.getListing().getListingID()==listing.getListingID()){
                            return featureValue.getValue();
                        }
                    }
                } else {
                    return "No value assigned";
                }
            default:
                return "return!";
        }
    }

    public void fillTable() {
        try {
            list = ClientController.getInstance().getAllApartmentFeatures();
            fireTableDataChanged();
        } catch (Exception ex) {
            System.out.println("Can't fill table, Error : "+ex.getMessage());
            Logger.getLogger(TableModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ApartmentFeatures getApartmentFeature(int row) {
        if (row > list.size()) {
            return null;
        } else {
            return list.get(row);
        }
    }

    public void updateFeature(ApartmentFeatures af) {
        for (ApartmentFeatures apartmentFeat : list) {
            if (apartmentFeat.getFeatureID() == af.getFeatureID()) {
                apartmentFeat = af;
            }
        }
        fireTableDataChanged();
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

//    public void fillTableWithListingID(long listingID) throws Exception {
//        list = ClientController.getInstance().getAllApartmentFeatures();
//        ArrayList<FeatureValue> featureValues = ClientController.getInstance().getAllFeatureValues(listing.getListingID());
//        for (FeatureValue fv : featureValues) {
//            fv.setListing(listing);
//        }
//        listing.setFeatureValues(featureValues);
//        
//    }

    public void fillTableWithListingFeatureValueDetails() throws Exception {
        list = ClientController.getInstance().getAllApartmentFeatures();
        for (ApartmentFeatures af : list) {
            for (FeatureValue featureValue : listing.getFeatureValues()) {
                System.out.println("Listing ID "+featureValue.getListing().getListingID());
                if(featureValue.getAppFeatures().getFeatureID()==af.getFeatureID()){
                    if(af.getFeatureValues()==null){
                        af.setFeatureValues(new ArrayList<>());
                    }
                    af.getFeatureValues().add(featureValue);
                    System.out.println(af.getFeatureID()+" "+featureValue.getAppFeatures().getFeatureID());
                }
            }
        }
        fireTableDataChanged();
    }

    public void setList(ArrayList<ApartmentFeatures> list) {
        this.list = list;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.models;

import client.controller.ClientController;
import domain.Listing;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andrej
 */
public class TableModelListing extends AbstractTableModel {

    private ArrayList<Listing> list;
    String[] columns = {"City", "Neighborhood", "Price", "Publication Date"};

    public TableModelListing() {
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
        Listing listing = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return listing.getLocation().getCity();
            case 1:
                return listing.getLocation().getNeighborhood();
            case 2:
                return listing.getPrice() + "€";
            case 3:
                return listing.getPublicationDate();

            default:
                return "return!";
        }
    }

    public void fillTable() {
        try {
            list = ClientController.getInstance().getAllListings();
            for (Listing listing : list) {
                listing.setFeatureValues(ClientController.getInstance().getAllFeatureValues(listing.getListingID()));
            }
            fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Can't fill listing table");
        }
    }

    public void search(String param) throws Exception {
        if (param.contains("€")) {
            param = param.substring(0, param.length() - 1);
        }
        ArrayList<Listing> newList = new ArrayList<>();
        if (!param.equals("")) {
            for (Listing l : list) {

                if (l.getLocation().getCity().toLowerCase().contains(param.toLowerCase())
                        || l.getLocation().getNeighborhood().toLowerCase().contains(param.toLowerCase())) {
                    newList.add(l);
                }
                try {
                    if (Integer.parseInt(param) >= l.getPrice()) {
                        newList.add(l);
                    }
                } catch (NumberFormatException nbfe) {

                }

            }
            if (newList.isEmpty()) {
                throw new Exception("Sistem ne može da pronađe zaposlene po zadatim vrijednostima");
            }
            list = newList;
            fireTableDataChanged();
        } else {
            throw new Exception("Prvo unesite vrijednost prije pretrage");
        }
    }

    public Listing getListingAtRow(int row) {
        Listing l = list.get(row);
        return l;
    }

    public void addListing(Listing listing) {
        list.add(listing);
        fireTableDataChanged();
    }

}

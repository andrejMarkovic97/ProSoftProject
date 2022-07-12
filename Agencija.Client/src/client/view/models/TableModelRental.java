/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.models;

import client.controller.ClientController;
import domain.Rental;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andrej
 */
public class TableModelRental extends AbstractTableModel {

    private ArrayList<Rental> list;
    String[] columns = {"Listing ID", "Agent", "Renting Date"};

    public TableModelRental() {
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
        Rental rental = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rental.getListing().getListingID();
            case 1:
                return rental.getEmployee().getFirstName() + " " + rental.getEmployee().getLastName();
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                String date = sdf.format(rental.getRentingDate());
                return date;
            default:
                return "return!";
        }
    }

    public void fillTable() {
        ArrayList<Rental> rentals = new ArrayList<>();
        try {
            rentals = ClientController.getInstance().getAllRentals();
        } catch (Exception ex) {
            Logger.getLogger(TableModelRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        list = rentals;
        fireTableDataChanged();
    }

    public Rental getRentalAtRow(int row) {
        return list.get(row);
    }

    public void search(String param) throws Exception {
        ArrayList<Rental> newList = new ArrayList<>();
        if (!param.equals("")) {
            for (Rental rental : list) {
                if (rental.getEmployee().getFirstName().toLowerCase().contains(param.toLowerCase())
                        || rental.getEmployee().getLastName().toLowerCase().contains(param.toLowerCase())) {
                    newList.add(rental);
                }
            }
            if (newList.isEmpty()) {
                throw new Exception("Sistem ne može da pronađe izdavanja po zadatim vrijednostima");
            }
            list = newList;
            fireTableDataChanged();
        } else {
            throw new Exception("Prvo unesite vrijednost prije pretrage");
        }
    }
}

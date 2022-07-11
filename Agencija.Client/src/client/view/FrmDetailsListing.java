/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import client.controller.ClientController;
import client.view.models.TableModelApartmentFeatures;
import domain.ApartmentFeatures;
import domain.FeatureValue;
import domain.Listing;
import domain.Location;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Andrej
 */
public class FrmDetailsListing extends javax.swing.JDialog {

    private Listing listing;
    private ArrayList<Location> locations;

    public FrmDetailsListing(Listing l) {
        this.listing = l;
        initComponents();
        fillLocations();
        txtPrice.setText(String.valueOf(l.getPrice()));
        txtDescription.setText(l.getAdditionalDescription());
        TableModelApartmentFeatures model = new TableModelApartmentFeatures();
        tblFeatureValues.setModel(model);
        getFeatureValues();
        model.setListing(listing);
        fillTable();
        txtPrice.setEditable(false);
        txtDescription.setEditable(false);
        btnInsert.setEnabled(false);
        btnSubmit.setEnabled(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbCity = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbNeighborhood = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFeatureValues = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("City");

        cmbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Neighborhood");

        cmbNeighborhood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Price");

        txtPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel4.setText("Additional Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        tblFeatureValues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblFeatureValues);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert feature value");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnSubmit)
                    .addComponent(btnInsert))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbNeighborhood, 0, 275, Short.MAX_VALUE)
                            .addComponent(txtPrice)
                            .addComponent(jScrollPane1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)))
                .addGap(14, 14, 14)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        txtPrice.setEditable(true);
        txtDescription.setEditable(true);
        btnInsert.setEnabled(true);
        btnSubmit.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        int row = tblFeatureValues.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Izaberite odgovarajucu karakteristiku", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        TableModelApartmentFeatures model = (TableModelApartmentFeatures) tblFeatureValues.getModel();
        ApartmentFeatures af = model.getApartmentFeature(row);
        FrmFeatureValues frm = new FrmFeatureValues(af, null, listing);
        frm.setFrmDetailsListing(this);
        frm.setVisible(true);
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Da li sigurno zelis ove promjene izvrsiti?", "Confirm edit", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.NO_OPTION) {
            return;
        }

        if (option == JOptionPane.YES_OPTION) {
            try {
                listing.setPrice(Integer.parseInt(txtPrice.getText()));
                String city = (String) cmbCity.getSelectedItem();
                String neighborhood = (String) cmbNeighborhood.getSelectedItem();
                for (Location location : locations) {
                    if(location.getCity().equals(city) && location.getNeighborhood().equals(neighborhood)){
                        listing.setLocation(location);
                    }
                }
                listing.setAdditionalDescription(txtDescription.getText());
                ClientController.getInstance().updateListing(listing);
                JOptionPane.showMessageDialog(this, "Uspješna izmjena oglasa");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbCity;
    private javax.swing.JComboBox<String> cmbNeighborhood;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblFeatureValues;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JFormattedTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    private void fillLocations() {
        locations = new ArrayList<>();
        try {
            locations = ClientController.getInstance().getAllLocations();
        } catch (Exception ex) {
            Logger.getLogger(FrmSelectLocation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ArrayList<String> cities = new ArrayList<>();
        cmbCity.removeAllItems();
        for (Location loc : locations) {
            if (!cities.contains(loc.getCity())) {
                cities.add(loc.getCity());
                cmbCity.addItem(loc.getCity());
            }

        }
        cmbCity.setSelectedItem(listing.getLocation().getCity());;
        fillNeighborhoods(listing.getLocation().getCity());
    }

    private void fillNeighborhoods(String city) {
        cmbNeighborhood.removeAllItems();
        ArrayList neighborhoods = new ArrayList();
        for (Location loc : locations) {
            if (loc.getCity().equals(city) && !neighborhoods.contains(loc.getNeighborhood())) {
                cmbNeighborhood.addItem(loc.getNeighborhood());
                neighborhoods.add(loc.getNeighborhood());
            }
        }
        cmbNeighborhood.setSelectedItem(listing.getLocation().getNeighborhood());
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    private void getFeatureValues() {
        try {
            ArrayList<FeatureValue> featureValues = ClientController.getInstance().getAllFeatureValues(listing.getListingID());

            for (FeatureValue fv : featureValues) {
                fv.setListing(listing);
            }
            listing.setFeatureValues(featureValues);
        } catch (Exception ex) {
            Logger.getLogger(FrmDetailsListing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillTable() {
        TableModelApartmentFeatures model = (TableModelApartmentFeatures) tblFeatureValues.getModel();
        try {
            model.fillTableWithListingFeatureValueDetails();
        } catch (Exception ex) {
            Logger.getLogger(FrmDetailsListing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void addApartmentFeature(ApartmentFeatures af) {
        TableModelApartmentFeatures model = (TableModelApartmentFeatures) tblFeatureValues.getModel();
        model.addApartmentFeature(af);
    }

}

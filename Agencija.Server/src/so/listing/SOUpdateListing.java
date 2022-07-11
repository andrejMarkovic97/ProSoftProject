/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.listing;

import domain.FeatureValue;
import domain.Listing;
import java.util.ArrayList;
import repository.db.impl.RepositoryFeatureValue;
import repository.db.impl.RepositoryListing;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOUpdateListing extends AbstractSO {

    private final RepositoryListing storageListing;
    private final RepositoryFeatureValue storageFeatureValue;

    public SOUpdateListing() {
        storageListing = new RepositoryListing();
        storageFeatureValue = new RepositoryFeatureValue();
    }

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Listing)) {
            throw new Exception("Invalid parametar");
        }
        Listing listing = (Listing) param;
        if (listing.getPrice() == 0 || listing.getFeatureValues() == null || listing.getFeatureValues().isEmpty()
                || listing.getLocation() == null || listing.getPublicationDate() == null) {
            throw new Exception("Empty parameters");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Listing l = (Listing) param;
        storageListing.connect();
        storageListing.edit(l);
        ArrayList<FeatureValue> list = storageFeatureValue.getAllByID(l.getListingID());
        ArrayList<FeatureValue> insert = new ArrayList<>();
        ArrayList<FeatureValue> update = new ArrayList<>();

        for (FeatureValue featureValue : l.getFeatureValues()) {
            boolean toUpdate = false;
            for (FeatureValue fv : list) {
                if (featureValue.getAppFeatures().getFeatureID() == fv.getAppFeatures().getFeatureID()
                        && featureValue.getListing().getListingID()==fv.getListing().getListingID()) {
                    toUpdate = true;
                    update.add(featureValue);
                }
            }
            if (toUpdate == false) {
                insert.add(featureValue);
            }
        }

        for (FeatureValue fv1 : update) {
            storageFeatureValue.edit(fv1);
        }

        for (FeatureValue fv2 : insert) {
            storageFeatureValue.add(fv2);
        }

    }

    @Override
    protected void commitTransaction() throws Exception {
        storageListing.commit();
    }

    @Override
    protected void rollbackTransaction() throws Exception {
        storageListing.rollback();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.listing;

import domain.FeatureValue;
import domain.Listing;
import repository.db.impl.RepositoryFeatureValue;
import repository.db.impl.RepositoryListing;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SODeleteListing extends AbstractSO {

    private final RepositoryListing storageListing;
    private final RepositoryFeatureValue storageFeatureValue;

    public SODeleteListing() {
        storageFeatureValue = new RepositoryFeatureValue();
        storageListing = new RepositoryListing();
    }

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Listing)) {
            throw new Exception("Invalid parametar");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Listing l = (Listing) param;
        if (l.getFeatureValues() != null) {
            for (FeatureValue featureValue : l.getFeatureValues()) {
                storageFeatureValue.connect();
                storageFeatureValue.delete(featureValue);
            }
        }
        storageListing.connect();
        storageListing.delete(l);

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

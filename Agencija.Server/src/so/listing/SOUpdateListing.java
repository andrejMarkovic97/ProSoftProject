/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.listing;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.FeatureValue;
import domain.Listing;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOUpdateListing extends AbstractSO {

    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Listing)) {
            throw new Exception("Invalid parametar");
        }
        Listing listing = (Listing) ado;
        if (listing.getPrice() == 0 || listing.getFeatureValues() == null || listing.getFeatureValues().isEmpty()
                || listing.getLocation() == null || listing.getPublicationDate() == null) {
            throw new Exception("Empty parameters");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);

        Listing l = (Listing) ado;

        if (l.getFeatureValues() != null) {
            DBBroker.getInstance().delete(l.getFeatureValues().get(0));
            for (FeatureValue featureValue : l.getFeatureValues()) {
                DBBroker.getInstance().insert(featureValue);
            }

        }

    }
}

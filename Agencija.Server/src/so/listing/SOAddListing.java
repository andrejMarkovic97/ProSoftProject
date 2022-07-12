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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOAddListing extends AbstractSO {

    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Listing)) {
            throw new Exception("Invalid parametar");
        }

    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long listingID = tableKeys.getLong(1);

        Listing l = (Listing) ado;
        l.setListingID(listingID);

        if (l.getFeatureValues() != null && !l.getFeatureValues().isEmpty()) {
            for (FeatureValue featureValue : l.getFeatureValues()) {
                featureValue.setListing(l);
                DBBroker.getInstance().insert(featureValue);
            }
        }
    }

}

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
import domain.Rental;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SODeleteListing extends AbstractSO {



    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Listing)) {
            throw new Exception("Invalid parametar");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
//        Listing l = (Listing) ado;
//        
//        if(l.getFeatureValues()!=null){
//            for (FeatureValue featureValue : l.getFeatureValues()) {
//                DBBroker.getInstance().delete(featureValue);
//            }
//        }
//        
//        if(l.getRentals()!=null){
//            for (Rental rental : l.getRentals()) {
//                DBBroker.getInstance().delete(rental);
//            }
//        }
//        
        DBBroker.getInstance().delete(ado);
    }

}

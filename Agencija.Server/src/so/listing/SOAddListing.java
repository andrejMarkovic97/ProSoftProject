/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.listing;

import domain.Listing;
import java.util.ArrayList;
import repository.db.impl.RepositoryListing;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOAddListing extends AbstractSO{
    private final RepositoryListing storageListing;

    public SOAddListing() {
        storageListing = new RepositoryListing();
    }
    
    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Listing)) {
            throw new Exception("Invalid parametar");
        }
        Listing l= (Listing) param;
        ArrayList<Listing> listings = (ArrayList<Listing>) storageListing.getAll();
        for (Listing listing : listings) {
            if(listing.getListingID()==l.getListingID()){
                throw new Exception("This listing already exists!");
            }
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Listing l = (Listing) param;
        storageListing.connect();
        storageListing.add(l);
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

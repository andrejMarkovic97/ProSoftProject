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
public class SOGetAllListings extends AbstractSO{
    private final RepositoryListing storageListing;
    private ArrayList<Listing> list;
    public SOGetAllListings() {
    storageListing = new RepositoryListing();
    }
    
    
    @Override
    protected void precondition(Object param) throws Exception {

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
     storageListing.connect();
     list = (ArrayList<Listing>) storageListing.getAll();
    }

    public ArrayList<Listing> getList() {
        return list;
    }
    
}

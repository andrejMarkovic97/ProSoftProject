/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.listing;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Listing;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOGetAllListings extends AbstractSO{
    private ArrayList<Listing> list;
    
    

    public ArrayList<Listing> getList() {
        return list;
    }

    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Listing)) {
            throw new Exception("The object that has been sent is not a instance of class Listing!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
      ArrayList<AbstractDomainObject> listings = DBBroker.getInstance().select(ado);
        list = (ArrayList<Listing>) (ArrayList<?>) listings;  
    }
    
}

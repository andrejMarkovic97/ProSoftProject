/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rental;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Rental;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOGetAllRentals extends AbstractSO{
    private ArrayList<Rental> list;

    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
         if (!(ado instanceof Rental)) {
            throw new Exception("Invalid parametar");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
         ArrayList<AbstractDomainObject> rentals = DBBroker.getInstance().select(ado);
        list = (ArrayList<Rental>) (ArrayList<?>) rentals ;  
    }

    public ArrayList<Rental> getList() {
        return list;
    }
    
}

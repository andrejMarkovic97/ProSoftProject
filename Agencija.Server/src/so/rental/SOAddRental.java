/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rental;

import domain.Listing;
import domain.Rental;
import java.util.ArrayList;
import repository.db.impl.RepositoryRental;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOAddRental extends AbstractSO{
    private final RepositoryRental storageRental;

    public SOAddRental() {
        storageRental=new RepositoryRental();
    }
    
    
  protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Rental)) {
            throw new Exception("Invalid parametar");
        }
        Rental r = (Rental) param;
        if(r.getEmployee()==null || r.getListing()==null || r.getRentingDate()==null){
            throw new Exception("Empty parameters");
        }
        ArrayList<Rental> rentals = (ArrayList<Rental>) storageRental.getAll();
       for (Rental rental : rentals) {
          if(r.getEmployee().getEmployeeID()==rental.getEmployee().getEmployeeID() &&
                  r.getListing().getListingID()==rental.getListing().getListingID()
                  && r.getRentingDate()==rental.getRentingDate()){
              throw new Exception("Rental already exists!");
          }
      }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Rental r = (Rental) param;
       storageRental.connect();
       storageRental.add(r);

    }

    @Override
    protected void commitTransaction() throws Exception {
        storageRental.commit();
    }

    @Override
    protected void rollbackTransaction() throws Exception {
        storageRental.rollback();

    }

    
}

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
public class SOAddRental extends AbstractSO {

    protected void precondition(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Rental)) {
            throw new Exception("Invalid parametar");
        }
        Rental r = (Rental) ado;
        if (r.getEmployee() == null || r.getListing() == null || r.getRentingDate() == null) {
            throw new Exception("Empty parameters");
        }

        ArrayList<Rental> rentals = (ArrayList<Rental>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        for (Rental rental : rentals) {
            if (rental.getEmployee().getEmployeeID() == r.getEmployee().getEmployeeID()
                    && rental.getListing().getListingID() == r.getListing().getListingID()
                    && rental.getRentingDate().equals(r.getRentingDate())) {
                throw new Exception("Rental already exists!");
            }
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.location;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Location;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOGetAllLocations extends AbstractSO {

    private ArrayList<Location> list;

    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof Location)) {
            throw new Exception("The object that has been sent is not a instance of class Location!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> locations = DBBroker.getInstance().select(ado);
        list = (ArrayList<Location>) (ArrayList<?>) locations;
    }

    public ArrayList<Location> getList() {
        return list;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.apartmentfeatures;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.ApartmentFeatures;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOGetAllApartmentFeatures extends AbstractSO{
    private ArrayList<ApartmentFeatures> list;
    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof ApartmentFeatures)) {
            throw new Exception("The object that has been sent is not a instance of class ApartmentFeatures!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> features = DBBroker.getInstance().select(ado);
        list =  (ArrayList<ApartmentFeatures>)(ArrayList<?>)features;
    }

    public ArrayList<ApartmentFeatures> getList() {
        return list;
    }


    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.apartmentfeatures;

import domain.ApartmentFeatures;
import java.util.ArrayList;
import repository.db.impl.RepositoryApartmentFeatures;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOGetAllApartmentFeatures extends AbstractSO{
    private final RepositoryApartmentFeatures storageFeatures;
    private ArrayList<ApartmentFeatures> list;
    public SOGetAllApartmentFeatures() {
        storageFeatures = new RepositoryApartmentFeatures();
    }
    
    
    @Override
    protected void precondition(Object param) throws Exception {

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        storageFeatures.connect();
        list = (ArrayList<ApartmentFeatures>) storageFeatures.getAll();
    }

    public ArrayList<ApartmentFeatures> getList() {
        return list;
    }
    
}

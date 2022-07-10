/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.location;

import domain.Location;
import java.util.ArrayList;
import repository.db.impl.RepositoryLocation;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOGetAllLocations extends AbstractSO{
    private final RepositoryLocation storageLocation;
    private ArrayList<Location> list;

    public SOGetAllLocations() {
        storageLocation = new RepositoryLocation();
    }
    
    
    @Override
    protected void precondition(Object param) throws Exception {
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        storageLocation.connect();
        list = (ArrayList<Location>) storageLocation.getAll();
       
    }

    public ArrayList<Location> getList() {
        return list;
    }
    
}

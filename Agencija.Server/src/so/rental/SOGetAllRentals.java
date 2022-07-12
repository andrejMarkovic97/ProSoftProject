/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rental;

import domain.Rental;
import java.util.ArrayList;
import repository.db.impl.RepositoryRental;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOGetAllRentals extends AbstractSO{
    private final RepositoryRental storageRental;
    private ArrayList<Rental> list;

    public SOGetAllRentals() {
        storageRental=new RepositoryRental();
    }
    
     protected void precondition(Object param) throws Exception {
   
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        storageRental.connect();
        list = (ArrayList<Rental>) storageRental.getAll();

    }

    @Override
    protected void commitTransaction() throws Exception {
        storageRental.commit();
    }

    @Override
    protected void rollbackTransaction() throws Exception {
        storageRental.rollback();

    }

    public ArrayList<Rental> getList() {
        return list;
    }
}

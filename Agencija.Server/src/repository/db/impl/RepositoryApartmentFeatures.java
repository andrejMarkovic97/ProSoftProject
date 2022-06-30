/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;


import domain.ApartmentFeatures;
import java.sql.Connection;
import java.util.List;
import repository.db.DBRepository;

/**
 *
 * @author Andrej
 */
public class RepositoryApartmentFeatures implements DBRepository<ApartmentFeatures, Long>{
  private Connection connection;

    public RepositoryApartmentFeatures() {
    }
  
    @Override
    public List<ApartmentFeatures> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(ApartmentFeatures t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(ApartmentFeatures t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ApartmentFeatures t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ApartmentFeatures getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
 
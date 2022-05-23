/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DbRepository;
import domain.Employee;
import repository.db.impl.RepositoryApartmentFeatures;
import repository.db.impl.RepositoryEmployee;
import repository.db.impl.RepositoryFeatureValue;
import repository.db.impl.RepositoryListing;
import repository.db.impl.RepositoryLocation;
import repository.db.impl.RepositoryRental;



/**
 *
 * @author Andrej
 */
public class Controller {
   private static Controller instance;
   private final DbRepository storageEmployee;
   private final DbRepository storageApartmentFeatures;
   private final DbRepository storageFeatureValue;
   private final DbRepository storageListing;
   private final DbRepository storageLocation;
   private final DbRepository storageRental;
   
   

    public Controller() {
        this.storageEmployee = new RepositoryEmployee();
        this.storageApartmentFeatures = new RepositoryApartmentFeatures();
        this.storageFeatureValue = new RepositoryFeatureValue();
        this.storageListing = new RepositoryListing();
        this.storageLocation = new RepositoryLocation();
        this.storageRental = new RepositoryRental();
    }
   
   
  

    public static Controller getInstance() {
        if(instance ==null){
            instance = new Controller();
        }
        return instance;
    }

    public Employee login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
   
}

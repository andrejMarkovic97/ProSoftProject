/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Employee;
import repository.db.impl.RepositoryApartmentFeatures;
import repository.db.impl.RepositoryEmployee;
import repository.db.impl.RepositoryFeatureValue;
import repository.db.impl.RepositoryListing;
import repository.db.impl.RepositoryLocation;
import repository.db.impl.RepositoryRental;
import so.AbstractSO;
import so.employee.AddEmployeeSO;
import so.employee.LoginEmployeeSO;

/**
 *
 * @author Andrej
 */
public class ServerController {

    private static ServerController instance;
    private final RepositoryEmployee storageEmployee;
    private final RepositoryApartmentFeatures storageAppFeatures;
    private final RepositoryFeatureValue storageFeatureValues;
    private final RepositoryListing storageListing;
    private final RepositoryLocation storageLocation;
    private final RepositoryRental storageRental;

    public ServerController() {
        this.storageEmployee = new RepositoryEmployee();
        this.storageAppFeatures = new RepositoryApartmentFeatures();
        this.storageFeatureValues = new RepositoryFeatureValue();
        this.storageListing = new RepositoryListing();
        this.storageLocation = new RepositoryLocation();
        this.storageRental = new RepositoryRental();
    }
    
    

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Employee login(Employee employee) throws Exception {
        LoginEmployeeSO loginEmployeeSo = new LoginEmployeeSO();
        loginEmployeeSo.execute(employee);
        Employee e = loginEmployeeSo.getEmployee();
        System.out.println(e);
        
        return loginEmployeeSo.getEmployee();
    }

    public void addEmployee(Employee employee) throws Exception {
        AddEmployeeSO addEmployeeSo = new AddEmployeeSO();
        addEmployeeSo.execute(employee);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.ApartmentFeatures;
import domain.Employee;
import domain.Listing;
import domain.Location;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DBRepository;
import repository.db.impl.RepositoryApartmentFeatures;
import repository.db.impl.RepositoryEmployee;
import repository.db.impl.RepositoryFeatureValue;
import repository.db.impl.RepositoryListing;
import repository.db.impl.RepositoryLocation;
import repository.db.impl.RepositoryRental;
import so.AbstractSO;
import so.apartmentfeatures.SOGetAllApartmentFeatures;
import so.employee.SOAddEmployee;
import so.employee.SODeleteEmployee;
import so.employee.SOGetAllEmployees;
import so.employee.SOLoginEmployee;
import so.employee.SOUpdateEmployee;
import so.listing.SOAddListing;
import so.location.SOGetAllLocations;

/**
 *
 * @author Andrej
 */
public class ServerController {

    private static ServerController instance;
    private final DBRepository storageEmployee;

    public ServerController() {
        storageEmployee = new RepositoryEmployee();
    }

    

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Employee login(Employee employee) throws Exception {
        SOLoginEmployee loginEmployeeSo = new SOLoginEmployee();
        loginEmployeeSo.execute(employee);
        Employee e = loginEmployeeSo.getEmployee();
        System.out.println(e);

        return loginEmployeeSo.getEmployee();
    }

    public void addEmployee(Employee employee) throws Exception  {
        SOAddEmployee addEmployeeSo = new SOAddEmployee();
        addEmployeeSo.execute(employee);

    }

    public ArrayList<Employee> getAllEmployees() throws Exception {
        SOGetAllEmployees so = new SOGetAllEmployees();
        so.execute(null);
        ArrayList<Employee> list = so.getList();
        return list;
    }

    public void deleteEmployee(Employee e) throws Exception {
        SODeleteEmployee deleteEmployeeSO = new SODeleteEmployee();
        deleteEmployeeSO.execute(e);
    }

    public void updateEmployee(Employee e) throws Exception{
        SOUpdateEmployee so = new SOUpdateEmployee();
        so.execute(e);
    }

    public ArrayList<Location> getAllLocations() throws Exception {
        SOGetAllLocations so = new SOGetAllLocations();
        so.execute(null);
        return so.getList();
    }

    public ArrayList<ApartmentFeatures> getAllApartmentFeatures() throws Exception {
        SOGetAllApartmentFeatures so = new SOGetAllApartmentFeatures();
        so.execute(null);
        return so.getList();
    }

    public void addListing(Listing listing) throws Exception {
        SOAddListing so = new SOAddListing();
        so.execute(listing);
    }

}

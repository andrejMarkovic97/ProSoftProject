/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.ApartmentFeatures;
import domain.Employee;
import domain.FeatureValue;
import domain.Listing;
import domain.Location;
import java.util.ArrayList;
import repository.db.DBRepository;
import repository.db.impl.RepositoryEmployee;
import so.apartmentfeatures.SOGetAllApartmentFeatures;
import so.employee.SOAddEmployee;
import so.employee.SODeleteEmployee;
import so.employee.SOGetAllEmployees;
import so.employee.SOLoginEmployee;
import so.employee.SOUpdateEmployee;
import so.featurevalues.SOGetAllFeatureValues;
import so.listing.SOAddListing;
import so.listing.SODeleteListing;
import so.listing.SOGetAllListings;
import so.location.SOGetAllLocations;
import so.listing.SOUpdateListing;

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

    public void addEmployee(Employee employee) throws Exception {
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

    public void updateEmployee(Employee e) throws Exception {
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

    public ArrayList<Listing> getAllListings() throws Exception {
        SOGetAllListings so = new SOGetAllListings();
        so.execute(null);
        return so.getList();
    }

    public ArrayList<FeatureValue> getAllFeatureValues(long id) throws Exception {
        SOGetAllFeatureValues so = new SOGetAllFeatureValues();
        so.execute(id);
        return so.getList();
    }

    public void updateListing(Listing l) throws Exception {
        SOUpdateListing so = new SOUpdateListing();
        so.execute(l);
    }

    public void deleteListing(Listing l) throws Exception {
        SODeleteListing so = new SODeleteListing();
        so.execute(l);
    }

    

}

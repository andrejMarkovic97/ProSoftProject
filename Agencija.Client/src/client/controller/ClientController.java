/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.communication.Communication;
import communication.Operations;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import domain.ApartmentFeatures;
import domain.Employee;
import domain.Listing;
import domain.Location;
import domain.Rental;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Andrej
 */
public class ClientController {

    private static ClientController instance;
    private Employee currentEmployee;

    public ClientController() {

    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public Employee login(Employee e) throws Exception {
        Request request = new Request(Operations.LOGIN, e);
        Response response = Communication.getInstance().sendRequest(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            Employee employee = (Employee) response.getResult();

            return employee;
        } else {
            throw response.getException();
        }
    }

    public boolean addEmployee(Employee employee) throws Exception {
        Request request = new Request(Operations.ADD_EMPLOYEE, employee);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return true;
        } else {
            throw response.getException();
        }

    }

    public ArrayList<Employee> getAllEmployees() throws Exception {
        ArrayList<Employee> list = new ArrayList<>();
        Request request = new Request(Operations.GET_EMPLOYEES, null);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            list = (ArrayList<Employee>) response.getResult();

        } else {
            throw response.getException();
        }
        return list;
    }

    public void deleteEmployee(Employee e) throws Exception {
        Request request = new Request(Operations.DELETE_EMPLOYEE, e);
        Response response = Communication.getInstance().sendRequest(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            System.out.println("Employee successfully deleted!");
        } else {
            throw response.getException();
        }
    }

    public void editEmployee(Employee e) throws Exception {
        Request request = new Request(Operations.UPDATE_EMPLOYEE, e);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            System.out.println("Employee successfully edited!");
        } else {
            throw response.getException();
        }
    }

    public ArrayList<Location> getAllLocations() throws Exception {
        ArrayList<Location> locations = new ArrayList<>();
        Request request = new Request(Operations.GET_LOCATIONS, null);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            locations = (ArrayList<Location>) response.getResult();
            System.out.println("Locations successfully retrieved");

        } else {
            throw response.getException();
        }
        return locations;
    }

    public ArrayList<ApartmentFeatures> getAllApartmentFeatures() throws Exception {
        ArrayList<ApartmentFeatures> features = new ArrayList<>();
        Request request = new Request(Operations.GET_APARTMENT_FEATURES, null);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            features = (ArrayList<ApartmentFeatures>) response.getResult();
            System.out.println("Apartment features successfully retrieved!");
        } else {
            throw response.getException();
        }
        return features;
    }

    public void addListing(Listing listing) throws Exception {
        Request request = new Request(Operations.ADD_LISTING, listing);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            System.out.println("Listing successfully added");
        } else {
            throw response.getException();
        }
    }
}

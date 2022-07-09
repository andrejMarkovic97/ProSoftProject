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
import domain.Employee;
import domain.Listing;
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
        Response response = Communication.getInstance().login(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            Employee employee = (Employee) response.getResult();

            return employee;
        } else {
            throw response.getException();
        }
    }

    public boolean addEmployee(Employee employee) throws Exception {
        Request request = new Request(Operations.ADD_EMPLOYEE, employee);
        Response response = Communication.getInstance().addEmployee(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return true;
        } else {
            throw response.getException();
        }

    }

    public ArrayList<Employee> getAllEmployees() throws Exception {
        ArrayList<Employee> list = new ArrayList<>();
        Request request = new Request(Operations.GET_EMPLOYEES, null);
        Response response = Communication.getInstance().getAllEmployees(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            list = (ArrayList<Employee>) response.getResult();

        } else {
            throw response.getException();
        }
        return list;
    }

    public void deleteEmployee(Employee e) throws Exception {
        Request request = new Request(Operations.DELETE_EMPLOYEE, e);
        Response response = Communication.getInstance().deleteEmployee(e);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            System.out.println("Employee successfully deleted!");
        }
        else{
            throw response.getException();
        }
    }
}

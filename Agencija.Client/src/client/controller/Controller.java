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

/**
 *
 * @author Andrej
 */
public class Controller {
    private static Controller instance;
    private Employee currentEmployee;
    public Controller() {
        
    }
    
    public static Controller getInstance() {
       if(instance==null) {
           instance = new Controller();
       }
        return instance;
    }

    public Employee login(String username, String password) throws Exception {
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
        
         Request request = new Request(Operations.LOGIN, employee);
         Response response = Communication.getInstance().login(request);
            
            if(response.getResponseType().equals(ResponseType.SUCCESS)){
                Employee e =(Employee) response.getResult();
                return e;
            }
            else{
                throw response.getException();
            }
    }

    public void setCurrentEmployee(Employee employee) {
        currentEmployee = employee;
    }

    
    
    
}

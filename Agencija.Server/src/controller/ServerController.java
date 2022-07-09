/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Employee;
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
import so.employee.AddEmployeeSO;
import so.employee.LoginEmployeeSO;

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
        LoginEmployeeSO loginEmployeeSo = new LoginEmployeeSO();
        loginEmployeeSo.execute(employee);
        Employee e = loginEmployeeSo.getEmployee();
        System.out.println(e);

        return loginEmployeeSo.getEmployee();
    }

    public void addEmployee(Employee employee) throws Exception  {
        AddEmployeeSO addEmployeeSo = new AddEmployeeSO();
        addEmployeeSo.execute(employee);

    }

    public ArrayList<Employee> getAllEmployees() throws Exception {
        ArrayList<Employee> list = (ArrayList<Employee>) storageEmployee.getAll();
        return list;
    }

}

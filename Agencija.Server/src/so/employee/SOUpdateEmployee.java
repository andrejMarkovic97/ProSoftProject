/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.employee;

import domain.Employee;
import java.util.ArrayList;
import repository.db.impl.RepositoryEmployee;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOUpdateEmployee extends AbstractSO{
     RepositoryEmployee storageEmployee;

    public SOUpdateEmployee() {
        storageEmployee = new RepositoryEmployee();
    }
     
    
    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Employee)) {
            throw new Exception("Invalid parametar");
        }
        Employee employee = (Employee) param;
        if (employee.getFirstName().isEmpty() || employee.getLastName().isEmpty()
                || employee.getUsername().isEmpty() || employee.getPassword().isEmpty() || employee.getRole().isEmpty()) {
            throw new Exception("Empty parameters");
        }
        ArrayList<Employee> employees = (ArrayList<Employee>) storageEmployee.getAll();
        for (Employee e : employees) {
            if (e.getUsername().equals(employee.getUsername()) && e.getPassword().equals(employee.getPassword())) {
                throw new Exception("An employee with these credentials already exists!");
            }
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        storageEmployee.connect();
        storageEmployee.edit((Employee) param);
    }

    @Override
    protected void commitTransaction() throws Exception {
        storageEmployee.commit();
    }

    @Override
    protected void rollbackTransaction() throws Exception {
        storageEmployee.rollback();
    }
    
}

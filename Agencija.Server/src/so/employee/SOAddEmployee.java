/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.employee;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Employee;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOAddEmployee extends AbstractSO {


    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Employee)) {
            throw new Exception("Invalid parametar");
        }
        Employee employee = (Employee) ado;
        if (employee.getFirstName().isEmpty() || employee.getLastName().isEmpty()
                || employee.getUsername().isEmpty() || employee.getPassword().isEmpty() || employee.getRole().isEmpty()) {
            throw new Exception("Empty parameters");
        }
        ArrayList<Employee> employees = (ArrayList<Employee>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Employee e : employees) {
            if(e.getUsername().equals(employee.getUsername()) && e.getPassword().equals(employee.getPassword())){
                throw new Exception("An employee with these credentials already exists!");
            }
        }
            
    }

    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }

}

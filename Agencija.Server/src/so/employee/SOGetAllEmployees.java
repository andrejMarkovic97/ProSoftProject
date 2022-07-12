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
public class SOGetAllEmployees extends AbstractSO{
    private ArrayList<Employee> list;

   
    
    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof Employee)) {
            throw new Exception("The object that has been sent is not a instance of class Employee!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> employees = DBBroker.getInstance().select(ado);
        list = (ArrayList<Employee>) (ArrayList<?>) employees;
    }

    public ArrayList<Employee> getList() {
        return list;
    }
    
}

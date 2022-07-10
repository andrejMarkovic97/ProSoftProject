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
public class SOGetAllEmployees extends AbstractSO{
    private ArrayList<Employee> list;
    private final RepositoryEmployee storageEmployee;

    public SOGetAllEmployees() {
        storageEmployee = new RepositoryEmployee();
    }

   
    
    @Override
    protected void precondition(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        storageEmployee.connect();
        list = (ArrayList<Employee>) storageEmployee.getAll();
    }

    public ArrayList<Employee> getList() {
        return list;
    }
    
}

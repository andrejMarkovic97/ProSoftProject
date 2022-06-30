/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.employee;

import domain.Employee;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class AddEmployeeSO extends AbstractSO{

   
    
    @Override
    protected void precondition(Object param) throws Exception {
        if (param==null || !(param instanceof Employee)) {
            throw new Exception("Invalid parametar");
        }
        Employee employee = (Employee) param;
        if(employee.getFirstName().isEmpty()){
            throw new Exception("Name is empty");
            //OVO BI TREBALO U POSEBNU KLASU VALIDATOR
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        
    }

    @Override
    protected void commitTransaction() throws Exception {
        
    }

    @Override
    protected void rollbackTransaction() throws Exception{
        
        
    }

    
    
    
    
}

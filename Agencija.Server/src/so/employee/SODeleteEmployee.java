/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.employee;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Employee;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SODeleteEmployee extends AbstractSO {



    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Employee)) {
            throw new Exception("Invalid parametar");
        }
        Employee employee = (Employee) ado;
        if (employee.getUsername() == null || employee.getPassword() == null || employee.getUsername().isEmpty()
                || employee.getPassword().isEmpty()) {
            throw new Exception("Empty parameters");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        Employee e = (Employee) ado;
        if(e.getRentals()!=null){
            DBBroker.getInstance().delete(e.getRentals().get(0));
        }
        DBBroker.getInstance().delete(ado);
    }
}

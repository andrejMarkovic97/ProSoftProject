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
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOLoginEmployee extends AbstractSO {

    private Employee employee;


    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Employee)) {
            throw new Exception("Param is not a instance of employee");
        }
        if (ado == null) {
            throw new Exception("Param is null");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        Employee e = (Employee) ado;
        ArrayList<Employee> employees = (ArrayList<Employee>)(ArrayList<?>)DBBroker.getInstance().select(ado);
        for (Employee empl : employees) {
            if(empl.getUsername().equals(e.getUsername()) &&
                    empl.getPassword().equals(e.getPassword())){
                employee = empl;
                return;
            }
        }
        throw new Exception("No employee with these credentials!");
    }

    public Employee getEmployee() {
        return employee;
    }

    

}

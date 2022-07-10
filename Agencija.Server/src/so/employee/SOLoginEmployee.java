/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.employee;

import domain.Employee;
import java.util.List;
import repository.db.impl.RepositoryEmployee;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOLoginEmployee extends AbstractSO {

    private Employee employee;
    private final RepositoryEmployee storageEmployee;

    public SOLoginEmployee() {
        employee = null;
        storageEmployee = new RepositoryEmployee();
    }

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Employee)) {
            throw new Exception("Param is not a instance of employee");
        }
        if (param == null) {
            throw new Exception("Param is null");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Employee e = (Employee) param;
        storageEmployee.connect();
        List<Employee> employees = storageEmployee.getAll();
        storageEmployee.commit();
        for (Employee empl : employees) {
            if (empl.getUsername().equals(e.getUsername()) && empl.getPassword().equals(e.getPassword())) {
                employee = empl;
                return;
            }
        }
        throw new Exception("An employee dosen't exist with those credentials");
    }

    public Employee getEmployee() {
        return employee;
    }

    

}

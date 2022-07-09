/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.employee;

import domain.Employee;
import repository.db.impl.RepositoryEmployee;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class DeleteEmployeeSO extends AbstractSO {

    private final RepositoryEmployee storageEmployee;

    public DeleteEmployeeSO() {
        storageEmployee = new RepositoryEmployee();
    }

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Employee)) {
            throw new Exception("Invalid parametar");
        }
        Employee employee = (Employee) param;
        if (employee.getUsername() == null || employee.getPassword() == null || employee.getUsername().isEmpty()
                || employee.getPassword().isEmpty()) {
            throw new Exception("Empty parameters");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Employee e = (Employee) param;
        storageEmployee.connect();
        storageEmployee.delete(e);
        
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

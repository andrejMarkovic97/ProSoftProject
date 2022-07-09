/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import repository.db.DBConnectionFactory;

/**
 *
 * @author Andrej
 */
public abstract class AbstractSO {

    public void execute(Object param) throws Exception {
        try {
            precondition(param);
            executeOperation(param);
            commitTransaction();
            System.out.println("Successful system operation");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Error in system operation");
            rollbackTransaction();
            throw new Exception(exception.getMessage());
        }
    }

    protected abstract void precondition(Object param) throws Exception;

    protected abstract void executeOperation(Object param) throws Exception;

    protected void commitTransaction() throws Exception {
    }

    protected void rollbackTransaction() throws Exception {
    }

}

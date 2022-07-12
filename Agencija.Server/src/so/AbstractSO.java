/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domain.AbstractDomainObject;


/**
 *
 * @author Andrej
 */
public abstract class AbstractSO {

    public void execute(AbstractDomainObject ado) throws Exception {
        try {
            precondition(ado);
            executeOperation(ado);
            commitTransaction();
            System.out.println("Successful system operation");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Error in system operation");
            rollbackTransaction();
            throw new Exception(exception.getMessage());
        }
    }

    protected abstract void precondition(AbstractDomainObject ado) throws Exception;

    protected abstract void executeOperation(AbstractDomainObject ado) throws Exception;

    protected void commitTransaction() throws Exception {
        DBBroker.getInstance().getConnection().commit();
    }

    protected void rollbackTransaction() throws Exception {
        DBBroker.getInstance().getConnection().rollback();

    }

}

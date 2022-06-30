/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

/**
 *
 * @author Andrej
 */
public abstract class AbstractSO {

    public void execute(Object param) throws Exception {
        try {
            precondition(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();
            System.out.println("Successful system operation");
        } catch (Exception exception) {
            System.out.println("Error in system operation");
            rollbackTransaction();
        }
    }

    protected abstract void precondition(Object param) throws Exception;

    protected abstract void executeOperation(Object param) throws Exception;

    private void startTransaction() {

    }

    protected void commitTransaction() throws Exception {

    }

    protected void rollbackTransaction() throws Exception {

    }

}

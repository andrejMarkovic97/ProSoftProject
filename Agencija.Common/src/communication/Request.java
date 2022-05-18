/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Andrej
 */
public class Request implements Serializable{
    private int operation;
    private Object argument;

    
    public Request(int operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public int getOperation() {
        return operation;
    }

    public Object getArgument() {
        return argument;
    }
    
}

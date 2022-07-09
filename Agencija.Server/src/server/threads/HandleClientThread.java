/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.threads;

import communication.Operations;

import communication.Request;
import communication.Response;
import communication.ResponseType;

import controller.ServerController;
import domain.Employee;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrej
 */
public class HandleClientThread extends Thread {

    private final Socket socket;

    public HandleClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) throws Exception {
        switch (request.getOperation()) {
            case Operations.LOGIN:
                return login(request);
            case Operations.ADD_EMPLOYEE:
                return addEmployee(request);
            case Operations.GET_EMPLOYEES:
                return getAllEmployees(request);
            case Operations.DELETE_EMPLOYEE:
                return deleteEmployee(request);
        }
        return null;
    }

    public Socket getSocket() {
        return socket;
    }

    private Response login(Request request) {
        Response response = new Response();
        Employee requestEmployee = (Employee) request.getArgument();
        try {

            Employee employee = ServerController.getInstance().login(requestEmployee);
            if (employee != null) {
                System.out.println("Successful login!");
                response.setResponseType(ResponseType.SUCCESS);
                response.setResult(employee);
            } else {
                throw new Exception("Credentials don't match any employees!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response addEmployee(Request request) {
        Response response = new Response();
        Employee employee = (Employee) request.getArgument();
        try {
            ServerController.getInstance().addEmployee(employee);
            System.out.println("Employee successfully added!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getAllEmployees(Request request) {
        Response response = new Response();
        try {

            ArrayList<Employee> list = ServerController.getInstance().getAllEmployees();
            System.out.println("Employees successfully fetched!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            
        }
        return response;
    }

    private Response deleteEmployee(Request request) {
        Response response = new Response();
        
        Employee e = (Employee) request.getArgument();
        try {
            ServerController.getInstance().deleteEmployee(e);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        
        return response;
    }

}

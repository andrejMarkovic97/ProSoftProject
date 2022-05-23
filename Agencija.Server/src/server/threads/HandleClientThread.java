/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.threads;

import communication.Operations;
import communication.Reciever;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import controller.Controller;
import domain.Employee;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrej
 */
public class HandleClientThread extends Thread {

    private Socket socket;

    public HandleClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            Request request;
            try {
                request = (Request) new Reciever(socket).recieve();
                Response response = handleRequest(request);
                new Sender(socket).send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    private Response handleRequest(Request request) {
        switch (request.getOperation()) {
            case Operations.LOGIN:
                return login(request);
            default:
                return null;
        }
    }

    public Socket getSocket() {
        return socket;
    }

    private Response login(Request request) {
        Response response = new Response();
        Employee requestEmployee = (Employee) request.getArgument();

        Employee employee = Controller.getInstance().login(requestEmployee.getUsername(), requestEmployee.getPassword());

        System.out.println("Successful login!");
        response.setResponseType(ResponseType.SUCCESS);
        response.setResult(employee);

        return response;
    }
}

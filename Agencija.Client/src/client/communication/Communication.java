/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.communication;

import communication.Reciever;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Employee;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Andrej
 */
public class Communication {

    private static Communication instance;
    private Socket socket;

    private Communication() {

    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Response sendRequest(Request request) throws Exception {
        new Sender(socket).send(request);
        return (Response) new Reciever(socket).recieve();
    }
}

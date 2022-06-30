/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencija.server;

import communication.Operations;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import controller.ServerController;
import domain.Employee;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.view.form.FrmServerMain;

/**
 *
 * @author Andrej
 */
public class Server {

    public static void main(String[] args) {
        new FrmServerMain().setVisible(true);
    }
    /*
    public static void main(String[] args) {
        
        try {
            Server server = new Server();
            server.startServer();
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void startServer() throws Exception {

        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server is up and running");
        Socket socket = serverSocket.accept();
        System.out.println("Connected client");
        handleClient(socket);

    }

    private void handleClient(Socket socket) throws Exception {
        while (true) {
            try {
                //procitaj zahtjev klijenta
                // ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) new Reciever(socket).recieve();
                Response response = null;
                int operation = request.getOperation();

                switch (operation) {
                    case Operations.LOGIN:
                        response = login(request);
                        break;
                    default:

                }
                //Vrati rezultat klijentu
                //ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                //out.writeObject(response);
                //out.flush();
                new Sender(socket).send(response);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
*/
}

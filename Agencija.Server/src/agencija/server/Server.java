/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencija.server;

import communication.Operations;
import communication.Request;
import domain.Employee;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrej
 */
public class Server {

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.startServer();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void startServer() throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server is up and running");
        Socket socket = serverSocket.accept();
        System.out.println("Connected client");
        handleClient(socket);

    }

    private void handleClient(Socket socket) {
        while (true) {
            try {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                
                int operation = request.getOperation();
                
                switch(operation){
                    case Operations.LOGIN:
                        Employee employee = (Employee) request.getArgument();
                        
                        break;
                    default:
                        
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

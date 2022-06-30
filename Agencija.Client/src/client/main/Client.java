/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.main;

import client.communication.Communication;
import client.view.FrmLogin;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Andrej
 */
public class Client {
    
     public static void main(String[] args) {
        //pokreni server program
        Client client = new Client();
        try {
            client.connect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     private void connect() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9000);
        System.out.println("Klijent se povezao...");
        
        Communication.getInstance().setSocket(socket);
        //otvori formu za prijavu na sistem
        new FrmLogin().setVisible(true);
    }
}

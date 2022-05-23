/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencija.client;

import client.communication.Communication;
import forms.FrmLogin;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrej
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.connect();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    private void connect() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9000);
        System.out.println("Client has connected");
        Communication.getInstance().setSocket(socket);
        new FrmLogin().setVisible(true);
    }
}

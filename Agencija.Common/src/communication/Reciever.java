/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Andrej
 */
public class Reciever {
    private Socket socket;
    
    public Reciever(Socket socket) {
        this.socket = socket;
}
    
    public Object recieve() throws Exception{
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error recieve object= "+ex.getMessage());
            
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrej
 */
public class ServerThread extends Thread{
    private ServerSocket serverSocket;
    private List<HandleClientThread> clients;
    public ServerThread() throws IOException  {
        serverSocket=new ServerSocket(9000);
        clients = new ArrayList<>();
    }
            
    @Override
    public void run() {
        while(!serverSocket.isClosed()){
            System.out.println("Waiting for a client");
            try {
                Socket socket = serverSocket.accept();
                HandleClientThread client = new HandleClientThread(socket);
                client.start();
                clients.add(client);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        stopAllHandleClientThreads();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    private void stopAllHandleClientThreads(){
        for (HandleClientThread client : clients) {
            try {
                client.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

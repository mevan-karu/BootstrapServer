/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.controller;

import com.bootstrapserver.reciever.Reciever;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mevan
 */
public class RecieverController{
    
    private static ServerSocket recieverSocket;
    private static Socket senderSocket;
    private static int port;
    
    public RecieverController(int port){
        this.port = port;
    }

    
    public static void main(String[] args) {
        try {
            recieverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(RecieverController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (true){
            try {
                senderSocket = recieverSocket.accept();
            } catch (IOException ex) {
                Logger.getLogger(RecieverController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread t = new Thread(new Reciever(senderSocket));
            t.start();

        }
    }
    
}

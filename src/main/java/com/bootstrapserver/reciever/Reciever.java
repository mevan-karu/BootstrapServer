/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.reciever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mevan
 */
public class Reciever implements Runnable{
    
    private BufferedReader br;
    private final Socket senderSocket;
    
    public Reciever(Socket senderSocket){
        this.senderSocket = senderSocket;
    }
    

    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(senderSocket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getMessage() throws IOException{
        return br.readLine();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.sender;

import com.bootstrapserver.Message.*;
import com.bootstrapserver.peer.Peer;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mevan
 */
public class Sender implements Runnable{
    
    private final  Peer peer;
    private final  Message message;
    private  PrintStream os;
    private  Socket senderSocket;
    
    public Sender(Peer peer, Message message){
        this.message = message;
        this.peer = peer;
    }
    
    @Override
    public void run() {
        try {        
            senderSocket = new Socket(peer.getPeerAddress(), peer.getPeerPort());
            os = new PrintStream(senderSocket.getOutputStream());
            os.println(message.MessageToString());
        } catch (IOException ex) {
            
        }
    }
    
}

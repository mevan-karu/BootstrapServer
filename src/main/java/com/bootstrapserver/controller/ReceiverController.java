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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mevan
 */
public class ReceiverController implements Runnable{

    private int port;

    public ReceiverController(int port){
        this.port=port;
    }

    @Override
    public void run() {
        ServerSocket recieverSocket;
        Socket senderSocket;
        try {
            recieverSocket = new ServerSocket(port);
            while (true) {
                try {
                    senderSocket = recieverSocket.accept();
                    Thread t = new Thread(new Reciever(senderSocket));
                    t.start();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

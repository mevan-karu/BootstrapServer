/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.reciever;

import com.bootstrapserver.message.LoginMessage;
import com.bootstrapserver.validator.LoginValidator;
import com.bootstrapserver.validator.MessageValidator;
import com.bootstrapserver.validator.RegistrationValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mevan
 */
public class Reciever implements Runnable{
    
    private BufferedReader br;
    private final Socket senderSocket;
    private MessageValidator messageValidator;
    private LoginValidator loginValidator;
    private RegistrationValidator regValidator;
    
    public Reciever(Socket senderSocket) throws SQLException {
        this.senderSocket = senderSocket;
        messageValidator = new MessageValidator();
        loginValidator = new LoginValidator();
        regValidator = new RegistrationValidator();
    }
    

    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(senderSocket.getInputStream()));
            String msg = br.readLine();
            String[] msgList = msg.split(",");
            if (messageValidator.validate(msgList)){
                if ("Login".equals(msgList[0])){
                    LoginMessage logMSg = new LoginMessage("Login");


                    
                } else if ("Register".equals(msgList[0])){
                    
                } else if ("Heartbeat".equals(msgList[0])){

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
}

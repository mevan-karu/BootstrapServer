/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.Message;

/**
 *
 * @author Mevan
 */
public class RegisterMessage extends Message{
    
    private String username;
    private String password;
    
    public RegisterMessage(String title) {
        super(title);
    }

    @Override
    public String MessageToString() {
        return super.MessageToString()+","+username+","+password+"\n";
    }
    
}

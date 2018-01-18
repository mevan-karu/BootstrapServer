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
public class LoginMessage extends Message{
    
    private String username;
    private String password;
    
    public LoginMessage(String title) {
        super(title);
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String MessageToString() {
        return super.MessageToString()+","+username+","+password+"\n";        
    }
    
}

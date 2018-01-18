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
public class RegistrationSuccessMessage extends Message{
    
    public RegistrationSuccessMessage(String title) {
        super(title);
    }

    @Override
    public String MessageToString() {
        return super.MessageToString()+","+"Success"+"\n";
    }
    
}

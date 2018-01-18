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
public class InvalidRequestMessage extends Message{
    
    private String description;
    
    public InvalidRequestMessage(String title) {
        super(title);
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String MessageToString() {
        return super.MessageToString()+","+description+"\n";
    }
    
    
    
    
}

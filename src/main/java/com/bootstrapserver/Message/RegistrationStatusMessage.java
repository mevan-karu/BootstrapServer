/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.message;

/**
 *
 * @author Mevan
 */
public class RegistrationStatusMessage extends Message{

    private String status;

    public RegistrationStatusMessage(String title) {
        super(title);
    }

    @Override
    public String messageToString() {
        return super.messageToString()+","+status+"\n";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

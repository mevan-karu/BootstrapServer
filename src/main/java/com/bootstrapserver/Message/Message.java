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
public abstract class Message {
    
    private String title;
    private String recieverAddress;
    private int recieverPort;
    private String senderAddress;
    private int senderPort;
    private String timestamp;
    
    public Message(String title){
        this.title = title;
    }
    
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getRecieverAddress() {
        return recieverAddress;
    }

    public void setRecieverAddress(String recieverAddress) {
        this.recieverAddress = recieverAddress;
    }

    public int getRecieverPort() {
        return recieverPort;
    }

    public void setRecieverPort(int recieverPort) {
        this.recieverPort = recieverPort;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public int getSenderPort() {
        return senderPort;
    }

    public void setSenderPort(int senderPort) {
        this.senderPort = senderPort;
    }
    
    public String MessageToString(){
        return title+","+recieverAddress+","+Integer.toString(recieverPort)+","+senderAddress+","+Integer.toString(senderPort)+","+timestamp;    
    }
            
}

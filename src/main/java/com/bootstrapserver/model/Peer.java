/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.model;

/**
 *
 * @author Mevan
 */
public class Peer {
    
    private String username;
    private String peerAddress;
    private int peerPort;

    public Peer(){
        
    }
    
    public Peer(String username, String peerAddress, int peerPort){
        this.peerAddress = peerAddress;
        this.peerPort = peerPort;
        this.username = username;        
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPeerAddress() {
        return peerAddress;
    }

    public void setPeerAddress(String peerAddress) {
        this.peerAddress = peerAddress;
    }

    public int getPeerPort() {
        return peerPort;
    }

    public void setPeerPort(int peerPort) {
        this.peerPort = peerPort;
    }
    
    public String peerToString(){
        return username+","+peerAddress+","+Integer.toString(peerPort);
    }
    
    
}

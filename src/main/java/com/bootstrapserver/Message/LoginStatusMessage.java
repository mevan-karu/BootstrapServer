/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.message;

import java.util.ArrayList;
import com.bootstrapserver.model.*;

/**
 *
 * @author Mevan
 */
public class LoginStatusMessage extends Message{
    
    private ArrayList<Peer> activePeers = new ArrayList<Peer>();
    private int accountType;
    private String status;

    public LoginStatusMessage(String title) {
        super(title);
    }
    
    public ArrayList<Peer> getActivePeers() {
        return activePeers;
    }

    public void setActivePeers(ArrayList<Peer> activePeers) {
        this.activePeers = activePeers;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    @Override
    public String messageToString() {
        String msg = super.messageToString();
        if (status=="Success"){
            if (!(activePeers.isEmpty())){
                for (Peer p: activePeers){
                    msg+=(","+p.peerToString());
                }
            }
        } else {
            msg=msg+","+status;
        }
        return msg+="\n";        
    }
       
    
}

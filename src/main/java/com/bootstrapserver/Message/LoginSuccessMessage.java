/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.Message;

import java.util.ArrayList;
import com.bootstrapserver.peer.*;

/**
 *
 * @author Mevan
 */
public class LoginSuccessMessage extends Message{
    
    private ArrayList<Peer> activePeers = new ArrayList<Peer>();
    private int accountType;

    public LoginSuccessMessage(String title) {
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
    public String MessageToString() {
        String msg = super.MessageToString();
        if (!(activePeers.isEmpty())){
            for (Peer p: activePeers){
                msg+=(","+p.peerToString());
            }
        }
        return msg+="\n";        
    }
       
    
}

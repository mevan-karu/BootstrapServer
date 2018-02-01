/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.validator;

import java.util.ArrayList;

/**
 *
 * @author Mevan
 */
public class MessageValidator {
    
    public MessageValidator(){
    }
    
    public boolean validate(String[] msgList){
        ArrayList<String> msgTitles = new ArrayList<String>(){{
            add("Login");
            add("Register");
        }};

        boolean valid = true;
        if (msgList.length >5){
            if (msgTitles.contains(msgList[0])){
                if (portNumberValidator(msgList[2]) && portNumberValidator(msgList[4]) && ipAddressValidator(msgList[1])
                        && ipAddressValidator(msgList[3])){
                    if (!(msgList[4].matches("[0-9]+"))){
                        valid = false;
                    }
                } else {
                    valid = false;
                }
            } else {
                valid = false;
            }
        }else {
            valid = false;
        }
        return valid;
    }

    public boolean portNumberValidator(String port){
        boolean valid = true;
        try {
            if (!((Integer.parseInt(port)>1024) && (Integer.parseInt(port)<65536))){
                valid = false;
            }
        } catch (Exception e){
            valid = false;
            return valid;
        }
        return valid;
    }

    public boolean ipAddressValidator(String ipAdd){
        boolean valid = true;
        if (!(ipAdd.matches("[0-9.]+") && (ipAdd.length()>0 && ipAdd.length()<16))){
            valid=false;
        }
        return valid;
    }
    
}

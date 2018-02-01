/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.validator;

import com.bootstrapserver.message.RegisterMessage;
import com.bootstrapserver.repository.UserRepository;

/**
 *
 * @author Mevan
 */
public class RegistrationValidator {
    private UserRepository userRepo;

    public RegistrationValidator(){
        this.userRepo = new UserRepository();
    }

    public String validate(RegisterMessage msg){
        String error="";
        if (userRepo.getUser(msg.getUsername())!=null){
            error="Username already taken!";
        }

        return error;
    }
}

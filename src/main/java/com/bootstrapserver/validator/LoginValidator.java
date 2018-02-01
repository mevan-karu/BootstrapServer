/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.validator;

import com.bootstrapserver.message.LoginMessage;
import com.bootstrapserver.model.User;
import com.bootstrapserver.repository.UserRepository;

/**
 *
 * @author Mevan
 */
public class LoginValidator {
    private UserRepository userRepo;

    public LoginValidator(){
        this.userRepo = new UserRepository();
    }

    public String validate(LoginMessage msg){
        String error ="";
        User user =userRepo.getUser(msg.getUsername());
        if (user!=null){
            error = "Username doesn't exists!";
        } else if(user.getPassword() != msg.getPassword()) {
            error = "Invalid password!";
        }
        return error;
    }
}

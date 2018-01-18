/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootstrapserver.util;

import java.sql.Connection;

/**
 *
 * @author Mevan
 */
public class DBConnection {
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String url = "jdbc:derby:bootstrapserver;create=true";
    
    public DBConnection(){
        
    }
    
    public Connection getConnection(){
        
    }
    
    
}

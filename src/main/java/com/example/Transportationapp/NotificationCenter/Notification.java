/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportationapp.NotificationCenter;

import com.example.Transportationapp.User_System.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Notification {
    private String Message;
    private String Type;
    private String Name ;

    public Notification(String Message, String Type, String Name) {
        this.Message = Message;
        this.Type = Type;
        this.Name = Name;
        
    }

  
     
    
    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getMessage() {
        return Message;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }
    
    
    
}

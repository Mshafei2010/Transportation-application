/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.Transportationapp.User_System;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
@Service
public class AdminModel {
   Admin admin;
    
    public boolean validate(Admin admin) {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From Admin");
            while(resultset.next())
            {
                String Name=resultset.getString("Name");
                if(Name.equalsIgnoreCase(admin.getUserName()))
                {
                    String password=resultset.getString("Password");
                    if(password.equals(admin.getPassword()))
                    {
                        String Number=resultset.getString("Number");
                        admin.setMoblieNumber(Number);
                        String email=resultset.getString("Email");
                        admin.setEmail(email); 
                        con.close();
                        return true;
                    }
                }
            }
            con.close();   
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public void verifyDriverDatabase(String name) throws ClassNotFoundException, SQLException
     {   try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver where Name='"+name+"'");
            boolean first = resultset.next();
            if(first){
                    String Name=resultset.getString("Name");
                    String NationalID=resultset.getString("ID");
                    String DL=resultset.getString("driver_license");
                    Statement smt2=con.createStatement();
                    boolean state =true;
                    String dbo;
                    dbo = "Update driver set state="+state+" where Name='"+name+"'";
                    smt.execute(dbo);
            }
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
     }


   
    public boolean insert(Admin admin) throws SQLException {
             Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            
            Statement smt=con.createStatement();
            String dbo="Insert Into Admin (Name,Email,Number,Password)values('"+admin.getUserName()+"','"+admin.getEmail()+"','"+admin.getMoblieNumber()+"','"+admin.getPassword()+"')";
            smt.execute(dbo);
            smt.close();
            con.close();
            return true;
    }
    
    
}

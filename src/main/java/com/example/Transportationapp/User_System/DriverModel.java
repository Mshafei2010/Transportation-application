/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportationapp.User_System;

import com.example.Transportationapp.NotificationCenter.Notification;
import com.example.Transportationapp.NotificationCenter.NotificationModel;
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
public class DriverModel {
 
     //done
    public boolean validate(Driver driver){
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver");
            while(resultset.next())
            {
                
                String Name=resultset.getString("Name");
                
                if(Name.equalsIgnoreCase(driver.getUserName()))
                {
                     
                    
                    String password=resultset.getString("Password");
                    if(password.equals(driver.getPassword()))
                    {
                        boolean state=resultset.getBoolean("state");
                        String Number=resultset.getString("Number");
                        driver.setMoblieNumber(Number);
                        String Id=resultset.getString("ID");
                       driver.setNationalID(Id);
                        String DL=resultset.getString("driver_license");
                        driver.setMoblieNumber(Number);
                        driver.setUserName(Name);
                        driver.setDriverLicense(DL);
                        if(state)
                        {
                            driver.setState(1);
                        }
                        else
                        {
                            driver.setState(0);
                        }
                        
                        con.close();
                        
                        return state;
                    }
                }
                
            }
            con.close();
             return false;
        } catch (SQLException ex) {
            Logger.getLogger(DriverModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
     public int retrivebalance(Driver driver){
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            
            ResultSet resultset=smt.executeQuery("SELECT * From driver");
            while(resultset.next())
            {
                
                String Name=resultset.getString("Name");
                
                if(Name.equalsIgnoreCase(driver.getUserName()))
                {
                     
                    
                    String password=resultset.getString("Password");
                   
                      
                        int balance=resultset.getInt("DriverBalance");
                       
                        
                        con.close();
                        return balance;
                        
                        
                    
                }
                
            }
            con.close();
             return 0;
        } catch (SQLException ex) {
            Logger.getLogger(DriverModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } 
    }
    
    //done
       public static ArrayList<Driver> retrivependingDrivers(){
         ArrayList<Driver> pendingdrivers=new ArrayList<Driver>();
        try {
       

           Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver");
            while(resultset.next())
            {
                boolean state =resultset.getBoolean("state");
                if(state==false)
                {
                    String Name=resultset.getString("Name");
                    String NationalID=resultset.getString("ID");
                    String DL=resultset.getString("driver_license");
                    String Number=resultset.getString("Number");
                     String Email=resultset.getString("Email");
                    Driver d=new Driver(Number,Email,"",Name,NationalID,DL);
                    pendingdrivers.add(d);
                    
                }
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pendingdrivers;    
}
       
    //done
    public void InsertFavArea(Driver driver,String area) {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo="Insert Into fav_area values('"+area+"','"+driver.getUserName()+"')";
            smt.execute(dbo);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //done
      public boolean insert(Driver driver) throws SQLException {  
        Notification Notify = new Notification("New Pending Registeration From Driver -->","Admin",driver.getUserName());
          NotificationModel.Insert(Notify);
         
                 Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
                 Statement smt=con.createStatement();
                 String dbo="Insert Into driver (Name,Password,ID,driver_license,Number,state,Email)values('"+driver.getUserName()+"','"+driver.getPassword()+"','"+driver.getNationalID()+"','"+driver.getDriverLicense()+"','"+driver.getMoblieNumber()+"','"+driver.getstate()+"','"+driver.getEmail()+"')";
                 smt.execute(dbo);
                 smt.close();
                 con.close();
        return true;
    

}
      //done
      public void updateBalance(String DriverName){
          
        try {
           Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From Ride");
            while(resultset.next())
            {
                String state =resultset.getString("State");
                if(state.equals("Completed"))
                {
                    int price=resultset.getInt("price");
                     String dbo = "Update Driver set DriverBalance=DriverBalance+"+price+" where Name='"+DriverName+"'";
                     smt.execute(dbo);
                      
                      dbo = "Update Ride set State='"+"History"+"' where Dname='"+DriverName+"' AND State='"+"Completed"+"'";
                      smt.execute(dbo);
                    
                }
           
            
            
        }
        }catch (SQLException ex) {
            Logger.getLogger(DriverModel.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}

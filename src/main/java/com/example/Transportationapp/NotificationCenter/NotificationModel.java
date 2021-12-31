/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportationapp.NotificationCenter;

import  com.example.Transportationapp.User_System.Person;
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
public class NotificationModel {
    
      public static void Insert(Notification notification)
    {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            
            Statement smt=con.createStatement();
            String dbo="Insert Into NotiicationCenter values('"+notification.getMessage()+"','"+notification.getName()+"','"+notification.getType()+"')";
            smt.execute(dbo);
            smt.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //to retrive all the Notifcation from the Notification Center Data Base
    public static ArrayList<Notification>Retrive(Person person,String typ) throws SQLException
    {
          ArrayList<Notification>Notifys=new ArrayList<Notification>();
        Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From NotiicationCenter");
            while(resultset.next())
            {
                String Name=resultset.getString("Name");
                if(Name.equalsIgnoreCase(person.getUserName()))
                {
                    String type=resultset.getString("Type");
                    if(type.equals(typ))
                    {
                        String Message=resultset.getString("Message");
                       Notifys.add(new Notification(Message,typ,Name));
                        
                       
                    }
                }
            }
             con.close();
             Delete(typ, person);
             return Notifys;
    }
    public static void Delete(String typ,Person person)
    {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo = "Delete FROM  NotiicationCenter WHERE Type='"+typ+"'AND Name='"+person.getUserName()+"'";
            smt.execute(dbo);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static ArrayList<Notification>RetriveNotification(String typ) throws SQLException
    {
          ArrayList<Notification>Notifys=new ArrayList<Notification>();
        Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From NotiicationCenter");
            while(resultset.next())
            {
               
                    String type=resultset.getString("Type");
                    if(type.equals(typ))
                    {
                        String Message=resultset.getString("Message");
                        String Name=resultset.getString("Name");
                       Notifys.add(new Notification(Message,typ,Name));
                        
                       
                    }
                
            }
             con.close();
             return Notifys;
    }
}

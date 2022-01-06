/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportationapp.Ride_System;

import com.example.Transportationapp.NotificationCenter.Notification;
import com.example.Transportationapp.NotificationCenter.NotificationModel;
import com.example.Transportationapp.User_System.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class RideModel{
   
   
    public ArrayList<Offer>RetriveOffers(String ClientName)
    {
        ArrayList<Offer>offers=new ArrayList<>();
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From Offers");
            while(resultset.next())
            {
                String Uname=resultset.getString("CName");
                if(Uname.equalsIgnoreCase(ClientName)) {
                    
                    int price=resultset.getInt("price");
                    String DName=resultset.getString("DriverName");
                    Offer offer= new Offer(price, DName, ClientName);
                    offers.add(offer);
                                       
                    
                }
            }
            con.close();
            return offers;
        } catch (SQLException ex) {
            Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public boolean Insert(Ride ride) {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            
            Statement smt=con.createStatement();
            String dbo="Insert Into Ride (src,dest,CName)values('"+ride.getSrc()+"','"+ride.getDest()+"','"+ride.getClientName()+"')";
            smt.execute(dbo);
            smt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
     
     
    public void notifydriverofarea(String src)
    {
        ArrayList<Driver>Drivers=new ArrayList<Driver>();
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver,fav_area,Ride,client where  clientName=CName and driver.Name=fav_area.Dname and fav_area.Area=Ride.src and Fav_area.Area='"+src+"'");
             while(resultset.next())
            {
                 String Name=resultset.getString("Name");
                 String Number=resultset.getString("Number");
                 String email="";
                 Driver d=new Driver(Number,email,"",Name,"","");
                 Drivers.add(d);            
            }
             con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<Drivers.size();i++)
        {
            Notification notification=new Notification("New Request added from your favourite Areas", "Driver", Drivers.get(i).getUserName());
            NotificationModel.Insert(notification);
        }
        
    }

    
    
    
    public void addnewOffer(Offer offer)
    {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo="Insert Into Offers (CName,price,DriverName)values('"+offer.getClient()+"','"+offer.getprice()+"','"+offer.getDriver()+"')";
            smt.execute(dbo);
            smt.close();
            con.close();
            Notifyclient(offer.getClient());
        } catch (SQLException ex) {
            Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Notifyclient(String ClientName)
    {
        Notification notification =new Notification("New Offer Added To your Requested Ride ","Client",ClientName);
         NotificationModel notificationModel=new NotificationModel();
        notificationModel.Insert(notification);
    }
    public void NotifyDriver(String DriverName){
         Notification notification =new Notification("Client Accepted your offer--> ","Driver",DriverName);
         NotificationModel notificationModel=new NotificationModel();
        notificationModel.Insert(notification);
    }
    
    public  void pickOffer(Offer offer) {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo = "Update Ride set Dname='"+offer.getDriver()+"' where CName='"+offer.getClient()+"'";
            smt.execute(dbo);
            dbo = "Update Ride set price="+offer.getprice()+" where CName='"+offer.getClient()+"'";
            smt.execute(dbo);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
    }


   
    public static ArrayList< Ride> getCleintrides(String Name)
    {
        ArrayList<Ride>rides=new ArrayList<>();
        
         try {
             Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
             Statement smt=con.createStatement();
             ResultSet resultset=smt.executeQuery("SELECT * From Ride");
               String src;
               String dest;
               String Uname;
               String DName;
               int rate;
             while(resultset.next())
             {
                 Uname=resultset.getString("CName");
                if(Uname.equalsIgnoreCase(Name)) {
                 
                 src=resultset.getString("src");
                 dest=resultset.getString("dest");
                 DName=resultset.getString("Dname");
                 rate=resultset.getInt("rate");
                 Ride ride=new Ride(Uname,src,dest);
                 ride.setDname(DName);
                 ride.setRate(rate);
                 rides.add(ride);
                 
                }
             }
                con.close();
                return rides;
         } catch (SQLException ex) {
             Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
   
     public static ArrayList<Ride> retriveDriverfavRides(Driver driver)
     {
               ArrayList<Ride> rides=new ArrayList<Ride>();
        try {
           
            
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver,fav_area,Ride,client where clientName=CName and driver.Name=fav_area.Dname and Area=src and driver.Name='"+driver.getUserName()+"'");
            while(resultset.next())
            {
                String src=resultset.getString("src");
    
                String dest=resultset.getString("dest");
               String Uname=resultset.getString("clientName");
                String pass=resultset.getString("CPassword");
                String Number=resultset.getString("CNumber");


                Client c=new Client(Uname, pass, Number,"");
                Ride r=new Ride(c.getUserName(), src, dest);
                rides.add(r);
                
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rides;
     }
     public void startmyRide(String DriverName)
     {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo = "Update Ride set State='"+"Started"+"' where Dname='"+DriverName+"' AND State='"+"Requested"+"'";
            smt.execute(dbo);
        } catch (SQLException ex) {
            Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void updaterate(String CName,String Dname ,int rate)
     {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo = "Update Ride set rate="+rate+" where CName='"+CName+"' AND Dname='"+Dname+"'";
            smt.execute(dbo);
        } catch (SQLException ex) {
            Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      public void endmyRide(String DriverName)
     {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo = "Update Ride set State='"+"Completed"+"' where Dname='"+DriverName+"' AND State='"+"Started"+"'";
            smt.execute(dbo);
        } catch (SQLException ex) {
            Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

 
   
}

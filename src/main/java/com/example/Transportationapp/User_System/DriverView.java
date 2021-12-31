/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportationapp.User_System;

import com.example.Transportationapp.NotificationCenter.Notification;
import com.example.Transportationapp.Ride_System.Ride;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class DriverView {
    DriverController driverController;
    public void ListDriverMenu() throws SQLException
    {/*
       
        while(true){
            
            System.out.println("\nDriver menu:");
            System.out.println("1- Register as A driver :");
            System.out.println("2- sign in as driver :");
            System.out.println("3- Exit :");
            String choice;
            String name,password,phoneNumber,email,NAID,license;
               Scanner cin = new Scanner(System.in);
             choice=cin.next();
               if(choice.equals("1")){
        //driver register 
        Driver driver;
                 System.out.println("Enter your name: ");
                 name=cin.next();
                 System.out.println("Enter your password: ");
                 password=cin.next();
                 System.out.println("Enter your phone number: ");
                phoneNumber=cin.next();
                System.out.println("Enter your  Email(optional if you want to skip press enter): ");
                email=cin.next();
                 System.out.println("Enter your  National ID: ");
                NAID=cin.next();
                System.out.println("Enter your License: ");
                license=cin.next();
                  driverController= new DriverController();
                driverController.SignUp(phoneNumber, email, password, name, NAID, license);
                
                System.out.println("\nYour request is pending till admin verfy it\n ");
               }
               else if(choice.equals("2"))
               {
                   Driver driver;
                 System.out.println("Enter your name: ");
                 name=cin.next();
                 System.out.println("Enter your password: ");
                 password=cin.next();
                 System.out.println("Enter your phone number: ");
                 phoneNumber=cin.next();
                 
                 driverController= new DriverController();
                 if(driverController.login(name, password, phoneNumber))
                 {
                     System.out.println("Sign in completed"); 
                    System.out.println("click (1) to - Add A new Favourite Area");
                    System.out.println("click (2) to - list all reqested rides and make Offer");
                    System.out.println("click (3) to - list all Notification");
                     System.out.println("click (4) to - Start Your Ride");
                      System.out.println("click (5) to - End Your Ride");
                      System.out.println("click (6) to - get your balance");
                     String choice2=cin.next();
                     if(choice2.equalsIgnoreCase("1"))
                     {
                             System.out.println("Enter your fav area: ");
                             String area=cin.next();
                             driverController.AddFavArea(area);
                     }
                     else if(choice2.equalsIgnoreCase("2"))
                     {
                        List<Ride>driverfav= new ArrayList<Ride>();
                          driverfav= driverController.listreqrides();
                         for(int i=0;i<driverfav.size();i++)
                         {
                             System.out.println((i+1)+"-Requested from user-->"+driverfav.get(i).getClientName()+"//Src->>"+driverfav.get(i).getSrc()+"//destination->>"+driverfav.get(i).getDest());
                         }
                        System.out.println("Enter ride number to add offer");
                        int num=cin.nextInt();
                        if(driverfav.size()>=num)
                        {
                         System.out.println("Enter your offer please");
                         int offer=cin.nextInt();
                         driverController.addOffer(driverfav.get(num-1), offer);
                        }
                     }
                      else if(choice2.equalsIgnoreCase("3"))
                     {
                        List<Notification>notifications= driverController.Notifications();
                         for(int i=0;i<notifications.size();i++)
                         {
                             System.out.println((i+1)+"Notification -->"+notifications.get(i).getMessage());
                         }
                     }
                      else if(choice2.equalsIgnoreCase("4"))
                     {
                        driverController.StartRide(name);
                     }
                      else if(choice2.equalsIgnoreCase("5")){
                          driverController.EndRide(name);
                      }
                      else if(choice2.equalsIgnoreCase("6")){
                          System.out.println("Your current Balance is-->"+driverController.getMybalance());
                      }
                 }
                 else
                 {
                     System.out.println("Log in Rejected");
                 }
               }
               else if(choice.equals("3"))
               {
                   break;
               }
        }*/
    }
    
}

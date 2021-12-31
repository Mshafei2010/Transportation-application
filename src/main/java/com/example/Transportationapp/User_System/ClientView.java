/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportationapp.User_System;

import com.example.Transportationapp.NotificationCenter.Notification;
import com.example.Transportationapp.Ride_System.Offer;
import com.example.Transportationapp.Ride_System.Ride;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class ClientView {
    
    ClientController clientcontroller;
    public void ListClientMenu() throws SQLException, ClassNotFoundException
    {/*
        while(true){
    
            Scanner cin = new Scanner(System.in);
            Client client;
            System.out.println("Client menu:");
            System.out.println("1- Register as A Client:");
            System.out.println("2- sign in as Client :");
              System.out.println("3- Exit:");
            
            int choice= cin.nextInt();
             String name,password,phoneNumber,email;
            if(choice==1)
            {
                 System.out.println("Enter your name: ");
                 name=cin.next();
                 System.out.println("Enter your password: ");
                 password=cin.next();
                 System.out.println("Enter your phone number: ");
                 phoneNumber=cin.next();
                System.out.println("Enter your  Email(optional if you want to skip press enter): ");
                email=cin.next();
               clientcontroller=new ClientController();
                if(clientcontroller.Signup(name, password, phoneNumber, email))
                {
                    System.out.println("\nSign UP Completed");
                }
                else
                {
                    System.out.println("\nTry Another UserName please (Duplicated User Name)");
                }
            }
            else if(choice==2)
            {
                System.out.println("Enter your name: ");
                 name=cin.next();
                 System.out.println("Enter your password: ");
                 password=cin.next();
                 System.out.println("Enter your phone number: ");
                 phoneNumber=cin.next();
                 client=new Client(name, password, phoneNumber);
                  clientcontroller=new ClientController();
                 if(clientcontroller.login(name, password, phoneNumber))
                 {
                      System.out.println("Sign in completed"); 
                    System.out.println("click (1) to - Get Your Notifications");
                    System.out.println("click (2) to - list all Offers");
                     System.out.println("click (3) to - Request Ride");
                     System.out.println("click (4) to - List my History");
                    int choice2=cin.nextInt();
                    if(choice2==1){
                        ArrayList<Notification> Notify=clientcontroller.Notifications(client);
                        for (int i=0;i<Notify.size();i++) {
                            System.out.println((i+1)+"--->"+Notify.get(i).getMessage());
                        }
                    }
                    else if(choice2==2){
                        ArrayList<Offer>rideOfers=new ArrayList<Offer>();
                        rideOfers=clientcontroller.listoffers();
                         for (int i=0;i<rideOfers.size();i++) {
                            System.out.println((i+1)+"--->"+rideOfers.get(i).getprice()+"//From Driver"+rideOfers.get(i).getDriver());
                        }
                         System.out.println("Enter Number of offer you want to pick"); 
                         int num=cin.nextInt();
                         clientcontroller.selectOffer(rideOfers.get(num-1));
                    }
                    else if(choice2==3)
                    {
                         System.out.println("Enter your src: ");
                         String src=cin.next();
                         System.out.println("Enter your dest: ");
                         String dest=cin.next();
                         Ride ride=clientcontroller.RequestRide( src, dest);
                    }
                    else if(choice2 ==4)
                    {
                         ArrayList<Ride>rideHistory=new ArrayList<Ride>();
                        rideHistory=clientcontroller.GetMyRides();
                         for (int i=0;i<rideHistory.size();i++) {
                            System.out.println((i+1)+"-from--->"+rideHistory.get(i).getSrc()+"//to-->"+rideHistory.get(i).getDest()+"BY-->"+rideHistory.get(i).getDname() +"Rate-->"+rideHistory.get(i).getRate());
                        }
                         System.out.println("Enter Number of ride you want to rate"); 
                         
                         int num=cin.nextInt();
                         if(num<rideHistory.size() &&num>0){
                          System.out.println("Enter rate"); 
                          int Rate=cin.nextInt();
                         clientcontroller.RateRide(Rate, rideHistory.get(num-1));
                         }
                         else
                         {
                             System.out.println("UNvalid Ride Number\n");
                         }
                    }
                    
                    
                 }
                 else
                 {
                     System.out.println("\nlogin refused ");
                 }
            }
            else if(choice==3)
            {
                break;
            }

}*/
    }
}

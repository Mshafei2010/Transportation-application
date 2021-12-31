/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.Transportationapp.User_System;
import com.example.Transportationapp.NotificationCenter.Notification;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class AdminView {
    
     AdminController adminController;
      public void ListAdminMenu() throws SQLException, ClassNotFoundException
    {/*
        while(true){
    
            Scanner cin = new Scanner(System.in);
            Admin admin;
            System.out.println("Admin menu:");
            System.out.println("1- Register as An Admin:");
            System.out.println("2- sign in as Admin :");
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
                admin =new Admin(name, password, phoneNumber, email);
                adminController=new AdminController(admin);
                if(adminController.Signup(admin))
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
                 admin =new Admin(name, password, phoneNumber);
                  adminController=new AdminController(admin);
                 if(adminController.login(admin))
                 {
                      System.out.println("Sign in completed"); 
                    System.out.println("click (1) to - Get Your Notifications");
                    System.out.println("click (2) to - list all Pending Registeration");
                    int choice2=cin.nextInt();
                    if(choice2==1){
                        ArrayList<Notification> Notify=adminController.Notifications(admin);
                        for (int i=0;i<Notify.size();i++) {
                            System.out.println((i+1)+"--->"+Notify.get(i).getMessage()+Notify.get(i).getName());
                                    }
                    }
                    else if(choice2==2){
                        ArrayList<Driver> pending=adminController.listPendingReg();
                        for (int i=0;i<pending.size();i++) {
                            System.out.println((i+1)+"-DriverName-->"+pending.get(i).getUserName()+" -Driver ID-->"+pending.get(i).getNationalID()+" -Driver License-->"+pending.get(i).getDriverLicense());  
                            
                        }
                        System.out.println("Enter the Driver name to verfiy the registration: ");
                         name=cin.next();
                         adminController.verifyDriver(name, admin);
                    }
                 }
            }
            else if(choice==3)
            {
                break;
            }
            
          }*/
    }
    
}

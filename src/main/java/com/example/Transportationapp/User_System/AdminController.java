/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.Transportationapp.User_System;
import com.example.Transportationapp.NotificationCenter.Notification;
import com.example.Transportationapp.NotificationCenter.NotificationModel;
import com.sun.source.tree.ReturnTree;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
@RestController
@RequestMapping(path="api/Admin")
public class AdminController {
    Admin admin;
   AdminModel adminmodel;
    public AdminController() {
        adminmodel =new AdminModel();
    }
    @RequestMapping(path = "login",method = RequestMethod.GET)
     public Admin login(@RequestBody Admin admin) {
        this.admin=admin;
        if(adminmodel.validate(admin)) {
            return admin;
        }
        return null;
    }

      public void logout() {
        System.exit(0);
    }
    @RequestMapping(path = "signup",method = RequestMethod.GET)
    public Admin Signup(@RequestBody Admin admin) throws SQLException {
        this.admin=admin;
        if(adminmodel.insert(admin)) {
            return admin;
        }
        return null;
    }
    @RequestMapping(path = "verifyDriver",method = RequestMethod.PUT)
     public String verifyDriver(String name) throws ClassNotFoundException, SQLException
     {  
         adminmodel.verifyDriverDatabase(name);
         return "Driver is verified";

     }
    @RequestMapping(path = "GetNotifications",method = RequestMethod.GET)
      public ArrayList<Notification> Notifications() throws SQLException {
          ArrayList<Notification> notification=NotificationModel.RetriveNotification("Admin");
       return notification;
    }


    @RequestMapping(path = "GetpendingReg",method = RequestMethod.GET)
 public ArrayList<Driver> listPendingReg() throws ClassNotFoundException, SQLException
    {
       return DriverModel.retrivependingDrivers();
    }
      
     
    
}

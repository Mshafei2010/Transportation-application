/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportationapp.User_System;

import com.example.Transportationapp.NotificationCenter.Notification;
import com.example.Transportationapp.NotificationCenter.NotificationModel;
import com.example.Transportationapp.Ride_System.Offer;
import com.example.Transportationapp.Ride_System.Ride;
import com.example.Transportationapp.Ride_System.RideController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
@RestController
@RequestMapping(path="api/driver")
public class DriverController {
  
   Driver driver;
    DriverModel driverModel=new DriverModel();
 
     //done
    @RequestMapping(path="login",method = RequestMethod.GET)
    public Driver login(String name,String password,String phoneNumber){
        driver=new Driver(name, password, phoneNumber);
       if( driverModel.validate(driver))
       {
           return driver;
       }
       return null;
    }
    //done
    @RequestMapping(path="logout",method = RequestMethod.DELETE)
      public void logout() {
            System.exit(0);
        }
       //done
       @RequestMapping(path="Signup",method = RequestMethod.POST)
    public Driver SignUp(String phoneNumber, String email, String password, String name, String NAID, String license) throws SQLException {
        
      driver=new Driver(phoneNumber, email, password, name, NAID, license);
      if( driverModel.insert(driver))
      {
          return driver;
      }
      return null;
      
    }

   //done
   @RequestMapping(path="AddFavArea",method = RequestMethod.POST)
    public void AddFavArea(String Area) {
        driverModel.InsertFavArea(driver,Area);
        
    }
    //done

    @RequestMapping(path="listrides",method = RequestMethod.GET)
    public List<Ride> listreqrides() {
       RideController ridecontoroller=new RideController();
       return ridecontoroller.getmyRides(driver);
        
    }
    
   //done
   @RequestMapping(path="GetNotifications",method = RequestMethod.GET)
    public ArrayList<Notification> Notifications() throws SQLException {
       return NotificationModel.Retrive(driver,"Driver");
    }
    
    //done
    @RequestMapping(path="addoffer",method = RequestMethod.POST)
    public void addOffer(@RequestBody  Ride ride,
                         int price) {
        Offer offer;
       offer = new Offer(price, driver.getUserName(), ride.getClientName());
       RideController ridecontroller =new RideController();
       ridecontroller.AddOffer(offer);
    }
    //done
    @RequestMapping(path="StartRide",method = RequestMethod.POST)
    public void StartRide(String Name){
          RideController ridecontroller =new RideController();
       ridecontroller.RideBegin(Name);
    }
    //To end the ride we need to call the controller to end it
    //then we need to call the driver model to update the driver balance
    @RequestMapping(path="EndRide",method = RequestMethod.POST)
     public void EndRide(String Name){
       RideController ridecontroller =new RideController();
       ridecontroller.RideEnd(Name);
       driverModel.updateBalance(Name);
    }
    @RequestMapping(path="GetBalance",method = RequestMethod.GET)
       public int getMybalance() {
        return driverModel.retrivebalance(driver);
        
    }
    

    
    
}

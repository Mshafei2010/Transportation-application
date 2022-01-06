/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportationapp.User_System;

import com.example.Transportationapp.NotificationCenter.Notification;
import com.example.Transportationapp.NotificationCenter.NotificationModel;
import com.example.Transportationapp.Ride_System.Offer;
import com.example.Transportationapp.Ride_System.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path ="api/client")
public class ClientController {
    Client client;
     ClientModel clientmodel;
    public ClientController()
    {
        this.clientmodel=new ClientModel();
    }
    //log in Requests will retrun the object
    @RequestMapping(path = "login",method = POST)
    public Client login(@RequestBody Client client) {
        this.client=client;
        if(clientmodel.validate(client))
        {
            return (client);
        }
        return null;
    }

    @RequestMapping(path = "logout",method = POST)
    public void logout() {
       System.exit(0);
    }

    @RequestMapping(path = "signup",method = POST)
    public Client Signup(@RequestBody Client client) {
        this.client=client;
        return clientmodel.insert(client);}

    @RequestMapping(path ="RequestRide",method =PUT)
    public Ride RequestRide( String src,  String dest){
           Ride requested=new Ride (client.getUserName(), src, dest);
           RideController ridecontroller=new RideController();
          ridecontroller.RequestnewRide(requested);
          return requested;
                
    }
    @RequestMapping(path = "GetOffers",method=GET)
    public ArrayList<Offer> listoffers() {

            RideController rideController=new RideController();
            return rideController.getmyOffers(client.getUserName());
    }
    @RequestMapping(path="GetNotification",method=GET)
    public ArrayList<Notification> Notifications() throws SQLException
    {  
       return NotificationModel.Retrive(client,"Client");
    }


    @RequestMapping(path="pickoffer",method=POST)
    public void selectOffer(@RequestBody  Offer offer) {
        RideController rideController=new RideController();
        rideController.Clientpickoffer(offer);
    }
    
    //LIST all history
    @RequestMapping(path="GetMyRides",method=POST)
   public ArrayList<Ride>GetMyRides()
   {
       RideController rideController=new RideController();
       return rideController.getclientRides(client);
   }
    @RequestMapping(path="RateRide",method=POST)
    public void RateRide(int Rate,String Dname)
    {
        RideController rideController=new RideController();
        rideController.rate(client.getUserName(),Dname,Rate);
    }

    
    
}

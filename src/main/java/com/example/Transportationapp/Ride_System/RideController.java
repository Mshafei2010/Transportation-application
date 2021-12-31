/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  com.example.Transportationapp.Ride_System;

import  com.example.Transportationapp.User_System.*;
import java.util.ArrayList;

/**
 *
 * @author mshaf
 */
public class RideController{
   Ride ride;
    RideModel ridemodel;
    public RideController() {
        ridemodel=new RideModel();
    }
    
    public void RequestnewRide(Ride ride)
    {
        ridemodel.Insert(ride);
        ridemodel.notifydriverofarea(ride.getSrc());
        
    }
    public ArrayList<Offer>getmyOffers(String ClientName){
        ArrayList<Offer>offers=ridemodel.RetriveOffers(ClientName);
        return  offers;
    }
     public ArrayList<Ride>getmyRides(Driver driver){
        ArrayList<Ride>rides=ridemodel.retriveDriverfavRides(driver);
        return  rides;
    }
     public void AddOffer(Offer offer)
     {
         ridemodel.addnewOffer(offer);
     }
     public  void Clientpickoffer(Offer offer){
         ridemodel.pickOffer(offer);
         ridemodel.NotifyDriver(offer.getDriver());
         
     }
     public void RideBegin(String Name){
          ridemodel.startmyRide(Name);
     }
      public void RideEnd(String Name){
          ridemodel.endmyRide(Name);
     }
      public ArrayList<Ride>getclientRides(Client client){
        ArrayList<Ride>rides=RideModel.getCleintrides(client.getUserName());
        return  rides;
    }
      public  void rate(String CName,String Dname,int Rate)
      {
          ridemodel.updaterate(CName,Dname,Rate);
      }
     
    
    
    
    
   

}

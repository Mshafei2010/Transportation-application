/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  com.example.Transportationapp.Ride_System;

import  com.example.Transportationapp.User_System.*;

/**
 *
 * @author mshaf
 */
public class Offer {
    float price=0;
    String driver;
    String client;
    
   public Offer(int price, String driver,String client)
    {
        this.price=price;
        this.driver = driver;
        this.client=client;
    }

  

    public String getClient() {
        return client;
    }
    
    public void setprice(int price)
    {
        this.price = price;
    }
    public float getprice()
    {
        return price;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    
            
}

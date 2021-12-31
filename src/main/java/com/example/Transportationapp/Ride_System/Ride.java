/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  com.example.Transportationapp.Ride_System;

import  com.example.Transportationapp.User_System.Client;
import  com.example.Transportationapp.User_System.Driver;
import java.sql.Time;


public class Ride {
    protected String title;
    protected String description;
    protected String clientName;
    protected String src;
    protected String dest;
    protected String Dname;
     Time timetoleave;
    int distance;
    int speed;
    Time finalETA;
    int rate;
    Offer Cost;
    
    public Ride(String clientName , String src ,String dest){
        this.clientName=clientName;
        this.dest=dest;
        this.src=src;
    }
    public void Notifyclient(){
        
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClientName() {
        return clientName;
    }

    public void setCost(Offer Cost) {
        this.Cost = Cost;
    }

    public Offer getCost() {
        return Cost;
    }


    public String getSrc() {
        return src;
    }

    public String getDescription() {
        return description;
    }

    public String getDest() {
        return dest;
    }

    public String getTitle() {
        return title;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String Dname) {
        this.Dname = Dname;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
    
    
    

}

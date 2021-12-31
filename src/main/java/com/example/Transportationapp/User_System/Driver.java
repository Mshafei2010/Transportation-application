
package com.example.Transportationapp.User_System;

public class Driver extends Person {
    
    private String NationalID;
    private String DriverLicense ;
    private int state=0;

   
     public Driver(String MoblieNumber, String Email, String Password, String UserName,String NationalID,String DriverLicense) {
        //Calling the super class Consturctor
        super(UserName, Password, MoblieNumber, Email);
        this.NationalID = NationalID;
        this.DriverLicense = DriverLicense;
    }
    public Driver(String UserName,String Password,String MoblieNumber,String NationalID,String DriverLicense) {
         //Calling the super class Consturctor
        super( UserName,Password,MoblieNumber);
          this.NationalID = NationalID;
        this.DriverLicense = DriverLicense;
    }
     public Driver(String UserName,String Password,String MoblieNumber) {
         //Calling the super class Consturctor
        super(UserName,Password,MoblieNumber);
    }

    public void setDriverLicense(String DriverLicense) {
        this.DriverLicense = DriverLicense;
    }

    public void setNationalID(String NationalID) {
        this.NationalID = NationalID;
    }
   
    public String getDriverLicense() {
        return DriverLicense;
    }

    public String getNationalID() {
        return NationalID;
    }
    public void setState(int state) {
        this.state = state;
    }
    public int getstate()
    {
        return state;
    }
  
}
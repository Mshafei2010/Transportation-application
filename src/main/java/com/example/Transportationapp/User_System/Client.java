/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.Transportationapp.User_System;

import com.example.Transportationapp.NotificationCenter.Notification;
import com.example.Transportationapp.Ride_System.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Client extends Person {

    public Client(String UserName,String Password,String MoblieNumber) {
        super(UserName, Password,MoblieNumber);
    }
       public Client(String UserName,String Password,String MoblieNumber,String Email) {
        //Calling the super class Consturctor
        super( UserName,Password, MoblieNumber,Email);
    }
    
}

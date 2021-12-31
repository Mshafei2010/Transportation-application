package com.example.Transportationapp.Ride_System;

import java.sql.Time;

public interface Calc {
    public abstract int CalcDistance();
    public abstract Time calcETA(int Distance,int speed);
}

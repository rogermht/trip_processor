package com.littlepay;

/**
 * author:  Roger Ting
 * date: 2019-03-31
 * desciption:
 * Enumerate all the constants
 */
public class Constants{

    public final static String littlepayDateTimeFormat = "dd-MM-yyyy kk:mm:ss";
    public enum Stops{
        Stop1, Stop2, Stop3
    }

    public enum TapType{
        ON, OFF
    }

    public enum TripStatus{
        Completed, Incomplete, Cancelled
    }


}

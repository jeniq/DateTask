package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by mazi on 18.05.2016.
 */
public class Watches extends Time implements Cloneable{
    private SimpleDateFormat timeFormat;
    long time;
    long newTime;

    // Constructor
    public Watches(){
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        date = new Date();
        timeHistory.add(date);
    }

    /**
     * This method returns current time using format
     * @return string
     */
    @Override
    public String currentTime(){
        date = new Date();
        timeHistory.add(date);
        return timeFormat.format(date);
    }

    /**
     * This method sets input time
     * @param date string
     * @throws ParseException
     */
    @Override
    public void setTime(String date) throws ParseException {
        this.date = timeFormat.parse(date);
        timeHistory.add(this.date);
    }

    /**
     * This method add 1 hour ahead
     */
    @Override
    public void increment(){
        time = date.getTime();
        newTime = 1;
        time = time + (60 * 60 * 1000 * newTime);
        date = new Date(time);
        timeHistory.add(date);
    }

    /**
     * This method change time in 1 hour ago
     */
    @Override
    public void decrement() {
        time = date.getTime();
        newTime = -1;
        time = time + (60 * 60 * 1000 * newTime);
        date = new Date(time);
        timeHistory.add(date);
    }

    /**
     * This method override default clone method
     * @return link to the new independent object
     */
    @Override
    public Watches clone(){
        try {
            Watches temp = new Watches();
            super.clone();
            temp.timeHistory = new ArrayList();
            for (Date date : this.timeHistory){
                temp.timeHistory.add((Date)date.clone());
            }
            return temp;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This method returns history of time changing
     * @return arraylist
     */
    public List<Date> getTimeHistory() {
        return timeHistory;
    }
}

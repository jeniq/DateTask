package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mazi on 18.05.2016.
 */
public class Calendar extends Time {
    private SimpleDateFormat format;
    private long time;
    private long newTime;

    // Constructor
    public Calendar(){
        format = new SimpleDateFormat("dd MMMM yyyy EEEE");
        date = new Date();
        timeHistory.add(date);
    }

    /**
     * This method returns current date using format
     * @return string
     */
    @Override
    public String currentTime() {
        date = new Date();
        return format.format(date);
    }

    /**
     * This method sets input date
     * @param date string
     * @throws ParseException
     */
    @Override
    public void setTime(String date) throws ParseException {
        this.date = format.parse(date);
        timeHistory.add(this.date);
    }

    /**
     * This method add 1 day ahead
     */
    @Override
    public void increment() {
        time = date.getTime();
        newTime = 1;
        time = time + (60 * 60 * 24 * 1000 * newTime);
        date = new Date(time);
        timeHistory.add(date);
    }

    /**
     * This method add 1 day ago
     */
    @Override
    public void decrement() {
        time = date.getTime();
        newTime = -1;
        time = time + (60 * 60 * 24 * 1000 * newTime);
        date = new Date(time);
        timeHistory.add(date);
    }

}

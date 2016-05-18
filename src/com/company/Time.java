package com.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mazi on 18.05.2016.
 */
public abstract class Time {
        protected List<Date> timeHistory = new ArrayList();
        protected Date date;

        public abstract String currentTime();
        public abstract void setTime(String date) throws ParseException;
        public abstract void increment();
        public abstract void decrement();

    /**
     * This method override default equals method
     * @param obj
     * @return boolean value
     */
        public boolean equals(Time obj){
                if (this == obj){
                        return true;
                }
                if (obj == null){
                        return false;
                }
                if (obj instanceof Time){
                        Time temp = (Time) obj;
                        return (((Date) this.date).getTime() == temp.date.getTime() &&
                                this.timeHistory.equals(temp.timeHistory));
                }else{
                        return false;
                }
        }

    /**
     * This method generate hashCode
     * @return integer value
     */
    public int hashCode(){
                return -(int) (date.getTime() >>> 5);
        }

    /**
     * This method override default method toString
     * @return strung
     */
    public String toString(){
                return getClass().getName() + "\n" + timeHistory;
        }
}

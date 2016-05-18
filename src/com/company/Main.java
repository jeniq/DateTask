package com.company;

import java.text.ParseException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        // Initialize
        Watches watches = new Watches();
        Watches watches1 = watches.clone();
        Calendar calendar = new Calendar();

        // Execution
        System.out.println(watches.equals(watches1));
        System.out.println(watches.hashCode());
        System.out.println(watches1.hashCode());

        watches.increment();
        watches.setTime("00:00:00");
        watches.decrement();

        System.out.println(watches.hashCode());
        System.out.println(watches1.hashCode());

        System.out.println(watches.equals(watches1));

        System.out.println(watches.getTimeHistory());
        System.out.println(watches1.getTimeHistory());

        System.out.println(watches.toString());
    }
}

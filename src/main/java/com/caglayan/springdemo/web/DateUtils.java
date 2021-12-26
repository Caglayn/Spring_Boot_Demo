package com.caglayan.springdemo.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static DateUtils instance;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private DateUtils() {
    }

    public static DateUtils getInstance(){
        if (instance == null){
            instance = new DateUtils();
        }
        return instance;
    }

    public Date createDateFromString(String dateString){
        Date date = null;
        if (dateString != null){
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException e){
                date = new Date();
                System.out.println(e.getMessage());
            }
        }
        else{
            date = new Date();
        }
        return date;
    }
}

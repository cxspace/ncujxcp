package com.cx.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cxspace on 16-11-18.
 */
public class DateTimeHelper {

    public static String getCurrentDateTime(){

        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        return time;

    }
}

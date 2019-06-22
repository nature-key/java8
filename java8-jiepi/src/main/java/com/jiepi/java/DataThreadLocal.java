package com.jiepi.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataThreadLocal {


    private static final ThreadLocal<DateFormat> tl = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };


    public static Date convert(String source) throws Exception {
        return tl.get().parse(source);
    }


}

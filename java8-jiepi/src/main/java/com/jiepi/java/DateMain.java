package com.jiepi.java;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.SimpleFormatter;

public class DateMain {


    public static void main(String[] args) throws  Exception {
//        SimpleDateFormat stf = new SimpleDateFormat("yyyyMMdd");
//        Callable<Date> task = new Callable<Date>() {
//            @Override
//            public Date call() throws Exception {
////                return stf.parse("20170222");
////                return DataThreadLocal.convert("20170330");
//                return LocalDate.parse("20181212",stf);
//            }
//        };


        DateTimeFormatter stf = DateTimeFormatter.ofPattern("yyyyMMdd");//线程安全
        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20181212",stf);//java8线程安全
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            result.add(executorService.submit(task));

        }

        for (Future<LocalDate> future : result
                ) {
            System.out.println(future.get());
        }

    }






}

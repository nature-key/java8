package com.jiepi.java;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkMain {


    @Test
    public void Test(){

        Instant start= Instant.now();

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkjoinCalculate(0,10000l);
        Long invoke = forkJoinPool.invoke(task);

        System.out.println(invoke);
        Instant end= Instant.now();

        System.out.println("耗时:"+ Duration.between(end,start).getNano());


    }

    @Test
    public void test2(){

        Instant start= Instant.now();
        OptionalLong reduce = LongStream.rangeClosed(0, 10000l)
                .parallel()
                .reduce(Long::sum);
        System.out.println(reduce.getAsLong());
        Instant end= Instant.now();

        System.out.println("耗时:"+ Duration.between(end,start).getNano());

    }

}

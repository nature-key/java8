package com.jiepi.java;

import java.util.concurrent.RecursiveTask;

public class ForkjoinCalculate extends RecursiveTask<Long> {


    private Long start;

    private Long end;

    private static final long FENDUAN = 1000;

    public ForkjoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        long fen = end - start;

        if (fen <= FENDUAN) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (start + end) / 2;
            ForkjoinCalculate forkjoinCalculate = new ForkjoinCalculate(start, mid);
            forkjoinCalculate.fork();

            ForkjoinCalculate forkjoinCalculate1 = new ForkjoinCalculate(mid+1, start);
            forkjoinCalculate1.fork();

            return forkjoinCalculate.join() + forkjoinCalculate1.join();
        }
        }
}

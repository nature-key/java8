package com.jiepi.java;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8Test {


    @Test
    public void test() {

        /**
         * 1.集合 stream  parallelStream
         * 2.Arrays
         * 3.Stream.of()
         * 4.Stream.generate  Stream.iterate
         */
//        List  list = new ArrayList();
//        Stream stream = list.stream();
//        Stream stream1 = list.parallelStream();
////        String
//        Arrays.stream(new Employee[10]).forEach(System.out::println);
        System.out.println("44444444444");
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10)

                .forEach(System.out::println);

        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(12).forEach(System.out::println);


    }
    List<Employee> list = Arrays.asList(
            new Employee(10, "lisi", "男"),
            new Employee(12, "流入", "男"),
            new Employee(13, "王二", "女"),
            new Employee(16, "lisi", "男"),
            new Employee(13, "lisi", "男"),
            new Employee(14, "lisi", "男"),
            new Employee(14, "lisi", "男"),
            new Employee(14, "lisi", "男"),
            new Employee(18, "lisi", "男")
    );

    @Test
    public  void  test2(){
        list.stream()
                .filter((e)->e.getAge()>10)
                        .limit(2).forEach(System.out::println);
        System.out.println("================");
                list.stream().filter(e->e.getAge()>10)
                        .skip(3).forEach(System.out::println);
        System.out.println("================");

        list.stream().filter(e->e.getAge()>10)
                .distinct()//实现equal hashcode
                .forEach(System.out::println);
    }

}

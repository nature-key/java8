package com.jiepi.java;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
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


    @Test
    public void test4(){
        List<String>  list = Arrays.asList("aaa","bbb","ccc");
        list.stream().map((s)->s.toUpperCase())
                .forEach(System.out::println);

        /**
         * flatmap 输入一个函数参数， 多个stream和成一个stream
         */
   list.stream()
           .flatMap(Java8Test::filter).forEach(System.out::println);
    list.stream().flatMap((str)->filter(str)).forEach(System.out::println);

    }

    public static Stream<Character> filter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch:str.toCharArray()
             ) {
                list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void  test7(){

        boolean b = list.stream().allMatch(it -> it.getAge() >=10);
        System.out.println(b);

        boolean wang = list.stream().anyMatch(it -> it.getName().contains("li"));
        System.out.println(wang);

        Optional<Employee> any = list.parallelStream().findAny();
        System.out.println(any.get());
        Optional<Employee> first = list.stream().filter(it -> it.getAge() > 10).findFirst();

        System.out.println(first.get());

    }


    List<Employee> listemp = Arrays.asList(
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
    public void test8(){
        listemp.stream().mapToInt(e->e.getAge()).forEach(System.out::println);

        Map<Integer, List<Employee>> collect = listemp.stream().collect(Collectors.groupingBy((e) -> e.getAge()));

        System.out.println(collect);
        Map<Boolean, List<Employee>> collect1 = listemp.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 12));

        System.out.println(collect1);

        Map<Integer,Map<String,List<Employee>>> t=listemp.stream().collect(Collectors.groupingBy(e->e.getAge(),Collectors.groupingBy(s->s.getSex())));

        System.out.println(t);


    }


}

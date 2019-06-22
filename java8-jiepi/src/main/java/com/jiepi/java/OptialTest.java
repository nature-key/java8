package com.jiepi.java;

import org.junit.Test;

import java.util.Optional;

public class OptialTest {


    @Test
    public void  test1(){
//        Optional<Employee> optional = Optional.of(null);
//        System.out.println(optional.get());

//        Optional<Object> empty = Optional.empty();
//
//        System.out.println(empty.get());
//
//        Optional<Employee> optional1 = Optional.ofNullable(new Employee());
//
//        System.out.println(optional1.get());
//               Optional<Employee> optional3 = Optional.ofNullable(null);
//
//        System.out.println(optional3.get());

//        System.out.println(Optional.of(new Employee()).flatMap((e) -> Optional.of(e.getName())));

        Optional<Employee> optional = Optional.of(new Employee());
        System.out.println("00000000000000");
//        Employee employee = optional.flatMap()
        System.out.println("033330000000000000");
//        System.out.println(employee.getAge());
        Optional<String> s = optional.flatMap(e -> Optional.of(e.getName()));
        System.out.println("000000000030000");

        System.out.println(s.get());



    }
}

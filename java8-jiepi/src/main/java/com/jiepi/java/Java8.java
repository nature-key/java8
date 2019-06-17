package com.jiepi.java;

import java.util.*;

public class Java8 {


    public void test0() {
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<Integer>(com);
        ts.add(2);
        ts.add(0);
        ts.add(1);
        ts.add(4);

        Iterator<Integer> iterator = ts.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }

    }

    public void test1() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> list = Arrays.asList(
            new Employee(10, "lisi", "男"),
            new Employee(12, "流入", "男"),
            new Employee(13, "王二", "女"),
            new Employee(16, "lisi", "男")
    );

    public List<Employee> filter(List<Employee> list, MyFilterPre<Employee> mi) {
        List<Employee> employees = new ArrayList<>();
        for (Employee it : list) {
            if (mi.test(it)) {
                employees.add(it);
            }
        }
        return employees;

    }

    /**
     * lambda
     */
    public void test2(){
        List<Employee> filter = filter(list, (employee -> employee.getAge() > 12));
        filter.forEach(System.out::println);
    }

    public void test3(){
        list.stream().filter(it->it.getAge()>12)
                .forEach(System.out::println);

    }

    /**
     *   lambda表达式 实现函数式接口 @Funcationin
     */
    public void  test4(){
        Integer operation = this.Operation(12, x -> x + 100);

        System.out.println(operation);

    }
    public  Integer Operation(Integer num,MyOperation op){

        return  op.getValue(num);

    }


    public static void main(String[] args) {
//        new Java8().test0();
//        new Java8().test1();
//        new Java8().test2();
//        new Java8().test3();
        new Java8().test4();
    }


}

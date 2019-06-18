package com.jiepi.java;

import java.util.*;
import java.util.function.*;

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
    public void test2() {
        List<Employee> filter = filter(list, (employee -> employee.getAge() > 12));
        filter.forEach(System.out::println);
    }

    public void test3() {
        list.stream().filter(it -> it.getAge() > 12)
                .forEach(System.out::println);

    }

    /**
     * lambda表达式 实现函数式接口 @Funcationin
     */
    public void test4() {
        Integer operation = this.Operation(12, x -> x + 100);

        System.out.println(operation);

    }

    public Integer Operation(Integer num, MyOperation op) {

        return op.getValue(num);

    }


    /**
     * 1.消费类型  Cousmer<>  void accept(T t);
     * 2.提供类型  supperiler
     * 3.断言类型   pre
     * 4.函数类型
     *
     * @param
     */

    //1.消费类型
    public void consumer(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    public void test5() {
        consumer("wangxuan", (str) -> System.out.println(str));
    }

    //2.提供类型

    public String getStr(Supplier<String> stringSupplier) {
        return stringSupplier.get();
    }

    public void test6() {
        String str = getStr(() -> Math.random() * 100 + "");
        System.out.println(str);

    }

    //3.断言

    public boolean getisExist(String str, Predicate<String> predicate) {

        return predicate.test(str);

    }

    public void test7() {

        boolean b = getisExist("wangxuanlisi", (str) -> str.contains("wang"));
        System.out.println(b);

    }

    public Long getFunction(Long l1, Long l2, Function<Long, Long> function) {

        return function.apply(l1);

    }

    public void test8() {
        Long function = getFunction(1l, 2l, (l) -> l.longValue() + 3);

        System.out.println(function);
    }

    /**
     * 1.方法引用
     * 类：实例方法
     * 对象：实例方法
     * 类：静态方发
     * 2.构造函数引用
     * 参数和构造函数保持一致
     * 类名：new
     * 3.数组引用
     * type[]:new
     *
     * @param args
     */


    public static void main(String[] args) {
//        new Java8().test0();
//        new Java8().test1();
//        new Java8().test2();
//        new Java8().test3();
//        new Java8().test4();
//        new Java8().test8();
        //1.方法引用
        Consumer<String> com = (s) -> System.out.println(s);
        com.accept("lisi");

        Consumer<String> com2 = System.out::println;
        com2.accept("wangxuan");

        Supplier<Employee> supplier=()->new Employee();
        System.out.println(supplier.get());
        Supplier<String> stringSupplier =()->new Employee().getName();
        System.out.println(stringSupplier.get());

        Supplier<String> supplier1 =String::new;
        System.out.println(supplier1.get());

        BiPredicate<String,String> biPredicate = (x,y)->x.equals(y);
        //类名::实例方法
        BiPredicate<String,String> biPredicate1 =String::equals;

        Consumer<Employee> consumer = (e)-> System.out.println(e);


        Supplier<Employee> supplier2 = ()->new  Employee();

        Supplier<Employee> supplier3 =Employee::new;

        Function<String,Employee> ff= Employee::new;

        /**
         * 数组类型
         */
        Function<Integer,String[]> function = String[]::new;

        System.out.println(function.apply(10).length);





    }


}

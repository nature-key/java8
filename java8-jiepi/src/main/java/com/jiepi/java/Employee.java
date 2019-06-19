package com.jiepi.java;


import java.util.Objects;

public class Employee {

    private int  age;

    private String name;

    private  String sex;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Employee(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(sex, employee.sex);
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, name, sex);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

package com.jiepi.java;

import org.junit.Test;

import java.lang.reflect.Method;

public class TestAnnation {

    @Test
    public void test() throws NoSuchMethodException {
        Class<TestAnnation> testAnnationClass = TestAnnation.class;
        Method show = testAnnationClass.getMethod("show");
        MyAnnotion[] annotationsByType = show.getAnnotationsByType(MyAnnotion.class);
        for (MyAnnotion myAnnotion : annotationsByType) {
            System.out.println(myAnnotion.value());

        }


    }


    @MyAnnotion("test")
    @MyAnnotion("test1")
    public void show(){

    }
}

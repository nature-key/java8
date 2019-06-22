package com.jiepi.java;

import org.junit.Test;

import java.lang.annotation.*;

@Repeatable(MyAnnotions.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyAnnotion {

   String value() default "测试";
}

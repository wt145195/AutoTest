package com.course.testng.multiThreads;

import org.testng.annotations.Test;

public class multiThreadsOnXml {

    @Test
    public void test1()
    {
        System.out.println("test1的方法执行");
        System.out.printf("Thread ID = %s%n", Thread.currentThread().getId());
        System.out.println("=====================================");
    }
    @Test
    public void test2()
    {
        System.out.println("test2的方法执行");
        System.out.printf("Thread ID = %s%n", Thread.currentThread().getId());
        System.out.println("=====================================");
    }
    @Test
    public void test3()
    {
        System.out.println("test3的方法执行");
        System.out.printf("Thread ID = %s%n", Thread.currentThread().getId());
        System.out.println("=====================================");
    }
    @Test
    public void test4()
    {
        System.out.println("test4的方法执行");
        System.out.printf("Thread ID = %s%n", Thread.currentThread().getId());
        System.out.println("=====================================");
    }
}

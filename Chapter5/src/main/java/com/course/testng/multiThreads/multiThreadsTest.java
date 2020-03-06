package com.course.testng.multiThreads;

import org.testng.annotations.Test;

public class multiThreadsTest {

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void testMultiThreads()
    {
        System.out.println(11);
        System.out.printf("Thread ID:  %s%n", Thread.currentThread().getId());
    }
}

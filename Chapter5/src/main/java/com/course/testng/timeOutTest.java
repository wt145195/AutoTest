package com.course.testng;

import org.testng.annotations.Test;

import java.rmi.server.RMIClassLoader;

public class timeOutTest {

    @Test(timeOut = 3000)
    public void timeOutSuccess() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(1111);
    }
    @Test(timeOut = 2000)
    public void timeOutFailed() throws InterruptedException{
        Thread.sleep(3000);
        System.out.println(222);
    }
}

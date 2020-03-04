package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class testSuit {

    @BeforeSuite
    public void beforeSuit()
    {
        System.out.println("beforeSuite执行");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("afterSuite执行");
    }

    @BeforeTest  //在xml中的每一个test标签执行前运行；
    public void beforeTest()
    {
        System.out.println("beforeTest执行");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("afterTest执行");
    }


}

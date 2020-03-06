package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test  //最基础的注解，用来把方法标记为测试的一部分
    public void testCase1(){
        System.out.println("testcase1");

    }

    @Test
    public void testcase2()
    {

    }

    @BeforeMethod
    public void beforeMethod()
    {

    }

    @AfterMethod
    public void afterMethod()
    {

    }

    @BeforeClass  //在类运行之前运行的方法
    public void beforeClass()
    {

    }

    @AfterClass //在类运行之后运行的方法
    public void afterClass()
    {

    }

    @BeforeSuite
    public void beforeSuit(){

    }

    @AfterSuite
    public void afterSuite(){

    }



}

package com.course.testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupMethodTest {

    @Test(groups = "server")
    public void test1()
    {
        System.out.println("服务端测试111");
    }

    @Test(groups = "server")
    public void test2()
    {
        System.out.println("服务端测试222");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("客户端测试333");
    }

    @Test(groups = "client")
    public void test4()
    {
        System.out.println("客户端测试444");
    }


    //在testng 7.0以上版本执行不起来，只能在6.11.0的版本执行
    @BeforeGroups("server")
    public void beforeGroupsOnServer()
    {
        System.out.println("服务端组用例运行之前的方法执行");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer()
    {
        System.out.println("服务端组用例运行之前的方法执行");
    }

}

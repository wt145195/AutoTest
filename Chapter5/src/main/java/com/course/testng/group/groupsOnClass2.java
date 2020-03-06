package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu2")
public class groupsOnClass2 {

    public void groupsOnStu1()
    {
        System.out.println("执行groupsOnClass2的groupsOnStu1方法");
    }
    public void groupsOnStu2(){
        System.out.println("执行groupsOnClass2的groupsOnStu2方法");
    }
}

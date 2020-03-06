package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu1")
public class groupsOnClass1 {

    public void groupsOnStu1(){
        System.out.println("执行groupsOnClass1的groupsOnStu1方法");
    }

    public void groupsOnStu2(){
        System.out.println("执行groupsOnClass1的groupsOnStu2方法");
    }
}

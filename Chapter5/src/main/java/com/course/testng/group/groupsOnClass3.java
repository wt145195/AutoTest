package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class groupsOnClass3 {
    public void groupsOnTeacher1()
    {
        System.out.println("执行groupsOnClass3的groupsOnTeacher1方法");
    }

    public void groupsOnTeacher2()
    {
        System.out.println("执行groupsOnClass3的groupsOnTeacher2方法");
    }
}

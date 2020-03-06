package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class dataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("testDataProvider的name= "+name+"; age="+age);
    }

    @DataProvider(name="data")
    public Object[][] providerData()
    {
        Object[][] object = new Object[][]{
                {"zhangsan",10},
                {"lisi",15},
                {"wangwu",20}
        };
        return object;
    }


    @Test(dataProvider = "Methoddata")
    public void test1(String name,int age){
        System.out.println("test1的name= "+name+"; age="+age);
    }
    @Test(dataProvider = "Methoddata")
    public void test2(String name,int age){
        System.out.println("test2的name= "+name+"; age="+age);
    }

    @DataProvider(name="Methoddata")
    public Object[][] providerData1(Method method){
        Object[][] object1=null;
        if(method.getName().equals("test1"))
        {
            object1=new Object[][]{
                    {"Alice",30},
                    {"Bobby",35}
            };
        }else if(method.getName().equals("test2"))
        {
            object1=new Object[][]{
                    {"celina",40},
                    {"lucy",45}
            };
        }
        return object1;
    }

}

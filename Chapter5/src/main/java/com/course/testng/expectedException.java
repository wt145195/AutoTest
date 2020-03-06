package com.course.testng;

import org.testng.annotations.Test;

public class expectedException {

    /*
    * 在期望结果是一个异常的时候，比如传入了某些不合法的参数，程序
    * 抛出了异常
    * 即该程序的预期结果就是这个异常
    * */
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExpectionFailed()
    {
        System.out.println("这次异常测试失败");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExpectionSuccess()
    {
        System.out.println("异常测试成功");
        throw new RuntimeException();

    }

}

package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Api(value = "/",description = "这是我的post接口请求")
@RestController
@RequestMapping("/v1")
public class testForPostCookies {

    /*
    * 先通过登录接口获取一个cookie，然后再拿着cookie访问另一个列表页面
    * */
    private static Cookie cookies;

    @RequestMapping(value = "/getpostcookies",method = RequestMethod.POST)
    @ApiOperation(value = "这是一个登录接口，会返回一个cookie信息",httpMethod = "POST")
    //定义了用户名和密码两个参数，这两个参数设置为必填，@RequestParam后面的value=""将前端的传值和方法定义的变量名对应起来
    public String getCookies(HttpServletResponse response,
                             @RequestParam(value = "userName",required = true) String userName,
                             @RequestParam(value = "password",required = true) String password){

        cookies = new Cookie("login","true");
        if(userName.equals("alice") && password.equals("123456"))
        {
            response.addCookie(cookies);
            return "login success!!!!";
        }
        return "账号名或密码错误";


    }
}

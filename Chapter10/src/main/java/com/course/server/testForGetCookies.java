package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "下面都是get接口")
public class testForGetCookies {

    @GetMapping("/getcookies")
    @ApiOperation(value = "这是响应返回带cookies信息的get请求",httpMethod = "GET")
    public String getcookies(HttpServletResponse response){

        //HttpServerletRequest 装请求信息的类
        //HttpServerletResponse 装响应信息的类
        //创建Cookie对象，把cookie放到response中
        Cookie cookie =new Cookie("login","true");
        response.addCookie(cookie);

        return "这是带cookies信息的反馈";
    }

    @ApiOperation(value = "这是一个必须要带cookie才能请求成功的get接口",httpMethod = "GET")
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        /*
        * 这是一个必须要带cookie才能请求成功的接口
        * */
        //HttpServerletRequest自带的getCookies()方法返回的是个数组，所以定义Cookie对象是也需要是数组类型
        Cookie[] cookies = request.getCookies();

        if(Objects.isNull(cookies)){
            return "这个请求必须要带cookie信息才能成功，请加上cookie信息再请求";
        }

        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "这个带cookie的请求成功了！！！";
            }
        }

        return "这个请求必须要带cookie信息才能成功，请加上cookie信息再请求";
    }




    /*
    * 开发一个需要携带参数才能访问的get请求
    * 第一种实现方式 url：key=value&key=value  通过@ReuqestParam在参数定义中使用实现
    * 模拟获取商品列表
    * */
    @ApiOperation(value = "这是第一种实现方式实现的需要携带参数才能访问的get请求",httpMethod = "GET")
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end)
    {
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋",280);
        myList.put("外套",450);
        myList.put("饼干",20);

        return myList;
    }


    /*
    * 开发一个需要携带参数才能访问的get请求
    * 第二种实现方式 url ip:port/get/with/param/参数1/参数2，通过@PathVariable在参数定义中使用实现
    * */
    @ApiOperation(value = "这是第二种实现方式实现的需要携带参数才能访问的get请求",httpMethod = "GET")
    @RequestMapping(value = "get/with/param/{start}/{end}",method = RequestMethod.GET)
    public Map<String,Integer> getList2(@PathVariable Integer start,@PathVariable Integer end)
    {
        Map<String,Integer> myList2 = new HashMap<>();
        myList2.put("皮鞋",280);
        myList2.put("上衣",450);
        myList2.put("饮料",20);

        return myList2;
    }
}

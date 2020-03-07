package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class cookieTestForPost {

    private String url;
    private ResourceBundle bundle;
    CookieStore cookieStore = new BasicCookieStore();  //保存cookie

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }

    //从服务端获取cookie信息
    @Test
    public void testGetCookies() throws IOException {

        String result;
        String uri = bundle.getString("getcookie.uri");
        String testurl = this.url+uri;

        HttpGet get = new HttpGet(testurl);

        ////创建CloseableHttpClient类，httpclient 4.5以上不能用DefaultHttpClient
        //    HttpClient client = HttpClientBuilder.create().build();

        //创建能获取cookie的CloseableHttpClient类
        HttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();

        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        List<Cookie> cookieList = cookieStore.getCookies();
        for(Cookie cookie :cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie的name = "+name+"   cookie的value = "+value);
        }
    }


    @Test(dependsOnMethods = "testGetCookies")
    public void testPostCookies() throws IOException {

        String uri = bundle.getString("test.post.with.cookies");
        String testPostUrl = this.url+uri;

        //创建post对象
        HttpPost post = new HttpPost(testPostUrl);

        //创建执行请求的httpclient对象，并且将该对象和cookieStore绑定
        HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        //设置请求的参数
        post.setHeader("content-type","application/json");
        //设置请求头
        JSONObject param = new JSONObject();
        param.put("name","zhangsan");
        param.put("sex","man");

        //将参数信息添加到请求方法中Entity
        StringEntity entity = new StringEntity(param.toString());  //param不是String类型，需要toString一下
        post.setEntity(entity);

        //执行post请求保存结果
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //将返回结果的字符串转换成json对象格式
        JSONObject resultJson = new JSONObject(result);
        //获取响应结果，并进行断言判断
        String name = (String) resultJson.get("name");
        String age = (String) resultJson.get("age");
        Assert.assertEquals(name,"zhangsan");
        System.out.println("断言成功");
        Assert.assertEquals(age,"28");
        System.out.println("断言成功");

    }
}

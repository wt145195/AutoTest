package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class cookieTestForGet {

    private String url;
    private ResourceBundle bundle;
    CookieStore cookieStore = new BasicCookieStore();  //保存cookie

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("test.url");

    }

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
    public void testGetWithCookies() throws IOException {

        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode==200)
        {
            System.out.println(result);
        }


    }
}

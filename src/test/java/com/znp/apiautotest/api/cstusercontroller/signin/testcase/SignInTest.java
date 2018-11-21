package com.znp.apiautotest.api.cstusercontroller.signin.testcase;

import com.alibaba.fastjson.JSON;
import com.znp.apiautotest.api.cstusercontroller.signin.bean.SignInRequ;
import com.znp.apiautotest.api.cstusercontroller.signin.bean.SignInResp;
import com.znp.apiautotest.api.tools.HttpTools;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {
    @Test
    public void testSignIn(){
        SignInRequ signInRequ = new SignInRequ();
        signInRequ.setPwd("kaxni02778");
        signInRequ.setUserName("DBB44654");

        String requJson = JSON.toJSONString(signInRequ,true);
        System.out.println("--------------------登录请求报文--------------------");
        System.out.println(requJson);
        String url = "http://qa.guoyasoft.com:8080/user/login";
        String respJson = HttpTools.doPostByJson(url,requJson,"utf-8");
        System.out.println("--------------------登录响应报文--------------------");
        System.out.println(respJson);
        SignInResp signInResp = JSON.parseObject(respJson,SignInResp.class);
        Assert.assertEquals(signInResp.getRespCode(),"0000");
    }
}

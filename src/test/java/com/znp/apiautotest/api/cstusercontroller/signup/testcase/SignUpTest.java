package com.znp.apiautotest.api.cstusercontroller.signup.testcase;

import com.alibaba.fastjson.JSON;
import com.znp.apiautotest.api.cstusercontroller.signup.bean.SignUpRequ;
import com.znp.apiautotest.api.cstusercontroller.signup.bean.SignUpResp;
import com.znp.apiautotest.api.tools.HttpTools;
import com.znp.apiautotest.api.tools.PinYinTools;
import com.znp.apiautotest.api.tools.RandomTools;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {
    @Test
    public void testSignUp() {
        SignUpRequ signUpRequ = new SignUpRequ();
        String phone = RandomTools.getTel();
        String pwd = RandomTools.randomString(RandomTools.charStr,5) + RandomTools.randomString(RandomTools.numStr,5);
        String str1 = RandomTools.randomString(RandomTools.numStr,5);
        String userName = PinYinTools.toFirstChar(RandomTools.getChineseName()).toUpperCase() + str1;

        signUpRequ.setPhone(phone);
        signUpRequ.setPwd(pwd);
        signUpRequ.setRePwd(pwd);
        signUpRequ.setUserName(userName);

        String requJson = JSON.toJSONString(signUpRequ,true);
        System.out.println("--------------------注册请求报文--------------------");
        System.out.println(requJson);
        Allure.addAttachment("请求报文", requJson);
        String url = "http://qa.guoyasoft.com:8080/user/signup";
        String respJson = HttpTools.doPostByJson(url,requJson,"utf-8");
        System.out.println("--------------------注册响应报文--------------------");
        System.out.println(respJson);
        Allure.addAttachment("响应报文", respJson);
        SignUpResp signUpResp = JSON.parseObject(respJson,SignUpResp.class);
        Assert.assertEquals(signUpResp.getRespBase().getRespCode(),"0000");
    }
}

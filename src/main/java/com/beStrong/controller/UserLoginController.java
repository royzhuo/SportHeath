package com.beStrong.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by roy on 2017/3/20.
 */
@Controller
public class UserLoginController {

    public static final String LOGIN_SUCCESS="SUCCESS";
    public static final String LOGIN_FAIL="FAIL";


    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    public String login(String name, String pwd, HttpRequest request, HttpServletResponse response){


        return LOGIN_FAIL;
    }

    @RequestMapping(value = "/main1",method = RequestMethod.GET)
    public String  loginMain1(HttpServletRequest request){
        System.out.println("this is main1");
        Cookie[] cookies= request.getCookies();

        return "mian1";
    }

    @RequestMapping(value = "/main2",method = RequestMethod.GET)
    public String  loginMain2(){
        System.out.println("this is main2");
        return "main2";
    }
}

package com.beStrong.service;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by roy on 2017/3/23.
 */
@Service
public interface CheckLoginService {

/*    public boolean checkLogin(String username,String pwd,HttpServletResponse response){
        if (username.equals("roy")&&pwd.equals("123")){
            Cookie cookie=new Cookie("royCookie","roysso");
            response.addCookie(cookie);
            return true;
        }
        return false;
    }*/

public boolean checkUserLogin(String username,String pwd);
}

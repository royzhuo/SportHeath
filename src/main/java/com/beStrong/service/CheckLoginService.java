package com.beStrong.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by roy on 2017/3/23.
 */
@Service
public class CheckLoginService {

    public boolean checkLogin(String username, String pwd) {
        if (null != username && null != pwd) {
            if (username.equals("roy") && pwd.equals("123")) {

                return true;
            }
        }
        return false;
    }

    public boolean checkCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("roy") && cookie.getValue().equals("royLogin")) {
                    return true;
                }
            }
        }
        return false;
    }
}

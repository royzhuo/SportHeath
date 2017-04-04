package com.beStrong.controller;

import com.beStrong.service.CheckLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by roy on 2017/3/20.
 */
@Controller
public class UserLoginController {

    @Autowired
    private CheckLoginService checkLoginService;


    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String login(String name, String pwd, HttpServletResponse response,
                        @RequestParam(value = "goUrl", required = false) String goUrl,
                        @ModelAttribute("goUrl") String url, HttpServletRequest request) {

        if (checkLoginService.checkLogin(name, pwd)) {
            Cookie cookie = new Cookie("roy", "royLogin");
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:" + goUrl;
        }
        goUrl = url;
        //request.setAttribute("goUrl", url);
        return "Login";
    }

    @RequestMapping(value = "/main1", method = RequestMethod.GET)
    public String loginMain1(HttpServletRequest request, RedirectAttributes attributes) {
        System.out.println("this is main1");
        Cookie[] cookies = request.getCookies();
        if (checkLoginService.checkCookie(request)) {
            return "mian1";
        }
        String goUrl = "/main1";
        attributes.addAttribute("goUrl", goUrl);
        return "redirect:/userLogin";

    }

    @RequestMapping(value = "/main2", method = RequestMethod.GET)
    public String loginMain2(HttpServletRequest request, RedirectAttributes attributes) {
        Cookie[] cookies = request.getCookies();
        if (checkLoginService.checkCookie(request)) {
            return "main2";
        }
        String goUrl = "/main2";
        attributes.addAttribute("goUrl", goUrl);
        return "redirect:/userLogin";
    }
}

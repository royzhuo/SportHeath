package com.beStrong.controller;

import com.beStrong.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author roy.zhuo
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> login(@RequestParam(value = "userName") String userName,
                                     @RequestParam(value = "pwd") String pwd) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != userService.checkLogin(userName, pwd)) {
            map.put("info", userService.checkLogin(userName, pwd));
            map.put("code", 200);
        } else {
            map.put("info", "用户名或密码错误");
            map.put("code", "404");
        }

        return map;
    }
}

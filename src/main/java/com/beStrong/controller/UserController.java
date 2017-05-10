package com.beStrong.controller;

import com.beStrong.entity.User;
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
    public Map<String, Object> login(@RequestParam(value = "phone") String phone,
                                     @RequestParam(value = "pwd") String pwd) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != userService.checkLogin(phone, pwd)) {
            map.put("info", userService.checkLogin(phone, pwd));
            map.put("code", "200");
        } else {
            map.put("info", "用户名或密码错误");
            map.put("code", "404");
        }

        return map;
    }

    @RequestMapping(value = "/api/user/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registerUser(@RequestParam(value = "height") String height,
                                            @RequestParam(value = "weight") String weight,
                                            @RequestParam(value = "birthday") String birthday,
                                            @RequestParam(value = "bmi") String bmi,
                                            @RequestParam(value = "advice") String advice,
                                            @RequestParam(value = "nickName") String nickName,
                                            @RequestParam(value = "phone") String phone,
                                            @RequestParam(value = "pwd") String pwd,
                                            @RequestParam(value = "sex") int mySex) {
        Map<String, Object> map = null;
        //新建用户
        User user = new User();
        user.setHeight(Double.valueOf(height));
        user.setWeight(Double.valueOf(weight));
        //user.setBirthDay();
        user.setPwd(pwd);
        user.setNickname(nickName);
        user.setBmi(bmi);
        user.setAdvice(advice);
        user.setPhone(phone);
        user.setBirthDay(userService.setBirthDay(birthday));
        user.setSex(mySex);
        map = userService.registerUser(user);
        return map;
    }

    @RequestMapping(value = "/api/user/confirm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> confimUser(@RequestParam(value = "phone") String phone,
                                          @RequestParam(value = "birthday") String birthday) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.getUser(phone, birthday);
        if (user != null) {
            map.put("code", "200");
            map.put("info", user);
        } else {
            map.put("code", "500");
            map.put("info", "没有对象");
        }
        return map;
    }

    @RequestMapping(value = "/api/user/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatePwd(@RequestParam(value = "pwd") String pwd,
                                         @RequestParam(value = "userId") Integer id) {
        Map<String, Object> map = null;
        map = userService.updatePwd(id, pwd);
        return map;
    }

    @RequestMapping(value = "/api/user/findUser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findUser(@RequestParam(value = "phone") String phone,
                                        @RequestParam(value = "birth") String birth) {
        Map<String, Object> map = null;
        map = userService.getUser1(phone, birth);
        return map;
    }

    @RequestMapping(value = "/api/user/orderPlan", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> orderPlan(@RequestParam("plan") String plan,
                                         @RequestParam("id") Integer id) {
        Map<String, Object> map = null;
        map = userService.orderPlan(id, plan);
        return map;


    }

    @RequestMapping(value = "/api/user/updateUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserInfo(@RequestParam(value = "nickName") String nickname,
                                              @RequestParam(value = "height") String height,
                                              @RequestParam(value = "weight") String weight,
                                              @RequestParam(value = "advice") String advice,
                                              @RequestParam(value = "bmi") String bmi,
                                              @RequestParam(value = "userId") Integer id) {

        Map<String, Object> map = userService.updateUserInfo(id, nickname, height, weight, bmi, advice);
        return map;
    }


}

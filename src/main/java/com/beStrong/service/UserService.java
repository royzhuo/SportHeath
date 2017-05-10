package com.beStrong.service;

import com.beStrong.dao.UserDao;
import com.beStrong.entity.User;
import com.beStrong.exceptions.SportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author roy.zhuo
 */
@Service
public class UserService {

    //public static User user = new User("roy", "志艺", "123", 24, 150.8, 178.0, new Date(), new Date());
    @Autowired
    private UserDao userDao;

    public User checkLogin(String phone, String pwd) {
        User user = null;
        user = userDao.getUserByPhoneAndPwd(phone, pwd);
        return user;
    }

    public Map<String, Object> registerUser(User user) {

        Map<String, Object> map = new HashMap<String, Object>();
        //判断是否用户是否被注册过
        List<User> list = userDao.getUser(user.getPhone());

        if (list != null && list.size() > 0) {
            map.put("code", "500");
            map.put("message", "用户已被注册");
        } else {
            //生成一个sport_id
            String sport_id = "sport" + System.currentTimeMillis();
            user.setSprot_id(sport_id);
            user.setCreateTime(new Date());
            try {
                userDao.save(user);
                map.put("code", "200");
                map.put("message", "注册成功");
            } catch (Exception e) {
                map.put("code", "500");
                map.put("message", "添加失败");
                throw new SportException("添加失败");

            }
        }

        return map;
    }

    public User getUser(String phone, String birth) {


        return userDao.getUserByPhoneAndBirth(phone, setBirthDay(birth));
    }

    public Date setBirthDay(String birth) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public Map<String, Object> getUser1(String phone, String birth) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = null;
        user = userDao.getUserByPhoneAndBirth(phone, setBirthDay(birth));
        if (user != null) {
            map.put("code", "200");
            map.put("result", user);
        } else {
            map.put("code", "200_404");
            map.put("result", "没有此用户");
        }

        return map;
    }

    @Transactional
    public Map<String, Object> updatePwd(Integer id, String pwd) {
        Map<String, Object> map = new HashMap<String, Object>();
        int result = 0;
        try {
            result = userDao.updatePwd(pwd, id);
            if (result == 1) {
                map.put("code", "200");
                map.put("message", "更新成功");
            }
        } catch (Exception e) {
            map.put("code", "500");
            map.put("message", "sql异常");
            throw new SportException(e);
        }

        return map;
    }

    @Transactional
    public Map<String, Object> orderPlan(Integer id, String plan) {
        Map<String, Object> map = new HashMap<String, Object>();
        int result = 0;
        try {
            result = userDao.orderPlan(id, plan);
            if (result == 1) {

                map.put("code", "200");
                map.put("message", "更新成功");
                map.put("result", plan);
            }
        } catch (Exception e) {
            map.put("code", "500");
            map.put("message", "sql异常");
            throw new SportException(e);
        }
        return map;

    }

    @Transactional
    public Map<String, Object> updateUserInfo(Integer id, String nickName, String height, String weight, String bmi,
                                              String advice) {
        Map<String, Object> map = new HashMap<String, Object>();
        double height1 = Double.valueOf(height);
        double weight1 = Double.valueOf(weight);
        User user = userDao.findOne(id);
        user.setUpdateTime(new Date());
        user.setHeight(height1);
        user.setWeight(weight1);
        user.setAdvice(advice);
        user.setBmi(bmi);
        user.setNickname(nickName);
        int result = 0;
        try {
            result = userDao.updateUserInfo(user.getNickname(), user.getWeight(), user.getHeight(), user.getBmi(), user.getAdvice(),user.getUpdateTime(), user.getId());
            if (result == 1) {
                map.put("code", "200");
                map.put("message", "更新成功");
                map.put("result", user);
            } else {
                map.put("code", "200_500");
                map.put("message", "更新失败");
            }
        } catch (Exception e) {
            map.put("code", "500");
            map.put("message", "更新失败");
            map.put("result", e);
        }
        return map;

    }


}

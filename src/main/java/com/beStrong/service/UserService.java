package com.beStrong.service;

import com.beStrong.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author roy.zhuo
 */
@Service
public class UserService {

    public static User user = new User("roy", "志艺", "123", 24, 150.8, 178.0, new Date(), new Date());

    public User checkLogin(String userName, String pwd) {
        if (user != null) {
            if (userName.equals(user.getNickname()) && pwd.equals(user.getPwd())) return user;
        }
        return null;
    }
}

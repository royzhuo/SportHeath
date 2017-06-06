package com.beStrong.service;

import com.beStrong.dao.ShareDao;
import com.beStrong.dao.UserDao;
import com.beStrong.entity.Share;
import com.beStrong.entity.User;
import com.beStrong.exceptions.SportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author roy.zhuo
 */
@Service
public class ShareSerive {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ShareDao shareDao;


    public Map<String, Object> share(String content, Integer userid) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userDao.findOne(userid);
        Share share = new Share();
        share.setName(user.getNickname());
        share.setContent(content);
        share.setCreateTime(new Date());

        List<Share> shares = user.getShares();
        if (shares != null) shares.add(share);
        else {
            shares = new ArrayList<Share>();
            shares.add(share);
        }
        user.setShares(shares);
        try {
            shareDao.save(share);
            userDao.saveAndFlush(user);
            map.put("code", "200");
        } catch (Exception e) {
            map.put("code", "200_500");
            map.put("message", "添加失败");
            throw new SportException("添加失败");
        }
        return map;

    }

    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Share> shares = shareDao.findAll();
            map.put("code", "200");
            map.put("result", shares);
        } catch (Exception e) {
            map.put("code", "200_500");
            map.put("message", "添加失败");
            throw new SportException("获取失败");
        }


        return map;
    }
}

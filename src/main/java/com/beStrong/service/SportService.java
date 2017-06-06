package com.beStrong.service;

import com.beStrong.dao.LocationDao;
import com.beStrong.dao.SportDao;
import com.beStrong.dao.UserDao;
import com.beStrong.entity.Location;
import com.beStrong.entity.Sport;
import com.beStrong.entity.User;
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
public class SportService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private SportDao sportDao;
    @Autowired
    private LocationDao locationDao;

    public Map<String, Object> addSportData(Integer userId, String nickName, String kilo, String kaluli, List<String> locations) {

        Map<String, Object> map = new HashMap<String, Object>();
        //获取用户信息
        User user = userDao.findOne(userId);
        //装配运动数据
        Sport sport = new Sport();
        sport.setName(nickName);
        sport.setKaluli(kaluli);
        sport.setKil(kilo);


        List<Sport> sports = user.getSports();
        if (sports != null) {
            sports.add(sport);
        } else {
            sports = new ArrayList<Sport>();
            sports.add(sport);
        }

        List<Location> locations1 = sport.getLocations();
        if (locations1 == null) locations1 = new ArrayList<Location>();
        try {
            for (String tempLoation : locations) {
                //装配地理信息
                Location location = new Location();
                location.setLocation(tempLoation);
                location.setCreateTime(new Date());
                locations1.add(location);

            }
            sport.setLocations(locations1);
            sport.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            sportDao.save(sport);
            for (Location location : locations1) {
                locationDao.save(location);
            }


            userDao.saveAndFlush(user);
            map.put("code", "200");
        } catch (Exception e) {
            map.put("code", "200_500");
            throw new RuntimeException(e);

        }


        return map;

    }

    public Map<String, Object> list(Integer userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Sport> sportDatas = sportDao.listByUserId(userId);
        if (sportDatas != null && sportDatas.size() > 0) {
            map.put("code", "200");
            map.put("resutl", sportDatas);
        }
        return map;
    }
}

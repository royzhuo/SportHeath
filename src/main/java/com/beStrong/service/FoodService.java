package com.beStrong.service;

import com.beStrong.dao.FoodDao;
import com.beStrong.entity.HealthFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author roy.zhuo
 */
@Service
public class FoodService {


    @Autowired
    private FoodDao foodDao;

    public int uploadFood(String fileUrl, String foodName, String foodContent) {

        try {

            //得到session

            //得到LobHelper

           /* byte[] photo = new byte[fileInputStream.available()];
            fileInputStream.read(photo);
            fileInputStream.close();*/
            HealthFood healthFood = new HealthFood();
            healthFood.setName(foodName);
            healthFood.setContent(foodContent);
            //healthFood.setPhoto(photo);
            healthFood.setImageUrl(fileUrl);
            foodDao.save(healthFood);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<HealthFood> foods = foodDao.findAll();
        for (HealthFood food : foods) {
            File file = new File(food.getImageUrl());
            try {
                InputStream in = new FileInputStream(file);
                food.setPhotoInps(in);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (foods != null && foods.size() > 0) {

            map.put("code", "200");
            map.put("resutl", foods);
        }
        return map;
    }
}

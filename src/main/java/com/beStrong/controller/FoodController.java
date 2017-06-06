package com.beStrong.controller;

import com.beStrong.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author roy.zhuo
 */

@Controller
public class FoodController {

    public static final String fileurl = "/Users/Roy/Documents/personal/roy/素材/image";
    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/api/food/upload", method = RequestMethod.POST)
    public String uploadFood(@RequestParam(value = "foodFile") MultipartFile file,
                             @RequestParam(value = "foodName") String foodName,
                             @RequestParam(value = "foodYingYang") String foodYingYang) throws IOException {

        BufferedInputStream bis = null;
        OutputStream outputStream = null;
        BufferedOutputStream bos = null;
        int temp = 0;
        try {
            String filePath = fileurl + file.getOriginalFilename();
            File tempFile = new File(fileurl);
            if (!tempFile.exists()) {
                tempFile.mkdir();
            }
            File foodFile = new File(filePath);
            FileInputStream foodInputStream = (FileInputStream) file.getInputStream();

            bis = new BufferedInputStream(foodInputStream);
            outputStream = new FileOutputStream(filePath);
            bos = new BufferedOutputStream(outputStream);
            foodService.uploadFood(filePath, foodName, foodYingYang);
            while ((temp = bis.read()) != -1) {
                bos.write(temp);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                bos.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }

            if (bis != null) {
                bis.close();
            }
        }

        return null;
    }

    @RequestMapping(value = "/api/food/list", method = RequestMethod.GET)
    public Map<String, Object> foods(@RequestParam(value = "id") Integer id) {


        Map<String, Object> map = foodService.list();
        return map;
    }
}

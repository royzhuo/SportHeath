package com.beStrong.controller;

import com.beStrong.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author roy.zhuo
 */
@RestController
public class SportController {

    @Autowired
    private SportService sportService;

    @RequestMapping(value = "/api/sport/addSportData", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addSportData(@RequestParam(value = "id") Integer id,
                                            @RequestParam(value = "name") String nickName, @RequestParam(value = "kilo") String kilo,
                                            @RequestParam(value = "kaluli") String kaluli,
                                            @RequestParam(value = "location[]") List<String> locations) {
        Map<String, Object> map = sportService.addSportData(id, nickName, kilo, kaluli, locations);
        return map;

    }

    @RequestMapping(value = "/api/sport/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listSportData(@RequestParam(value = "id") Integer id) {
        Map<String, Object> map = sportService.list(id);
        return map;
    }

}

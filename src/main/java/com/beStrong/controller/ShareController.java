package com.beStrong.controller;

import com.beStrong.service.ShareSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author roy.zhuo
 */
@Controller
public class ShareController {
    @Autowired
    private ShareSerive shareSerive;

    @RequestMapping(value = "/api/shareMyInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> share(@RequestParam(value = "id") Integer userid,
                                     @RequestParam(value = "content") String content) {
        Map<String, Object> map = shareSerive.share(content, userid);
        return map;
    }

    @RequestMapping(value = "/api/share/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(@RequestParam(value = "id") Integer id) {
        Map<String, Object> map = shareSerive.list();
        return map;
    }

}

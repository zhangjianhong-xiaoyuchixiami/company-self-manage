package org.qydata.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.qydata.entity.User;
import org.qydata.entity.UserNotice;
import org.qydata.service.NoticeService;
import org.qydata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/23.
 */
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

    @Autowired private NoticeService noticeService;
    @Autowired private UserService userService;

    @RequestMapping(value = "/unread-notice-content")
    @ResponseBody
    public String queryUserUnReadNotice(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(username);
        Map<String,Object> map = new HashMap<>();
        map.put("userId",user.getId());
        List<UserNotice> userNoticeList = noticeService.queryUserUnReadNotice(map);
        JSONArray jsonArray = JSONArray.fromObject(userNoticeList);
        JSONArray jsonArrayCount = JSONArray.fromObject((noticeService.getCountUnReadNotice(map)));
        JSONObject getObj = new JSONObject();
        getObj.put("userNoticeList", jsonArray);
        getObj.put("userNoticeCount", jsonArrayCount);
        return getObj.toString();
    }


}

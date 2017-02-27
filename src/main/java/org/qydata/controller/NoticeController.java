package org.qydata.controller;

import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.qydata.entity.User;
import org.qydata.entity.UserNotice;
import org.qydata.service.NoticeService;
import org.qydata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * Created by jonhn on 2017/2/23.
 */
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

    @Autowired private NoticeService noticeService;
    @Autowired private UserService userService;


    /**
     * 获取用户未读消息数
     * @return
     */
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

    /**
     * 根据Id查询系统消息
     * @param id
     * @return
     */
    @RequestMapping(value = "/notice-content")
    @ResponseBody
    public String queryUserNoticeById(Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        UserNotice userNotice = noticeService.queryUserNoticeById(map);
        JSONObject jsonObject = JSONObject.fromObject(userNotice);
        return jsonObject.toString();
    }

    /**
     * 设置消息为已读状态
     * @param id
     * @return
     */
    @RequestMapping(value = "/update-active")
    @ResponseBody
    public String updateActive(Integer id){
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        Integer isActive = 1;
        if (noticeService.updateActive(id,isActive)){
            map.put("successMessage","修改成功");
        }
        return gson.toJson(map);
    }

    /**
     * 查询系统消息
     * @return
     */
    @RequestMapping(value = "/user-notice")
    public String userNotice(Model model,String beginDate, String endDate, String [] reasonId,String title ){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(username);
        Map<String,Object> map = new HashMap<>();
        map.put("userId",user.getId());
        map.put("title",title);
        if (beginDate != null && beginDate != "" ) {
            map.put("beginDate", beginDate+" "+"00:00:00");
        }
        if(endDate != null && endDate != ""){
            map.put("endDate", endDate+" "+"23:59:59");
        }
        List<Integer> isActiveList = new ArrayList<>();
        if (reasonId != null && reasonId.length >0) {
            for(int i=0;i<reasonId.length;i++){
                isActiveList.add(parseInt(reasonId[i]));
            }
        }else {
            isActiveList.add(0);
            isActiveList.add(1);
        }
        map.put("isActiveList",isActiveList);
        List<UserNotice> userNoticeList = noticeService.queryUserNotice(map);
        model.addAttribute("userNoticeList",userNoticeList);
        model.addAttribute("reasonIdArray",reasonId);
        model.addAttribute("beginDate",beginDate);
        model.addAttribute("endDate",endDate);
        model.addAttribute("title",title);
        return "/notice/usernotice";
    }

    /**
     * 删除公告
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete-notice")
    @ResponseBody
    public String deleteUserNotice(Integer id){
        Gson gson = new Gson();
        Integer isActive = 2;
        Map<String,Object> map = new HashMap<>();
        if (noticeService.updateActive(id,isActive)){
            map.put("successMessage","修改成功");
        }
        return gson.toJson(map);
    }

}

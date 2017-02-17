package org.qydata.controller;

import org.qydata.service.UserService;
import org.qydata.tools.Md5Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jonhn on 2017/2/15.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired private UserService userService;

    /**
     * 用户注册
     * @param sign_up_username 用户名
     * @param sign_up_email 邮箱
     * @param sign_up_password 密码
     * @param sign_up_rpPassword 重复密码
     * @return
     */
    @RequestMapping(value = "/register")
    public String Register(String sign_up_username,String sign_up_email,String sign_up_password,String sign_up_rpPassword){
        String md5Password = Md5Tools.md5(sign_up_password);
        Boolean flag = userService.register(sign_up_username,md5Password,sign_up_email);
        if (flag){

            return "redirect:/login";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/action")
    public String Register(String code){
        userService.active(code);
        return "redirect:/login";
    }


}

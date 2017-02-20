package org.qydata.controller;

import org.qydata.service.UserService;
import org.qydata.tools.Md5Tools;
import org.qydata.tools.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String register(String sign_up_username,String sign_up_email,String sign_up_password,String sign_up_rpPassword,RedirectAttributes model){
        if(RegexUtil.isNull(sign_up_username)){
            model.addFlashAttribute("usernameMessage","请输入用户名");
            return "redirect:view/signup";
        }
        if(RegexUtil.isNull(sign_up_email)){
            model.addFlashAttribute("emailMessage","请输入邮箱");
            return "redirect:view/signup";
        }
        if(RegexUtil.isNull(sign_up_password)){
            model.addFlashAttribute("passwordMessage","请输入密码");
            return "redirect:view/signup";
        }
        if(!RegexUtil.isPwd(sign_up_password)){
            model.addFlashAttribute("passwordMessage","密码格式输入不正确，请重新输入");
            return "redirect:view/signup";
        }
        if(RegexUtil.isNull(sign_up_rpPassword)){
            model.addFlashAttribute("rpPasswordMessage","请再次输入密码");
            return "redirect:view/signup";
        }
        if(sign_up_password.equals(sign_up_rpPassword)){
            model.addFlashAttribute("rpPasswordMessage","两次密码输入不一致");
            return "redirect:view/signup";
        }
        String md5Password = Md5Tools.md5(sign_up_password.trim());
        Boolean flag = userService.register(sign_up_username.trim(),md5Password,sign_up_email.trim());
        if (flag){
            model.addFlashAttribute("sendMessage","激活链接已发送到您的邮箱，请点击链接完成注册");
            return "redirect:view/signup";
        }
        model.addFlashAttribute("sendMessage","注册失败，请检查你的操作");
        return "redirect:view/signup";
    }

    /**
     * 用户激活链接
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = "/action")
    public String action(String code,RedirectAttributes model){
        Boolean flag = userService.active(code);
        if (flag){
            model.addFlashAttribute("activeMessage","激活成功，欢迎登录使用");
            return "redirect:view/login";
        }
        userService.deleteUserByCode(code);
        model.addFlashAttribute("sendMessage","激活失败，请重新注册");
        return "redirect:view/signup";
    }

    /**
     * 用户找回密码
     * @param forgot_email
     * @param forgot_password
     * @return
     */
    @RequestMapping(value = "/forgot")
    public String forgot(String forgot_email,String forgot_password,RedirectAttributes model){
        if(RegexUtil.isNull(forgot_email)){
            model.addFlashAttribute("emailMessage","请输入邮箱");
            return "redirect:view/forgot";
        }
        if(RegexUtil.isNull(forgot_password)){
            model.addFlashAttribute("passwordMessage","请输入密码");
            return "redirect:view/forgot";
        }
        if(!RegexUtil.isPwd(forgot_password)){
            model.addFlashAttribute("passwordMessage","密码格式输入不正确，请重新输入");
            return "redirect:view/forgot";
        }
        String md5Password = Md5Tools.md5(forgot_password.trim());
        Boolean flag = userService.forgot(forgot_email.trim(),md5Password);
        if (flag){
            model.addFlashAttribute("sendMessage","修改链接已发送到您的邮箱，请点击链接完成修改");
            return "redirect:view/forgot";
        }
        model.addFlashAttribute("sendMessage","邮件发送失败，请重新操作");
        return "redirect:view/forgot";
    }

    /**
     * 用户找回密码
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/update-password")
    public String updatePassword(String email,String password,RedirectAttributes model){
        Boolean flag = userService.updatePassword(email,password);
        if (flag){
            model.addFlashAttribute("sendMessage","修改成功，欢迎登录使用");
            return "redirect:view/login";
        }
        model.addFlashAttribute("sendMessage","激活失败，请检查你的操作");
        return "redirect:view/forgot";
    }

}

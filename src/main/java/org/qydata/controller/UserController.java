package org.qydata.controller;

import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.qydata.service.UserService;
import org.qydata.tools.Md5Tools;
import org.qydata.tools.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/15.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(value = "/sign-up")
    public String signUp(){
        return "/view/signup";
    }

    @RequestMapping(value = "/forgot-url")
    public String forgotUrl(){
        return "/view/forgot";
    }

    /**
     * 用户注册
     * @param sign_up_email 邮箱
     * @param sign_up_password 密码
     * @param sign_up_rpPassword 重复密码
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(String sign_up_email,String sign_up_password,String sign_up_rpPassword,RedirectAttributes model){

        if(RegexUtil.isNull(sign_up_email)){
            model.addFlashAttribute("msg","请输入邮箱");
            return "redirect:/user/sign-up";
        }
        if(userService.queryUserByUsername(sign_up_email.trim()) != null){
            model.addFlashAttribute("msg","该邮箱已被注册，请重新输入");
            return "redirect:/user/sign-up";
        }
        if(RegexUtil.isNull(sign_up_password)){
            model.addFlashAttribute("msg","请输入密码");
            return "redirect:/user/sign-up";
        }
        if(!RegexUtil.isPwd(sign_up_password)){
            model.addFlashAttribute("msg","密码格式输入不正确，请重新输入");
            return "redirect:/user/sign-up";
        }
        if(RegexUtil.isNull(sign_up_rpPassword)){
            model.addFlashAttribute("msg","请再次输入密码");
            return "redirect:/user/sign-up";
        }
        if(!sign_up_password.trim().equals(sign_up_rpPassword.trim())){
            model.addFlashAttribute("msg","两次密码输入不一致");
            return "redirect:/user/sign-up";
        }
        String md5Password = Md5Tools.md5(sign_up_password.trim());
        Boolean flag = userService.register(md5Password,sign_up_email.trim());
        if (flag){
            model.addFlashAttribute("successMsg","激活链接已发送到您的邮箱");
            return "redirect:/user/sign-up";
        }
        model.addFlashAttribute("msg","注册失败，请检查你的操作");
        return "redirect:/user/sign-up";
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
            model.addFlashAttribute("successMsg","激活成功，欢迎登录使用");
            return "redirect:/login";
        }
        userService.deleteUserByCode(code);
        model.addFlashAttribute("msg","激活失败，请重新注册");
        return "redirect:/user/sign-up";
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
            model.addFlashAttribute("msg","请输入邮箱");
            return "redirect:/user/forgot-url";
        }
        if(RegexUtil.isNull(forgot_password)){
            model.addFlashAttribute("msg","请输入新密码");
            return "redirect:/user/forgot-url";
        }
        if(!RegexUtil.isPwd(forgot_password)){
            model.addFlashAttribute("msg","密码格式输入不正确，请重新输入");
            return "redirect:/user/forgot-url";
        }
        String md5Password = Md5Tools.md5(forgot_password.trim());
        Boolean flag = userService.forgot(forgot_email.trim(),md5Password);
        if (flag){
            model.addFlashAttribute("successMsg","修改链接已发送到您的邮箱");
            return "redirect:/user/forgot-url";
        }
        model.addFlashAttribute("msg","邮件发送失败，请重新操作");
        return "redirect:/user/forgot-url";
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
            model.addFlashAttribute("successMsg","修改成功，欢迎登录使用");
            return "redirect:/login";
        }
        model.addFlashAttribute("msg","激活失败，请检查你的操作");
        return "redirect:/user/forgot-url";
    }


    /**
     * 修改登录密码
     * @param password
     * @param rpPassword
     * @return
     */
    @RequestMapping(value = "/update-login-password")
    @ResponseBody
    public String updateLoginPassword(String password,String rpPassword){
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        if(RegexUtil.isNull(password)){
            map.put("passwordMessage","请输入新密码");
            return gson.toJson(map);
        }
        if(!RegexUtil.isPwd(password)){
            map.put("passwordMessage","密码格式输入不正确，请重新输入");
            return gson.toJson(map);
        }
        if(RegexUtil.isNull(rpPassword)){
            map.put("rpPasswordMessage","请再次输入新密码");
            return gson.toJson(map);
        }
        if(!password.trim().equals(rpPassword.trim())){
            map.put("rpPasswordMessage","两次密码输入不一致");
            return gson.toJson(map);
        }
        String email = (String) SecurityUtils.getSubject().getPrincipal();
        if (userService.updateLoginPassword(email,Md5Tools.md5(password.trim()))){
            map.put("successMessage","恭喜你，修改成功！");
        }else {
            map.put("errorMessage","操作失败，请检查你的输入");
        }
        return gson.toJson(map);
    }

}

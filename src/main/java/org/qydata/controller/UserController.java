package org.qydata.controller;

import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.qydata.entity.User;
import org.qydata.service.UserService;
import org.qydata.tools.Md5Tools;
import org.qydata.tools.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by jonhn on 2017/2/15.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired private UserService userService;

    /**
     * 注册页面
     * @return
     */
    @RequestMapping(value = "/sign-up")
    public String signUp(){
        return "/view/signup";
    }

    /**
     * 忘记密码页面
     * @return
     */
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
    @ResponseBody
    public String register(String sign_up_email, String sign_up_password, String sign_up_rpPassword,
                           String sign_up_companyName, String sign_up_busPerson, String sign_up_busTel,
                           String sign_up_techPerson, String sign_up_techTel, String sign_up_product,
                           String sign_up_content, HttpServletRequest request)
    {
        String [] sign_up_companyUrl = request.getParameterValues("sign_up_companyUrl[]");
        String [] sign_up_officialIp = request.getParameterValues("sign_up_officialIp[]");
        String [] sign_up_testIp = request.getParameterValues("sign_up_testIp[]");
        Map<String,Object> map = new HashMap<>();
        Gson gson = new Gson();
        if(RegexUtil.isNull(sign_up_email)){
            map.put("sign_up_email","请输入邮箱");
            return gson.toJson(map);
        }
        if(userService.queryUserByUsername(sign_up_email.trim()) != null){
            map.put("sign_up_email","该邮箱已被注册，请重新输入");
            return gson.toJson(map);
        }
        if(RegexUtil.isNull(sign_up_password)){
            map.put("sign_up_password","请输入密码");
            return gson.toJson(map);
        }
        if(!RegexUtil.isPwd(sign_up_password)){
            map.put("sign_up_password","密码格式输入不正确，请重新输入");
            return gson.toJson(map);
        }
        if(RegexUtil.isNull(sign_up_rpPassword)){
            map.put("sign_up_rpPassword","请再次输入密码");
            return gson.toJson(map);
        }
        if(!sign_up_password.trim().equals(sign_up_rpPassword.trim())){
            map.put("sign_up_rpPassword","两次密码输入不一致");
            return gson.toJson(map);
        }
        if(RegexUtil.isNull(sign_up_companyName)){
            map.put("sign_up_companyName","请输入公司名称");
            return gson.toJson(map);
        }

        if(RegexUtil.isNull(sign_up_busPerson)){
            map.put("sign_up_busPerson","请输入商务联系人");
            return gson.toJson(map);
        }
        if(RegexUtil.isNull(sign_up_busTel)){
            map.put("sign_up_busTel","请输入联系方式");
            return gson.toJson(map);
        }
        if(!RegexUtil.isTel(sign_up_busTel)){
            map.put("sign_up_busTel","电话格式输入不正确");
            return gson.toJson(map);
        }
        String md5Password = Md5Tools.md5(sign_up_password.trim());
        Boolean flag = userService.register(md5Password,sign_up_email.trim(),sign_up_companyName.trim(),
                sign_up_busPerson.trim(),sign_up_busTel.trim(),sign_up_techPerson.trim(),
                sign_up_techTel.trim(),sign_up_product.trim(),sign_up_content.trim(),sign_up_companyUrl,
                sign_up_officialIp,sign_up_testIp
        );
        if (flag){
            map.put("successMsg","激活链接已发送到您的邮箱");
            return gson.toJson(map);
        }
        map.put("msg","注册失败，请检查你的操作");
        return gson.toJson(map);
    }

    /**
     * 用户激活链接
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = "/action")
    public String action(String code,RedirectAttributes model){
        Map<String,Object> map = userService.active(code);
        Set<Map.Entry<String,Object>> set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            Map.Entry<String,Object> me = (Map.Entry<String, Object>) it.next();
            if (me.getKey().equals("success")){
                model.addFlashAttribute("successMsg",me.getValue());
                return "redirect:/login";
            }
            if (me.getKey().equals("outCancel")){
                model.addFlashAttribute("msg",me.getValue());
                return "redirect:/user/sign-up";
            }
            if (me.getKey().equals("outDate")){
                model.addFlashAttribute("successMsg",me.getValue());
                return "redirect:/user/sign-up";
            }
            if (me.getKey().equals("isActive")){
                model.addFlashAttribute("successMsg",me.getValue());
                return "redirect:/login";
            }
            if (me.getKey().equals("noRegister")){
                model.addFlashAttribute("successMsg",me.getValue());
                return "redirect:/user/sign-up";
            }
        }
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
     * 修改登录密码时验证旧密码
     * @param oldPassword
     */
    @RequestMapping(value = "/validate-old-password")
    @ResponseBody
    public String validateOldPassword(String oldPassword){
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        String email = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(email);
        if (user.getPassword().equals(Md5Tools.md5(oldPassword.trim()))){
            map.put("success","true");
            return gson.toJson(map);
        }
        map.put("fail","false");
        return gson.toJson(map);
    }

    /**
     * 修改登录密码
     * @param oldPassword
     * @param newPassword
     * @param newRpPassword
     * @return
     */
    @RequestMapping(value = "/update-login-password")
    @ResponseBody
    public String updateLoginPassword(String oldPassword,String newPassword,String newRpPassword){
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        String email = (String) SecurityUtils.getSubject().getPrincipal();
        if(RegexUtil.isNull(oldPassword)){
            map.put("oldPasswordMessageNull","oldPasswordMessageNull");
            return gson.toJson(map);
        }
        if (!userService.queryUserByUsername(email).getPassword().equals(Md5Tools.md5(oldPassword.trim()))){
            map.put("oldPasswordMessageExist","oldPasswordMessageExist");
            return gson.toJson(map);
        }
        if(RegexUtil.isNull(newPassword)){
            map.put("newPasswordMessageNull","newPasswordMessageNull");
            return gson.toJson(map);
        }
        if(!(newPassword.length() >= 6 && newPassword.length() <= 12)){
            map.put("newPasswordMessageFormat","newPasswordMessageFormat");
            return gson.toJson(map);
        }
        if(RegexUtil.isNull(newRpPassword)){
            map.put("rpPasswordMessageNull","rpPasswordMessageNull");
            return gson.toJson(map);
        }
        if(!(newPassword.trim().equals(newRpPassword.trim()))){
            map.put("rpPasswordMessageEqual","rpPasswordMessageEqual");
            return gson.toJson(map);
        }

        if (userService.updateLoginPassword(email,Md5Tools.md5(newPassword.trim()))){
            map.put("successMessage","successMessage");
            return gson.toJson(map);
        }
        map.put("errorMessage","errorMessage");
        return gson.toJson(map);
    }

}

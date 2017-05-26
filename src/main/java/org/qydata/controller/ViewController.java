package org.qydata.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.qydata.service.UserService;
import org.qydata.tools.Md5Tools;
import org.qydata.tools.definexception.UserCustomerNoBound;
import org.qydata.tools.definexception.UserCustomerStatusNoPass;
import org.qydata.tools.definexception.UserStatusNoPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jonhn on 2017/2/15.
 */
@Controller
public class ViewController {

    private final Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("/login")
    public String loginUrl() {
        return "/view/login";
    }

    //登录提交
    @RequestMapping("/view/login-action")
    public String login(String login_username_email, String login_password, RedirectAttributes model, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        String md5Password = Md5Tools.md5(login_password.trim());
        UsernamePasswordToken token = new UsernamePasswordToken(login_username_email.trim(), md5Password);
        try {
            String url = null;
            Session session = subject.getSession(false);
            if (session != null && WebUtils.getSavedRequest(request) != null){
                url = WebUtils.getSavedRequest(request).getRequestUrl();
            }
            subject.login(token);
            if (url != null){
                return "redirect:"+url;
            }
            return "redirect:/";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            model.addFlashAttribute("msg", "该用户名不存在！");
            return "redirect:/login";
        }catch (IncorrectCredentialsException e1){
            e1.printStackTrace();
            model.addFlashAttribute("msg", "密码错误！");
            return "redirect:/login";
        }catch (UserStatusNoPass e2){
            e2.printStackTrace();
            model.addFlashAttribute("msg", "该账号已被禁用！");
            return "redirect:/login";
        }catch (UserCustomerNoBound e3){
            e3.printStackTrace();
            model.addFlashAttribute("msg", "该账号未绑定产品账号，请联系管理员！");
            return "redirect:/login";
        }catch (UserCustomerStatusNoPass e4){
            e4.printStackTrace();
            model.addFlashAttribute("msg", "该账号未通过授权！");
            return "redirect:/login";
        }catch (Exception e5){
            e5.printStackTrace();
            model.addFlashAttribute("msg", "服务异常，请稍后重试！");
            return "redirect:/login";
        }
    }

    //登录成功
    @RequestMapping("/")
    public String successUrl() {
        return "/view/index";
    }

    //未授权
    @RequestMapping("/view/unauthurl")
    public String unauthUrl() {
        return "/view/role";
    }

    //注销
    @RequestMapping(value = "/view/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}

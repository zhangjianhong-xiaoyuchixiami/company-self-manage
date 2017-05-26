package org.qydata.controller;

import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.qydata.entity.Customer;
import org.qydata.entity.CustomerIp;
import org.qydata.entity.User;
import org.qydata.service.CustomerService;
import org.qydata.service.UserService;
import org.qydata.tools.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/17.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired private CustomerService customerService;
    @Autowired private UserService userService;

    @RequestMapping("/layout")
    public String layout(){
        return "/test/layout";
    }

    /**
     *验证账号
     * @param authId
     * @param response
     */
    @RequestMapping(value = "/find-customer-by-authId")
    public void findCustomerByAuthId(String authId,HttpServletResponse response){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if(customerService.findCustomerByAuthId(authId) != null){
                out.print("yes");
            }else{
                out.print("no");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证密码
     * @param authId
     * @param authPass
     * @param response
     */
    @RequestMapping(value = "/validate-password-customer-by-authId")
    public void validatePasswordByAuthId(String authId,String authPass,HttpServletResponse response){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if(customerService.findCustomerByAuthIdAndAuthPass(authId,authPass) != null){
                out.print("yes");
            }else{
                out.print("no");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加用户和账号映射
     * @param authId
     * @param authPass
     * @return
     */
    @RequestMapping(value = "/bound-user-customer")
    @ResponseBody
    public String boundUserCustomer(String authId,String authPass){
        Gson gson = new Gson();
        Map<String,Object> mapTip = new HashMap<>();
        if(RegexUtil.isNull(authId)){
            mapTip.put("authIdMessage","请输入账号");
            return gson.toJson(mapTip);
        }
        if(RegexUtil.isNull(authPass)){
            mapTip.put("authPassMessage","请输入密码");
            return gson.toJson(mapTip);
        }
        Customer customer = customerService.findCustomerByAuthIdAndAuthPass(authId,authPass);
        String email = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(email);
        Map<String,Object> map = new HashMap<>();
        map.put("userId",user.getId());
        map.put("customerId",customer.getId());
        if (customerService.addUserCustomer(map)){
            mapTip.put("successMessage","恭喜你，操作成功！");
        }else {
            mapTip.put("errorMessage","操作失败，请检查你的输入");
        }
        return gson.toJson(mapTip);
    }

    /**
     * 查看账号信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/account-message")
    public String accountMessage(Model model,String content){
        String email = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(email);
        Map<String,Object> map = new HashMap<>();
        map.put("userId",user.getId());
        map.put("content",content);
        List<Customer> customerList = customerService.queryCustomerByAuthId(map);
        int floor = 0;
        if (customerList != null && customerList.size() >0){
            for (int i=0; i<customerList.size(); i++){
                Customer customer = customerList.get(i);
                floor = floor+customer.getFloor();
            }
        }
        model.addAttribute("floor",floor);
        model.addAttribute("customerList",customerList);
        model.addAttribute("content",content);
        model.addAttribute("companyName",customerService.findCompanyNameByUserId(user.getId()));
        return "/account/accountmessage";
    }

    /**
     * 给用户绑定账号
     * @param authId
     * @return
     */
    @RequestMapping("/bound-user-customer-url")
    @ResponseBody
    public String boundUserCustomerUrl(String authId){
        //正式账号
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userService.queryUserByUsername((String) SecurityUtils.getSubject().getPrincipal()).getId());
        map.put("customerId",customerService.findCustomerByAuthId(authId).getId());
        //测试账号
        Map<String,Object> mapTest = new HashMap<>();
        mapTest.put("userId",userService.queryUserByUsername((String) SecurityUtils.getSubject().getPrincipal()).getId());
        mapTest.put("customerId",customerService.findCustomerByAuthId(authId+"_test").getId());
        if (customerService.addUserCustomer(map) && customerService.addUserCustomer(mapTest)){
            return "ok:200";
        }
        return "fail:500";
    }

    /**
     * 根据账号Id查询Ip
     * @param customerId
     * @return
     */
    @RequestMapping("/find-ip")
    @ResponseBody
    public String queryCustomerIpById(Integer customerId){
        Gson gson = new Gson();
        List<CustomerIp> customerIpList = customerService.queryCustomerIpById(customerId);
        return gson.toJson(customerIpList);
    }

}

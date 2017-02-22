package org.qydata.controller;

import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.qydata.dst.CustomerApiConsume;
import org.qydata.entity.Customer;
import org.qydata.entity.CustomerBalanceLog;
import org.qydata.entity.User;
import org.qydata.service.CustomerService;
import org.qydata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by jonhn on 2017/2/17.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired private CustomerService customerService;
    @Autowired private UserService userService;

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
        Customer customer = customerService.findCustomerByAuthIdAndAuthPass(authId,authPass);
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(username);
        Map<String,Object> map = new HashMap<>();
        map.put("userId",user.getId());
        map.put("customerId",customer.getId());
        Map<String,Object> mapTip = new HashMap<>();
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
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(username);
        Map<String,Object> map = new HashMap<>();
        map.put("userId",user.getId());
        map.put("content",content);
        List<Customer> customerList = customerService.queryCustomerByAuthId(map);
        model.addAttribute("customerList",customerList);
        model.addAttribute("content",content);
        return "/account/accountmessage";
    }

    /**
     * 指定账号充值记录
     * @param customerId
     * @param beginDate
     * @param endDate
     * @param reasonId
     * @param model
     * @return
     */
    @RequestMapping(value = "/account-charge")
    public String findAllCustomerRechargeLogByCustomerId(Integer customerId, String beginDate, String endDate, String [] reasonId, Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("customerId", customerId);
        List<Integer> reasonIdList = new ArrayList<>();
        if (reasonId != null && reasonId.length >0) {
            for(int i=0;i<reasonId.length;i++){
                reasonIdList.add(parseInt(reasonId[i]));
            }
        }else {
            reasonIdList.add(1);
            reasonIdList.add(2);
            reasonIdList.add(3);
        }
        map.put("reasonIdList", reasonIdList);
        if (beginDate != null && beginDate != "" ) {
            map.put("beginDate", beginDate+" "+"00:00:00");
        }
        if(endDate != null && endDate != ""){
            map.put("endDate", endDate+" "+"23:59:59");
        }
        List<CustomerBalanceLog> customerBalanceLogList = customerService.queryCustomerRechargeRecordByCustomerId(map);
        model.addAttribute("customerBalanceLogList",customerBalanceLogList);
        model.addAttribute("reasonIdArray",reasonId);
        model.addAttribute("beginDate",beginDate);
        model.addAttribute("endDate",endDate);
        return "/account/accountcharge";

    }

    /**
     * 指定账号消费记录
     * @return
     */
    @RequestMapping("/account-consume")
    public String findAllApiConsumeRecordByCustomerId(Integer customerId,Model model){
        Map<String,Object> map = new HashMap();
        map.put("customerId",customerId);
        List<CustomerApiConsume> customerApiConsumeList = customerService.queryCustomerConsumeRecordByCustomerId(map);
        model.addAttribute("customerApiConsumeList", customerApiConsumeList);
        model.addAttribute("customerId", customerId);
        return "/account/accountconsume";
    }

    /**
     * 指定账号消费明细记录
     * @return
     */
    @RequestMapping("/account-consume/detail")
    public String findAllApiConsumeDetailRecordByCustomerId(Integer customerId,Integer apiTypeId,String beginDate, String endDate, String [] reasonId,Model model){
        Map<String,Object> map = new HashMap();
        map.put("customerId",customerId);
        map.put("apiTypeId",apiTypeId);
        List<Integer> reasonIdList = new ArrayList<>();
        if (reasonId != null && reasonId.length >0) {
            for(int i=0;i<reasonId.length;i++){
                reasonIdList.add(parseInt(reasonId[i]));
            }
        }else {
            reasonIdList.add(-1);
            reasonIdList.add(-2);
        }
        map.put("reasonIdList", reasonIdList);
        if (beginDate != null && beginDate != "" ) {
            map.put("beginDate", beginDate+" "+"00:00:00");
        }
        if(endDate != null && endDate != ""){
            map.put("endDate", endDate+" "+"23:59:59");
        }
        List<CustomerBalanceLog> customerBalanceLogList = customerService.queryCustomerConsumeDetailRecordByCustomerId(map);
        model.addAttribute("customerBalanceLogList", customerBalanceLogList);
        model.addAttribute("reasonIdArray",reasonId);
        model.addAttribute("beginDate",beginDate);
        model.addAttribute("endDate",endDate);
        return "/account/accountconsumedetail";
    }



}

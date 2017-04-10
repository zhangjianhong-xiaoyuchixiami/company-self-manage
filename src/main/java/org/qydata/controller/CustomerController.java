package org.qydata.controller;

import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.qydata.dst.CustomerApiConsume;
import org.qydata.entity.Customer;
import org.qydata.entity.CustomerBalanceLog;
import org.qydata.entity.User;
import org.qydata.entity.WeekMonthAmount;
import org.qydata.service.CustomerService;
import org.qydata.service.UserService;
import org.qydata.tools.CalendarTools;
import org.qydata.tools.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public String findAllCustomerRechargeLogByCustomerId(Integer customerId, String authId,String beginDate, String endDate, String [] reasonId, Model model){
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
        model.addAttribute("authId",authId);
        model.addAttribute("customerId",customerId);
        return "/account/accountcharge";

    }

    /**
     * 指定账号消费记录
     * @return
     */
    @RequestMapping("/account-consume")
    public String findAllApiConsumeRecordByCustomerId(Integer customerId,String authId,Model model){
        Map<String,Object> map = new HashMap();
        map.put("customerId",customerId);
        List<CustomerApiConsume> customerApiConsumeList = customerService.queryCustomerConsumeRecordByCustomerId(map);
        model.addAttribute("customerApiConsumeList", customerApiConsumeList);
        model.addAttribute("customerId", customerId);
        model.addAttribute("authId", authId);
        return "/account/accountconsume";
    }

    /**
     * 指定账号消费明细记录
     * @return
     */
    @RequestMapping("/account-consume/detail")
    public String findAllApiConsumeDetailRecordByCustomerId(Integer customerId,Integer apiTypeId,String apiTypeName,String mobileOperatorName,String beginDate, String endDate, String [] reasonId,Model model){
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
        model.addAttribute("apiTypeId",apiTypeId);
        model.addAttribute("customerId",customerId);
        model.addAttribute("apiTypeName",apiTypeName);
        model.addAttribute("mobileOperatorName",mobileOperatorName);
        return "/account/accountconsumedetail";
    }

    /**
     * 月历史记录
     * @param customerId
     * @param years
     * @param months
     * @param typeId
     * @param authId
     * @param model
     * @return
     */
    @RequestMapping("/month-record")
    public String findMonthRecordByCustomerId(Integer customerId,Integer years,Integer months, Integer typeId,String authId,Model model){
        Map<String,Object> map = new HashedMap();
        map.put("customerId",customerId);
        map.put("weekMonthTypeId",2);
        List<Integer> tableIdList = new ArrayList();
        tableIdList.add(typeId);
        map.put("tableIdList",tableIdList);
        List<Integer> yearList = customerService.queryCustomerYearsByCustomerId(map);
        List<Integer> monthList = null;
        if(years != null){
            map.put("years",years);
            monthList = customerService.queryCustomerMonthsByCustomerId(map);
        }
        if(months != null){
            map.put("months",months);
        }
        List<WeekMonthAmount> weekMonthAmountList = customerService.queryCustomerWeekMonthRecordByCustomerId(map);
        model.addAttribute("weekMonthAmountList",weekMonthAmountList);
        model.addAttribute("yearList",yearList);
        model.addAttribute("monthList",monthList);
        model.addAttribute("authId",authId);
        model.addAttribute("customerId",customerId);
        model.addAttribute("typeId",typeId);
        model.addAttribute("years",years);
        model.addAttribute("months",months);
        return "/account/accountmonthrecord";
    }

    /**
     * 月记录数月级联菜单
     * @param request
     * @return
     */
    @RequestMapping("/month-up-link")
    @ResponseBody
    public String findCompanyCustomerMonthUplinkMonthsByCustomerId(Integer customerId,Integer years,Integer typeId,HttpServletRequest request){
        Map<String,Object> map = new HashedMap();
        map.put("customerId",customerId);
        map.put("weekMonthTypeId",2);
        map.put("years",years);
        List<Integer> tableIdList = new ArrayList();
        tableIdList.add(typeId);
        map.put("tableIdList",tableIdList);
        List<Integer> monthList = customerService.queryCustomerMonthsByCustomerId(map);
        JSONArray jsonArray = JSONArray.fromObject(monthList);
        return jsonArray.toString();
    }

    /**
     * 客户月账单充值消费走势图
     * @param customerId
     * @param typeId
     * @return
     */
    @RequestMapping("/months-charge-consume-toward")
    @ResponseBody
    public String monthsChargeConsumeToward(Integer customerId,Integer typeId,Integer years,Integer months){
        System.out.println(customerId);
        System.out.println(typeId);
        System.out.println(years);
        System.out.println(months);
        Map<String,Object> map = new HashedMap();
        map.put("customerId",customerId);
        map.put("tableId",typeId);
        if(years != null && months == null){
            if (years < CalendarTools.getYearMonthCount(0)){
                Integer result =  (CalendarTools.compareDate(years+"-"+12+"-"+31, null, 1)-1);
                map.put("result",result);
                System.out.println(result);
            }else {
                map.put("result",0);
            }

        }
        if(years != null && months != null){
            Integer result =  (CalendarTools.compareDate(years+"-"+months+"-"+31, null, 1)-1);
            map.put("result",result);
            System.out.println(result);
        }
        if (years == null && months == null){
            map.put("result",0);
        }
        Map<String,List> stringListMap = customerService.monthChargeConsumeToward(map);
        Set<Map.Entry<String,List>> set = stringListMap.entrySet();
        Iterator<Map.Entry<String,List>> it = set.iterator();
        List xList= null;
        List yList = null;
        while(it.hasNext()){
            Map.Entry<String,List> me = it.next();
            if(me.getKey().equals("xPort")){
                xList = (List) me.getValue();
            }if(me.getKey().equals("type") ){
                yList = (List) me.getValue();
            }
        }
        Map mapOne = new HashedMap();
        if (typeId ==1){
            mapOne.put("name","充值");
        }
        if (typeId ==2){
            mapOne.put("name","消费");
        }
        mapOne.put("data",yList);
        JSONArray jsonArray = JSONArray.fromObject(xList);
        JSONArray jsonArray1 = JSONArray.fromObject(mapOne);
        JSONObject getObj = new JSONObject();
        getObj.put("xList", jsonArray);
        getObj.put("yList", jsonArray1);
        return getObj.toString();
    }

    @RequestMapping("/bound-user-customer-url")
    @ResponseBody
    public String boundUserCustomerUrl(String authId){
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userService.queryUserByUsername((String) SecurityUtils.getSubject().getPrincipal()).getId());
        map.put("customerId",customerService.findCustomerByAuthId(authId).getId());

        Map<String,Object> mapTest = new HashMap<>();
        mapTest.put("userId",userService.queryUserByUsername((String) SecurityUtils.getSubject().getPrincipal()).getId());
        mapTest.put("customerId",customerService.findCustomerByAuthId(authId+"_test").getId());
        if (customerService.addUserCustomer(map) && customerService.addUserCustomer(mapTest)){
            return "ok:200";
        }
        return "fail:500";
    }

}

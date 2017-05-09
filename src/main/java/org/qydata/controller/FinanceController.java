package org.qydata.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.qydata.dst.CustomerApiConsume;
import org.qydata.entity.*;
import org.qydata.service.CustomerService;
import org.qydata.service.UserService;
import org.qydata.tools.CalendarTools;
import org.qydata.tools.DataTableTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by jonhn on 2017/5/8.
 */
@Controller
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;

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
    public String findAllApiConsumeRecordByCustomerId(String beginDate, String endDate, Model model){

        String email = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(email);
        List<Customer> customerList = customerService.findCustomerIdByUserId(user.getId());
        List<Integer> customerIdList = new ArrayList<>();
        if (customerList != null && customerList.size() >0){
            for (int i=0; i<customerList.size(); i++){
                Customer customer = customerList.get(i);
                customerIdList.add(customer.getId());
            }
        }
        Map<String,Object> map = new HashMap();
        map.put("customerIdList",customerIdList);
        if (beginDate != null && beginDate != "" ) {
            map.put("beginDate", beginDate+" "+"00:00:00");
            model.addAttribute("beginDate", beginDate);
        }
        if(endDate != null && endDate != ""){
            map.put("endDate", endDate+" "+"23:59:59");
            model.addAttribute("endDate", endDate);
        }
        List<CustomerApiConsume> customerApiConsumeList = customerService.queryCustomerConsumeRecordByCustomerId(map);
        model.addAttribute("customerApiConsumeList", customerApiConsumeList);
        return "/finance/accountconsume";
    }

    @RequestMapping("/account-consume/day-detail")
    public String queryCustomerApiTypeConsumeDayCount(String beginDate,String endDate,Model model){
        String email = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(email);
        List<Customer> customerList = customerService.findCustomerIdByUserId(user.getId());
        List<Integer> customerIdList = new ArrayList<>();
        if (customerList != null && customerList.size() >0){
            for (int i=0; i<customerList.size(); i++){
                Customer customer = customerList.get(i);
                customerIdList.add(customer.getId());
            }
        }
        Map<String,Object> map = new HashMap();
        map.put("customerIdList",customerIdList);
        if (beginDate != null && beginDate != "" ) {
            map.put("beginDate", beginDate+" "+"00:00:00");
            model.addAttribute("beginDate", beginDate);
        }
        if(endDate != null && endDate != ""){
            map.put("endDate", endDate+" "+"23:59:59");
            model.addAttribute("endDate", endDate);
        }
        List<CompanyApiTypeConsumeDayCount> companyApiTypeConsumeDayCountList = customerService.queryCustomerApiTypeConsumeDayCount(map);
        model.addAttribute("companyApiTypeConsumeDayCountList",companyApiTypeConsumeDayCountList);
        return "/finance/accountdayconsume";
    }




    /**
     * 指定账号消费明细记录 -- 返回视图
     * @param customerId
     * @param apiTypeId
     * @param stid
     * @param apiTypeName
     * @param mobileOperatorName
     * @param beginDate
     * @param endDate
     * @param reasonId
     * @param model
     * @return
     */
    @RequestMapping("/account-consume/detail")
    public String findAllApiConsumeDetailRecordByCustomerId(Integer customerId,Integer apiTypeId,Integer stid,String apiTypeName,String mobileOperatorName,String beginDate, String endDate, String [] reasonId,Model model){
        if (beginDate != null && beginDate != "" ) {
            model.addAttribute("beginDate",beginDate);
        }
        if(endDate != null && endDate != ""){
            model.addAttribute("endDate",endDate);
        }
        model.addAttribute("reasonIdArray",reasonId);
        model.addAttribute("apiTypeId",apiTypeId);
        model.addAttribute("customerId",customerId);
        model.addAttribute("stid",stid);
        model.addAttribute("apiTypeName",apiTypeName);
        model.addAttribute("mobileOperatorName",mobileOperatorName);
        return "/finance/accountconsumedetail";
    }

    /**
     * 指定账号消费明细记录 -- 加载数据
     * @param aaData
     * @param customerId
     * @param apiTypeId
     * @param stid
     * @param beginDate
     * @param endDate
     * @param request
     * @return
     */
    @RequestMapping("/account-consume/detail-ajax")
    @ResponseBody
    public String findAllApiConsumeDetailRecordByCustomerIdLoadData(String aaData,Integer customerId,Integer apiTypeId,Integer stid,String beginDate, String endDate,HttpServletRequest request){
        String [] reasonId = request.getParameterValues("reasonId[]");
        Map<String,Object> mapTran = new HashMap();
        Map<String,Object> mapParam = DataTableTools.traverseParam(aaData);
        Set<Map.Entry<String, Object>> setParam = mapParam.entrySet();
        Iterator<Map.Entry<String, Object>> itParam = setParam.iterator();
        String sEcho = null;
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数
        int iSortCol = 0; //第几列排序
        String sSortDir = null; //按什么排序
        while (itParam.hasNext()) {
            Map.Entry<String, Object> me = itParam.next();
            if (me.getKey().equals("sEcho")) {
                sEcho = (String) me.getValue();
            }
            if (me.getKey().equals("iDisplayStart")) {
                iDisplayStart = (int) me.getValue();
            }
            if (me.getKey().equals("iDisplayLength")) {
                iDisplayLength = (int) me.getValue();
            }
            if (me.getKey().equals("iSortCol")) {
                iSortCol = (int) me.getValue();
            }
            if (me.getKey().equals("sSortDir")) {
                sSortDir = (String) me.getValue();
            }
        }
        switch (iSortCol) {
            case 0:
                mapTran.put("amount", sSortDir);
                break;
            case 1:
                mapTran.put("createTime", sSortDir);
                break;
            default:
                break;
        }
        mapTran.put("pageSize", iDisplayStart);
        mapTran.put("lineSize", iDisplayLength);
        mapTran.put("customerId",customerId);
        mapTran.put("apiTypeId",apiTypeId);
        List<Integer> reasonIdList = new ArrayList<>();
        if (reasonId != null && reasonId.length >0) {
            for(int i=0;i<reasonId.length;i++){
                reasonIdList.add(parseInt(reasonId[i]));
            }
        }else {
            reasonIdList.add(-1);
            reasonIdList.add(-2);
            reasonIdList.add(-3);
        }
        mapTran.put("reasonIdList", reasonIdList);
        if (stid != null) {
            mapTran.put("stid", stid);
        }
        if (beginDate != null && beginDate != "" ) {
            mapTran.put("beginDate", beginDate+" "+"00:00:00");
        }
        if(endDate != null && endDate != ""){
            mapTran.put("endDate", endDate+" "+"23:59:59");
        }
        Map<String, Object> map = customerService.queryCustomerConsumeDetailRecordByCustomerId(mapTran);
        Set<Map.Entry<String, Object>> set = map.entrySet();
        Iterator<Map.Entry<String, Object>> it = set.iterator();
        List<CustomerBalanceLog> customerBalanceLogList = null;
        int count = 0;
        while (it.hasNext()) {
            Map.Entry<String, Object> me = it.next();
            if (me.getKey().equals("queryCustomerConsumeDetailRecordByCustomerId")) {
                customerBalanceLogList = (List<CustomerBalanceLog>) me.getValue();
            }
            if (me.getKey().equals("getAllCountCustomerConsumeDetailRecordByCustomerId")) {
                count = (int) me.getValue();
            }
        }
        JSONArray jsonArray = JSONArray.fromObject(customerBalanceLogList);
        JSONObject getObj = new JSONObject();
        getObj.put("sEcho", sEcho);// 不知道这个值有什么用,有知道的请告知一下
        getObj.put("iTotalRecords", count);//实际的行数
        getObj.put("iTotalDisplayRecords", count);//显示的行数,这个要和上面写的一样
        getObj.put("aaData", jsonArray);//要以JSON格式返回
        return getObj.toString();
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


}

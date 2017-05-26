package org.qydata.controller;

import org.apache.shiro.SecurityUtils;
import org.qydata.dst.CustomerApiConsume;
import org.qydata.entity.CompanyApiTypeConsumeDayCount;
import org.qydata.entity.Customer;
import org.qydata.entity.CustomerConsumeExcel;
import org.qydata.entity.User;
import org.qydata.service.CustomerService;
import org.qydata.service.UserService;
import org.qydata.tools.DownLoadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            List<CustomerConsumeExcel> customerConsumeExcelList = customerService.queryCustomerConsumeExcelConsuTimeByCustomerId(customerList.get(0).getId());
            model.addAttribute("customerApiConsumeList", customerApiConsumeList);
            model.addAttribute("companyName",customerService.findCompanyNameByUserId(user.getId()));
            model.addAttribute("download",customerConsumeExcelList);
            return "/finance/accountconsume";
        }
        return "/finance/accountconsume";
    }

    /**
     * 指定账号按天消费统计
     * @param beginDate
     * @param endDate
     * @param model
     * @return
     */
    @RequestMapping("/account-consume/day-detail")
    public String queryCustomerApiTypeConsumeDayCount(Integer apiTypeId,Integer stid,String apiTypeName, String stidName, String beginDate,String endDate,Model model){
        String email = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(email);
        List<Customer> customerList = customerService.findCustomerIdByUserId(user.getId());
        List<Integer> customerIdList = new ArrayList<>();
        if (customerList != null && customerList.size() >0){
            for (int i=0; i<customerList.size(); i++){
                Customer customer = customerList.get(i);
                customerIdList.add(customer.getId());
            }
            Map<String,Object> map = new HashMap();
            map.put("customerIdList",customerIdList);
            if (apiTypeId != null) {
                map.put("apiTypeId",apiTypeId);
            }
            if (stid != null) {
                map.put("stid",stid);
            }
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
            model.addAttribute("apiTypeName",apiTypeName);
            model.addAttribute("stidName",stidName);
            return "/finance/accountdayconsume";
        }
        return "/finance/accountdayconsume";
    }

    /**
     * 下载消费账单Excel
     * @return
     */
    @RequestMapping("/download-consume-check")
    public ResponseEntity downloadConsumeCheck(String consuTime) throws IOException {
        String email = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(email);
        List<Customer> customerList = customerService.findCustomerIdByUserId(user.getId());
        if (customerList != null && customerList.size() > 0){
            Map<String,Object> map = new HashMap<>();
            map.put("customerId",customerList.get(0).getId());
            map.put("consuTime",consuTime);
            CustomerConsumeExcel customerConsumeExcel = customerService.queryCustomerConsumeExcelByCustomerId(map);
            String companyName = customerService.queryCompanyNameByCustomerId(map);
            if (customerConsumeExcel != null && customerConsumeExcel.getExcelCode() != null){
                return DownLoadFile.downloadFile(customerConsumeExcel.getExcelCode(),companyName+consuTime);
            }
            return null;
        }
        return null;
    }


}

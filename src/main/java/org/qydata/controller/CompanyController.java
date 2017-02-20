package org.qydata.controller;

import org.apache.shiro.SecurityUtils;
import org.qydata.entity.CompanyApi;
import org.qydata.service.CompanyService;
import org.qydata.service.CustomerService;
import org.qydata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/20.
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired private CompanyService companyService;
    @Autowired private UserService userService;
    @Autowired private CustomerService customerService;

    @RequestMapping(value = "/find-company-product-by-company-id")
    public String findCompanyProductByCompanyId(Model model){
        Integer companyId = customerService.queryCompanyIdByUserId(userService.queryUserByUsername((String) SecurityUtils.getSubject().getPrincipal()).getId());
        Map<String,Object> map = new HashMap<>();
        map.put("companyId",companyId);
        List<CompanyApi> companyApiList = companyService.queryApiByCompanyId(map);
        model.addAttribute("companyApiList",companyApiList);
        return "product/companyproduct";
    }

}

package org.qydata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jonhn on 2016/11/29.
 */
@Controller
public class ErrorPageController {

    @RequestMapping(value = "/error/not-found")
    public String getNotFoundError(){
        return "/errorpages/404";
    }

    @RequestMapping(value = "/error/program")
    public String getProgramError(){
        return "/errorpages/500";
    }
}

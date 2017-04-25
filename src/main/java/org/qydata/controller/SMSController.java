package org.qydata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jonhn on 2017/4/24.
 */
@Controller
@RequestMapping("/sms")
public class SMSController {

    @RequestMapping("/sms-message")
    public String smsMessage(){

        return "/sms/smsmessage";
    }

}

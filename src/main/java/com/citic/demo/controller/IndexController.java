package com.citic.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title:
 * Description:
 * Create time  2019/12/16
 * Author：Democwf
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "redirect:/";
    }

    @RequestMapping("/loginout")
    @ResponseBody
    public String loginout(){
        return "index";
    }
}

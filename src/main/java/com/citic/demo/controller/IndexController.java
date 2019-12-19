package com.citic.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title:
 * Description:
 * Create time  2019/12/16
 * Author：Democwf
 */
@Controller
@Slf4j
public class IndexController {

    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }



    @RequestMapping("/loginOut")
    public String loginout(HttpServletResponse response, HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "index";
    }
}

package com.citic.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @ResponseBody
    public String main(Model model){
        return "index";
    }

    @RequestMapping("/index")
    public String index(Model model){
        log.info("adasdasdasdasdasdasd");
        model.addAttribute("result", "后台返回index1");
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "redirect:/";
    }

    @RequestMapping("/loginout")
    @ResponseBody
    public String loginout(Model model){
        return "index";
    }
}

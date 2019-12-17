package com.citic.demo.controller;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.entity.UserInfo;
import com.citic.demo.query.GoodsQuery;
import com.citic.demo.query.UserQuery;
import com.citic.demo.request.UserRequest;
import com.citic.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title:
 * Description:
 * Create time  2019/12/16
 * Author：Democwf
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/query/{id}")
    @ResponseBody
    public ActionResponse getUser(@PathVariable("id") Integer id) throws Exception{
        UserInfo userInfo = this.userService.queryUserInfoById(id);
        return ActionResponse.success(userInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public ActionResponse saveUserInfo(UserRequest userRequest) throws Exception{
        this.userService.saveUserInfo(userRequest);
        return ActionResponse.success();
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public ActionResponse updateUserInfo(UserRequest userRequest) throws Exception{
        this.userService.updateUserInfo(userRequest);
        return ActionResponse.success();
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}")
    public ActionResponse deleteUserInfo(@PathVariable("id") Integer id) throws Exception{
        this.userService.deleteUserInfo(id);
        return ActionResponse.success();
    }

}

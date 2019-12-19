package com.citic.demo.controller;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.base.RespBasicCode;
import com.citic.demo.entity.UserInfo;
import com.citic.demo.query.GoodsQuery;
import com.citic.demo.query.UserQuery;
import com.citic.demo.request.UserRequest;
import com.citic.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Title:
 * Description:
 * Create time  2019/12/16
 * Author：Democwf
 */
@Slf4j
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
    public ActionResponse saveUserInfo(@RequestBody UserRequest userRequest) throws Exception{
        userRequest.setGrade("青铜");
        userRequest.setAdress("四川省成都市四川师范大学成龙校区");
        userRequest.setUserPhoto("images/headImg/headImg1.jpg");
        UserInfo userInfo = this.userService.saveUserInfo(userRequest);


        try {
            log.info("返回ID》》》》》》》》》》 "+userInfo.toString());
            return ActionResponse.success(userInfo);
        }catch (Exception e){
            log.info(e.getMessage());
            return ActionResponse.fail(RespBasicCode.ACCOUNT_LOGIN_ERROR, "账号已存在！");
        }


    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public ActionResponse updateUserInfo(@RequestBody UserRequest userRequest) throws Exception{
        this.userService.updateUserInfo(userRequest);
        return ActionResponse.success();
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}")
    public ActionResponse deleteUserInfo(@PathVariable("id") Integer id) throws Exception{
        this.userService.deleteUserInfo(id);
        return ActionResponse.success();
    }

    @ResponseBody
    @RequestMapping(value = "/validate")
    public ActionResponse valUserInfo(@RequestBody UserRequest userRequest) throws Exception{

        UserInfo userInfo = this.userService.queryUserInfoByPhoneAndPwd(userRequest);
        if (userInfo == null){
            return ActionResponse.fail(RespBasicCode.ACCOUNT_LOGIN_ERROR, "用户不存在！");
        }
        log.info(userInfo.toString());
        return ActionResponse.success(userInfo);
    }


}

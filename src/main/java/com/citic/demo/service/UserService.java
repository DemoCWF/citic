package com.citic.demo.service;

import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.entity.UserInfo;
import com.citic.demo.query.GoodsQuery;
import com.citic.demo.query.UserQuery;
import com.citic.demo.request.GoodsRequest;
import com.citic.demo.request.UserRequest;

import java.util.List;

/**
 * Title:
 * Description:
 * Create time  2019/12/16
 * Author：Democwf
 */
public interface UserService {

//    /**
//     *
//     * 获取用户信息
//     *
//     * @param userQuery
//     * @return
//     * @throws Exception
//     */
//    List<UserInfo> query(UserQuery userQuery) throws Exception;

    /**
     *
     * 通过id获取用户信息
     *
     * @param primaryKey
     * @return
     */
    UserInfo queryUserInfoById(Integer id) throws Exception;

    /**
     *
     * 通过id获取用户信息
     *
     * @param primaryKey
     * @return
     */
    UserInfo queryUserInfoByPhoneAndPwd(UserRequest userRequest) throws Exception;


    /**
     *
     * 新增用户
     *
     * @param userRequest
     * @return
     * @throws Exception
     */
    int saveUserInfo(UserRequest userRequest) throws Exception;


    /**
     *
     * 修改用户信息
     *
     * @param userRequest
     * @return
     * @throws Exception
     */
    int updateUserInfo(UserRequest userRequest) throws Exception;


    /**
     *
     * 删除
     *
     * @param primaryKey
     * @return
     * @throws Exception
     */
    int deleteUserInfo(Integer id) throws Exception;
}

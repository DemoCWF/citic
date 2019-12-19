package com.citic.demo.serviceimpl;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.base.BaseConverter;
import com.citic.demo.base.RespBasicCode;
import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.entity.UserInfo;
import com.citic.demo.mapper.UserInfoMapper;
import com.citic.demo.query.UserQuery;
import com.citic.demo.request.GoodsRequest;
import com.citic.demo.request.UserRequest;
import com.citic.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:
 * Description:
 * Create time  2019/12/17
 * Author：Democwf
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private BaseConverter<UserRequest, UserInfo> requestConverter;
//    @Override
//    public List<UserInfo> query(UserQuery userQuery) throws Exception {
//        return this.userInfoMapper.;
//    }

    @Override
    public UserInfo queryUserInfoById(Integer id) throws Exception {
        return this.userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserInfo queryUserInfoByPhoneAndPwd(UserRequest userRequest) throws Exception {
        UserInfo userInfo = this.requestConverter.convert(userRequest,UserInfo.class);
        return this.userInfoMapper.selectByPhoneAndPwd(userInfo);
    }

    @Override
    public int saveUserInfo(UserRequest userRequest) throws Exception {
        UserInfo userInfo = this.requestConverter.convert(userRequest,UserInfo.class);
        String mailReg="[A-z]+[A-z0-9_-]*\\@[A-z0-9]+\\.[A-z]+";
        String phoneReg = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
        if (userRequest.getUserCount().matches(mailReg)){
            userInfo.setMail(userRequest.getUserCount());
        }
        if (userRequest.getUserCount().matches(phoneReg)){
            userInfo.setPhoneNum(userRequest.getUserCount());
        }
        if (userInfoMapper.valPhoneAndMail(userInfo) > 0)
        {
            throw new Exception();
        }
        return this.userInfoMapper.insert(userInfo);
    }

    @Override
    public int updateUserInfo(UserRequest userRequest) throws Exception {
        UserInfo userInfo = this.requestConverter.convert(userRequest,UserInfo.class);
        return this.userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public int deleteUserInfo(Integer id) throws Exception {
        return this.userInfoMapper.deleteByPrimaryKey(id);
    }
}

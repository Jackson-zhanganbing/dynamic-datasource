package com.changan.dynamicdatasource.service.impl;

import com.changan.dynamicdatasource.common.GeneralResponse;
import com.changan.dynamicdatasource.common.datasource.DatabaseType;
import com.changan.dynamicdatasource.common.datasource.DynamicDataSource;
import com.changan.dynamicdatasource.common.datasource.Master;
import com.changan.dynamicdatasource.common.datasource.Slave;
import com.changan.dynamicdatasource.dao.Oauth2UserMapper;
import com.changan.dynamicdatasource.dao.UserMapper;
import com.changan.dynamicdatasource.entity.Oauth2User;
import com.changan.dynamicdatasource.entity.User;
import com.changan.dynamicdatasource.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zab
 * @date 2019/5/30 13:20
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Oauth2UserMapper oauth2UserMapper;

    @Override
    @Master
    public GeneralResponse getAllUserInfo() {
        List<User> userList = userMapper.getAllUserInfo();
        return GeneralResponse.success("ok", userList);
    }

    @Override
    @Slave
    public GeneralResponse getAllOauthUserInfo() {
        List<Oauth2User> userList = oauth2UserMapper.getAllOauthUserInfo();
        return GeneralResponse.success("ok", userList);
    }
}

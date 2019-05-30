package com.changan.dynamicdatasource.service.impl;

import com.changan.dynamicdatasource.common.GeneralResponse;
import com.changan.dynamicdatasource.common.datasource.DatabaseContextHolder;
import com.changan.dynamicdatasource.common.datasource.DatabaseType;
import com.changan.dynamicdatasource.dao.Oauth2UserMapper;
import com.changan.dynamicdatasource.dao.UserMapper;
import com.changan.dynamicdatasource.entity.User;
import com.changan.dynamicdatasource.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Oauth2UserMapper oauth2UserMapper;

    @Override
    public GeneralResponse getAllUserInfo() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.db1);
        List<User> userList = userMapper.getAllUserInfo();
        return GeneralResponse.success("ok",userList);
    }

    @Override
    public GeneralResponse getAllOauthUserInfo() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.db2);
        List<User> userList = oauth2UserMapper.getAllOauthUserInfo();
        return GeneralResponse.success("ok",userList);
    }
}

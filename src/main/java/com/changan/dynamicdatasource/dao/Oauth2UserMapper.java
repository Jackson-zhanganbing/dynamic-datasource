package com.changan.dynamicdatasource.dao;

import com.changan.dynamicdatasource.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface Oauth2UserMapper {

    List<User> getAllOauthUserInfo();
}
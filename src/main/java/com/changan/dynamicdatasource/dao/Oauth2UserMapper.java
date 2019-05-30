package com.changan.dynamicdatasource.dao;

import com.changan.dynamicdatasource.entity.Oauth2User;
import com.changan.dynamicdatasource.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface Oauth2UserMapper {

    List<Oauth2User> getAllOauthUserInfo();
}
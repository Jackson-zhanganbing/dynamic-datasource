package com.changan.dynamicdatasource.dao;

import com.changan.dynamicdatasource.entity.Oauth2User;

import java.util.List;
public interface Oauth2UserMapper {

    List<Oauth2User> getAllOauthUserInfo();
}
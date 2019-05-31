package com.changan.dynamicdatasource.dao;

import com.changan.dynamicdatasource.entity.User;

import java.util.List;
public interface UserMapper {

    List<User> getAllUserInfo();
}
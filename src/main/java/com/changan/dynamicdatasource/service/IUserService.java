package com.changan.dynamicdatasource.service;

import com.changan.dynamicdatasource.common.GeneralResponse;
/**
 *@author zab
 *@date 2019/5/30 10:27
*/
public interface IUserService {
    GeneralResponse getAllUserInfo();

    GeneralResponse getAllOauthUserInfo();

}

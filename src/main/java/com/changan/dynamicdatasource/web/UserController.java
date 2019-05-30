package com.changan.dynamicdatasource.web;

import com.changan.dynamicdatasource.common.GeneralResponse;
import com.changan.dynamicdatasource.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zab
 * @date 2019/5/30 10:23
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * @return com.changan.dynamicdatasource.common.GeneralResponse
     */
    @GetMapping("/get")
    public GeneralResponse getAllUserInfo() {

        return userService.getAllUserInfo();
    }
    @GetMapping("/get_oauth")
    public GeneralResponse getAllOauthUserInfo() {

        return userService.getAllOauthUserInfo();
    }
}

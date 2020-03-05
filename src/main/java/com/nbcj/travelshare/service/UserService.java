package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.User;

import java.util.List;

public interface UserService {
    User findUserById(Integer uid);
    User findUserByPhone(String phone);
    User findUserByUsername(String username); // 根据用户名查找用户
    Boolean registerUser(String username, String password); // 注册
    Boolean updateUser(String username, String password); // 忘记密码

    List getTravelsByUserId(Integer uid);
}

package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.Travels;
import com.nbcj.travelshare.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findUserById(Integer uid);
    User findUserByPhone(String phone);
    User findUserByUsername(String username); // 根据用户名查找用户
    Boolean registerUser(String username, String password); // 注册
    Boolean updateUser(String username, String password); // 忘记密码

    Map<String, String> changeUserInfo(MultipartFile[] file, User user);
    void saveUser(User user);

    List getTravelsByUserId(Integer uid);
}

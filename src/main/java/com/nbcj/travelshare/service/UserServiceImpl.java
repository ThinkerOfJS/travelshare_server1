package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.User;
import com.nbcj.travelshare.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    // 注册用户，调用 countUser 判断用户存不存在
    @Override
    public Boolean registerUser(String username, String password) {
        if (userMapper.countUser(username) == 0) {
            // 用户不存在，插入用户信息，返回 true
            userMapper.insertUser(username, password);
            return true;
        } else {
            // 用户存在，返回 false
            return false;
        }
    }

    // 用户修改密码的方法
    @Override
    public Boolean updateUser(String username, String password) {
        if (userMapper.countUser(username) == 0) {
            // 用户不存在
            return false;
        } else {
            // 用户存在
            userMapper.updateUser(username, password);
            return true;
        }
    }

    @Override
    public List getTravelsByUserId(Integer id) {
        return null;
    }

}

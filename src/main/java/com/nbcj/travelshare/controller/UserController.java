package com.nbcj.travelshare.controller;

import com.nbcj.travelshare.domain.ExceptionResp;
import com.nbcj.travelshare.domain.User;
import com.nbcj.travelshare.mapper.TravelsMapper;
import com.nbcj.travelshare.mapper.UserMapper;
import com.nbcj.travelshare.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    UserMapper userMapper;

    @Resource
    TravelsMapper travelsMapper;

    Logger logger = LoggerFactory.getLogger(getClass());
    ExceptionResp exceptionResp = new ExceptionResp();

    // 登录
    @ResponseBody
    @PostMapping("/user/login")
    private ExceptionResp login(@RequestBody User user){

        String username = user.getUsername();
        String password = user.getPassword();

        //logger.info("用户名："+ username + '-' + "密码：" + password);
        // 1.获取 Subject
        Subject subject = SecurityUtils.getSubject();

        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        // 3.执行登录方法
        try {
            subject.login(token);
            // 登录成功
            exceptionResp.setCode(0);
            exceptionResp.setMsg("登录成功！");

        } catch (UnknownAccountException e) {
            // 登录失败，用户名不存在
            exceptionResp.setCode(1);
            exceptionResp.setMsg("用户不存在！");

        } catch (IncorrectCredentialsException e) {
            exceptionResp.setCode(2);
            exceptionResp.setMsg("密码错误");

        }
        return exceptionResp;
    }

    // 注册
    @ResponseBody
    @PostMapping("/user/register")
    public ExceptionResp register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        Boolean flag = userService.registerUser(username, password);
        if (flag) {
            exceptionResp.setCode(0);
            exceptionResp.setMsg("注册成功！");
        } else {
            exceptionResp.setCode(1);
            exceptionResp.setMsg("用户名已存在！");
        }
        return exceptionResp;
    }

    // 忘记密码
    @ResponseBody
    @PostMapping("/user/forgot")
    public ExceptionResp updateUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        Boolean flag = userService.updateUser(username, password);
        if (flag) {
            exceptionResp.setCode(0);
            exceptionResp.setMsg("修改成功！");
        } else {
            exceptionResp.setCode(1);
            exceptionResp.setMsg("用户不存在！");
        }
        return exceptionResp;
    }

    // 个人收藏
    @ResponseBody
    @GetMapping("/user/collection")
    public List getCollection(@RequestParam Integer id) {
        List travels;
        travels = userMapper.getCollectionTravelsByUserId(id);
        return travels;
    }

    // 个人动态
    @ResponseBody
    @GetMapping("/user/dynamic")
    public List getTravelsByUid(@RequestParam Integer id) {
        List travels;
        travels = travelsMapper.findTravelsByUserId(id);
        return travels;
    }

    // 获取用户信息
    @ResponseBody
    @GetMapping("/user/getuser")
    public User getUserInfo( String username ) {
        User user;
        user = userMapper.findUserByUsername(username);
        return user;
    }

}

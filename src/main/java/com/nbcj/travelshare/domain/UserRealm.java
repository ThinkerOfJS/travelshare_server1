package com.nbcj.travelshare.domain;

import com.nbcj.travelshare.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    // 用户验证和用户授权管理
    @Autowired
    private UserService userService;
    

    Logger logger = LoggerFactory.getLogger(getClass());

    // 执行授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("执行授权");
        return null;
    }

    // 执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        logger.info("执行认证");

        // 1.判断用户名,获取用户输入的token
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;

        User user = userService.findUserByUsername(utoken.getUsername());

        if (user == null) {
            // 用户名不存在
            // 返回 null 后，shiro 会自动抛出 UnKnownAccountException
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}

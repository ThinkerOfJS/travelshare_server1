package com.nbcj.travelshare.config;

import com.nbcj.travelshare.domain.UserRealm;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    // 1. 创建 Realm
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

    // 2. 创建 DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联 realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 3. 创建 ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") SessionsSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // shiro 拦截以后会自动跳转到默认的页面，可以修改这些页面
        shiroFilterFactoryBean.setLoginUrl("/tologin");

        // 设置未授权跳转的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        // 添加 Shiro 内置过滤器
        /*
         * Shiro 内置过滤器，可以实现权限相关的拦截器
         *   常用过滤器：
         *       anon: 无需认证(登录)可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用 remberMe 的功能可以直接访问
         *       perms: 该资源必须得到资源权限才能访问
         *       role: 该资源必须得到角色权限才可以访问
         * */
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        // filterMap.put("/user/add", "authc");
        // filterMap.put("/user/update", "authc");
        //filterMap.put("/user/add", "roles[user]");
        //filterMap.put("/user/update", "roles[admin]");
        // 放行 login.html 页面
        //filterMap.put("/login","anon");

        //filterMap.put("/*", "authc");

        // 执行授权过滤器
        // 当授权拦截后，shiro会自动跳转到未授权页面
        //filterMap.put("/user/add", "perms[user:add]");
        //filterMap.put("/user/update", "perms[user:update]");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启aop注解支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SessionsSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}

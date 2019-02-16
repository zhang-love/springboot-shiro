package com.zl.springboot.shiro.configuration;

import com.zl.springboot.shiro.realm.MyShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfiguration {

    @Bean
    public MyShiroRealm myShiroRealm(){
        return new MyShiroRealm();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myShiroRealm());
        return manager;
    }

    @Bean(name= "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //匿名访问
        map.put("/getUser","anon");
        map.put("/lx","anon");
        //认证访问
        map.put("/**","authc");
        //设置admin角色才能访问的请求
        map.put("/admin/*","roles[admin]");
        map.put("/user/*","roles[user]");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
}

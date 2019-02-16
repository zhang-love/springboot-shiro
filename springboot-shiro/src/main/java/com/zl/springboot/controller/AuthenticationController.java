package com.zl.springboot.controller;

import com.zl.springboot.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

    @RequestMapping("/")
    public String in(){
        return "hello";
    }
    @RequestMapping("/lx")
    public String login(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/index";
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "test";
    }

    @RequestMapping("/admin/a")
    public String a(){
        return "admin";
    }

    @RequestMapping("/user/b")
    public String b(){
        return "user";
    }
}

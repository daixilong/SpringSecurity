package com.xdl.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Administrator on 2018/1/14.
 */
@Controller
public class LoginController {
    @GetMapping("/")
    public String home(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/logout")
    public String logout(){
        SecurityContextHolder.clearContext();
        return "login";
    }
    @GetMapping("/main")
    public String main(){
        return "index";
    }

    @GetMapping("/test1")
    public String test1(){
        return "index";
    }
    @GetMapping("/test2")
    public String test2(){
        return "index";
    }
}

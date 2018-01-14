package com.xdl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/12/31.
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "index";
    }

    /**
     * 跳转到login页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}

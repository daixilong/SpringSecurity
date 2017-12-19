package com.xdl.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2017/12/19.
 */
@Controller
public class SysUserController {
    @GetMapping("/login")
    public String login(){
        return "sys/sysuser/index";
    }

    @GetMapping("/logout")
    public String logout(){
        return "sys/sysuser/index";
    }
}

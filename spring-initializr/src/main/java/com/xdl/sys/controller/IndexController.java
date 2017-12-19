package com.xdl.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/12/18.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public  String index(){
        return "index";
    }
    @RequestMapping("/home")
    public  String home(){
        return "sys/sysuser/index";
    }
}

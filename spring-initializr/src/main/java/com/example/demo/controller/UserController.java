package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/18.
 */
@Controller
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public  String hello(){
        userMapper.insert(2l,"张三",24);
        return "helloWord";
    }
}

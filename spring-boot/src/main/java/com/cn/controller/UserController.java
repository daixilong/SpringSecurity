package com.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
		@RequestMapping("/home")
		public String home(){
			return "首页进入";
		}
}

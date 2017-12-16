package com.cn.controller;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource({"classpath:user.properties"})
public class UserController {
		
		@Value("${user.name}")
	  private String name;
	  
		@Value("${user.hobby}")
	  private String hoby;
		
		@Value("${user.age}")
		private int age;
	
		@RequestMapping("/home")
		public String home(){
			return "首页进入";
		}
		
		
		@RequestMapping("/user")
		public String user(){
			 return name+"的爱好是:"+hoby+"，年龄"+age;
		}
		
}

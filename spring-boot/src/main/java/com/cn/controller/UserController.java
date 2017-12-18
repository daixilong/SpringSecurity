package com.cn.controller;

import com.cn.dao.UserRepository;
import com.cn.exception.MyException;
import com.cn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
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

	   @Autowired
       private UserRepository userRepository;
	
		@RequestMapping("/home")
		public String home(){
			return "首页进入";
		}
		
		
		@RequestMapping("/user")
		public String user(){
			return name+"的爱好是:"+hoby+"，年龄"+age;
		}

		@RequestMapping("/json")
		public String json() throws MyException {
			throw new MyException("发生错误2");
		}
		@GetMapping("/add")
	   public String add(){
			User user=new User();
			user.setName("张三");
			user.setAge(10);
			userRepository.save(user);
			return "添加成功";
		}

}

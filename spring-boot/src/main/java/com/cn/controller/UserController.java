package com.cn.controller;

import com.cn.exception.MyException;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

		@Autowired
		private UserService userService;
	
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

	/*	@RequestMapping("/add")
	    public String add() throws MyException{
			throw new  MyException("出现错误");
				User user1=new User();
			    user1.setId(1l);
				user1.setName("张三");
			   user1.setAge(24);
				userService.insert(user1);
		}*/

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

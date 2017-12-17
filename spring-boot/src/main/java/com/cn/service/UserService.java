package com.cn.service;

import com.cn.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   // @Autowired
   // private JdbcTemplate jdbcTemplate;

    public int insert(User user){
      return 0;
        // return jdbcTemplate.update("insert into User (id,name,age) values(?,?,?)",user.getId(),user.getName(),user.getAge());
    }

}

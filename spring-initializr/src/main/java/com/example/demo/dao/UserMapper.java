package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/12/18.
 */
@Mapper
public interface UserMapper {
    @Insert("insert into User(id,name,age) values (#{id},#{name},#{age})")
    int insert(@Param("id") Long id,@Param("name") String name,@Param("age") Integer age);
}

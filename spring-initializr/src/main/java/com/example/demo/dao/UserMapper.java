package com.example.demo.dao;

import com.example.demo.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/12/18.
 */
@Mapper
public interface UserMapper {
    @Insert("insert into User(id,name,age) values (#{id},#{name},#{age})")
    int insert(@Param("id") Long id,@Param("name") String name,@Param("age") Integer age);

    @Select("SELECT\n" +
                    "\tu.*,\n" +
                    "\tr. NAME\n" +
                    "FROM\n" +
                    "\tSys_User u\n" +
                    "LEFT JOIN sys_role_user sru ON u.id = sru.Sys_User_id\n" +
                    "LEFT JOIN Sys_Role r ON sru.Sys_Role_id = r.id\n" +
                    "WHERE username = #{username}")
    SysUser findByUsername(@Param("username") String username);
}

package com.xdl.sys.controller;

import com.xdl.sys.entity.SysUser;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Administrator on 2017/12/19.
 */
@RestController
@RequestMapping("/swagger")
public class SwaggerController {
    static Map<Integer, SysUser> users = Collections.synchronizedMap(new HashMap<Integer, SysUser>());

    @ApiOperation(value = "获取用户列表")
    @GetMapping("/getAllUser")
    public List<SysUser> getAllUser(){
        List<SysUser> list=new ArrayList<>(users.values());
        return list;
    }

    @ApiOperation(value = "创建用户",notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "sysUser" ,value= "用户详细的实体sysuser",required = true,dataType = "sysUser")
    @PostMapping("/addUser")
    public  String addUser(@RequestBody SysUser sysUser){
        users.put(sysUser.getId(),sysUser);
        return "Success";
    }

    @ApiOperation(value = "获取用户",notes = "根据用户id获取用户")
    @ApiImplicitParam(name = "id" ,value= "根据用户的ID获取用户",required = true,dataType = "id")
    @GetMapping(value = "/{id}")
    public SysUser getUser(@PathVariable Integer id){
       return users.get(id);
    }

    @ApiOperation(value = "更新用户",notes = "根据制定的id和user更新对象")
    @PutMapping(value ="/{id}" )
    @ApiImplicitParams({
                               @ApiImplicitParam(name = "id" ,value= "根据用户的ID获取用户",required = true,dataType = "id"),
                               @ApiImplicitParam(name = "sysUser" ,value= "用户详细的实体sysuser",required = true,dataType = "sysUser")
    })
    public  String updateUser(@PathVariable Integer id,@RequestBody SysUser sysUser){
        SysUser user=users.get(id);
        user.setPassword(sysUser.getPassword());
        user.setUsername(sysUser.getUsername());
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
   @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable Integer id) {
        users.remove(id);
        return "success";
    }
}

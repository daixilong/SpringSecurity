package com.xdl.dao;

import com.xdl.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/1/14.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long>{


    SysUser findByUsername(String username);
}

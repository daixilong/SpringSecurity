package com.xdl.sys.dao;

import com.xdl.sys.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Mapper
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
public interface SysPermissionMapper {
	/**
	 * 根据当前用户查询拥有的权限
	 * @param userId
	 * @return
     */
	 List<SysPermission> findByUserId(int userId);
}

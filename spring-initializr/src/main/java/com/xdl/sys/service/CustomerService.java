package com.xdl.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xdl.sys.config.MyGrantedAuthority;
import com.xdl.sys.dao.SysPermissionMapper;
import com.xdl.sys.dao.SysUserMapper;
import com.xdl.sys.entity.SysPermission;
import com.xdl.sys.entity.SysRole;
import com.xdl.sys.entity.SysUser;

@Service
public class CustomerService implements UserDetailsService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	/**
	 * 登录验证
	 */
	public UserDetails loadUserByUsername(String s) 
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SysUser sysUser= sysUserMapper.findByUsername(s);
		if(sysUser==null){
			 throw new UsernameNotFoundException("未找到相关用户信息!");
		}
		/**
		 * 认证的权限
		 */
		List<SysPermission> sysPermissions= sysPermissionMapper.findByUserId(sysUser.getId());
	  List<GrantedAuthority > authorities = new ArrayList<GrantedAuthority>();
	  for (SysPermission permission : sysPermissions) {
				if(permission!=null && permission.getName()!=null){
					GrantedAuthority authority=new MyGrantedAuthority(permission.getUrl(),permission.getMethod());
					authorities.add(authority);
				}
		}
		return new User(sysUser.getUsername(), sysUser.getPassword(),authorities);
	}

}

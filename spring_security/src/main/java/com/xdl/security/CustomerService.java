package com.xdl.security;

import com.xdl.dao.SysRoleRepository;
import com.xdl.dao.SysUserRepository;
import com.xdl.entity.SysRole;
import com.xdl.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/1/14.
 */
@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser= sysUserRepository.findByUsername(username);
        System.out.println("--获取当前用户的信息-"+sysUser);
        if(sysUser==null){
            throw new UsernameNotFoundException("未找到相关用户信息!");
        }
        List<SysRole> sysRoles= sysRoleRepository.queryRoleById(sysUser.getId());
        Set<GrantedAuthority> sets=new HashSet<>(sysRoles.size());
        for(SysRole sysRole:sysRoles){
            sets.add(new SimpleGrantedAuthority(sysRole.getRolename()));
        }
        return new User(username,sysUser.getPassword(),sets);
    }
}

package com.xdl;

import com.xdl.dao.*;
import com.xdl.domain.p.User1Repository;
import com.xdl.domain.s.MessageRepository;
import com.xdl.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//import org.apache.log4j.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityApplicationTests {
  //  private static Logger log= Logger.getLogger(SpringSecurityApplicationTests.class);

	@Autowired
	private User1Repository user1Repository;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SysUserRepository sysUserRepository;

	@Autowired
	private SysRoleRepository sysRoleRepository;

	@Autowired
	private SysPermissionRepository sysPermissionRepository;

	@Autowired
	private SysUserRoleRepository sysUserRoleRepository;

	@Autowired
	private SysRolePermissionRepository sysRolePermissionRepository;

	@Test
	public void contextLoads() {
		List<SysUser> sysUsers= sysUserRepository.findAll();
		for (SysUser sys:sysUsers
			 ) {
			System.out.println("------"+sys.getId()+"------");
			//List<SysRole> sysroles= sysRoleRepository.queryRoleById(sys.getId());
			//System.out.println("------"+sysroles.size()+"------");
		}
	}
    public void init(){
		/*   	User user= userRepository.findByName("aaa");
		//log.info("user==="+user.getId()+"----"+user.getAge());
		userRepository.findByName("aaa");*/
		SysPermission sysPermission=new SysPermission("管理员能访问","/main");
		SysPermission sysPermission1=new SysPermission("测试用户1","/test1");
		SysPermission sysPermission2=new SysPermission("测试用户2","/test2");
		sysPermissionRepository.save(sysPermission);
		sysPermissionRepository.save(sysPermission1);
		sysPermissionRepository.save(sysPermission2);
		SysRole sysRole=new SysRole("role_admin");
		SysRole sysRole1=new SysRole("role_test1");
		sysRoleRepository.save(sysRole);
		sysRoleRepository.save(sysRole1);
		SysUser sysUser=new SysUser("xiaodai","1");
		sysUserRepository.save(sysUser);
		SysUser sysUser1=new SysUser("test","1");
		sysUserRepository.save(sysUser1);
		/**
		 * 用户1拥有两个角色
		 */
		SysUserRole sysUserRole=new SysUserRole(sysUser.getId(),sysRole.getId());
		sysUserRoleRepository.save(sysUserRole);
		SysUserRole sysUserRole1=new SysUserRole(sysUser.getId(),sysRole1.getId());
		sysUserRoleRepository.save(sysUserRole1);
		SysUserRole sysUserRole2=new SysUserRole(sysUser1.getId(),sysRole1.getId());
		sysUserRoleRepository.save(sysUserRole2);
		/**
		 * 角色1拥有三个权限
		 */
		SysRolePermission sysRolePermission=new SysRolePermission(sysRole.getId(),sysPermission.getId());
		sysRolePermissionRepository.save(sysRolePermission);
		SysRolePermission sysRolePermission1=new SysRolePermission(sysRole.getId(),sysPermission1.getId());
		sysRolePermissionRepository.save(sysRolePermission1);
		SysRolePermission sysRolePermission2=new SysRolePermission(sysRole.getId(),sysPermission2.getId());
		sysRolePermissionRepository.save(sysRolePermission2);
		SysRolePermission sysRolePermission3=new SysRolePermission(sysRole1.getId(),sysPermission1.getId());
		sysRolePermissionRepository.save(sysRolePermission3);
	}
}

package com.xdl.dao;

import com.xdl.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2018/1/14.
 */
public interface SysRoleRepository extends JpaRepository<SysRole,Long> {


    @Query(value = "select a.* from Sys_Role a left join Sys_User_Role b on a.id=b.roleid left join Sys_User c on b.userid=c.id where c.id=?1",nativeQuery = true)
    List<SysRole> queryRoleById(long userid);

    @Query(value = "select a.* from Sys_Role a left join Sys_Role_Permission b on a.id=b.roleid left join Sys_Permission c on b.permissionid=c.id where c.id=?1",nativeQuery = true)
    List<SysRole> queryRoleByPermId(long permissionId);
}

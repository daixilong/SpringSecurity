package com.xdl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/1/14.
 */
@Entity
public class SysRolePermission {
    @Id
    @GeneratedValue
    private long id;

    private long roleid;

    private long permissionid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }

    public long getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(long permissionid) {
        this.permissionid = permissionid;
    }

    public SysRolePermission(long roleid, long permissionid) {
        this.roleid = roleid;
        this.permissionid = permissionid;
    }
}

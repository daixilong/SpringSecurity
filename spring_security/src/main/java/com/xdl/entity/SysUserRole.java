package com.xdl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/1/14.
 */
@Entity
public class SysUserRole {
    @Id
    @GeneratedValue
    private long id;

    private long userid;

    private long roleid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }

    public SysUserRole(long userid, long roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }

    public SysUserRole() {
    }
}

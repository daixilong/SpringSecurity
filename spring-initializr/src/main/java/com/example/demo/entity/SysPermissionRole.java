package com.example.demo.entity;

/**
 * Created by Administrator on 2017/12/18.
 */
public class SysPermissionRole {
    private  int id;
    private  int sysRoleId;
    private  int sysPermissionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(int sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public int getSysPermissionId() {
        return sysPermissionId;
    }

    public void setSysPermissionId(int sysPermissionId) {
        this.sysPermissionId = sysPermissionId;
    }
}

package com.example.demo.entity;

/**
 * Created by Administrator on 2017/12/18.
 */
public class SysRoleUser {
    private  int id;
    private  int sysRoleId;
    private  int sysUserId;

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

    public int getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }
}

package com.xdl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/1/14.
 */
@Entity
public class SysRole {

    @Id
    @GeneratedValue
    private long id;

    private String rolename;

    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SysRole(String rolename) {
        this.rolename = rolename;
    }

    public SysRole() {
    }
}

package com.xdl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/1/14.
 */
@Entity
public class SysPermission {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SysPermission(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public SysPermission() {
    }
}

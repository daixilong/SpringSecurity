package com.xdl.sys.config;

import org.springframework.security.core.GrantedAuthority;

/**
 * 自定义资源文件
 * @author a
 *
 */
public class MyGrantedAuthority implements GrantedAuthority {
	
	private String method;
	
	private String url;
	
	public String getMethod() {
		return method;
	}



	public void setMethod(String method) {
		this.method = method;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}

	public MyGrantedAuthority(String method, String url) {
		super();
		this.method = method;
		this.url = url;
	}



	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.url+":"+this.method;
	}
	
}

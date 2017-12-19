package com.xdl.sys.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.xiaoleilu.hutool.crypto.SecureUtil;
/**
 * 对密码进行加密操作
 * @author a
 *
 */
public class EncordPass implements PasswordEncoder {

	public String encode(CharSequence pa) {
		// TODO Auto-generated method stub
		return SecureUtil.md5((String)pa);
	}

	public boolean matches(CharSequence arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg1.equals(SecureUtil.md5((String)arg0));
	}
	public static void main(String[] args) {
		  System.out.println("==="+SecureUtil.md5("test"));
	}
}

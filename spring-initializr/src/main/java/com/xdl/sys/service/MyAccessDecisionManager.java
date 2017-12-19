package com.xdl.sys.service;

import com.xdl.sys.config.MyGrantedAuthority;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * 验证
 * @author a
 *  //authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.

        //object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();

        //configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

  //decide 方法是判定是否拥有权限的决策方法
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		// TODO Auto-generated method stub
		 //获取request对象
		 HttpServletRequest request=((FilterInvocation)object).getHttpRequest();
		 String url,method;
		 AntPathRequestMatcher matcher;
	   for (GrantedAuthority ga : authentication.getAuthorities()) {
	  	   if(ga instanceof MyGrantedAuthority){
	  	  	  MyGrantedAuthority urlGrantedAuthority = (MyGrantedAuthority) ga;
		 	       url = urlGrantedAuthority.getUrl();
	          method = urlGrantedAuthority.getMethod();
	          matcher=new AntPathRequestMatcher(url);
	          if (matcher.matches(request)) {
	         	//当权限表权限的method为ALL时表示拥有此路径的所有请求方式权利。
	            if (method.equals(request.getMethod()) || "ALL".equals(method)) {
	                return;
	            }
	          }
	  	   }else if(ga.getAuthority().equals("ROLE_ANONYMOUS")){//未登录的用户
	  	  	 	System.out.println("未登录");
	  	  	  matcher = new AntPathRequestMatcher("/login");
            if (matcher.matches(request)) {
                return;
            }
	  	   }
	     
	   }
	}

	public boolean supports(ConfigAttribute arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}

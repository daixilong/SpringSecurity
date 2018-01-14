package com.xdl.security;

import com.xdl.dao.SysPermissionRepository;
import com.xdl.dao.SysRoleRepository;
import com.xdl.entity.SysPermission;
import com.xdl.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by Administrator on 2018/1/14.
 */
@Component
public class SecurityMetadataSource implements FilterInvocationSecurityMetadataSource{

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if (requestUrl.indexOf("?") != -1) {
            requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
            requestUrl = requestUrl.trim();
        }
        if(requestUrl.equals("/login") || requestUrl.equals("/index")){
            return configAttributes;
        }
        Iterator<String> it = resourceMap.keySet().iterator();
        while (it.hasNext()) {
            String _url = it.next();
            System.out.println("------"+_url+"------"+requestUrl);
            if (_url == null || "".equals(_url)) {
                continue;
            }
            if (_url.equals(requestUrl)) {

                //保存角色名
                configAttributes = resourceMap.get(_url);

                break;
            }
        }
        if (configAttributes.isEmpty()) {
            throw new AccessDeniedException(" 没有权限访问！ ");
        }

        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 初始化资源权限
     */
    @PostConstruct
    public void  loadResourceDefine(){
        resourceMap=new HashMap<>();
        List<SysPermission> sysPermissions= sysPermissionRepository.findAll();
        for (SysPermission syspermission:sysPermissions
             ) {
            String url=syspermission.getUrl();
            List<SysRole> sysroles= sysRoleRepository.queryRoleByPermId(syspermission.getId());
            if(resourceMap.containsKey(url)){
                Collection<ConfigAttribute> configAttributes = resourceMap.get(url);
                for (SysRole sysrole:sysroles
                        ) {
                    ConfigAttribute configAttribute = new SecurityConfig(sysrole.getRolename());
                    configAttributes.add(configAttribute);
                }
            }else{
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                for (SysRole sysrole:sysroles
                     ) {
                    ConfigAttribute configAttribute = new SecurityConfig(sysrole.getRolename());
                    configAttributes.add(configAttribute);
                }
                resourceMap.put(url,configAttributes);
            }
        }
    }
}

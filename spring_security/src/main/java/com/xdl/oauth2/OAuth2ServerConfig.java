package com.xdl.oauth2;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/12/31.
 */
@Configuration
public class OAuth2ServerConfig {
    private static  final  String DEMO_RESOURCE_ID="order";

    /**
     * 配置资源服务器
     */
    @Configuration
    protected static class ResourceServerConfiguration  {

    }

}

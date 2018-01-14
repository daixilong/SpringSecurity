//package com.xdl.oauth2;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by Administrator on 2017/12/31.
// * 外网中相互调用接口，增加安全保护机制
// * 配置资源服务器，认证服务器，配置springsecurity
// * oauth2认证模式分为 :授权码模式（qq第三方登录），简化模式，密码模式和客户端模式
// * 如果是用户，不考虑权限，采用客户端模式，如果有系统有用户的权限采用密码模式
// * token配置使用redis，1是性能，而是自动过期
// */
//@RestController
//public class TestEndpoints {
//    @GetMapping("/product/{id}")
//    public  String getProduct(@PathVariable String id){
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        return  "产品id"+id;
//    }
//
//    /**
//     * 安全校验
//     * @param id
//     * @return
//     */
//    @GetMapping("/order/{id}")
//    public String getOrder(@PathVariable String id){
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        return  "订单id"+id;
//    }
//}

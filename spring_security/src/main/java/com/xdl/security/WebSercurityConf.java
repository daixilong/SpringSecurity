package com.xdl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by Administrator on 2018/1/14.
 */
@Configuration
@EnableWebSecurity
public class WebSercurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private MYFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Bean
    UserDetailsService getUserDetailsService(){
        return new CustomerService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getUserDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
        http.authorizeRequests().antMatchers("/login","/").permitAll().anyRequest().authenticated();
        http.formLogin().successForwardUrl("/index").loginPage("/login").failureUrl("/login?error").permitAll();
        http.logout().logoutUrl("/logout").permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}

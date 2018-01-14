/*
package com.xdl.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

*/
/**
 * Created by Administrator on 2017/12/31.
 *//*

@Configuration
@EnableWebSecurity
public class WebSercurityConfig extends WebSecurityConfigurerAdapter {
    */
/**
     * 设置需要拦截
     * @param http
     * @throws Exception
     *//*

    @Override
    protected void configure(HttpSecurity http) throws Exception {
             http
                .authorizeRequests()
                     .antMatchers("/","/hello").permitAll()
                     .anyRequest().authenticated()
                     .and()
                 .formLogin()
                     .loginPage("/login")
                     .successForwardUrl("/hello")
                     .permitAll()
                     .and()
                 .logout()
                     .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
       web.ignoring().antMatchers("/css*/
/**","/image*/
/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
    }
}
*/

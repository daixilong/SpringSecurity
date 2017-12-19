package com.xdl.sys.config;

import com.xdl.sys.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
/**
 * springSecurity的相关配置
 * @author a
 *
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
		@Bean
		UserDetailsService getUserDetailsService(){
			return new CustomerService();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth)
				throws Exception {
			// TODO Auto-generated method stub
			auth.userDetailsService(getUserDetailsService()).passwordEncoder(new EncordPass());
		}

		/**
		 * 访问权限的配置
		 */
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
			http.authorizeRequests().antMatchers("/css/**","/layui/**","/images/*","/home","/js/*","/swagger/**").permitAll().anyRequest().authenticated().
			and().
			formLogin().successForwardUrl("/index").loginPage("/login").failureUrl("/login?error").permitAll().
			and().logout().logoutUrl("/logout").permitAll();
		}
		
		
}

package com.xinliang.spring.boot.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 * @author liangxin
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * 自定义配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()  //都可以访问
		.antMatchers("/users/**").hasRole("ADMIN")  //需要相应对角色才能访问
		.and()
		.formLogin()			//基于form表单登录验证
		.loginPage("/login").failureUrl("/login-error"); //自定义登录界面
	}
	
	
	/**
	 * 认证信息管理
	 * @param auto
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auto) throws Exception {
		auto.inMemoryAuthentication()	//认证信息存储在内存中
		.withUser("xili").password("123").roles("ADMIN");
	}
}

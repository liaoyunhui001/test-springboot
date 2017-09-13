package com.hui.config;

import com.hui.interceptor.MyInterceptor1;
import com.hui.interceptor.MyInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigure extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则.addPathPatterns("/**")
		// excludePathPatterns 用户排除拦截.excludePathPatterns("/user/deleteUserById")
		registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**").excludePathPatterns("/deleteUserById");
		//registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
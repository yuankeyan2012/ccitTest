package com.chinacoal.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

@Configuration
public class MybatisPlusConfig {

	 /*
	    * 分页插件，自动识别数据库类型
	    */
	    @Bean
	    public PaginationInterceptor paginationInterceptor() {
	        return new PaginationInterceptor();
	    }
	    
	    /**
	     * SQL执行效率插件
	     */
	    @Bean
	    @Profile({"dev","qa"})// 设置 dev test 环境开启
	    public PerformanceInterceptor performanceInterceptor() {
	        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
	        performanceInterceptor.setMaxTime(10000);
	        performanceInterceptor.setFormat(true);
	        return performanceInterceptor;
	    }
}

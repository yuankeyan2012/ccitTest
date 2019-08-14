package com.chinacoal.microservice;

import com.primeton.ptp.tarest.client.api.annotation.EnableTarestClients;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * @author zhanfy   zhanfy  
 *
 */
@EnableDiscoveryClient
@EnableTarestClients
@EnableCircuitBreaker
@SpringBootApplication
@MapperScan("com.chinacoal.microservice.impl.mapper")
@EnableTransactionManagement
public class CcitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcitTestApplication.class, args);
	}
}

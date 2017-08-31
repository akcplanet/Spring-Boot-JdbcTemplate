package com.fail.trade;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages={"com.fail.trade.controller" , "com.fail.trade"})
public class FailTradeServerApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(FailTradeServerApplication.class, args);
	}
	
	/*@Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new ApplicationSecurity();
    }
	*/


	
}

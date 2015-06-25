package com.hm.engine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableWebMvc
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
@Import({PersistenceContext.class})
//@ImportResource("classpath:applicationContext-security.xml")
@ComponentScan("com.hm.engine")
@EnableTransactionManagement
public class HmEngineConfig {
	//
	//
	//
	
}
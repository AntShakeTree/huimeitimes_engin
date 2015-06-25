package com.engine.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hm.engine.config.PersistenceContext;


//@EnableWebMvc
@Configuration
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
@Import({PersistenceContext.class})
@ComponentScan("com.hm.engine")
@EnableTransactionManagement 
public class TestConfig {

}

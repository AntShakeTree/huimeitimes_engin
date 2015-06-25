package com.hm.engine.config.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DynamicBeanReaderImpl implements DynamicBeanManager,
		ApplicationContextAware {
	private GenericApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		
//		if (applicationContext instanceof AnnotationConfigApplicationContext)
			this.applicationContext = (GenericApplicationContext) applicationContext;
	}

	public GenericApplicationContext getContext() {
		return this.applicationContext;
	}

}
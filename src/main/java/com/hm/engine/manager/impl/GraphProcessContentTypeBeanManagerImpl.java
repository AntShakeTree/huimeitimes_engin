package com.hm.engine.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hm.engine.config.bean.DynamicBeanManager;
import com.hm.engine.manager.GraphProcessContentTypeBeanManager;
import com.hm.engine.manager.type.IProcessContentType;
@Component
public class GraphProcessContentTypeBeanManagerImpl implements
		GraphProcessContentTypeBeanManager {
	@Autowired DynamicBeanManager dynamicBeanManager;
	@Override
	public IProcessContentType loadContentTypeByName(String name) {
		return (IProcessContentType) dynamicBeanManager.getContext().getBean(name);
	}

}
